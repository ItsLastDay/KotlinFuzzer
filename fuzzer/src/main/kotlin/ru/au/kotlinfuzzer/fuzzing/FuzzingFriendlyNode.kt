package ru.au.kotlinfuzzer.fuzzing

import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.ASTNodeVisitor
import ru.au.kotlinfuzzer.scope.Scope
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.javaType

/**
 * A decorator for all ASTNodes. Used as a "hole" for fuzzing.
 *
 * FuzzingFriendlyNode supports node reassignment in uniform manner,
 * so you can modify the AST if every ASTNode is decorated
 * by FuzzingFriendlyNode. This allows every other node type to be immutable.
 *
 * Moreover, we can gather all code concerning `parent` and `scope` update
 * of all expressions. When a node is assigned to FuzzingFriendlyNode, we
 * can assign `nodeParent` to that node's `parent`.
 * The same goes for `scope`.
 * This is because FuzzingFriendlyNode is considered "stable": it does not
 * change parent nor scope. It is a fixed hole in AST, possibly
 * filled with existing node.
 *
 * In order to support persistence (in the sense of "persistent data structures"),
 * FuzzingFriendlyNode can hold all its previous states. However, this is not needed
 * at the time of writing.
 */
class FuzzingFriendlyNode(
        node: ASTNode?,
        val nodeParent: ASTNode?,
        val nodeScope: Scope?
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()

    override var scope: Scope?
        get() = throw NotImplementedError("use nodeScope")
        set(value) = throw NotImplementedError("use nodeScope")

    override var parent: ASTNode?
        get() = throw NotImplementedError("use nodeParent")
        set(value) = throw NotImplementedError("use nodeParent")

    var originalNodeValue: ASTNode? = null

    var node: ASTNode? = null
        get
        set(value) {
            assert(value !is FuzzingFriendlyNode)
            if (value != null) {
                value.parent = nodeParent
                value.scope = nodeScope
            }
            field = value
        }

    /**
     * Recursively rollback the subtree to the original state.
     */
    fun rollbackToOriginal() {
        node = originalNodeValue

        if (node != null) {
            node!!.children.forEach { (it as FuzzingFriendlyNode).rollbackToOriginal() }
        }
    }

    init {
        // Force usage of custom setter. Otherwise, `node` from constructor
        // is just assigned to `this.node`, without setter side-effects (like changing parent of assigned ASTNode).
        this.node = node
        originalNodeValue = node
    }
}


/**
 * Decorate every ASTNode in the subtree of `obj` with FuzzingFriendlyNode.
 *
 * Assign `parent` as `nodeParent` to created FuzzingFriendlyNode.
 * If `obj`-s children are already decorated, leave them as is (but reconstruct `obj`).
 *
 * Uses reflection, hence `Refl` in the name.
 */
private fun makeFuzzingFriendlyNodeReflRecursive(
        obj: ASTNode?,
        parent: ASTNode?
): FuzzingFriendlyNode {
    if (obj == null) {
        return FuzzingFriendlyNode(null, parent, null)
    }
    val primaryConstructor = obj::class.primaryConstructor!!
    val valueParams = primaryConstructor.valueParameters
    val properties = obj::class.declaredMemberProperties

    val propertiesConverted = valueParams.associateBy({it}, {
        val prop = properties.find { prop -> prop.name == it.name }!! as KProperty1<ASTNode, Any?>
        val propVal = prop.get(obj)

        when (propVal) {
            is Collection<*> -> {
                if (propVal.all { it is ASTNode })
                    propVal.map {
                        it as? FuzzingFriendlyNode ?: makeFuzzingFriendlyNodeReflRecursive(it as ASTNode, obj)
                    }
                else
                    propVal
            }
            is FuzzingFriendlyNode -> propVal
            is ASTNode -> makeFuzzingFriendlyNodeReflRecursive(propVal, obj)
            null -> if (prop.returnType.javaType == ASTNode::class.java)
                        makeFuzzingFriendlyNodeReflRecursive(propVal as ASTNode?, obj)
                    else
                        propVal
            else -> propVal
        }
    })

    return FuzzingFriendlyNode(primaryConstructor.callBy(propertiesConverted), parent, obj.scope)
}

/**
 * Decorate every node of AST with FuzzingFriendlyNode
 */
fun makeFuzzingFriendly(ast: ASTNode, root: FuzzingFriendlyNode? = null): FuzzingFriendlyNode {
    val decorated = makeFuzzingFriendlyNodeReflRecursive(ast, null)
    return root?.apply { node = decorated.node } ?: decorated
}

/**
 * Undecorate AST - remove all FuzzingFriendlyNode-s
 */
fun makeFuzzingUnfriendly(ast: FuzzingFriendlyNode): ASTNode? {
    val node = ast.node ?: return null

    val primaryConstructor = node::class.primaryConstructor!!
    val valueParams = primaryConstructor.valueParameters
    val properties = node::class.declaredMemberProperties

    val propertiesConverted = valueParams.associateBy({it}, {
        val prop = properties.find { prop -> prop.name == it.name }!! as KProperty1<ASTNode, Any?>
        val propVal = prop.get(node)

        when (propVal) {
            is Collection<*> -> {
                if (propVal.all { it is FuzzingFriendlyNode })
                    propVal.map { makeFuzzingUnfriendly(it as FuzzingFriendlyNode) }
                else
                    propVal
            }
            is FuzzingFriendlyNode -> makeFuzzingUnfriendly(propVal)
            is ASTNode -> throw IllegalArgumentException("Can only undecorate decorated nodes")
            else -> propVal
        }
    })

    return primaryConstructor.callBy(propertiesConverted)
}

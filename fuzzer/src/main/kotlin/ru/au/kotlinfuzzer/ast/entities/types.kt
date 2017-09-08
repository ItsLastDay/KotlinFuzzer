package ru.au.kotlinfuzzer.ast.entities

import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.ASTNodeVisitor
import ru.au.kotlinfuzzer.ast.ModifiersNode
import ru.au.kotlinfuzzer.mutation.getTypedList
import ru.au.kotlinfuzzer.mutation.getTypedNode

abstract class KotlinType : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
}

/**
 * A simple one-word type (e.g. String), without package
 */
data class SimpleType(val name: String) : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

/**
 * Type that contains dots (e.g. a.b.List)
 */
data class DottedType(val lhs: ASTNode, // KotlinType
                      val rhs: ASTNode // KotlinType
) : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(lhs, rhs)
}

/**
 * E.g. "List<T, X, out V>
 */
data class ProjectedGenericType(
        val innerType: ASTNode, // KotlinType
        val projections: List<ASTNode> // List<TypeProjection>
) : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = projections

    val projectionsTyped = getTypedList<TypeProjection>(projections)
}

/**
 * One element of generic type, e.g. "out V" in "List<out V>"
 */
data class TypeProjection(
        val modifiers: ASTNode, // ModifiersNode
        val type: ASTNode?, // KotlinType?
        val castedType: ASTNode? // KotlinType, used only when instance represents `typeParameter` from grammar
) : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(type, castedType).filterNotNull()

    val modifiersTyped = getTypedNode<ModifiersNode>(modifiers)
}

/**
 * Type of a function (e.g. "(Int) -> String")
 */
data class FunctionType(
        val params: List<ASTNode>, // FunctionTypeParameter
        val receiverType: ASTNode?, // KotlinType?
        val returnType: ASTNode // KotlinType
) : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(receiverType, returnType).filterNotNull() + params

    val paramsTyped = getTypedList<FunctionTypeParameter>(params)
}

/**
 * Type that fuzzer cannot parse\use yet.
 */
class UndefinedType : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()

}

/**
 * `dynamic` types: can call any method. Does not work in JVM target.
 */
class DynamicType : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()

}

/**
 * A nullable type (e.g. String?)
 */
data class NullableType(
        val innerType: ASTNode // KotlinType
) : KotlinType() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(innerType)
}


/**
 * Parameter in function type (e.g. "(a : Int)" in "(a: Int) -> String")
 */
data class FunctionTypeParameter(
        val name: String?,
        val type: ASTNode // KotlinType
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(type)
}

// TODO: Generic types? Algebraic data types?
// TODO: get types for already defined expressions from kotlinc (via "fun show(x: Nothing)")
package ru.au.kotlinfuzzer.mutation

import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.ASTNodeVisitor
import ru.au.kotlinfuzzer.ast.MembersNode
import ru.au.kotlinfuzzer.ast.StatementsNode
import ru.au.kotlinfuzzer.fuzzing.invokeKotlinc
import ru.au.kotlinfuzzer.fuzzing.writeMutatedToFile
import java.io.File

fun minimize(ast: ASTNode): ASTNode {
    return ast
}

/**
 * return `null` if not minimized
 */
fun realMinimize(ast: ASTNode): ASTNode? {
    var everMinimized = false

    while (true) {
        val minimizer = Minimizer(ast)
        ast.accept(minimizer, Unit)
        if (minimizer.alreadyMinimized) {
            everMinimized = true
        } else {
            break
        }
    }

    if (!everMinimized) {
        return null
    }
    return ast
}


class Minimizer(val root: ASTNode) : ASTNodeVisitor<Unit, Unit> {
    var alreadyMinimized = false

    override fun defaultValue(node: ASTNode, data: Unit) {
        node.acceptChildren(this, data)
    }

    private fun tryToDelete(node: ASTNode) {
        var i = 0
        while (i < node.children.size) {
            val removedGuy = node.children[i]
            (node.children as MutableList<ASTNode>).removeAt(i)

            val stillHasCrash = try {
                invokeKotlinc(
                    writeMutatedToFile(File.createTempFile("qwe" + 
                        root.hashCode().toString(), "kt"), root)
                    !!).hasCompilerCrash()
                } catch (ex: Throwable) {
                    false
                }

            if (stillHasCrash) {
                alreadyMinimized = true
                // Good, erase further
            } else {
                (node.children as MutableList<ASTNode>).add(i, removedGuy)
                ++i
            }
        }

        defaultValue(node, Unit)
    }

    override fun visit(node: StatementsNode, data: Unit) {
        tryToDelete(node)
    }

    override fun visit(node: MembersNode, data: Unit) {
        tryToDelete(node)
    }
}

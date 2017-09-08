package ru.au.kotlinfuzzer.ast.postprocess

import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.ASTNodeVisitor

class ParentComputeVisitor : ASTNodeVisitor<Unit, ASTNode?> {
    override fun defaultValue(node: ASTNode, data: ASTNode?) {
        node.parent = data
        node.acceptChildren(this, node)
    }
}

fun computeParents(node: ASTNode) = node.accept(ParentComputeVisitor(), null)
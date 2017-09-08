package ru.au.kotlinfuzzer.ast.entities

import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.ASTNodeVisitor
import ru.au.kotlinfuzzer.ast.NamedDeclaration


data class VariableDeclaration(
        override val name: String,
        // Can be null e.g. in lambdas
        val type: ASTNode? // KotlinType
) : ASTNode(),
    NamedDeclaration {
    override val children = listOf(type).filterNotNull()
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
}



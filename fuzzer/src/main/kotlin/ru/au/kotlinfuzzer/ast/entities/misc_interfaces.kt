package ru.au.kotlinfuzzer.ast.entities

import ru.au.kotlinfuzzer.ast.ASTNode

interface WithReceiver {
    val receiverType: ASTNode?
}
package ru.au.kotlinfuzzer.generators

import ru.au.kotlinfuzzer.ast.ClassDeclarationNode
import ru.au.kotlinfuzzer.ast.entities.KotlinType
import ru.au.kotlinfuzzer.ast.entities.SimpleType
import ru.au.kotlinfuzzer.scope.Scope
import java.util.*

private val random = Random(System.getenv("fixedMutationSeed")?.toLong() ?: System.currentTimeMillis())

fun generateType(scope: Scope): KotlinType {
    return scope.run {
        val classesAsTypes = allEntities.filter { it is ClassDeclarationNode }
                .map { SimpleType(it.name) }
        val allTypesHere = allTypes + classesAsTypes
        allTypesHere.run {
            get(random.nextInt(size))
        }
    }
}
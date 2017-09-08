package ru.au.kotlinfuzzer.ast.builders

import org.antlr.v4.runtime.ParserRuleContext
import ru.au.kotlinfuzzer.ast.ModifiersNode
import ru.au.kotlinfuzzer.ast.entities.*
import ru.au.kotlinfuzzer.generated.KotlinBaseVisitor
import ru.au.kotlinfuzzer.generated.KotlinParser

class TypeBuilder: KotlinBaseVisitor<KotlinType>() {
    override fun visitType(ctx: KotlinParser.TypeContext): KotlinType {
        return ctx.typeReference().accept(this)
    }

    override fun visitTypeReference(ctx: KotlinParser.TypeReferenceContext): KotlinType {
        return ctx.getChild(0).accept(this)
    }

    override fun visitTypeReferenceNonNullable(ctx: KotlinParser.TypeReferenceNonNullableContext): KotlinType {
        return if (ctx.KW_DYNAMIC() != null) DynamicType() else ctx.getChild(ParserRuleContext::class.java, 0).accept(this)
    }

    override fun visitNullableType(ctx: KotlinParser.NullableTypeContext): KotlinType {
        return NullableType(ctx.typeReferenceNonNullable().accept(this))
    }

    override fun visitFuncReceiverType(ctx: KotlinParser.FuncReceiverTypeContext): KotlinType {
        val isNullable = ctx.nullability != null
        // TODO: `typeModifiers` is child(0)
        val childType = if (ctx.KW_DYNAMIC() != null) DynamicType() else ctx.getChild(1).accept(this)
        return if (isNullable) NullableType(childType) else childType
    }

    override fun visitUserType(ctx: KotlinParser.UserTypeContext): KotlinType {
        return ctx.simpleUserType_dot().accept(this)
    }

    override fun visitSimpleUserType_dot(ctx: KotlinParser.SimpleUserType_dotContext): KotlinType {
        var returnedType = ctx.simpleUserType(0).accept(this)

        for (i in 1 until ctx.simpleUserType().size) {
            returnedType = DottedType(returnedType,
                    ctx.simpleUserType(i).accept(this))
        }

        return returnedType
    }

    override fun visitSimpleUserType(ctx: KotlinParser.SimpleUserTypeContext): KotlinType {
        val baseType = SimpleType(ctx.simpleName().text)

        if (ctx.optProjection_usertype() != null) {
            val projections = ctx.optProjection_usertype().optProjection_elem().map {
                if (it.type() != null) {
                    val modifiers = ModifiersNode(listOf(it.optionalProjection().text).filter { it.isNotBlank() })
                    TypeProjection(modifiers, it.type().accept(this), null)
                } else {
                    TypeProjection(ModifiersNode(listOf("*")), null, null)
                }
            }
            return ProjectedGenericType(baseType, projections)
        }

        return baseType
    }


    override fun visitFunctionType(ctx: KotlinParser.FunctionTypeContext): KotlinType {
        val receiverType = ctx.funcReceiverType()?.accept(this)
        val params = ctx.functiontype_parameter_comma()?.let {
            it.functiontype_parameter().map {
                FunctionTypeParameter(it.simpleName()?.text,
                        it.type().accept(this))
            }
        } ?: emptyList()
        val returnType = ctx.type()?.accept(this) ?: unitType
        return FunctionType(params, receiverType, returnType)
    }
}

val unitType = SimpleType("Unit")

fun buildType(tp: KotlinParser.TypeContext): KotlinType = tp.accept(TypeBuilder())
fun buildType(tp: KotlinParser.UserTypeContext): KotlinType = tp.accept(TypeBuilder())

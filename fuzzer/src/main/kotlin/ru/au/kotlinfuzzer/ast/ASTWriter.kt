package ru.au.kotlinfuzzer.ast

import ru.au.kotlinfuzzer.ast.entities.*

/**
 * Class that writes code from AST.
 *
 * Each node is considered independent, i.e. no default formatting
 * assumed: no '\n' after a statement, no indentation.
 * Instead, nodes must format their children accordingly.
 */
class ASTWriter(val needToPrintNotImplemented: Boolean) : ASTNodeVisitor<StringBuilder, Unit> {
    override fun defaultValue(node: ASTNode, data: Unit): StringBuilder = StringBuilder()

    override fun visit(node: NotImplementedNode, data: Unit): StringBuilder {
        return if (needToPrintNotImplemented) {
            StringBuilder(node.initialText)
        }
        else
            StringBuilder()
    }

    override fun visit(node: NotImplementedExpressionNode, data: Unit): StringBuilder {
        return if (needToPrintNotImplemented) {
            StringBuilder(node.initialText)
        }
        else
            StringBuilder()
    }

    override fun visit(node: ModifiersNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        return node.rawModifiersAnnotations.joinTo(sb, " ")
    }

    override fun visit(node: FunctionDeclarationNode, data: Unit): StringBuilder {
        val sb = StringBuilder()

        sb.append(node.modifiers.accept(this, data))
        if (sb.isNotEmpty())
            sb.append(" ")

        sb.append("fun ")
        node.genericParams?.let { sb.append(it.accept(this, data)).append(' ') }

        node.receiverType?.let {
            sb.append(it.accept(this, data))
            sb.append('.')
        }
        sb.append(node.name)

        sb.append('(')
        node.arguments.joinTo(sb, ", ") { it.accept(this, data) }
        sb.append(')')

        node.returnType?.let {
            sb.append(": ")
            sb.append(it.accept(this, data))
        }

        sb.append(node.whereConstraints.accept(this, data))

        node.body?.let {
            if (it is ExpressionNode)
                sb.append(" = ")
            if (it is CodeBlockNode)
                sb.append(" {\n")
            sb.append(it.accept(this, data))
            if (it is CodeBlockNode)
                sb.append("\n}")
        }

        return sb
    }

    override fun visit(node: KotlinFileNode, data: Unit) = node.members.accept(this, data)

    override fun visit(node: MembersNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        return node.children.joinTo(sb, "\n") { it.accept(this, data) }
    }

    override fun visit(node: PackageNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("package ${node.name}")
        return sb
    }

    override fun visit(node: ImportNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("import ")
        sb.append(node.name)
        node.alias?.let { sb.append(" as $it") }
        if (node.isImportAll)
            sb.append(".*")
        return sb
    }

    override fun visit(node: SimpleType, data: Unit) = StringBuilder(node.name)

    override fun visit(node: DynamicType, data: Unit) = StringBuilder("dynamic")

    override fun visit(node: NullableType, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append('(')
        sb.append(node.innerType.accept(this, data))
        sb.append(')')
        sb.append('?')

        return sb
    }

    override fun visit(node: FunctionTypeParameter, data: Unit): StringBuilder {
        val sb = node.name?.let { StringBuilder(it).append(": ") } ?: StringBuilder()
        return sb.append(node.type.accept(this, data))
    }

    override fun visit(node: FunctionType, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append('(')
        node.receiverType?.let {
            sb.append(it.accept(this, data))
            sb.append('.')
        }

        node.params.joinTo(sb, ", ", "(", ")") { it.accept(this, data) }

        sb.append(" -> ")
        sb.append(node.returnType.accept(this, data))

        sb.append(')')

        return sb
    }

    override fun visit(node: FunctionArgument, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("${node.varDeclTyped.name}: ")
        sb.append(node.varDeclTyped.type!!.accept(this, data))
        node.defaultValue?.let {
            sb.append(" = ")
            sb.append(it.accept(this, data))
        }

        return sb
    }

    override fun visit(node: WhenNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("when")
        node.expr?.let { sb.append(" (${it.accept(this, data)})") }
        node.entries.joinTo(sb, "\n", " {\n", "\n}") { it.accept(this, data) }
        return sb
    }

    override fun visit(node: WhenEntry, data: Unit): StringBuilder {
        val sb = StringBuilder()
        node.conditions.joinTo(sb, ", ") { it.accept(this, data) }
        sb.append(" -> ${node.code.accept(this, data)}")
        return sb
    }

    override fun visit(node: WhenConditionElse, data: Unit): StringBuilder
            = StringBuilder("else")

    override fun visit(node: WhenConditionIn, data: Unit): StringBuilder
            = StringBuilder("${if (node.negated) "!" else ""}in ${node.expr.accept(this, data)}")

    override fun visit(node: WhenConditionExpr, data: Unit): StringBuilder
            = StringBuilder("${node.expr.accept(this, data)}")

    override fun visit(node: WhenConditionIs, data: Unit): StringBuilder
            = StringBuilder("${if (node.negated) "!" else ""}is ${node.type.accept(this, data)}")

    override fun visit(node: StatementsNode, data: Unit): StringBuilder
            = node.children.joinTo(StringBuilder(), "\n") { it.accept(this, data) }

    override fun visit(node: BlockExpressionNode, data: Unit): StringBuilder
        = StringBuilder("${node.expr.accept(this, data)}")

    override fun visit(node: TryNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("try {\n")
        sb.append(node.code.accept(this, data))
        sb.append("\n}")
        node.catchBlocks.joinTo(sb, "\n") { it.accept(this, data) }
        node.finallyBlock?.let {
            sb.append("\nfinally {\n")
            sb.append(it.accept(this, data))
            sb.append("\n}")
        }
        return sb
    }

    override fun visit(node: CatchBlock, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("catch(${node.varName}: ${node.varType.accept(this, data)}) {\n")
        sb.append(node.code.accept(this, data))
        sb.append("\n}")
        return sb
    }

    override fun visit(node: VariableDeclaration, data: Unit): StringBuilder {
        val sb = StringBuilder(node.name)
        node.type?.let { sb.append(": ${it.accept(this, data)}") }
        return sb
    }

    override fun visit(node: IfNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("if (${node.condExpr.accept(this, data)})")
        node.thenBlock?.let {
            sb.append(" {\n${it.accept(this, data)}\n}")
        }
        node.elseBlock?.let {
            sb.append(" else {\n")
            sb.append(it.accept(this, data))
            sb.append("\n}")
        }
        return sb
    }

    override fun visit(node: LiteralConstantNode, data: Unit): StringBuilder
            = StringBuilder(node.body)

    override fun visit(node: ObjectLiteralNode, data: Unit): StringBuilder
            = StringBuilder().also {
                it.append("object")
                node.delegationSpecifiers?.let { spec -> it.append(": ${spec.accept(this, data)}") }
                it.append("{\n${node.members?.accept(this, data)}\n}")
            }

    override fun visit(node: ThrowNode, data: Unit): StringBuilder
            = StringBuilder("throw ${node.expr.accept(this, data)}")

    override fun visit(node: ReturnNode, data: Unit): StringBuilder {
        val sb = StringBuilder("return")
        node.label?.let { sb.append("@${it}") }
        node.expr?.let { sb.append(" ${it.accept(this, data)}") }
        return sb
    }

    override fun visit(node: LoopJumpNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append(when (node.jumpType) {
            LoopJumpNodeType.CONTINUE -> "continue"
            LoopJumpNodeType.BREAK -> "break"
        })
        node.label?.let { sb.append("@${it}") }
        return sb
    }

    override fun visit(node: ForLoopNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("for (")
        val isMultipleVars = node.varDeclarations.size > 1
        node.varDeclarations.joinTo(sb, ", ", if (isMultipleVars) "(" else "", if (isMultipleVars) ")" else "") { it.accept(this, data) }
        sb.append(" in ")
        sb.append(node.inExpr.accept(this, data))
        sb.append(") ")
        sb.append("{\n${node.body.accept(this, data)}\n}")
        return sb
    }

    override fun visit(node: WhileLoopNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append(when (node.loopType) {
            WhileLoopType.WHILE -> "while"
            WhileLoopType.DO_WHILE -> "do"
        })

        if (node.loopType == WhileLoopType.WHILE) {
            sb.append(" (${node.expr.accept(this, data)})")
        }

        node.body?.let { sb.append(" {\n${it.accept(this, data)}\n}") }

        if (node.loopType == WhileLoopType.DO_WHILE) {
            sb.append(" while (${node.expr.accept(this, data)})")
        }
        return sb
    }

    override fun visit(node: VariableUsageNode, data: Unit): StringBuilder
        = StringBuilder(node.name)

    override fun visit(node: FunctionLiteralNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("{")
        node.parameters.joinTo(sb, ", ") { it.accept(this, data) }
        if (node.parameters.isNotEmpty())
            sb.append(" -> ")
        sb.append(node.statements.accept(this, data))
        sb.append("}")
        return sb
    }

    override fun visit(node: ThisNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("this")
        node.label?.let { sb.append("@${it}") }
        return sb
    }

    override fun visit(node: SuperNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("super")
        node.type?.let { sb.append("<${it.accept(this, data)}>") }
        node.label?.let { sb.append("@${it}") }
        return sb
    }

    override fun visit(node: PropertyDeclarationNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append(node.modifiers.accept(this, data))
        if (sb.isNotEmpty())
            sb.append(' ')

        sb.append(if (node.propType == PropertyType.VAL) "val " else "var ")
        node.genericParams?.let {
            sb.append(it.accept(this, data))
            sb.append(' ')
        }
        node.receiverType?.let{ sb.append("${it.accept(this, data)}.") }
        val isMultipleVars = node.varDecl.size > 1
        node.varDecl.joinTo(sb, ", ", if (isMultipleVars) "(" else "", if (isMultipleVars) ")" else "") { it.accept(this, data) }
        sb.append(node.whereConstraints.accept(this, data))
        node.initExpr?.let {
            val separator = if (node.propDelegationType == PropertyDelegationType.EQ) "=" else "by"
            sb.append(" ${separator} ${it.accept(this, data)}")
        }
        node.getter?.let {
            sb.append("\n${it.accept(this, data)}")
        }
        node.setter?.let {
            sb.append("\n${it.accept(this, data)}")
        }
        return sb
    }

    override fun visit(node: ClassDeclarationNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append(node.modifiers.accept(this, data))
        if (sb.isNotEmpty())
            sb.append(" ")
        sb.append(if (node.nodeType == ClassNodeType.CLASS) "class" else "interface")
        sb.append(" ${node.name}")
        node.typeParams?.let {
            sb.append(it.accept(this, data))
        }
        node.primaryConstructor?.let { sb.append(it.accept(this, data)) }
        node.delegationSpecifiers?.let {
            sb.append(": ${it.accept(this, data)}")
        }
        sb.append(node.whereConstraints.accept(this, data))
        node.body?.let {
            sb.append(" ")
            sb.append("{\n")
            sb.append(it.accept(this, data))
            sb.append("\n}")
        }
        return sb
    }

    override fun visit(node: WhereConstraints, data: Unit): StringBuilder {
        return StringBuilder().also {
            if (node.constraints.isEmpty())
                return it
            node.constraints.joinTo(it, ", ", " where ", " ") { it.accept(this, data) }
        }
    }

    override fun visit(node: TypealiasNode, data: Unit): StringBuilder
            = StringBuilder().also {
        it.append("typealias ")
        it.append(node.name)
        node.genericParams?.let {
            pr -> it.append(pr.accept(this, data))
        }
        it.append(" = ")
        it.append(node.type.accept(this, data))
    }

    override fun visit(node: ObjectNode, data: Unit): StringBuilder {
        val sb = StringBuilder()
        sb.append("object ${node.name}")
        node.delegationSpecifiers?.let { sb.append(": ${it.accept(this, data)}") }
        node.body?.let {
            sb.append(' ')
            sb.append("{\n")
            sb.append(it.accept(this, data))
            sb.append("\n}")
        }
        return sb
    }

    override fun visit(node: AsIsOperation, data: Unit): StringBuilder {
        return StringBuilder().also {
            val needParenthesis = node.kind == AsIsType.AS || node.kind == AsIsType.AS_QUEST
            if (needParenthesis)
                it.append("(")
            it.append(node.expr.accept(this, data))
            it.append(' ')
            it.append(when (node.kind) {
                AsIsType.IS -> "is"
                AsIsType.NOT_IS -> "!is"
                AsIsType.AS -> "as"
                AsIsType.AS_QUEST -> "as?"
                AsIsType.COLON -> ":"
            })
            it.append(' ')
            it.append(node.type.accept(this, data))
            if (needParenthesis)
                it.append(")")
        }
    }

    override fun visit(node: BinaryOpNode, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append(node.left.accept(this, data))
            it.append(' ')
            it.append(when (node.type) {
                BinaryOpType.MULTIPLY -> "*"
                BinaryOpType.DIVIDE -> "/"
                BinaryOpType.MODULO -> "%"
                BinaryOpType.ADD -> "+"
                BinaryOpType.SUB -> "-"
                BinaryOpType.RANGE -> ".."
                BinaryOpType.ELVIS -> "?:"
                BinaryOpType.IN -> "in"
                BinaryOpType.NOT_IN -> "!in"
                BinaryOpType.LT -> "<"
                BinaryOpType.GT -> ">"
                BinaryOpType.LE -> "<="
                BinaryOpType.GE -> ">="
                BinaryOpType.EQ -> "=="
                BinaryOpType.NOT_EQ -> "!="
                BinaryOpType.NOT_REF_EQ -> "!=="
                BinaryOpType.REF_EQ -> "==="
                BinaryOpType.AND -> "&&"
                BinaryOpType.OR -> "||"
                BinaryOpType.ASSIGN -> "="
                BinaryOpType.ADD_ASSIGN -> "+="
                BinaryOpType.SUB_ASSIGN -> "-="
                BinaryOpType.MULTIPLY_ASSIGN -> "*="
                BinaryOpType.DIVIDE_ASSIGN -> "/="
                BinaryOpType.MODULO_ASSIGN -> "%="
            })
            it.append(' ')
            it.append(node.right.accept(this, data))
        }
    }

    override fun visit(node: InfixCallNode, data: Unit): StringBuilder {
        return StringBuilder().apply {
            append(node.argLeft.accept(this@ASTWriter, data))
            append(' ')
            append(node.funcName)
            append(' ')
            append(node.argRight.accept(this@ASTWriter, data))
        }
    }

    override fun visit(node: PrefixUnaryOpNode, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append('(')
            it.append(when (node.type) {
                PrefixUnaryOpType.NEG -> "-"
                PrefixUnaryOpType.POS -> "+"
                PrefixUnaryOpType.INCREMENT -> "++"
                PrefixUnaryOpType.DECREMENT -> "--"
                PrefixUnaryOpType.NOT -> "!"
                PrefixUnaryOpType.ANNOTATION -> node.annotations!!.accept(this, data)
                PrefixUnaryOpType.LABEL -> "${node.labelName!!}@"
            })
            it.append(' ')
            it.append(node.expr.accept(this, data))
            it.append(')')
        }
    }

    override fun visit(node: CallableReferenceNode, data: Unit): StringBuilder {
        return StringBuilder().apply {
            node.type?.let { append(it.accept(this@ASTWriter, data)) }
            append("::")
            append(node.name)
        }
    }

    override fun visit(node: PostfixUnaryNode, data: Unit): StringBuilder {
        return StringBuilder().apply {
            append(node.expr.accept(this@ASTWriter, data))
            append(when (node.type) {
                PostfixUnaryOpType.INCREMENT -> "++"
                PostfixUnaryOpType.DECREMENT -> "--"
                PostfixUnaryOpType.NOT_NULL -> "!!"
            })
        }
    }

    override fun visit(node: MemberAccessNode, data: Unit): StringBuilder {
        return StringBuilder().apply {
            append(node.obj.accept(this@ASTWriter, data))
            append(when (node.type) {
                MemberAccessType.DOT -> "."
                MemberAccessType.SAFE -> "?."
            })
            append(node.member.accept(this@ASTWriter, data))
        }
    }

    override fun visit(node: FunctionCallNode, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append(node.func.accept(this, data))
            node.typeArgs.let { lst ->
                if (lst.isNotEmpty()) {
                    lst.joinTo(it, ", ", "<", ">") { it.accept(this, data) }
                }
            }
            it.append('(')
            node.args.joinTo(it, ", ") { it.accept(this, data) }
            it.append(')')
        }
    }

    override fun visit(node: ValueArgument, data: Unit): StringBuilder {
        return StringBuilder().apply {
            node.name?.let { append(it); append("=") }
            if (node.needUnpack)
                append("*")
            append(node.expr.accept(this@ASTWriter, data))
        }
    }

    override fun visit(node: ArrayAccessNode, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append(node.arr.accept(this, data))
            node.expressions.joinTo(it, ", ", "[", "]") {
                it.accept(this, data)
            }
        }
    }

    override fun visit(node: ParenthizedExpressionNode, data: Unit): StringBuilder {
        return StringBuilder().apply {
            append('(')
            append(node.innerExpr.accept(this@ASTWriter, data))
            append(')')
        }
    }

    override fun visit(node: GenericTypeParams, data: Unit): StringBuilder {
        return node.types.joinTo(StringBuilder(), ", ", "<", ">") {
            it.accept(this, data)
        }
    }

    override fun visit(node: DottedType, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append(node.lhs.accept(this, data))
            it.append('.')
            it.append(node.rhs.accept(this, data))
        }
    }

    override fun visit(node: ProjectedGenericType, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append(node.innerType.accept(this, data))
            node.projections.joinTo(it, ", ", "<", ">") {
                it.accept(this, data)
            }
        }
    }

    override fun visit(node: TypeProjection, data: Unit): StringBuilder {
        return StringBuilder().also {
            it.append(node.modifiers.accept(this, data))
            if (it.isNotEmpty())
                it.append(' ')

            node.type?.let {
                tp -> it.append(tp.accept(this, data))
            }
            node.castedType?.let { tp ->
                it.append(" : ")
                it.append(tp.accept(this, data))
            }
        }
    }
}

fun getTextFromAST(node: ASTNode, needToPrintNotImplemented: Boolean = false): String {
    val text = node.accept(ASTWriter(needToPrintNotImplemented), Unit).toString()
    val replacedText = text
            .replace(Regex(" +"), " ")
            .replace(Regex(" +\n"), "\n")
    return replacedText.trimEnd()
}
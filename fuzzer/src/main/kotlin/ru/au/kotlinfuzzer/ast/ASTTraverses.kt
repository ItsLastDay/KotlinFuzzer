package ru.au.kotlinfuzzer.ast

import ru.au.kotlinfuzzer.ast.entities.*
import ru.au.kotlinfuzzer.fuzzing.FuzzingFriendlyNode

/**
 * AST visitor.
 *
 * Made parametrized as in kotlinc.
 */
interface ASTNodeVisitor<out R, in D> {
    fun defaultValue(node: ASTNode, data: D): R

    fun visit(node: FuzzingFriendlyNode, data: D): R = defaultValue(node, data)
    fun visit(node: NotImplementedNode, data: D): R = defaultValue(node, data)
    fun visit(node: NotImplementedExpressionNode, data: D): R = defaultValue(node, data)

    fun visit(node: FunctionDeclarationNode, data: D): R = defaultValue(node, data)
    fun visit(node: VariableDeclaration, data: D): R = defaultValue(node, data)
    fun visit(node: PropertyDeclarationNode, data: D): R = defaultValue(node, data)
    fun visit(node: ObjectNode, data: D): R = defaultValue(node, data)
    fun visit(node: TypealiasNode, data: D): R = defaultValue(node, data)
    fun visit(node: ClassDeclarationNode, data: D): R = defaultValue(node, data)

    fun visit(node: MembersNode, data: D): R = defaultValue(node, data)

    fun visit(node: ExpressionNode, data: D): R = defaultValue(node, data)
    fun visit(node: ParenthizedExpressionNode, data: D): R = defaultValue(node, data)
    fun visit(node: ArrayAccessNode, data: D): R = defaultValue(node, data)
    fun visit(node: PostfixUnaryNode, data: D): R = defaultValue(node, data)
    fun visit(node: CallableReferenceNode, data: D): R = defaultValue(node, data)
    fun visit(node: AsIsOperation, data: D): R = defaultValue(node, data)
    fun visit(node: BinaryOpNode, data: D): R = defaultValue(node, data)
    fun visit(node: PrefixUnaryOpNode, data: D): R = defaultValue(node, data)
    fun visit(node: WhenNode, data: D): R = defaultValue(node, data)
    fun visit(node: IfNode, data: D): R = defaultValue(node, data)
    fun visit(node: InfixCallNode, data: D): R = defaultValue(node, data)
    fun visit(node: MemberAccessNode, data: D): R = defaultValue(node, data)
    fun visit(node: FunctionCallNode, data: D): R = defaultValue(node, data)
    fun visit(node: VariableUsageNode, data: D): R = defaultValue(node, data)
    fun visit(node: LiteralConstantNode, data: D): R = defaultValue(node, data)
    fun visit(node: ObjectLiteralNode, data: D): R = defaultValue(node, data)
    fun visit(node: JumpNode, data: D): R = defaultValue(node, data)
    fun visit(node: ThrowNode, data: D): R = defaultValue(node, data)
    fun visit(node: ReturnNode, data: D): R = defaultValue(node, data)
    fun visit(node: LoopJumpNode, data: D): R = defaultValue(node, data)

    fun visit(node: LoopNode, data: D): R = defaultValue(node, data)
    fun visit(node: ForLoopNode, data: D): R = defaultValue(node, data)
    fun visit(node: WhileLoopNode, data: D): R = defaultValue(node, data)
    fun visit(node: FunctionLiteralNode, data: D): R = defaultValue(node, data)
    fun visit(node: CallNode, data: D): R = defaultValue(node, data)
    fun visit(node: TryNode, data: D): R = defaultValue(node, data)
    fun visit(node: SuperNode, data: D): R = defaultValue(node, data)
    fun visit(node: ThisNode, data: D): R = defaultValue(node, data)

    fun visit(node: KotlinFileNode, data: D): R = defaultValue(node, data)
    fun visit(node: PackageNode, data: D): R = defaultValue(node, data)
    fun visit(node: ImportNode, data: D): R = defaultValue(node, data)

    fun visit(node: KotlinType, data: D): R = defaultValue(node, data)
    fun visit(node: DottedType, data: D): R = defaultValue(node, data)
    fun visit(node: SimpleType, data: D): R = defaultValue(node, data)
    fun visit(node: FunctionType, data: D): R = defaultValue(node, data)
    fun visit(node: FunctionTypeParameter, data: D): R = defaultValue(node, data)
    fun visit(node: UndefinedType, data: D): R = defaultValue(node, data)
    fun visit(node: NullableType, data: D): R = defaultValue(node, data)
    fun visit(node: DynamicType, data: D): R = defaultValue(node, data)
    fun visit(node: TypeProjection, data: D): R = defaultValue(node, data)
    fun visit(node: ProjectedGenericType, data: D): R = defaultValue(node, data)

    fun visit(node: FunctionArgument, data: D): R = defaultValue(node, data)
    fun visit(node: ValueArgument, data: D): R = defaultValue(node, data)

    fun visit(node: GenericTypeParams, data: D): R = defaultValue(node, data)

    fun visit(node: CatchBlock, data: D): R = defaultValue(node, data)

    fun visit(node: WhenEntry, data: D): R = defaultValue(node, data)
    fun visit(node: WhenCondition, data: D): R = defaultValue(node, data)
    fun visit(node: WhenConditionIs, data: D): R = defaultValue(node, data)
    fun visit(node: WhenConditionIn, data: D): R = defaultValue(node, data)
    fun visit(node: WhenConditionExpr, data: D): R = defaultValue(node, data)
    fun visit(node: WhenConditionElse, data: D): R = defaultValue(node, data)

    fun visit(node: CodeBlockNode, data: D): R = defaultValue(node, data)
    fun visit(node: StatementsNode, data: D): R = defaultValue(node, data)
    fun visit(node: BlockExpressionNode, data: D): R = defaultValue(node, data)

    fun visit(node: WhereConstraints, data: D): R = defaultValue(node, data)

    fun visit(node: ModifiersNode, data: D): R = defaultValue(node, data)
}

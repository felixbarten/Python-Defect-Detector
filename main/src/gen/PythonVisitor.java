// Generated from Python.g4 by ANTLR 4.5

	package gen;
	
    import java.util.List;
    import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonParser#single_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_input(@NotNull PythonParser.Single_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#file_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_input(@NotNull PythonParser.File_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#eval_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval_input(@NotNull PythonParser.Eval_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(@NotNull PythonParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#decorators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorators(@NotNull PythonParser.DecoratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#decorated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated(@NotNull PythonParser.DecoratedContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(@NotNull PythonParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#async_funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsync_funcdef(@NotNull PythonParser.Async_funcdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(@NotNull PythonParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull PythonParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#typedargslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedargslist(@NotNull PythonParser.TypedargslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#tfpdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfpdef(@NotNull PythonParser.TfpdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#varargslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarargslist(@NotNull PythonParser.VarargslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#vfpdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVfpdef(@NotNull PythonParser.VfpdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#vfplist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVfplist(@NotNull PythonParser.VfplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull PythonParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(@NotNull PythonParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_stmt(@NotNull PythonParser.Small_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(@NotNull PythonParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#testlist_star_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist_star_expr(@NotNull PythonParser.Testlist_star_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#augassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugassign(@NotNull PythonParser.AugassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#print_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stmt(@NotNull PythonParser.Print_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#del_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDel_stmt(@NotNull PythonParser.Del_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#pass_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass_stmt(@NotNull PythonParser.Pass_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#flow_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_stmt(@NotNull PythonParser.Flow_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(@NotNull PythonParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#continue_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stmt(@NotNull PythonParser.Continue_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(@NotNull PythonParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#yield_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYield_stmt(@NotNull PythonParser.Yield_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#super_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuper_stmt(@NotNull PythonParser.Super_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#instance_method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstance_method_call(@NotNull PythonParser.Instance_method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(@NotNull PythonParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#method_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_args(@NotNull PythonParser.Method_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#chained_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChained_method(@NotNull PythonParser.Chained_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#raise_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaise_stmt(@NotNull PythonParser.Raise_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stmt(@NotNull PythonParser.Import_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#import_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_name(@NotNull PythonParser.Import_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#import_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_from(@NotNull PythonParser.Import_fromContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#import_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_name(@NotNull PythonParser.Import_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dotted_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_name(@NotNull PythonParser.Dotted_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#import_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_names(@NotNull PythonParser.Import_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dotted_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_names(@NotNull PythonParser.Dotted_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dotted_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_name(@NotNull PythonParser.Dotted_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#global_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_stmt(@NotNull PythonParser.Global_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#nonlocal_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonlocal_stmt(@NotNull PythonParser.Nonlocal_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#exec_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExec_stmt(@NotNull PythonParser.Exec_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#assert_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssert_stmt(@NotNull PythonParser.Assert_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(@NotNull PythonParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#async_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsync_stmt(@NotNull PythonParser.Async_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(@NotNull PythonParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(@NotNull PythonParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(@NotNull PythonParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#try_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_stmt(@NotNull PythonParser.Try_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#with_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_stmt(@NotNull PythonParser.With_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#with_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_item(@NotNull PythonParser.With_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#except_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_clause(@NotNull PythonParser.Except_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(@NotNull PythonParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(@NotNull PythonParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#test_nocond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_nocond(@NotNull PythonParser.Test_nocondContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#lambdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdef(@NotNull PythonParser.LambdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#lambdef_nocond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdef_nocond(@NotNull PythonParser.Lambdef_nocondContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_test(@NotNull PythonParser.Or_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(@NotNull PythonParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(@NotNull PythonParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull PythonParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_op(@NotNull PythonParser.Comp_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#star_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar_expr(@NotNull PythonParser.Star_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull PythonParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#xor_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expr(@NotNull PythonParser.Xor_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(@NotNull PythonParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expr(@NotNull PythonParser.Shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(@NotNull PythonParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull PythonParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull PythonParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(@NotNull PythonParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull PythonParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#testlist_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist_comp(@NotNull PythonParser.Testlist_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer(@NotNull PythonParser.TrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#subscriptlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptlist(@NotNull PythonParser.SubscriptlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(@NotNull PythonParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#sliceop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceop(@NotNull PythonParser.SliceopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(@NotNull PythonParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#testlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist(@NotNull PythonParser.TestlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#dictorsetmaker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictorsetmaker(@NotNull PythonParser.DictorsetmakerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#classdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdef(@NotNull PythonParser.ClassdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(@NotNull PythonParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(@NotNull PythonParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comp_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_iter(@NotNull PythonParser.Comp_iterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comp_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_for(@NotNull PythonParser.Comp_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#comp_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_if(@NotNull PythonParser.Comp_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#yield_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYield_expr(@NotNull PythonParser.Yield_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#yield_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYield_arg(@NotNull PythonParser.Yield_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull PythonParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull PythonParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(@NotNull PythonParser.IntegerContext ctx);
}
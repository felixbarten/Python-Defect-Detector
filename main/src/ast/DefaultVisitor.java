package ast;

import ast.argument.Arg;
import ast.argument.Argument;
import ast.argument.CondArgument;
import ast.argument.DefValArgument;
import ast.argument.Kwarg;
import ast.argument.SimpleArgument;
import ast.expression.Conditional;
import ast.expression.ExprList;
import ast.expression.Lambda;
import ast.expression.compiter.CompFor;
import ast.expression.compiter.CompIf;
import ast.expression.nocond.LambdaNoCond;
import ast.expression.nocond.arithmetic.Nnary;
import ast.expression.nocond.arithmetic.Power;
import ast.expression.nocond.arithmetic.Unary;
import ast.expression.nocond.atom.Bool;
import ast.expression.nocond.atom.Ellipsis;
import ast.expression.nocond.atom.Identifier;
import ast.expression.nocond.atom.None;
import ast.expression.nocond.atom.Str;
import ast.expression.nocond.atom.StrConversion;
import ast.expression.nocond.atom.comprehension.CondComprehension;
import ast.expression.nocond.atom.comprehension.EnumComprehension;
import ast.expression.nocond.atom.maker.DictMaker;
import ast.expression.nocond.atom.maker.SetMaker;
import ast.expression.nocond.atom.numeric.Float;
import ast.expression.nocond.atom.numeric.Imaginary;
import ast.expression.nocond.atom.numeric.Int;
import ast.expression.nocond.atom.numeric.Long;
import ast.expression.nocond.atom.trailed.AttributeRef;
import ast.expression.nocond.atom.trailed.Call;
import ast.expression.nocond.atom.trailed.ObjectMethodCall;
import ast.expression.nocond.atom.trailed.Slice;
import ast.expression.nocond.atom.yield.YieldFrom;
import ast.expression.nocond.atom.yield.YieldValues;
import ast.expression.nocond.bitwise.And;
import ast.expression.nocond.bitwise.Bitwise;
import ast.expression.nocond.bitwise.Or;
import ast.expression.nocond.bitwise.Shift;
import ast.expression.nocond.bitwise.Xor;
import ast.expression.nocond.logical.Binary;
import ast.expression.nocond.logical.Comparison;
import ast.expression.nocond.logical.Not;
import ast.expression.nocond.trailer.ArgList;
import ast.expression.nocond.trailer.SliceBound;
import ast.expression.nocond.trailer.SubscriptIndex;
import ast.expression.nocond.trailer.SubscriptSliceList;
import ast.param.ListParam;
import ast.param.Params;
import ast.param.TypedParam;
import ast.param.UntypedParam;
import ast.path.DottedPath;
import ast.path.SimplePath;
import ast.statement.MethodCallStmt;
import ast.statement.compound.ClassDef;
import ast.statement.compound.Except;
import ast.statement.compound.For;
import ast.statement.compound.Function;
import ast.statement.compound.If;
import ast.statement.compound.Try;
import ast.statement.compound.While;
import ast.statement.compound.With;
import ast.statement.compound.WithItem;
import ast.statement.flow.Break;
import ast.statement.flow.Continue;
import ast.statement.flow.RaiseEx;
import ast.statement.flow.RaiseFrom;
import ast.statement.flow.Return;
import ast.statement.flow.Yield;
import ast.statement.simple.Assert;
import ast.statement.simple.Assign;
import ast.statement.simple.Delete;
import ast.statement.simple.Exec;
import ast.statement.simple.Global;
import ast.statement.simple.ImportFrom;
import ast.statement.simple.ImportPaths;
import ast.statement.simple.Nonlocal;
import ast.statement.simple.Pass;
import ast.statement.simple.Print;
import ast.statement.simple.SuperStmt;

/**
 * Created by Nik on 29-06-2015
 */
public class DefaultVisitor<T> implements Visitor<T> {

	@Override
	public T visit(Decorator n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(DottedPath n) {
		return null;
	}

	@Override
	public T visit(Module n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(SimplePath n) {
		return null;
	}

	@Override
	public T visit(Suite n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Arg n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(DefValArgument n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Kwarg n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(SimpleArgument n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(CondArgument n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Params n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ListParam n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(TypedParam n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(UntypedParam n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Assert n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Assign n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Delete n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Exec n) {
		this.visitChildren(n);
		return null;
	}
	
	public T visit(SuperStmt n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ExprList n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Global n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ImportFrom n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ImportPaths n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Nonlocal n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Pass n) {
		return null;
	}

	@Override
	public T visit(Print n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Break n) {
		return null;
	}

	@Override
	public T visit(Continue n) {
		return null;
	}

	@Override
	public T visit(RaiseEx n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(RaiseFrom n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Return n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Yield n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(YieldValues n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(YieldFrom n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ClassDef n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Except n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(For n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Function n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(If n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Try n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(While n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(With n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(WithItem n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Comparison n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Conditional n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Lambda n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(LambdaNoCond n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Power n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Shift n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Nnary n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Unary n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Bool n) {
		return null;
	}

	@Override
	public T visit(DictMaker n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Ellipsis n) {
		return null;
	}

	@Override
	public T visit(Float n) {
		return null;
	}

	@Override
	public T visit(Identifier n) {
		return null;
	}

	@Override
	public T visit(Imaginary n) {
		return null;
	}

	@Override
	public T visit(Int n) {
		return null;
	}

	@Override
	public T visit(Long n) {
		return null;
	}

	@Override
	public T visit(None n) {
		return null;
	}

	@Override
	public T visit(SetMaker n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Str n) {
		return null;
	}

	@Override
	public T visit(StrConversion n) {
		return null;
	}

	@Override
	public T visit(AttributeRef n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Call n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ObjectMethodCall n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Slice n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(And n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Or n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Xor n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(CompFor n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(CompIf n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(CondComprehension n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(EnumComprehension n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Binary n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(Not n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(ArgList n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(SliceBound n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(SubscriptSliceList n) {
		this.visitChildren(n);
		return null;
	}

	@Override
	public T visit(SubscriptIndex n) {
		this.visitChildren(n);
		return null;
	}
	
	// TODO
	private void visitChildren(SuperStmt n) {
		
		if (n.hasSuperArgs()) {
			n.getSuperArgs().accept(this);
		}
		
		if (n.hasCaller()) {
			n.getCaller().accept(this);
		}
		if (n.hasChain()) {
			n.getChainedMethod().accept(this);
		}
	}

	public void visitChildren(Module n) {
		n.getBody().forEach(s -> s.accept(this));
	}

	public void visitChildren(Decorator n) {
		n.getName().accept(this);
		if (n.hasArgList()) {
			n.getArgList().accept(this);
		}
	}

	public void visitChildren(Arg n) {
		n.getValue().accept(this);
	}

	private void visitChildren(CondArgument n) {
		n.getValue().accept(this);
		n.getCondition().accept(this);
	}

	public void visitChildren(DefValArgument n) {
		n.getValue().accept(this);
		n.getName().accept(this);
	}

	public void visitChildren(SimpleArgument n) {
		n.getValue().accept(this);
	}

	public void visitChildren(Kwarg n) {
		n.getValue().accept(this);
	}

	public void visitChildren(UntypedParam n) {
		n.getId().accept(this);

		if (n.hasDefaultVal()) {
			n.getDefaultVal().accept(this);
		}
	}

	public void visitChildren(Params n) {
		n.getRegular().forEach(p -> p.accept(this));
		if (n.hasPositionalParam()) {
			n.getPositional().accept(this);
		}
		if (n.hasKeywordParam()) {
			n.getKeyword().accept(this);
		}
	}

	public void visitChildren(ListParam n) {
		n.getParams().forEach(p -> p.accept(this));
	}

	public void visitChildren(TypedParam n) {
		n.getId().accept(this);

		if (n.hasDefaultVal()) {
			n.getDefaultVal().accept(this);
		}
		if (n.hasReturnVal()) {
			n.getReturnVal().accept(this);
		}
	}

	public void visitChildren(Suite n) {
		n.getStatements().forEach(s -> s.accept(this));
	}

	public void visitChildren(Assert n) {
		n.getAssertion().accept(this);

		if (n.hasAssertionError()) {
			n.getAssertionError().accept(this);
		}
	}

	public void visitChildren(Assign n) {
		n.getExprElements().forEach(t -> t.accept(this));
		n.getYieldElements().forEach(t -> t.accept(this));
	}

	public void visitChildren(ClassDef n) {
		n.getBody().accept(this);

		n.getName().accept(this);

		for (Argument argument : n.getInheritance()) {
			argument.accept(this);
		}
		n.getDecorators().forEach(d -> d.accept(this));
	}

	public void visitChildren(Delete n) {
		n.getItems().accept(this);
	}

	public void visitChildren(Exec n) {
		n.getTarget().accept(this);
		if (n.hasVars()) {
			n.getVars().accept(this);
		}
		if (n.hasLocalVars()) {
			n.getLocalVars().accept(this);
		}
	}

	public void visitChildren(ExprList n) {
		n.getValues().forEach(e -> e.accept(this));
	}

	public void visitChildren(Global n) {
		n.getIdentifiers().forEach(i -> i.accept(this));
	}

	public void visitChildren(ImportFrom n) {
		if (n.hasModule()) {
			n.getModule().accept(this);
		}
		n.getPaths().forEach(p -> p.accept(this));
	}

	public void visitChildren(ImportPaths n) {
		n.getPaths().forEach(p -> p.accept(this));
	}

	public void visitChildren(Nonlocal n) {
		n.getIdentifiers().forEach(i -> i.accept(this));
	}

	public void visitChildren(Print n) {
		n.getExpressions().forEach(e -> e.accept(this));
	}

	public void visitChildren(RaiseEx n) {
		if (n.hasType()) {
			n.getType().accept(this);
		}
		if (n.hasValue()) {
			n.getValue().accept(this);
		}
		if (n.hasTrace()) {
			n.getTrace().accept(this);
		}
	}

	public void visitChildren(RaiseFrom n) {
		if (n.hasType()) {
			n.getType().accept(this);
		}
		if (n.hasSource()) {
			n.getSource().accept(this);
		}
	}

	public void visitChildren(Return n) {
		if (n.hasValues()) {
			n.getValues().accept(this);
		}
	}

	public void visitChildren(Yield n) {
		n.getYield().accept(this);
	}

	public void visitChildren(YieldValues n) {
		if (n.hasValues()) {
			n.getValues().accept(this);
		}
	}

	public void visitChildren(YieldFrom n) {
		n.getFrom().accept(this);
	}

	public void visitChildren(Except n) {
		if (n.hasException()) {
			n.getException().accept(this);
		}
		if (n.hasAlias()) {
			n.getAlias().accept(this);
		}
	}

	public void visitChildren(For n) {
		n.getBody().accept(this);
		if (n.hasElseBody()) {
			n.getElseBody().accept(this);
		}
		n.getIterator().accept(this);
		n.getSource().accept(this);
	}

	public void visitChildren(Function n) {
		n.getBody().accept(this);
		if (n.hasReturnType()) {
			n.getReturnType().accept(this);
		}
		n.getName().accept(this);
		n.getParams().accept(this);
		n.getDecorators().forEach(d -> d.accept(this));
	}

	public void visitChildren(If n) {
		n.getConditions().forEach(c -> c.accept(this));
		n.getBodies().forEach(b -> b.accept(this));

		if (n.hasElseBody()) {
			n.getElseBody().accept(this);
		}
	}

	public void visitChildren(Try n) {
		n.getExceptions().forEach(e -> e.accept(this));
		n.getExceptBodies().forEach(b -> b.accept(this));

		n.getTryBlock().accept(this);
		if (n.hasElseBlock()) {
			n.getElseBlock().accept(this);
		}
		if (n.hasFinallyBlock()) {
			n.getFinallyBlock().accept(this);
		}
	}

	public void visitChildren(While n) {
		n.getBody().accept(this);
		if (n.hasElseBody()) {
			n.getElseBody().accept(this);
		}
		n.getCondition().accept(this);
	}

	public void visitChildren(With n) {
		n.getBody().accept(this);

		n.getItems().forEach(i -> i.accept(this));
	}

	public void visitChildren(WithItem n) {
		n.getItem().accept(this);
		if (n.hasAlias()) {
			n.getAlias().accept(this);
		}
	}

	public void visitChildren(Comparison n) {
		n.getOperands().forEach(e -> e.accept(this));
	}

	public void visitChildren(Conditional n) {
		n.getValue().accept(this);
		n.getCondition().accept(this);
		n.getFalseValue().accept(this);
	}

	public void visitChildren(Lambda n) {
		if (n.hasParameters()) {
			n.getParameters().accept(this);
		}
		n.getExpression().accept(this);
	}

	public void visitChildren(LambdaNoCond n) {
		if (n.hasParameters()) {
			n.getParameters().accept(this);
		}
		n.getExpression().accept(this);
	}

	public void visitChildren(Power n) {
		n.getBase().accept(this);
		if (n.hasExponent()) {
			n.getExponent().accept(this);
		}
	}

	public void visitChildren(Shift n) {
		n.getOperands().forEach(e -> e.accept(this));
	}

	public void visitChildren(Nnary n) {
		n.getOperands().forEach(e -> e.accept(this));
	}

	public void visitChildren(DictMaker n) {
		if (n.hasComprehension()) {
			n.getComprehension().accept(this);
		}

		n.getKeys().forEach(k -> k.accept(this));
		n.getValues().forEach(v -> v.accept(this));
	}

	public void visitChildren(AttributeRef n) {
		n.getBase().accept(this);
		n.getAttributes().forEach(a -> a.accept(this));
	}

	public void visitChildren(Call n) {
		n.getBase().accept(this);
		n.getArgs().accept(this);
	}

	public void visitChildren(ObjectMethodCall n) {
		n.getBase().accept(this);
		n.getCall().accept(this);
	}

	public void visitChildren(Slice n) {
		n.getBase().accept(this);
		n.getBounds().accept(this);
	}

	public void visitChildren(SetMaker n) {
		if (n.hasComprehension()) {
			n.getComprehension().accept(this);
		}
		if (n.hasValues()) {
			n.getValues().forEach(e -> e.accept(this));
		}
	}

	public void visitChildren(Bitwise n) {
		n.getOperands().forEach(o -> o.accept(this));
	}

	public void visitChildren(CompFor n) {
		if (n.hasNextLink()) {
			n.getNextLink().accept(this);
		}
		n.getSource().forEach(s -> s.accept(this));
		n.getTargets().accept(this);
	}

	public void visitChildren(CompIf n) {
		if (n.hasNextLink()) {
			n.getNextLink().accept(this);
		}
		n.getExpression().accept(this);
	}

	public void visitChildren(CondComprehension n) {
		n.getCompFor().accept(this);
		n.getExpression().accept(this);
	}

	public void visitChildren(EnumComprehension n) {
		n.getValues().forEach(e -> e.accept(this));
	}

	public void visitChildren(Binary n) {
		n.getOperands().forEach(e -> e.accept(this));
	}

	public void visitChildren(Not n) {
		n.getExpression().accept(this);
	}

	public void visitChildren(ArgList n) {
		n.getArguments().forEach(p -> p.accept(this));
	}

	public void visitChildren(SubscriptIndex n) {
		n.getIndex().accept(this);
	}

	public void visitChildren(SliceBound n) {
		if (n.hasLowerBound()) {
			n.getLowerBound().accept(this);
		}
		if (n.hasUpperBound()) {
			n.getUpperBound().accept(this);
		}
		if (n.hasStride()) {
			n.getStride().accept(this);
		}
	}

	public void visitChildren(SubscriptSliceList n) {
		n.getIndexes().forEach(s -> s.accept(this));
	}

	public void visitChildren(Unary n) {
		n.getValue().accept(this);
	}

	@Override
	public T visit(MethodCallStmt n) {
		this.visitChildren(n);
		return null;
	}

	private void visitChildren(MethodCallStmt n) {
		n.getName().accept(this);
		if (n.hasArgList()) {
			n.getArguments().accept(this);
			
		}
		if (n.hasChain()) {
			n.getChained_method().accept(this);

		}
		
	}

}

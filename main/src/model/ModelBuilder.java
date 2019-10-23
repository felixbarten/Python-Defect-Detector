package model;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import ast.CCVisitor;
import ast.DefaultVisitor;
import ast.argument.Arg;
import ast.argument.ArgumentVisitor;
import ast.argument.CondArgument;
import ast.argument.DefValArgument;
import ast.argument.Kwarg;
import ast.argument.SimpleArgument;
import ast.expression.ExprList;
import ast.expression.nocond.atom.Identifier;
import ast.expression.nocond.atom.trailed.AttributeRef;
import ast.expression.nocond.atom.trailed.Call;
import ast.expression.nocond.atom.trailed.ObjectMethodCall;
import ast.path.Path;
import ast.statement.MethodCallStmt;
import ast.statement.compound.ClassDef;
import ast.statement.compound.Function;
import ast.statement.simple.Assign;
import ast.statement.simple.Global;
import ast.statement.simple.ImportFrom;
import ast.statement.simple.ImportPaths;
import ast.statement.simple.SuperStmt;
import util.LexicalHelper;
import util.StringHelper;

/**
 * Created by Nik on 17-05-2015
 */
public class ModelBuilder {

	private final Project project;
	private final Stack<SuperCall> statements;

	public ModelBuilder(Project oldProject, Map<String, ast.Module> oldTrees, Map<String, ast.Module> trees) {
		this.project = new Project(oldProject.getFolder());

		//build new modules
		BuildingVisitor buildingVisitor = new BuildingVisitor(this.project);
		buildingVisitor.build(trees.values());

		//add relevant modules from previous version
		Set<Module> oldModules = oldProject.getModules().stream()
				.filter(m -> oldTrees.containsKey(m.getFilePath()) && !this.project.hasModule(m.getFilePath()))
				.map(m -> oldProject.getModule(m.getFilePath()))
				.collect(Collectors.toSet());
		oldModules.forEach(this.project::addModule);
		this.statements = buildingVisitor.getStatements();

		//link
		LinkingVisitor linkingVisitor = new LinkingVisitor(this.project);
		linkingVisitor.link(trees.values());
	}

	public ModelBuilder(File projectFolder, Collection<ast.Module> trees) {
		this.project = new Project(projectFolder);
		BuildingVisitor buildingVisitor = new BuildingVisitor(this.project);
		buildingVisitor.build(trees);
		this.statements = buildingVisitor.getStatements();
		LinkingVisitor linkingVisitor = new LinkingVisitor(this.project);
		linkingVisitor.link(trees);
	}

	public Project getProject() {
		return this.project;
	}
	
	public Stack<SuperCall> getStatements() {
		return statements;
	}

	private class LinkingVisitor extends DefaultVisitor<Void> {

		private String currentFilePath;
		private final Project project;
		private Linker linker;

		public LinkingVisitor(Project project) {
			super();
			this.project = project;
		}

		public void link(Collection<ast.Module> trees) {
			this.linker = new Linker(this.project);
			for (ast.Module m : trees) {
				this.currentFilePath = m.getFilePath();
				m.accept(this);
			}
			this.linker.link();
		}

		@Override
		public Void visit(ImportPaths n) {
			for (Path p : n.getPaths()) {
				this.linker.addModuleImport(this.currentFilePath, p.getPath(), this.getAlias(p));
			}
			this.visitChildren(n);
			return null;
		}

		@Override
		public Void visit(ImportFrom n) {
			for (Path p : n.getPaths()) {
				this.linker.addImportFrom(this.currentFilePath, n.getModule().getPath(), p.getPath(), this.getAlias(p));
			}
			this.visitChildren(n);
			return null;
		}

		private String getAlias(Path p) {
			return p.hasAlias() ? p.getAlias().getValue() : p.getPath();
		}
	}


	private class BuildingVisitor extends DefaultVisitor<Void> {

		private String currentFilePath;
		private final Project project;
		private final Stack<ContentContainer> contentContainers;

		private final Stack<model.Class> classes;
		private final Stack<Subroutine> subroutines;
		private final Stack<SuperCall> statements;
		private boolean inAssign;

		private boolean inAssignLeft;
		private boolean inAssignRight;
		private String leftAssign;
		private String rightAssign;
		
		public BuildingVisitor(Project project) {
			super();
			this.project = project;
			this.contentContainers = new Stack<>();

			this.classes = new Stack<>();
			this.subroutines = new Stack<>();
			this.inAssign = false;
			this.inAssignLeft = false;
			this.inAssignRight = false;
			this.statements = new Stack<>();
		}

		public void build(Collection<ast.Module> trees) {
			for (ast.Module m : trees) {
				this.currentFilePath = m.getFilePath();
				m.accept(this);
			}
		}

		@Override
		public void visitChildren(ast.Module n) {
			
			String filePath = n.getFilePath();
			model.Module module = new model.Module(n.getName(), n.getLocInfo(), filePath, StringHelper.implode(n.getErrors(), "\n"));

			this.project.addModule(module);

			this.contentContainers.push(module);
			super.visitChildren(n);
			this.contentContainers.pop();
		}

		@Override
		public Void visit(Global n) {
			for (Identifier i : n.getIdentifiers()) {
				this.addVarDef(i.getValue(), VarType.GLOBAL);
			}
			return null;
		}

		@Override
		public void visitChildren(Assign n) {
			this.inAssign = true;
			super.visitChildren(n);
			for (int i = 0; i < (n.getExprElements().size() - 1); i++) {
				this.inAssignLeft = true;
				ExprList left = n.getExprElements().get(i);
				left.accept(this);
				this.inAssignLeft = false;

				this.inAssignRight = true;
				ExprList right = n.getExprElements().get(i + 1);
				right.accept(this);
				this.inAssignRight = false;

				this.leftAssign = null;
				this.rightAssign = null;
			}
			this.inAssign = false;
		}

		@Override
		public Void visit(ClassDef n) {
			Integer locInfo = n.getLocInfo();
			// gather class arguments
			ClassArgumentCollector argCollector = new ClassArgumentCollector();
			// gather superclasses.
			List<String> superclassNames = n.getInheritance().stream()
					.map(p -> p.accept(argCollector))
					.collect(Collectors.toList());
			

			Class c = new Class(n.getName().getValue(), locInfo, this.getCurrentContainer(), superclassNames, project);
			this.getCurrentContainer().addClassDefinition(c);
			
			this.classes.push(c);
			this.contentContainers.push(c);
			this.visitChildren(n);
			this.contentContainers.pop();
			this.classes.pop();

			return null;
		}

		@Override
		public Void visit(Function n) {
			CCVisitor cc = new CCVisitor();
			cc.visit(n);	
			
			List<String> paramNames = n.getParams().getParamNames().stream()
					.filter(p -> !p.equals(LexicalHelper.SELF_KEYWORD))
					.collect(Collectors.toList());
			SubroutineType type = !this.inClass() ? SubroutineType.FUNCTION :
					(n.isStatic() ? SubroutineType.STATIC_METHOD : SubroutineType.INSTANCE_METHOD);
			// if a function is encountered after a class is parsed set it back to null.
			Class current =  (type == SubroutineType.FUNCTION) ? null : getCurrentClass();
			Subroutine subroutine = new Subroutine(n.getNameString(), n.getLocInfo(), cc.getComplexity(), this.getCurrentContainer(), type, paramNames, n.isAccessor(), current);
			this.getCurrentContainer().addSubroutineDefinition(subroutine);

			// process children 
			this.subroutines.push(subroutine);
			this.contentContainers.push(subroutine);
			this.visitChildren(n);
			this.contentContainers.pop();
			this.subroutines.pop();
			

			return null;
		}
		
		
		// TODO
		@Override
		public Void visit(MethodCallStmt n) {
			MethodCall call;
			
		
			return null;
		}

		
		// TODO

		@Override
		public Void visit(SuperStmt n) {
			SuperCall call;
			
			String name = (n.getCaller() != null && n.getCaller().getName().toString() != null) ? n.getCaller().getName().toString() : null;
			
			if (name != null && name == subroutines.peek().name) {
				call = new SuperCall(subroutines.peek(), null);
				statements.add(call);
			}
			
			return null;
		}
		
		@Override
		public void visitChildren(ClassDef n) {
			//prevents registering class names as variables
			n.getBody().accept(this);
			n.getDecorators().forEach(d -> d.accept(this));
		}

		@Override
		public void visitChildren(Function n) {
			//prevents registering function names and param names as variables
			n.getBody().accept(this);
			if (n.hasReturnType()) {
				n.getReturnType().accept(this);
			}
			n.getDecorators().forEach(d -> d.accept(this));
		}

		@Override
		public Void visit(Identifier n) {
			this.addVarDef(n.getValue());
			this.addVarRef(n.getValue());
			this.setAssignVar((String) n.getValue());
			return null;
		}

		@Override
		public Void visit(AttributeRef n) {
			this.addVarDef(n.toString());
			this.addVarRef(n.toString());
			this.setAssignVar((String) n.toString());
//			this.visitChildren(n);
			return null;
		}

		private void addVarRef(String fullName) {
			this.getCurrentContainer().addVariableReference(fullName);
		}

		private boolean hasClassVarName(String varName) {
			return varName.startsWith(this.getCurrentClass().getName() + ".");
		}

		private boolean hasInstanceVarName(String varName) {
			return varName.startsWith(LexicalHelper.SELF_KEYWORD + ".");
		}

		/**
		 * Process variable to see if it's contained inside a class or an instance. 
		 * @param fullName
		 */
		private void addVarDef(String fullName) {
			List<String> nameParts = StringHelper.explode(fullName, ".");
			if (this.inClass()) {
				if (this.hasClassVarName(fullName)) {
					this.addVarDef(nameParts.get(1), VarType.CLASS);
				}
				else if (this.hasInstanceVarName(fullName)) {
					this.addVarDef(nameParts.get(1), VarType.INSTANCE);
				}
				//if its name has more than 1 part, then it was just an attribute reference
				else if (!this.inSubroutine() && nameParts.size() == 1) {
					//variable defined inside of a class but outside of a method -> both class and instance variable
					this.addVarDef(nameParts.get(0), VarType.CLASS);
					this.addVarDef(nameParts.get(0), VarType.INSTANCE);
				}
			}
			else {
				this.addVarDef(nameParts.get(0), VarType.LOCAL);
			}
		}

		/**
		 * Add variable to parent after type has been determined.
		 * @param name varname
		 * @param varType instance or class variable
		 */
		private void addVarDef(String name, VarType varType) {
			ContentContainer parent = varType == VarType.CLASS || varType == VarType.INSTANCE ? this.getCurrentClass() : this.getCurrentContainer();
			Variable var = new Variable(name, parent, varType);
			parent.addVariableDefinition(var);
		}

		@Override
		public Void visit(Call n) {
			this.addSubroutineRef(n.getBase().toString());
			this.setAssignCall(n.getBase().toString());
			this.visitChildren(n);
			return null;
		}

		@Override
		public Void visit(ObjectMethodCall n) {
			this.addSubroutineRef(n.getBase().toString() + "." + n.getCall().getName());
			this.setAssignCall((n.getBase().toString() + "." + n.getCall().getName()));
			this.visitChildren(n);
			return null;
		}

		private void setAssignCall(String value) {
			this.setAssignVar(value, AssignType.CALL);
		}

		private void setAssignVar(String value) {
			this.setAssignVar(value, AssignType.VARIABLE);
		}

		private void setAssignVar(String value, AssignType type) {
			if (this.inAssign && this.inAssignLeft && this.leftAssign == null) {
				this.leftAssign = value;
			}
			if (this.inAssign && this.inAssignRight && this.rightAssign == null) {
				this.rightAssign = value;
				this.addAssign(type);
			}
		}

		private void addAssign(AssignType type) {
			if (this.leftAssign != null && this.rightAssign != null) {
				model.Assign assign = new model.Assign(this.leftAssign, this.rightAssign, type);
				this.getCurrentContainer().addAssign(assign);
			}
		}

		@Override
		public void visitChildren(Call n) {
			//prevents registering function names as variables
			n.getArgs().accept(this);
		}

		@Override
		public void visitChildren(ObjectMethodCall n) {
			//prevents registering function names as variables
			n.getCall().accept(this);
		}

		private void addSubroutineRef(String name) {
			this.getCurrentContainer().addSubroutineCall(name);
		}

		private model.Module getCurrentModule() {
			if (this.currentFilePath == null || !this.project.hasModule(this.currentFilePath)) {
				return null;
			}
			return this.project.getModule(this.currentFilePath);
		}

		private Class getCurrentClass() {
			return this.classes.peek();
		}

		
//		private Method getCurrentMethod() {
//			return this.subroutines.peek();
//		}
//
		private boolean inClass() {
			return !this.classes.isEmpty();
		}

		private boolean inSubroutine() {
			return !this.subroutines.isEmpty();
		}
//
//		private boolean inClassMethod() {
//			return this.inClass() && !this.subroutines.isEmpty();
//		}

		private ContentContainer getCurrentContainer() {
			return this.contentContainers.peek();
		}
	
		public Stack<SuperCall> getStatements() {
			return statements;
		}
	}

	/**
	 * Gathers arguments only if it's a defValArgument || simpleargument
	 * 
	 *
	 */
	public class ClassArgumentCollector implements ArgumentVisitor<String> {

		@Override
		public String visit(Arg n) {
			throw new IllegalArgumentException();
		}

		@Override
		public String visit(CondArgument n) {
			throw new IllegalArgumentException();
		}

		@Override
		public String visit(DefValArgument n) {
			return n.getValue().toString(); //in case it's an identifier - name of another class
		}

		@Override
		public String visit(Kwarg n) {
			throw new IllegalArgumentException();
		}

		@Override
		public String visit(SimpleArgument n) {
			return n.getValue().toString();
		}
	}
}

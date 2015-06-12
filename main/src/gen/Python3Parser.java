// Generated from D:/intellij_projects/thesis/main/grammar\Python3.g4 by ANTLR 4.5
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Python3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEF=1, RETURN=2, RAISE=3, FROM=4, IMPORT=5, AS=6, GLOBAL=7, NONLOCAL=8, 
		ASSERT=9, IF=10, ELIF=11, ELSE=12, WHILE=13, FOR=14, IN=15, TRY=16, FINALLY=17, 
		WITH=18, EXCEPT=19, LAMBDA=20, OR=21, AND=22, NOT=23, IS=24, NONE=25, 
		TRUE=26, FALSE=27, CLASS=28, YIELD=29, DEL=30, PASS=31, CONTINUE=32, BREAK=33, 
		NEWLINE=34, NAME=35, STRING_LITERAL=36, BYTES_LITERAL=37, DECIMAL_INTEGER=38, 
		OCT_INTEGER=39, HEX_INTEGER=40, BIN_INTEGER=41, FLOAT_NUMBER=42, IMAG_NUMBER=43, 
		DOT=44, ELLIPSIS=45, STAR=46, OPEN_PAREN=47, CLOSE_PAREN=48, COMMA=49, 
		COLON=50, SEMI_COLON=51, POWER=52, ASSIGN=53, OPEN_BRACK=54, CLOSE_BRACK=55, 
		OR_OP=56, XOR=57, AND_OP=58, LEFT_SHIFT=59, RIGHT_SHIFT=60, ADD=61, MINUS=62, 
		DIV=63, MOD=64, IDIV=65, NOT_OP=66, OPEN_BRACE=67, CLOSE_BRACE=68, LESS_THAN=69, 
		GREATER_THAN=70, EQUALS=71, GT_EQ=72, LT_EQ=73, NOT_EQ_1=74, NOT_EQ_2=75, 
		AT=76, ARROW=77, ADD_ASSIGN=78, SUB_ASSIGN=79, MULT_ASSIGN=80, AT_ASSIGN=81, 
		DIV_ASSIGN=82, MOD_ASSIGN=83, AND_ASSIGN=84, OR_ASSIGN=85, XOR_ASSIGN=86, 
		LEFT_SHIFT_ASSIGN=87, RIGHT_SHIFT_ASSIGN=88, POWER_ASSIGN=89, IDIV_ASSIGN=90, 
		SKIP=91, COMMENT=92, UNKNOWN_CHAR=93, INDENT=94, DEDENT=95;
	public static final int
		RULE_single_input = 0, RULE_file_input = 1, RULE_eval_input = 2, RULE_decorator = 3, 
		RULE_decorators = 4, RULE_decorated = 5, RULE_funcdef = 6, RULE_parameters = 7, 
		RULE_typedargslist = 8, RULE_tfpdef = 9, RULE_varargslist = 10, RULE_vfpdef = 11, 
		RULE_stmt = 12, RULE_simple_stmt = 13, RULE_small_stmt = 14, RULE_expr_stmt = 15, 
		RULE_testlist_star_expr = 16, RULE_augassign = 17, RULE_del_stmt = 18, 
		RULE_pass_stmt = 19, RULE_flow_stmt = 20, RULE_break_stmt = 21, RULE_continue_stmt = 22, 
		RULE_return_stmt = 23, RULE_yield_stmt = 24, RULE_raise_stmt = 25, RULE_import_stmt = 26, 
		RULE_import_name = 27, RULE_import_from = 28, RULE_import_as_name = 29, 
		RULE_dotted_as_name = 30, RULE_import_as_names = 31, RULE_dotted_as_names = 32, 
		RULE_dotted_name = 33, RULE_global_stmt = 34, RULE_nonlocal_stmt = 35, 
		RULE_assert_stmt = 36, RULE_compound_stmt = 37, RULE_if_stmt = 38, RULE_while_stmt = 39, 
		RULE_for_stmt = 40, RULE_try_stmt = 41, RULE_with_stmt = 42, RULE_with_item = 43, 
		RULE_except_clause = 44, RULE_suite = 45, RULE_test = 46, RULE_test_nocond = 47, 
		RULE_lambdef = 48, RULE_lambdef_nocond = 49, RULE_or_test = 50, RULE_and_test = 51, 
		RULE_not_test = 52, RULE_comparison = 53, RULE_comp_op = 54, RULE_star_expr = 55, 
		RULE_expr = 56, RULE_xor_expr = 57, RULE_and_expr = 58, RULE_shift_expr = 59, 
		RULE_arith_expr = 60, RULE_term = 61, RULE_factor = 62, RULE_power = 63, 
		RULE_atom = 64, RULE_testlist_comp = 65, RULE_trailer = 66, RULE_subscriptlist = 67, 
		RULE_subscript = 68, RULE_sliceop = 69, RULE_exprlist = 70, RULE_testlist = 71, 
		RULE_dictorsetmaker = 72, RULE_classdef = 73, RULE_arglist = 74, RULE_argument = 75, 
		RULE_comp_iter = 76, RULE_comp_for = 77, RULE_comp_if = 78, RULE_yield_expr = 79, 
		RULE_yield_arg = 80, RULE_string = 81, RULE_number = 82, RULE_integer = 83, 
		RULE_comment = 84;
	public static final String[] ruleNames = {
		"single_input", "file_input", "eval_input", "decorator", "decorators", 
		"decorated", "funcdef", "parameters", "typedargslist", "tfpdef", "varargslist", 
		"vfpdef", "stmt", "simple_stmt", "small_stmt", "expr_stmt", "testlist_star_expr", 
		"augassign", "del_stmt", "pass_stmt", "flow_stmt", "break_stmt", "continue_stmt", 
		"return_stmt", "yield_stmt", "raise_stmt", "import_stmt", "import_name", 
		"import_from", "import_as_name", "dotted_as_name", "import_as_names", 
		"dotted_as_names", "dotted_name", "global_stmt", "nonlocal_stmt", "assert_stmt", 
		"compound_stmt", "if_stmt", "while_stmt", "for_stmt", "try_stmt", "with_stmt", 
		"with_item", "except_clause", "suite", "test", "test_nocond", "lambdef", 
		"lambdef_nocond", "or_test", "and_test", "not_test", "comparison", "comp_op", 
		"star_expr", "expr", "xor_expr", "and_expr", "shift_expr", "arith_expr", 
		"term", "factor", "power", "atom", "testlist_comp", "trailer", "subscriptlist", 
		"subscript", "sliceop", "exprlist", "testlist", "dictorsetmaker", "classdef", 
		"arglist", "argument", "comp_iter", "comp_for", "comp_if", "yield_expr", 
		"yield_arg", "string", "number", "integer", "comment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'return'", "'raise'", "'from'", "'import'", "'as'", "'global'", 
		"'nonlocal'", "'assert'", "'if'", "'elif'", "'else'", "'while'", "'for'", 
		"'in'", "'try'", "'finally'", "'with'", "'except'", "'lambda'", "'or'", 
		"'and'", "'not'", "'is'", "'None'", "'True'", "'False'", "'class'", "'yield'", 
		"'del'", "'pass'", "'continue'", "'break'", null, null, null, null, null, 
		null, null, null, null, null, "'.'", "'...'", "'*'", "'('", "')'", "','", 
		"':'", "';'", "'**'", "'='", "'['", "']'", "'|'", "'^'", "'&'", "'<<'", 
		"'>>'", "'+'", "'-'", "'/'", "'%'", "'//'", "'~'", "'{'", "'}'", "'<'", 
		"'>'", "'=='", "'>='", "'<='", "'<>'", "'!='", "'@'", "'->'", "'+='", 
		"'-='", "'*='", "'@='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", 
		"'>>='", "'**='", "'//='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEF", "RETURN", "RAISE", "FROM", "IMPORT", "AS", "GLOBAL", "NONLOCAL", 
		"ASSERT", "IF", "ELIF", "ELSE", "WHILE", "FOR", "IN", "TRY", "FINALLY", 
		"WITH", "EXCEPT", "LAMBDA", "OR", "AND", "NOT", "IS", "NONE", "TRUE", 
		"FALSE", "CLASS", "YIELD", "DEL", "PASS", "CONTINUE", "BREAK", "NEWLINE", 
		"NAME", "STRING_LITERAL", "BYTES_LITERAL", "DECIMAL_INTEGER", "OCT_INTEGER", 
		"HEX_INTEGER", "BIN_INTEGER", "FLOAT_NUMBER", "IMAG_NUMBER", "DOT", "ELLIPSIS", 
		"STAR", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", "COLON", "SEMI_COLON", "POWER", 
		"ASSIGN", "OPEN_BRACK", "CLOSE_BRACK", "OR_OP", "XOR", "AND_OP", "LEFT_SHIFT", 
		"RIGHT_SHIFT", "ADD", "MINUS", "DIV", "MOD", "IDIV", "NOT_OP", "OPEN_BRACE", 
		"CLOSE_BRACE", "LESS_THAN", "GREATER_THAN", "EQUALS", "GT_EQ", "LT_EQ", 
		"NOT_EQ_1", "NOT_EQ_2", "AT", "ARROW", "ADD_ASSIGN", "SUB_ASSIGN", "MULT_ASSIGN", 
		"AT_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
		"LEFT_SHIFT_ASSIGN", "RIGHT_SHIFT_ASSIGN", "POWER_ASSIGN", "IDIV_ASSIGN", 
		"SKIP", "COMMENT", "UNKNOWN_CHAR", "INDENT", "DEDENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Python3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Python3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Single_inputContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Single_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_input; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSingle_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_inputContext single_input() throws RecognitionException {
		Single_inputContext _localctx = new Single_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_single_input);
		try {
			setState(175);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(170); 
				match(NEWLINE);
				}
				break;
			case RETURN:
			case RAISE:
			case FROM:
			case IMPORT:
			case GLOBAL:
			case NONLOCAL:
			case ASSERT:
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case YIELD:
			case DEL:
			case PASS:
			case CONTINUE:
			case BREAK:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(171); 
				simple_stmt();
				}
				break;
			case DEF:
			case IF:
			case WHILE:
			case FOR:
			case TRY:
			case WITH:
			case CLASS:
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(172); 
				compound_stmt();
				setState(173); 
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class File_inputContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Python3Parser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(Python3Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Python3Parser.NEWLINE, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFile_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF) | (1L << RETURN) | (1L << RAISE) | (1L << FROM) | (1L << IMPORT) | (1L << GLOBAL) | (1L << NONLOCAL) | (1L << ASSERT) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << TRY) | (1L << WITH) | (1L << LAMBDA) | (1L << NOT) | (1L << NONE) | (1L << TRUE) | (1L << FALSE) | (1L << CLASS) | (1L << YIELD) | (1L << DEL) | (1L << PASS) | (1L << CONTINUE) | (1L << BREAK) | (1L << NEWLINE) | (1L << NAME) | (1L << STRING_LITERAL) | (1L << BYTES_LITERAL) | (1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER) | (1L << FLOAT_NUMBER) | (1L << IMAG_NUMBER) | (1L << ELLIPSIS) | (1L << STAR) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (NOT_OP - 66)) | (1L << (OPEN_BRACE - 66)) | (1L << (AT - 66)))) != 0)) {
				{
				setState(179);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(177); 
					match(NEWLINE);
					}
					break;
				case DEF:
				case RETURN:
				case RAISE:
				case FROM:
				case IMPORT:
				case GLOBAL:
				case NONLOCAL:
				case ASSERT:
				case IF:
				case WHILE:
				case FOR:
				case TRY:
				case WITH:
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case CLASS:
				case YIELD:
				case DEL:
				case PASS:
				case CONTINUE:
				case BREAK:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
				case AT:
					{
					setState(178); 
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Eval_inputContext extends ParserRuleContext {
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Python3Parser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(Python3Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Python3Parser.NEWLINE, i);
		}
		public Eval_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval_input; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitEval_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eval_inputContext eval_input() throws RecognitionException {
		Eval_inputContext _localctx = new Eval_inputContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eval_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); 
			testlist();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(187); 
				match(NEWLINE);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecoratorContext extends ParserRuleContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public DecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDecorator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratorContext decorator() throws RecognitionException {
		DecoratorContext _localctx = new DecoratorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); 
			match(AT);
			setState(196); 
			dotted_name();
			setState(202);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(197); 
				match(OPEN_PAREN);
				setState(199);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (POWER - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(198); 
					arglist();
					}
				}

				setState(201); 
				match(CLOSE_PAREN);
				}
			}

			setState(204); 
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecoratorsContext extends ParserRuleContext {
		public List<DecoratorContext> decorator() {
			return getRuleContexts(DecoratorContext.class);
		}
		public DecoratorContext decorator(int i) {
			return getRuleContext(DecoratorContext.class,i);
		}
		public DecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDecorators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratorsContext decorators() throws RecognitionException {
		DecoratorsContext _localctx = new DecoratorsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decorators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(206); 
				decorator();
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecoratedContext extends ParserRuleContext {
		public DecoratorsContext decorators() {
			return getRuleContext(DecoratorsContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public DecoratedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorated; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDecorated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratedContext decorated() throws RecognitionException {
		DecoratedContext _localctx = new DecoratedContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decorated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); 
			decorators();
			setState(214);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(212); 
				classdef();
				}
				break;
			case DEF:
				{
				setState(213); 
				funcdef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(Python3Parser.DEF, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); 
			match(DEF);
			setState(217); 
			match(NAME);
			setState(218); 
			parameters();
			setState(221);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(219); 
				match(ARROW);
				setState(220); 
				test();
				}
			}

			setState(223); 
			match(COLON);
			setState(224); 
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public TypedargslistContext typedargslist() {
			return getRuleContext(TypedargslistContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); 
			match(OPEN_PAREN);
			setState(228);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STAR) | (1L << POWER))) != 0)) {
				{
				setState(227); 
				typedargslist();
				}
			}

			setState(230); 
			match(CLOSE_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedargslistContext extends ParserRuleContext {
		public List<TfpdefContext> tfpdef() {
			return getRuleContexts(TfpdefContext.class);
		}
		public TfpdefContext tfpdef(int i) {
			return getRuleContext(TfpdefContext.class,i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TypedargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedargslist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTypedargslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedargslistContext typedargslist() throws RecognitionException {
		TypedargslistContext _localctx = new TypedargslistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typedargslist);
		int _la;
		try {
			int _alt;
			setState(297);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(232); 
				tfpdef();
				setState(235);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(233); 
					match(ASSIGN);
					setState(234); 
					test();
					}
				}

				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(237); 
						match(COMMA);
						setState(238); 
						tfpdef();
						setState(241);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(239); 
							match(ASSIGN);
							setState(240); 
							test();
							}
						}

						}
						} 
					}
					setState(247);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(273);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(248); 
					match(COMMA);
					setState(271);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(249); 
						match(STAR);
						setState(251);
						_la = _input.LA(1);
						if (_la==NAME) {
							{
							setState(250); 
							tfpdef();
							}
						}

						setState(261);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(253); 
								match(COMMA);
								setState(254); 
								tfpdef();
								setState(257);
								_la = _input.LA(1);
								if (_la==ASSIGN) {
									{
									setState(255); 
									match(ASSIGN);
									setState(256); 
									test();
									}
								}

								}
								} 
							}
							setState(263);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						}
						setState(267);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(264); 
							match(COMMA);
							setState(265); 
							match(POWER);
							setState(266); 
							tfpdef();
							}
						}

						}
						break;
					case POWER:
						{
						setState(269); 
						match(POWER);
						setState(270); 
						tfpdef();
						}
						break;
					case CLOSE_PAREN:
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(275); 
				match(STAR);
				setState(277);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(276); 
					tfpdef();
					}
				}

				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(279); 
						match(COMMA);
						setState(280); 
						tfpdef();
						setState(283);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(281); 
							match(ASSIGN);
							setState(282); 
							test();
							}
						}

						}
						} 
					}
					setState(289);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				setState(293);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(290); 
					match(COMMA);
					setState(291); 
					match(POWER);
					setState(292); 
					tfpdef();
					}
				}

				}
				break;
			case POWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(295); 
				match(POWER);
				setState(296); 
				tfpdef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TfpdefContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TfpdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfpdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTfpdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfpdefContext tfpdef() throws RecognitionException {
		TfpdefContext _localctx = new TfpdefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tfpdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); 
			match(NAME);
			setState(302);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(300); 
				match(COLON);
				setState(301); 
				test();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarargslistContext extends ParserRuleContext {
		public List<VfpdefContext> vfpdef() {
			return getRuleContexts(VfpdefContext.class);
		}
		public VfpdefContext vfpdef(int i) {
			return getRuleContext(VfpdefContext.class,i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public VarargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varargslist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitVarargslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarargslistContext varargslist() throws RecognitionException {
		VarargslistContext _localctx = new VarargslistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varargslist);
		int _la;
		try {
			int _alt;
			setState(369);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(304); 
				vfpdef();
				setState(307);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(305); 
					match(ASSIGN);
					setState(306); 
					test();
					}
				}

				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(309); 
						match(COMMA);
						setState(310); 
						vfpdef();
						setState(313);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(311); 
							match(ASSIGN);
							setState(312); 
							test();
							}
						}

						}
						} 
					}
					setState(319);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(345);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(320); 
					match(COMMA);
					setState(343);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(321); 
						match(STAR);
						setState(323);
						_la = _input.LA(1);
						if (_la==NAME) {
							{
							setState(322); 
							vfpdef();
							}
						}

						setState(333);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(325); 
								match(COMMA);
								setState(326); 
								vfpdef();
								setState(329);
								_la = _input.LA(1);
								if (_la==ASSIGN) {
									{
									setState(327); 
									match(ASSIGN);
									setState(328); 
									test();
									}
								}

								}
								} 
							}
							setState(335);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						}
						setState(339);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(336); 
							match(COMMA);
							setState(337); 
							match(POWER);
							setState(338); 
							vfpdef();
							}
						}

						}
						break;
					case POWER:
						{
						setState(341); 
						match(POWER);
						setState(342); 
						vfpdef();
						}
						break;
					case COLON:
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(347); 
				match(STAR);
				setState(349);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(348); 
					vfpdef();
					}
				}

				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(351); 
						match(COMMA);
						setState(352); 
						vfpdef();
						setState(355);
						_la = _input.LA(1);
						if (_la==ASSIGN) {
							{
							setState(353); 
							match(ASSIGN);
							setState(354); 
							test();
							}
						}

						}
						} 
					}
					setState(361);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(365);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(362); 
					match(COMMA);
					setState(363); 
					match(POWER);
					setState(364); 
					vfpdef();
					}
				}

				}
				break;
			case POWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(367); 
				match(POWER);
				setState(368); 
				vfpdef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VfpdefContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public VfpdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vfpdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitVfpdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VfpdefContext vfpdef() throws RecognitionException {
		VfpdefContext _localctx = new VfpdefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_vfpdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371); 
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(375);
			switch (_input.LA(1)) {
			case RETURN:
			case RAISE:
			case FROM:
			case IMPORT:
			case GLOBAL:
			case NONLOCAL:
			case ASSERT:
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case YIELD:
			case DEL:
			case PASS:
			case CONTINUE:
			case BREAK:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(373); 
				simple_stmt();
				}
				break;
			case DEF:
			case IF:
			case WHILE:
			case FOR:
			case TRY:
			case WITH:
			case CLASS:
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(374); 
				compound_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_stmtContext extends ParserRuleContext {
		public List<Small_stmtContext> small_stmt() {
			return getRuleContexts(Small_stmtContext.class);
		}
		public Small_stmtContext small_stmt(int i) {
			return getRuleContext(Small_stmtContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSimple_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_simple_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377); 
			small_stmt();
			setState(382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(378); 
					match(SEMI_COLON);
					setState(379); 
					small_stmt();
					}
					} 
				}
				setState(384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(386);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(385); 
				match(SEMI_COLON);
				}
			}

			setState(388); 
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Small_stmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Del_stmtContext del_stmt() {
			return getRuleContext(Del_stmtContext.class,0);
		}
		public Pass_stmtContext pass_stmt() {
			return getRuleContext(Pass_stmtContext.class,0);
		}
		public Flow_stmtContext flow_stmt() {
			return getRuleContext(Flow_stmtContext.class,0);
		}
		public Import_stmtContext import_stmt() {
			return getRuleContext(Import_stmtContext.class,0);
		}
		public Global_stmtContext global_stmt() {
			return getRuleContext(Global_stmtContext.class,0);
		}
		public Nonlocal_stmtContext nonlocal_stmt() {
			return getRuleContext(Nonlocal_stmtContext.class,0);
		}
		public Assert_stmtContext assert_stmt() {
			return getRuleContext(Assert_stmtContext.class,0);
		}
		public Small_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_small_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSmall_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Small_stmtContext small_stmt() throws RecognitionException {
		Small_stmtContext _localctx = new Small_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_small_stmt);
		try {
			setState(398);
			switch (_input.LA(1)) {
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(390); 
				expr_stmt();
				}
				break;
			case DEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(391); 
				del_stmt();
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 3);
				{
				setState(392); 
				pass_stmt();
				}
				break;
			case RETURN:
			case RAISE:
			case YIELD:
			case CONTINUE:
			case BREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(393); 
				flow_stmt();
				}
				break;
			case FROM:
			case IMPORT:
				enterOuterAlt(_localctx, 5);
				{
				setState(394); 
				import_stmt();
				}
				break;
			case GLOBAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(395); 
				global_stmt();
				}
				break;
			case NONLOCAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(396); 
				nonlocal_stmt();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 8);
				{
				setState(397); 
				assert_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public List<Testlist_star_exprContext> testlist_star_expr() {
			return getRuleContexts(Testlist_star_exprContext.class);
		}
		public Testlist_star_exprContext testlist_star_expr(int i) {
			return getRuleContext(Testlist_star_exprContext.class,i);
		}
		public AugassignContext augassign() {
			return getRuleContext(AugassignContext.class,0);
		}
		public List<Yield_exprContext> yield_expr() {
			return getRuleContexts(Yield_exprContext.class);
		}
		public Yield_exprContext yield_expr(int i) {
			return getRuleContext(Yield_exprContext.class,i);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); 
			testlist_star_expr();
			setState(416);
			switch (_input.LA(1)) {
			case ADD_ASSIGN:
			case SUB_ASSIGN:
			case MULT_ASSIGN:
			case AT_ASSIGN:
			case DIV_ASSIGN:
			case MOD_ASSIGN:
			case AND_ASSIGN:
			case OR_ASSIGN:
			case XOR_ASSIGN:
			case LEFT_SHIFT_ASSIGN:
			case RIGHT_SHIFT_ASSIGN:
			case POWER_ASSIGN:
			case IDIV_ASSIGN:
				{
				setState(401); 
				augassign();
				setState(404);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(402); 
					yield_expr();
					}
					break;
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
					{
					setState(403); 
					testlist();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case NEWLINE:
			case SEMI_COLON:
			case ASSIGN:
				{
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ASSIGN) {
					{
					{
					setState(406); 
					match(ASSIGN);
					setState(409);
					switch (_input.LA(1)) {
					case YIELD:
						{
						setState(407); 
						yield_expr();
						}
						break;
					case LAMBDA:
					case NOT:
					case NONE:
					case TRUE:
					case FALSE:
					case NAME:
					case STRING_LITERAL:
					case BYTES_LITERAL:
					case DECIMAL_INTEGER:
					case OCT_INTEGER:
					case HEX_INTEGER:
					case BIN_INTEGER:
					case FLOAT_NUMBER:
					case IMAG_NUMBER:
					case ELLIPSIS:
					case STAR:
					case OPEN_PAREN:
					case OPEN_BRACK:
					case ADD:
					case MINUS:
					case NOT_OP:
					case OPEN_BRACE:
						{
						setState(408); 
						testlist_star_expr();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Testlist_star_exprContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public Testlist_star_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist_star_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTestlist_star_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Testlist_star_exprContext testlist_star_expr() throws RecognitionException {
		Testlist_star_exprContext _localctx = new Testlist_star_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_testlist_star_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(418); 
				test();
				}
				break;
			case 2:
				{
				setState(419); 
				star_expr();
				}
				break;
			}
			setState(429);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(422); 
					match(COMMA);
					setState(425);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						setState(423); 
						test();
						}
						break;
					case 2:
						{
						setState(424); 
						star_expr();
						}
						break;
					}
					}
					} 
				}
				setState(431);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			setState(433);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(432); 
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AugassignContext extends ParserRuleContext {
		public AugassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augassign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAugassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AugassignContext augassign() throws RecognitionException {
		AugassignContext _localctx = new AugassignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_augassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_la = _input.LA(1);
			if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (ADD_ASSIGN - 78)) | (1L << (SUB_ASSIGN - 78)) | (1L << (MULT_ASSIGN - 78)) | (1L << (AT_ASSIGN - 78)) | (1L << (DIV_ASSIGN - 78)) | (1L << (MOD_ASSIGN - 78)) | (1L << (AND_ASSIGN - 78)) | (1L << (OR_ASSIGN - 78)) | (1L << (XOR_ASSIGN - 78)) | (1L << (LEFT_SHIFT_ASSIGN - 78)) | (1L << (RIGHT_SHIFT_ASSIGN - 78)) | (1L << (POWER_ASSIGN - 78)) | (1L << (IDIV_ASSIGN - 78)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Del_stmtContext extends ParserRuleContext {
		public TerminalNode DEL() { return getToken(Python3Parser.DEL, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public Del_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDel_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Del_stmtContext del_stmt() throws RecognitionException {
		Del_stmtContext _localctx = new Del_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_del_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); 
			match(DEL);
			setState(438); 
			exprlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pass_stmtContext extends ParserRuleContext {
		public TerminalNode PASS() { return getToken(Python3Parser.PASS, 0); }
		public Pass_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pass_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitPass_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pass_stmtContext pass_stmt() throws RecognitionException {
		Pass_stmtContext _localctx = new Pass_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pass_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440); 
			match(PASS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Flow_stmtContext extends ParserRuleContext {
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Continue_stmtContext continue_stmt() {
			return getRuleContext(Continue_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Raise_stmtContext raise_stmt() {
			return getRuleContext(Raise_stmtContext.class,0);
		}
		public Yield_stmtContext yield_stmt() {
			return getRuleContext(Yield_stmtContext.class,0);
		}
		public Flow_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFlow_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Flow_stmtContext flow_stmt() throws RecognitionException {
		Flow_stmtContext _localctx = new Flow_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_flow_stmt);
		try {
			setState(447);
			switch (_input.LA(1)) {
			case BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(442); 
				break_stmt();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(443); 
				continue_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(444); 
				return_stmt();
				}
				break;
			case RAISE:
				enterOuterAlt(_localctx, 4);
				{
				setState(445); 
				raise_stmt();
				}
				break;
			case YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(446); 
				yield_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(Python3Parser.BREAK, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitBreak_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449); 
			match(BREAK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Continue_stmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(Python3Parser.CONTINUE, 0); }
		public Continue_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitContinue_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_stmtContext continue_stmt() throws RecognitionException {
		Continue_stmtContext _localctx = new Continue_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_continue_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451); 
			match(CONTINUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(Python3Parser.RETURN, 0); }
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453); 
			match(RETURN);
			setState(455);
			_la = _input.LA(1);
			if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
				{
				setState(454); 
				testlist();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Yield_stmtContext extends ParserRuleContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Yield_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitYield_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_stmtContext yield_stmt() throws RecognitionException {
		Yield_stmtContext _localctx = new Yield_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_yield_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457); 
			yield_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Raise_stmtContext extends ParserRuleContext {
		public TerminalNode RAISE() { return getToken(Python3Parser.RAISE, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode FROM() { return getToken(Python3Parser.FROM, 0); }
		public Raise_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitRaise_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Raise_stmtContext raise_stmt() throws RecognitionException {
		Raise_stmtContext _localctx = new Raise_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_raise_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459); 
			match(RAISE);
			setState(465);
			_la = _input.LA(1);
			if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
				{
				setState(460); 
				test();
				setState(463);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(461); 
					match(FROM);
					setState(462); 
					test();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_stmtContext extends ParserRuleContext {
		public Import_nameContext import_name() {
			return getRuleContext(Import_nameContext.class,0);
		}
		public Import_fromContext import_from() {
			return getRuleContext(Import_fromContext.class,0);
		}
		public Import_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_import_stmt);
		try {
			setState(469);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(467); 
				import_name();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(468); 
				import_from();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_nameContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Python3Parser.IMPORT, 0); }
		public Dotted_as_namesContext dotted_as_names() {
			return getRuleContext(Dotted_as_namesContext.class,0);
		}
		public Import_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_nameContext import_name() throws RecognitionException {
		Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_import_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); 
			match(IMPORT);
			setState(472); 
			dotted_as_names();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_fromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(Python3Parser.FROM, 0); }
		public TerminalNode IMPORT() { return getToken(Python3Parser.IMPORT, 0); }
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public Import_as_namesContext import_as_names() {
			return getRuleContext(Import_as_namesContext.class,0);
		}
		public Import_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_from(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_fromContext import_from() throws RecognitionException {
		Import_fromContext _localctx = new Import_fromContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_import_from);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); 
			match(FROM);
			setState(487);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT || _la==ELLIPSIS) {
					{
					{
					setState(475);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(480);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(481); 
				dotted_name();
				}
				break;
			case 2:
				{
				setState(483); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(482);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(485); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT || _la==ELLIPSIS );
				}
				break;
			}
			setState(489); 
			match(IMPORT);
			setState(496);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(490); 
				match(STAR);
				}
				break;
			case OPEN_PAREN:
				{
				setState(491); 
				match(OPEN_PAREN);
				setState(492); 
				import_as_names();
				setState(493); 
				match(CLOSE_PAREN);
				}
				break;
			case NAME:
				{
				setState(495); 
				import_as_names();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_as_nameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public Import_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_as_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_as_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_as_nameContext import_as_name() throws RecognitionException {
		Import_as_nameContext _localctx = new Import_as_nameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_import_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); 
			match(NAME);
			setState(501);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(499); 
				match(AS);
				setState(500); 
				match(NAME);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dotted_as_nameContext extends ParserRuleContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public Dotted_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDotted_as_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_as_nameContext dotted_as_name() throws RecognitionException {
		Dotted_as_nameContext _localctx = new Dotted_as_nameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dotted_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); 
			dotted_name();
			setState(506);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(504); 
				match(AS);
				setState(505); 
				match(NAME);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_as_namesContext extends ParserRuleContext {
		public List<Import_as_nameContext> import_as_name() {
			return getRuleContexts(Import_as_nameContext.class);
		}
		public Import_as_nameContext import_as_name(int i) {
			return getRuleContext(Import_as_nameContext.class,i);
		}
		public Import_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_as_names; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitImport_as_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_as_namesContext import_as_names() throws RecognitionException {
		Import_as_namesContext _localctx = new Import_as_namesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_import_as_names);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(508); 
			import_as_name();
			setState(513);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(509); 
					match(COMMA);
					setState(510); 
					import_as_name();
					}
					} 
				}
				setState(515);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(517);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(516); 
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dotted_as_namesContext extends ParserRuleContext {
		public List<Dotted_as_nameContext> dotted_as_name() {
			return getRuleContexts(Dotted_as_nameContext.class);
		}
		public Dotted_as_nameContext dotted_as_name(int i) {
			return getRuleContext(Dotted_as_nameContext.class,i);
		}
		public Dotted_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_names; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDotted_as_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_as_namesContext dotted_as_names() throws RecognitionException {
		Dotted_as_namesContext _localctx = new Dotted_as_namesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_dotted_as_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519); 
			dotted_as_name();
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(520); 
				match(COMMA);
				setState(521); 
				dotted_as_name();
				}
				}
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dotted_nameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Dotted_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDotted_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_nameContext dotted_name() throws RecognitionException {
		Dotted_nameContext _localctx = new Dotted_nameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dotted_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527); 
			match(NAME);
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(528); 
				match(DOT);
				setState(529); 
				match(NAME);
				}
				}
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Global_stmtContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(Python3Parser.GLOBAL, 0); }
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Global_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitGlobal_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_stmtContext global_stmt() throws RecognitionException {
		Global_stmtContext _localctx = new Global_stmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_global_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535); 
			match(GLOBAL);
			setState(536); 
			match(NAME);
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(537); 
				match(COMMA);
				setState(538); 
				match(NAME);
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nonlocal_stmtContext extends ParserRuleContext {
		public TerminalNode NONLOCAL() { return getToken(Python3Parser.NONLOCAL, 0); }
		public List<TerminalNode> NAME() { return getTokens(Python3Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(Python3Parser.NAME, i);
		}
		public Nonlocal_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonlocal_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitNonlocal_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nonlocal_stmtContext nonlocal_stmt() throws RecognitionException {
		Nonlocal_stmtContext _localctx = new Nonlocal_stmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_nonlocal_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544); 
			match(NONLOCAL);
			setState(545); 
			match(NAME);
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(546); 
				match(COMMA);
				setState(547); 
				match(NAME);
				}
				}
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assert_stmtContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(Python3Parser.ASSERT, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Assert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAssert_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assert_stmtContext assert_stmt() throws RecognitionException {
		Assert_stmtContext _localctx = new Assert_stmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_assert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553); 
			match(ASSERT);
			setState(554); 
			test();
			setState(557);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(555); 
				match(COMMA);
				setState(556); 
				test();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Try_stmtContext try_stmt() {
			return getRuleContext(Try_stmtContext.class,0);
		}
		public With_stmtContext with_stmt() {
			return getRuleContext(With_stmtContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public DecoratedContext decorated() {
			return getRuleContext(DecoratedContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_compound_stmt);
		try {
			setState(567);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(559); 
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(560); 
				while_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(561); 
				for_stmt();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 4);
				{
				setState(562); 
				try_stmt();
				}
				break;
			case WITH:
				enterOuterAlt(_localctx, 5);
				{
				setState(563); 
				with_stmt();
				}
				break;
			case DEF:
				enterOuterAlt(_localctx, 6);
				{
				setState(564); 
				funcdef();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 7);
				{
				setState(565); 
				classdef();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 8);
				{
				setState(566); 
				decorated();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Python3Parser.IF, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(Python3Parser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(Python3Parser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569); 
			match(IF);
			setState(570); 
			test();
			setState(571); 
			match(COLON);
			setState(572); 
			suite();
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(573); 
				match(ELIF);
				setState(574); 
				test();
				setState(575); 
				match(COLON);
				setState(576); 
				suite();
				}
				}
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(586);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(583); 
				match(ELSE);
				setState(584); 
				match(COLON);
				setState(585); 
				suite();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Python3Parser.WHILE, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588); 
			match(WHILE);
			setState(589); 
			test();
			setState(590); 
			match(COLON);
			setState(591); 
			suite();
			setState(595);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(592); 
				match(ELSE);
				setState(593); 
				match(COLON);
				setState(594); 
				suite();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Python3Parser.FOR, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); 
			match(FOR);
			setState(598); 
			exprlist();
			setState(599); 
			match(IN);
			setState(600); 
			testlist();
			setState(601); 
			match(COLON);
			setState(602); 
			suite();
			setState(606);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(603); 
				match(ELSE);
				setState(604); 
				match(COLON);
				setState(605); 
				suite();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Try_stmtContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(Python3Parser.TRY, 0); }
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode FINALLY() { return getToken(Python3Parser.FINALLY, 0); }
		public List<Except_clauseContext> except_clause() {
			return getRuleContexts(Except_clauseContext.class);
		}
		public Except_clauseContext except_clause(int i) {
			return getRuleContext(Except_clauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public Try_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTry_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Try_stmtContext try_stmt() throws RecognitionException {
		Try_stmtContext _localctx = new Try_stmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_try_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608); 
			match(TRY);
			setState(609); 
			match(COLON);
			setState(610); 
			suite();
			setState(632);
			switch (_input.LA(1)) {
			case EXCEPT:
				{
				setState(615); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(611); 
					except_clause();
					setState(612); 
					match(COLON);
					setState(613); 
					suite();
					}
					}
					setState(617); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(622);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(619); 
					match(ELSE);
					setState(620); 
					match(COLON);
					setState(621); 
					suite();
					}
				}

				setState(627);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(624); 
					match(FINALLY);
					setState(625); 
					match(COLON);
					setState(626); 
					suite();
					}
				}

				}
				break;
			case FINALLY:
				{
				setState(629); 
				match(FINALLY);
				setState(630); 
				match(COLON);
				setState(631); 
				suite();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_stmtContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(Python3Parser.WITH, 0); }
		public List<With_itemContext> with_item() {
			return getRuleContexts(With_itemContext.class);
		}
		public With_itemContext with_item(int i) {
			return getRuleContext(With_itemContext.class,i);
		}
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public With_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitWith_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_stmtContext with_stmt() throws RecognitionException {
		With_stmtContext _localctx = new With_stmtContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_with_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634); 
			match(WITH);
			setState(635); 
			with_item();
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(636); 
				match(COMMA);
				setState(637); 
				with_item();
				}
				}
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(643); 
			match(COLON);
			setState(644); 
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_itemContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public With_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_item; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitWith_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_itemContext with_item() throws RecognitionException {
		With_itemContext _localctx = new With_itemContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_with_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646); 
			test();
			setState(649);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(647); 
				match(AS);
				setState(648); 
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Except_clauseContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(Python3Parser.EXCEPT, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode AS() { return getToken(Python3Parser.AS, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public Except_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_clause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExcept_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_clauseContext except_clause() throws RecognitionException {
		Except_clauseContext _localctx = new Except_clauseContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_except_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651); 
			match(EXCEPT);
			setState(657);
			_la = _input.LA(1);
			if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
				{
				setState(652); 
				test();
				setState(655);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(653); 
					match(AS);
					setState(654); 
					match(NAME);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(Python3Parser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(Python3Parser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_suite);
		int _la;
		try {
			setState(669);
			switch (_input.LA(1)) {
			case RETURN:
			case RAISE:
			case FROM:
			case IMPORT:
			case GLOBAL:
			case NONLOCAL:
			case ASSERT:
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case YIELD:
			case DEL:
			case PASS:
			case CONTINUE:
			case BREAK:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(659); 
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(660); 
				match(NEWLINE);
				setState(661); 
				match(INDENT);
				setState(663); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(662); 
					stmt();
					}
					}
					setState(665); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF) | (1L << RETURN) | (1L << RAISE) | (1L << FROM) | (1L << IMPORT) | (1L << GLOBAL) | (1L << NONLOCAL) | (1L << ASSERT) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << TRY) | (1L << WITH) | (1L << LAMBDA) | (1L << NOT) | (1L << NONE) | (1L << TRUE) | (1L << FALSE) | (1L << CLASS) | (1L << YIELD) | (1L << DEL) | (1L << PASS) | (1L << CONTINUE) | (1L << BREAK) | (1L << NAME) | (1L << STRING_LITERAL) | (1L << BYTES_LITERAL) | (1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER) | (1L << FLOAT_NUMBER) | (1L << IMAG_NUMBER) | (1L << ELLIPSIS) | (1L << STAR) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (NOT_OP - 66)) | (1L << (OPEN_BRACE - 66)) | (1L << (AT - 66)))) != 0) );
				setState(667); 
				match(DEDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestContext extends ParserRuleContext {
		public List<Or_testContext> or_test() {
			return getRuleContexts(Or_testContext.class);
		}
		public Or_testContext or_test(int i) {
			return getRuleContext(Or_testContext.class,i);
		}
		public TerminalNode IF() { return getToken(Python3Parser.IF, 0); }
		public TerminalNode ELSE() { return getToken(Python3Parser.ELSE, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public LambdefContext lambdef() {
			return getRuleContext(LambdefContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_test);
		int _la;
		try {
			setState(680);
			switch (_input.LA(1)) {
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(671); 
				or_test();
				setState(677);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(672); 
					match(IF);
					setState(673); 
					or_test();
					setState(674); 
					match(ELSE);
					setState(675); 
					test();
					}
				}

				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(679); 
				lambdef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Test_nocondContext extends ParserRuleContext {
		public Or_testContext or_test() {
			return getRuleContext(Or_testContext.class,0);
		}
		public Lambdef_nocondContext lambdef_nocond() {
			return getRuleContext(Lambdef_nocondContext.class,0);
		}
		public Test_nocondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_nocond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTest_nocond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_nocondContext test_nocond() throws RecognitionException {
		Test_nocondContext _localctx = new Test_nocondContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_test_nocond);
		try {
			setState(684);
			switch (_input.LA(1)) {
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(682); 
				or_test();
				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(683); 
				lambdef_nocond();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdefContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(Python3Parser.LAMBDA, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public VarargslistContext varargslist() {
			return getRuleContext(VarargslistContext.class,0);
		}
		public LambdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitLambdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdefContext lambdef() throws RecognitionException {
		LambdefContext _localctx = new LambdefContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_lambdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686); 
			match(LAMBDA);
			setState(688);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STAR) | (1L << POWER))) != 0)) {
				{
				setState(687); 
				varargslist();
				}
			}

			setState(690); 
			match(COLON);
			setState(691); 
			test();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambdef_nocondContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(Python3Parser.LAMBDA, 0); }
		public Test_nocondContext test_nocond() {
			return getRuleContext(Test_nocondContext.class,0);
		}
		public VarargslistContext varargslist() {
			return getRuleContext(VarargslistContext.class,0);
		}
		public Lambdef_nocondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdef_nocond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitLambdef_nocond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambdef_nocondContext lambdef_nocond() throws RecognitionException {
		Lambdef_nocondContext _localctx = new Lambdef_nocondContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_lambdef_nocond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693); 
			match(LAMBDA);
			setState(695);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STAR) | (1L << POWER))) != 0)) {
				{
				setState(694); 
				varargslist();
				}
			}

			setState(697); 
			match(COLON);
			setState(698); 
			test_nocond();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_testContext extends ParserRuleContext {
		public List<And_testContext> and_test() {
			return getRuleContexts(And_testContext.class);
		}
		public And_testContext and_test(int i) {
			return getRuleContext(And_testContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(Python3Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(Python3Parser.OR, i);
		}
		public Or_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_test; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitOr_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_testContext or_test() throws RecognitionException {
		Or_testContext _localctx = new Or_testContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_or_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700); 
			and_test();
			setState(705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(701); 
				match(OR);
				setState(702); 
				and_test();
				}
				}
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_testContext extends ParserRuleContext {
		public List<Not_testContext> not_test() {
			return getRuleContexts(Not_testContext.class);
		}
		public Not_testContext not_test(int i) {
			return getRuleContext(Not_testContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(Python3Parser.AND); }
		public TerminalNode AND(int i) {
			return getToken(Python3Parser.AND, i);
		}
		public And_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_test; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAnd_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_testContext and_test() throws RecognitionException {
		And_testContext _localctx = new And_testContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_and_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708); 
			not_test();
			setState(713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(709); 
				match(AND);
				setState(710); 
				not_test();
				}
				}
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Not_testContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(Python3Parser.NOT, 0); }
		public Not_testContext not_test() {
			return getRuleContext(Not_testContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public Not_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_test; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitNot_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_testContext not_test() throws RecognitionException {
		Not_testContext _localctx = new Not_testContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_not_test);
		try {
			setState(719);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(716); 
				match(NOT);
				setState(717); 
				not_test();
				}
				break;
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(718); 
				comparison();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public List<Comp_opContext> comp_op() {
			return getRuleContexts(Comp_opContext.class);
		}
		public Comp_opContext comp_op(int i) {
			return getRuleContext(Comp_opContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721); 
			star_expr();
			setState(727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (IN - 15)) | (1L << (NOT - 15)) | (1L << (IS - 15)) | (1L << (LESS_THAN - 15)) | (1L << (GREATER_THAN - 15)) | (1L << (EQUALS - 15)) | (1L << (GT_EQ - 15)) | (1L << (LT_EQ - 15)) | (1L << (NOT_EQ_1 - 15)) | (1L << (NOT_EQ_2 - 15)))) != 0)) {
				{
				{
				setState(722); 
				comp_op();
				setState(723); 
				star_expr();
				}
				}
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public TerminalNode NOT() { return getToken(Python3Parser.NOT, 0); }
		public TerminalNode IS() { return getToken(Python3Parser.IS, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_comp_op);
		try {
			setState(743);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(730); 
				match(LESS_THAN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(731); 
				match(GREATER_THAN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(732); 
				match(EQUALS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(733); 
				match(GT_EQ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(734); 
				match(LT_EQ);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(735); 
				match(NOT_EQ_1);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(736); 
				match(NOT_EQ_2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(737); 
				match(IN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(738); 
				match(NOT);
				setState(739); 
				match(IN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(740); 
				match(IS);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(741); 
				match(IS);
				setState(742); 
				match(NOT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Star_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Star_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitStar_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_exprContext star_expr() throws RecognitionException {
		Star_exprContext _localctx = new Star_exprContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_star_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(745); 
				match(STAR);
				}
			}

			setState(748); 
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750); 
			xor_expr();
			setState(755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_OP) {
				{
				{
				setState(751); 
				match(OR_OP);
				setState(752); 
				xor_expr();
				}
				}
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Xor_exprContext extends ParserRuleContext {
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitXor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_xor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758); 
			and_expr();
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==XOR) {
				{
				{
				setState(759); 
				match(XOR);
				setState(760); 
				and_expr();
				}
				}
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_exprContext extends ParserRuleContext {
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766); 
			shift_expr();
			setState(771);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_OP) {
				{
				{
				setState(767); 
				match(AND_OP);
				setState(768); 
				shift_expr();
				}
				}
				setState(773);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_exprContext extends ParserRuleContext {
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_shift_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774); 
			arith_expr();
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_SHIFT || _la==RIGHT_SHIFT) {
				{
				setState(779);
				switch (_input.LA(1)) {
				case LEFT_SHIFT:
					{
					setState(775); 
					match(LEFT_SHIFT);
					setState(776); 
					arith_expr();
					}
					break;
				case RIGHT_SHIFT:
					{
					setState(777); 
					match(RIGHT_SHIFT);
					setState(778); 
					arith_expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(783);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arith_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitArith_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_arith_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784); 
			term();
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==MINUS) {
				{
				setState(789);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(785); 
					match(ADD);
					setState(786); 
					term();
					}
					break;
				case MINUS:
					{
					setState(787); 
					match(MINUS);
					setState(788); 
					term();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(793);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794); 
			factor();
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (STAR - 46)) | (1L << (DIV - 46)) | (1L << (MOD - 46)) | (1L << (IDIV - 46)) | (1L << (AT - 46)))) != 0)) {
				{
				setState(805);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(795); 
					match(STAR);
					setState(796); 
					factor();
					}
					break;
				case DIV:
					{
					setState(797); 
					match(DIV);
					setState(798); 
					factor();
					}
					break;
				case MOD:
					{
					setState(799); 
					match(MOD);
					setState(800); 
					factor();
					}
					break;
				case IDIV:
					{
					setState(801); 
					match(IDIV);
					setState(802); 
					factor();
					}
					break;
				case AT:
					{
					setState(803); 
					match(AT);
					setState(804); 
					factor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(809);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_factor);
		try {
			setState(817);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(810); 
				match(ADD);
				setState(811); 
				factor();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(812); 
				match(MINUS);
				setState(813); 
				factor();
				}
				break;
			case NOT_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(814); 
				match(NOT_OP);
				setState(815); 
				factor();
				}
				break;
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(816); 
				power();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowerContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TrailerContext> trailer() {
			return getRuleContexts(TrailerContext.class);
		}
		public TrailerContext trailer(int i) {
			return getRuleContext(TrailerContext.class,i);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_power);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819); 
			atom();
			setState(823);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK))) != 0)) {
				{
				{
				setState(820); 
				trailer();
				}
				}
				setState(825);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(828);
			_la = _input.LA(1);
			if (_la==POWER) {
				{
				setState(826); 
				match(POWER);
				setState(827); 
				factor();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Testlist_compContext testlist_comp() {
			return getRuleContext(Testlist_compContext.class,0);
		}
		public DictorsetmakerContext dictorsetmaker() {
			return getRuleContext(DictorsetmakerContext.class,0);
		}
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public TerminalNode NONE() { return getToken(Python3Parser.NONE, 0); }
		public TerminalNode TRUE() { return getToken(Python3Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Python3Parser.FALSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_atom);
		int _la;
		try {
			setState(857);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(830); 
				match(OPEN_PAREN);
				setState(833);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(831); 
					yield_expr();
					}
					break;
				case LAMBDA:
				case NOT:
				case NONE:
				case TRUE:
				case FALSE:
				case NAME:
				case STRING_LITERAL:
				case BYTES_LITERAL:
				case DECIMAL_INTEGER:
				case OCT_INTEGER:
				case HEX_INTEGER:
				case BIN_INTEGER:
				case FLOAT_NUMBER:
				case IMAG_NUMBER:
				case ELLIPSIS:
				case STAR:
				case OPEN_PAREN:
				case OPEN_BRACK:
				case ADD:
				case MINUS:
				case NOT_OP:
				case OPEN_BRACE:
					{
					setState(832); 
					testlist_comp();
					}
					break;
				case CLOSE_PAREN:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(835); 
				match(CLOSE_PAREN);
				}
				break;
			case OPEN_BRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(836); 
				match(OPEN_BRACK);
				setState(838);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(837); 
					testlist_comp();
					}
				}

				setState(840); 
				match(CLOSE_BRACK);
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(841); 
				match(OPEN_BRACE);
				setState(843);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(842); 
					dictorsetmaker();
					}
				}

				setState(845); 
				match(CLOSE_BRACE);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(846); 
				match(NAME);
				}
				break;
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 5);
				{
				setState(847); 
				number();
				}
				break;
			case STRING_LITERAL:
			case BYTES_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(849); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(848); 
					string();
					}
					}
					setState(851); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STRING_LITERAL || _la==BYTES_LITERAL );
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 7);
				{
				setState(853); 
				match(ELLIPSIS);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 8);
				{
				setState(854); 
				match(NONE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 9);
				{
				setState(855); 
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 10);
				{
				setState(856); 
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Testlist_compContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public Testlist_compContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist_comp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTestlist_comp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Testlist_compContext testlist_comp() throws RecognitionException {
		Testlist_compContext _localctx = new Testlist_compContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_testlist_comp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(859); 
			test();
			setState(871);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(860); 
				comp_for();
				}
				break;
			case CLOSE_PAREN:
			case COMMA:
			case CLOSE_BRACK:
				{
				setState(865);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(861); 
						match(COMMA);
						setState(862); 
						test();
						}
						} 
					}
					setState(867);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				setState(869);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(868); 
					match(COMMA);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailerContext extends ParserRuleContext {
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public SubscriptlistContext subscriptlist() {
			return getRuleContext(SubscriptlistContext.class,0);
		}
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public TrailerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTrailer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrailerContext trailer() throws RecognitionException {
		TrailerContext _localctx = new TrailerContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_trailer);
		int _la;
		try {
			setState(884);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(873); 
				match(OPEN_PAREN);
				setState(875);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (POWER - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(874); 
					arglist();
					}
				}

				setState(877); 
				match(CLOSE_PAREN);
				}
				break;
			case OPEN_BRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(878); 
				match(OPEN_BRACK);
				setState(879); 
				subscriptlist();
				setState(880); 
				match(CLOSE_BRACK);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(882); 
				match(DOT);
				setState(883); 
				match(NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubscriptlistContext extends ParserRuleContext {
		public List<SubscriptContext> subscript() {
			return getRuleContexts(SubscriptContext.class);
		}
		public SubscriptContext subscript(int i) {
			return getRuleContext(SubscriptContext.class,i);
		}
		public SubscriptlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSubscriptlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptlistContext subscriptlist() throws RecognitionException {
		SubscriptlistContext _localctx = new SubscriptlistContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_subscriptlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(886); 
			subscript();
			setState(891);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(887); 
					match(COMMA);
					setState(888); 
					subscript();
					}
					} 
				}
				setState(893);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			}
			setState(895);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(894); 
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubscriptContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public SliceopContext sliceop() {
			return getRuleContext(SliceopContext.class,0);
		}
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptContext subscript() throws RecognitionException {
		SubscriptContext _localctx = new SubscriptContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_subscript);
		int _la;
		try {
			setState(908);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(897); 
				test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(899);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(898); 
					test();
					}
				}

				setState(901); 
				match(COLON);
				setState(903);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(902); 
					test();
					}
				}

				setState(906);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(905); 
					sliceop();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SliceopContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public SliceopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitSliceop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SliceopContext sliceop() throws RecognitionException {
		SliceopContext _localctx = new SliceopContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_sliceop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910); 
			match(COLON);
			setState(912);
			_la = _input.LA(1);
			if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
				{
				setState(911); 
				test();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprlistContext extends ParserRuleContext {
		public List<Star_exprContext> star_expr() {
			return getRuleContexts(Star_exprContext.class);
		}
		public Star_exprContext star_expr(int i) {
			return getRuleContext(Star_exprContext.class,i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitExprlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_exprlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(914); 
			star_expr();
			setState(919);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(915); 
					match(COMMA);
					setState(916); 
					star_expr();
					}
					} 
				}
				setState(921);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(923);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(922); 
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestlistContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TestlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitTestlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestlistContext testlist() throws RecognitionException {
		TestlistContext _localctx = new TestlistContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_testlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(925); 
			test();
			setState(930);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(926); 
					match(COMMA);
					setState(927); 
					test();
					}
					} 
				}
				setState(932);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			setState(934);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(933); 
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DictorsetmakerContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public DictorsetmakerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictorsetmaker; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitDictorsetmaker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictorsetmakerContext dictorsetmaker() throws RecognitionException {
		DictorsetmakerContext _localctx = new DictorsetmakerContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_dictorsetmaker);
		int _la;
		try {
			int _alt;
			setState(969);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(936); 
				test();
				setState(937); 
				match(COLON);
				setState(938); 
				test();
				setState(953);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(939); 
					comp_for();
					}
					break;
				case COMMA:
				case CLOSE_BRACE:
					{
					setState(947);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(940); 
							match(COMMA);
							setState(941); 
							test();
							setState(942); 
							match(COLON);
							setState(943); 
							test();
							}
							} 
						}
						setState(949);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
					}
					setState(951);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(950); 
						match(COMMA);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(955); 
				test();
				setState(967);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(956); 
					comp_for();
					}
					break;
				case COMMA:
				case CLOSE_BRACE:
					{
					setState(961);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(957); 
							match(COMMA);
							setState(958); 
							test();
							}
							} 
						}
						setState(963);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
					}
					setState(965);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(964); 
						match(COMMA);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassdefContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(Python3Parser.CLASS, 0); }
		public TerminalNode NAME() { return getToken(Python3Parser.NAME, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitClassdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(971); 
			match(CLASS);
			setState(972); 
			match(NAME);
			setState(978);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(973); 
				match(OPEN_PAREN);
				setState(975);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LAMBDA - 20)) | (1L << (NOT - 20)) | (1L << (NONE - 20)) | (1L << (TRUE - 20)) | (1L << (FALSE - 20)) | (1L << (NAME - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BYTES_LITERAL - 20)) | (1L << (DECIMAL_INTEGER - 20)) | (1L << (OCT_INTEGER - 20)) | (1L << (HEX_INTEGER - 20)) | (1L << (BIN_INTEGER - 20)) | (1L << (FLOAT_NUMBER - 20)) | (1L << (IMAG_NUMBER - 20)) | (1L << (ELLIPSIS - 20)) | (1L << (STAR - 20)) | (1L << (OPEN_PAREN - 20)) | (1L << (POWER - 20)) | (1L << (OPEN_BRACK - 20)) | (1L << (ADD - 20)) | (1L << (MINUS - 20)) | (1L << (NOT_OP - 20)) | (1L << (OPEN_BRACE - 20)))) != 0)) {
					{
					setState(974); 
					arglist();
					}
				}

				setState(977); 
				match(CLOSE_PAREN);
				}
			}

			setState(980); 
			match(COLON);
			setState(981); 
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_arglist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(983); 
					argument();
					setState(984); 
					match(COMMA);
					}
					} 
				}
				setState(990);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			}
			setState(1011);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(991); 
				argument();
				setState(993);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(992); 
					match(COMMA);
					}
				}

				}
				break;
			case 2:
				{
				setState(995); 
				match(STAR);
				setState(996); 
				test();
				setState(1001);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(997); 
						match(COMMA);
						setState(998); 
						argument();
						}
						} 
					}
					setState(1003);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
				}
				setState(1007);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1004); 
					match(COMMA);
					setState(1005); 
					match(POWER);
					setState(1006); 
					test();
					}
				}

				}
				break;
			case 3:
				{
				setState(1009); 
				match(POWER);
				setState(1010); 
				test();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_argument);
		int _la;
		try {
			setState(1021);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1013); 
				test();
				setState(1015);
				_la = _input.LA(1);
				if (_la==FOR) {
					{
					setState(1014); 
					comp_for();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1017); 
				test();
				setState(1018); 
				match(ASSIGN);
				setState(1019); 
				test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_iterContext extends ParserRuleContext {
		public Comp_forContext comp_for() {
			return getRuleContext(Comp_forContext.class,0);
		}
		public Comp_ifContext comp_if() {
			return getRuleContext(Comp_ifContext.class,0);
		}
		public Comp_iterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_iter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_iter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_iterContext comp_iter() throws RecognitionException {
		Comp_iterContext _localctx = new Comp_iterContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_comp_iter);
		try {
			setState(1025);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1023); 
				comp_for();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(1024); 
				comp_if();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Python3Parser.FOR, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public Or_testContext or_test() {
			return getRuleContext(Or_testContext.class,0);
		}
		public Comp_iterContext comp_iter() {
			return getRuleContext(Comp_iterContext.class,0);
		}
		public Comp_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_for; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_forContext comp_for() throws RecognitionException {
		Comp_forContext _localctx = new Comp_forContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_comp_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1027); 
			match(FOR);
			setState(1028); 
			exprlist();
			setState(1029); 
			match(IN);
			setState(1030); 
			or_test();
			setState(1032);
			_la = _input.LA(1);
			if (_la==IF || _la==FOR) {
				{
				setState(1031); 
				comp_iter();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Python3Parser.IF, 0); }
		public Test_nocondContext test_nocond() {
			return getRuleContext(Test_nocondContext.class,0);
		}
		public Comp_iterContext comp_iter() {
			return getRuleContext(Comp_iterContext.class,0);
		}
		public Comp_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_if; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComp_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_ifContext comp_if() throws RecognitionException {
		Comp_ifContext _localctx = new Comp_ifContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_comp_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1034); 
			match(IF);
			setState(1035); 
			test_nocond();
			setState(1037);
			_la = _input.LA(1);
			if (_la==IF || _la==FOR) {
				{
				setState(1036); 
				comp_iter();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Yield_exprContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(Python3Parser.YIELD, 0); }
		public Yield_argContext yield_arg() {
			return getRuleContext(Yield_argContext.class,0);
		}
		public Yield_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitYield_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_exprContext yield_expr() throws RecognitionException {
		Yield_exprContext _localctx = new Yield_exprContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_yield_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1039); 
			match(YIELD);
			setState(1041);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (FROM - 4)) | (1L << (LAMBDA - 4)) | (1L << (NOT - 4)) | (1L << (NONE - 4)) | (1L << (TRUE - 4)) | (1L << (FALSE - 4)) | (1L << (NAME - 4)) | (1L << (STRING_LITERAL - 4)) | (1L << (BYTES_LITERAL - 4)) | (1L << (DECIMAL_INTEGER - 4)) | (1L << (OCT_INTEGER - 4)) | (1L << (HEX_INTEGER - 4)) | (1L << (BIN_INTEGER - 4)) | (1L << (FLOAT_NUMBER - 4)) | (1L << (IMAG_NUMBER - 4)) | (1L << (ELLIPSIS - 4)) | (1L << (STAR - 4)) | (1L << (OPEN_PAREN - 4)) | (1L << (OPEN_BRACK - 4)) | (1L << (ADD - 4)) | (1L << (MINUS - 4)) | (1L << (NOT_OP - 4)) | (1L << (OPEN_BRACE - 4)))) != 0)) {
				{
				setState(1040); 
				yield_arg();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Yield_argContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(Python3Parser.FROM, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TestlistContext testlist() {
			return getRuleContext(TestlistContext.class,0);
		}
		public Yield_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_arg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitYield_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_argContext yield_arg() throws RecognitionException {
		Yield_argContext _localctx = new Yield_argContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_yield_arg);
		try {
			setState(1046);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(1043); 
				match(FROM);
				setState(1044); 
				test();
				}
				break;
			case LAMBDA:
			case NOT:
			case NONE:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING_LITERAL:
			case BYTES_LITERAL:
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
			case FLOAT_NUMBER:
			case IMAG_NUMBER:
			case ELLIPSIS:
			case STAR:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case NOT_OP:
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1045); 
				testlist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(Python3Parser.STRING_LITERAL, 0); }
		public TerminalNode BYTES_LITERAL() { return getToken(Python3Parser.BYTES_LITERAL, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			_la = _input.LA(1);
			if ( !(_la==STRING_LITERAL || _la==BYTES_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode FLOAT_NUMBER() { return getToken(Python3Parser.FLOAT_NUMBER, 0); }
		public TerminalNode IMAG_NUMBER() { return getToken(Python3Parser.IMAG_NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_number);
		try {
			setState(1053);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
			case OCT_INTEGER:
			case HEX_INTEGER:
			case BIN_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050); 
				integer();
				}
				break;
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051); 
				match(FLOAT_NUMBER);
				}
				break;
			case IMAG_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1052); 
				match(IMAG_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL_INTEGER() { return getToken(Python3Parser.DECIMAL_INTEGER, 0); }
		public TerminalNode OCT_INTEGER() { return getToken(Python3Parser.OCT_INTEGER, 0); }
		public TerminalNode HEX_INTEGER() { return getToken(Python3Parser.HEX_INTEGER, 0); }
		public TerminalNode BIN_INTEGER() { return getToken(Python3Parser.BIN_INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1055);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_INTEGER) | (1L << OCT_INTEGER) | (1L << HEX_INTEGER) | (1L << BIN_INTEGER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(Python3Parser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Python3Visitor ) return ((Python3Visitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057); 
			match(COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3a\u0426\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\2\5\2\u00b2\n\2\3\3\3\3\7\3\u00b6\n\3\f"+
		"\3\16\3\u00b9\13\3\3\3\3\3\3\4\3\4\7\4\u00bf\n\4\f\4\16\4\u00c2\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\5\5\u00ca\n\5\3\5\5\5\u00cd\n\5\3\5\3\5\3\6\6\6"+
		"\u00d2\n\6\r\6\16\6\u00d3\3\7\3\7\3\7\5\7\u00d9\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00e0\n\b\3\b\3\b\3\b\3\t\3\t\5\t\u00e7\n\t\3\t\3\t\3\n\3\n\3\n"+
		"\5\n\u00ee\n\n\3\n\3\n\3\n\3\n\5\n\u00f4\n\n\7\n\u00f6\n\n\f\n\16\n\u00f9"+
		"\13\n\3\n\3\n\3\n\5\n\u00fe\n\n\3\n\3\n\3\n\3\n\5\n\u0104\n\n\7\n\u0106"+
		"\n\n\f\n\16\n\u0109\13\n\3\n\3\n\3\n\5\n\u010e\n\n\3\n\3\n\5\n\u0112\n"+
		"\n\5\n\u0114\n\n\3\n\3\n\5\n\u0118\n\n\3\n\3\n\3\n\3\n\5\n\u011e\n\n\7"+
		"\n\u0120\n\n\f\n\16\n\u0123\13\n\3\n\3\n\3\n\5\n\u0128\n\n\3\n\3\n\5\n"+
		"\u012c\n\n\3\13\3\13\3\13\5\13\u0131\n\13\3\f\3\f\3\f\5\f\u0136\n\f\3"+
		"\f\3\f\3\f\3\f\5\f\u013c\n\f\7\f\u013e\n\f\f\f\16\f\u0141\13\f\3\f\3\f"+
		"\3\f\5\f\u0146\n\f\3\f\3\f\3\f\3\f\5\f\u014c\n\f\7\f\u014e\n\f\f\f\16"+
		"\f\u0151\13\f\3\f\3\f\3\f\5\f\u0156\n\f\3\f\3\f\5\f\u015a\n\f\5\f\u015c"+
		"\n\f\3\f\3\f\5\f\u0160\n\f\3\f\3\f\3\f\3\f\5\f\u0166\n\f\7\f\u0168\n\f"+
		"\f\f\16\f\u016b\13\f\3\f\3\f\3\f\5\f\u0170\n\f\3\f\3\f\5\f\u0174\n\f\3"+
		"\r\3\r\3\16\3\16\5\16\u017a\n\16\3\17\3\17\3\17\7\17\u017f\n\17\f\17\16"+
		"\17\u0182\13\17\3\17\5\17\u0185\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0191\n\20\3\21\3\21\3\21\3\21\5\21\u0197\n\21\3"+
		"\21\3\21\3\21\5\21\u019c\n\21\7\21\u019e\n\21\f\21\16\21\u01a1\13\21\5"+
		"\21\u01a3\n\21\3\22\3\22\5\22\u01a7\n\22\3\22\3\22\3\22\5\22\u01ac\n\22"+
		"\7\22\u01ae\n\22\f\22\16\22\u01b1\13\22\3\22\5\22\u01b4\n\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u01c2\n\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\5\31\u01ca\n\31\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\5\33\u01d2\n\33\5\33\u01d4\n\33\3\34\3\34\5\34\u01d8\n\34\3\35\3\35\3"+
		"\35\3\36\3\36\7\36\u01df\n\36\f\36\16\36\u01e2\13\36\3\36\3\36\6\36\u01e6"+
		"\n\36\r\36\16\36\u01e7\5\36\u01ea\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\5\36\u01f3\n\36\3\37\3\37\3\37\5\37\u01f8\n\37\3 \3 \3 \5 \u01fd\n"+
		" \3!\3!\3!\7!\u0202\n!\f!\16!\u0205\13!\3!\5!\u0208\n!\3\"\3\"\3\"\7\""+
		"\u020d\n\"\f\"\16\"\u0210\13\"\3#\3#\3#\7#\u0215\n#\f#\16#\u0218\13#\3"+
		"$\3$\3$\3$\7$\u021e\n$\f$\16$\u0221\13$\3%\3%\3%\3%\7%\u0227\n%\f%\16"+
		"%\u022a\13%\3&\3&\3&\3&\5&\u0230\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5"+
		"\'\u023a\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0245\n(\f(\16(\u0248\13(\3"+
		"(\3(\3(\5(\u024d\n(\3)\3)\3)\3)\3)\3)\3)\5)\u0256\n)\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\5*\u0261\n*\3+\3+\3+\3+\3+\3+\3+\6+\u026a\n+\r+\16+\u026b\3"+
		"+\3+\3+\5+\u0271\n+\3+\3+\3+\5+\u0276\n+\3+\3+\3+\5+\u027b\n+\3,\3,\3"+
		",\3,\7,\u0281\n,\f,\16,\u0284\13,\3,\3,\3,\3-\3-\3-\5-\u028c\n-\3.\3."+
		"\3.\3.\5.\u0292\n.\5.\u0294\n.\3/\3/\3/\3/\6/\u029a\n/\r/\16/\u029b\3"+
		"/\3/\5/\u02a0\n/\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u02a8\n\60\3\60\5"+
		"\60\u02ab\n\60\3\61\3\61\5\61\u02af\n\61\3\62\3\62\5\62\u02b3\n\62\3\62"+
		"\3\62\3\62\3\63\3\63\5\63\u02ba\n\63\3\63\3\63\3\63\3\64\3\64\3\64\7\64"+
		"\u02c2\n\64\f\64\16\64\u02c5\13\64\3\65\3\65\3\65\7\65\u02ca\n\65\f\65"+
		"\16\65\u02cd\13\65\3\66\3\66\3\66\5\66\u02d2\n\66\3\67\3\67\3\67\3\67"+
		"\7\67\u02d8\n\67\f\67\16\67\u02db\13\67\38\38\38\38\38\38\38\38\38\38"+
		"\38\38\38\58\u02ea\n8\39\59\u02ed\n9\39\39\3:\3:\3:\7:\u02f4\n:\f:\16"+
		":\u02f7\13:\3;\3;\3;\7;\u02fc\n;\f;\16;\u02ff\13;\3<\3<\3<\7<\u0304\n"+
		"<\f<\16<\u0307\13<\3=\3=\3=\3=\3=\7=\u030e\n=\f=\16=\u0311\13=\3>\3>\3"+
		">\3>\3>\7>\u0318\n>\f>\16>\u031b\13>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\7?\u0328\n?\f?\16?\u032b\13?\3@\3@\3@\3@\3@\3@\3@\5@\u0334\n@\3A\3A\7"+
		"A\u0338\nA\fA\16A\u033b\13A\3A\3A\5A\u033f\nA\3B\3B\3B\5B\u0344\nB\3B"+
		"\3B\3B\5B\u0349\nB\3B\3B\3B\5B\u034e\nB\3B\3B\3B\3B\6B\u0354\nB\rB\16"+
		"B\u0355\3B\3B\3B\3B\5B\u035c\nB\3C\3C\3C\3C\7C\u0362\nC\fC\16C\u0365\13"+
		"C\3C\5C\u0368\nC\5C\u036a\nC\3D\3D\5D\u036e\nD\3D\3D\3D\3D\3D\3D\3D\5"+
		"D\u0377\nD\3E\3E\3E\7E\u037c\nE\fE\16E\u037f\13E\3E\5E\u0382\nE\3F\3F"+
		"\5F\u0386\nF\3F\3F\5F\u038a\nF\3F\5F\u038d\nF\5F\u038f\nF\3G\3G\5G\u0393"+
		"\nG\3H\3H\3H\7H\u0398\nH\fH\16H\u039b\13H\3H\5H\u039e\nH\3I\3I\3I\7I\u03a3"+
		"\nI\fI\16I\u03a6\13I\3I\5I\u03a9\nI\3J\3J\3J\3J\3J\3J\3J\3J\3J\7J\u03b4"+
		"\nJ\fJ\16J\u03b7\13J\3J\5J\u03ba\nJ\5J\u03bc\nJ\3J\3J\3J\3J\7J\u03c2\n"+
		"J\fJ\16J\u03c5\13J\3J\5J\u03c8\nJ\5J\u03ca\nJ\5J\u03cc\nJ\3K\3K\3K\3K"+
		"\5K\u03d2\nK\3K\5K\u03d5\nK\3K\3K\3K\3L\3L\3L\7L\u03dd\nL\fL\16L\u03e0"+
		"\13L\3L\3L\5L\u03e4\nL\3L\3L\3L\3L\7L\u03ea\nL\fL\16L\u03ed\13L\3L\3L"+
		"\3L\5L\u03f2\nL\3L\3L\5L\u03f6\nL\3M\3M\5M\u03fa\nM\3M\3M\3M\3M\5M\u0400"+
		"\nM\3N\3N\5N\u0404\nN\3O\3O\3O\3O\3O\5O\u040b\nO\3P\3P\3P\5P\u0410\nP"+
		"\3Q\3Q\5Q\u0414\nQ\3R\3R\3R\5R\u0419\nR\3S\3S\3T\3T\3T\5T\u0420\nT\3U"+
		"\3U\3V\3V\3V\2\2W\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\2\6\3\2P\\\3\2./\3\2&\'\3\2(+\u0495\2\u00b1"+
		"\3\2\2\2\4\u00b7\3\2\2\2\6\u00bc\3\2\2\2\b\u00c5\3\2\2\2\n\u00d1\3\2\2"+
		"\2\f\u00d5\3\2\2\2\16\u00da\3\2\2\2\20\u00e4\3\2\2\2\22\u012b\3\2\2\2"+
		"\24\u012d\3\2\2\2\26\u0173\3\2\2\2\30\u0175\3\2\2\2\32\u0179\3\2\2\2\34"+
		"\u017b\3\2\2\2\36\u0190\3\2\2\2 \u0192\3\2\2\2\"\u01a6\3\2\2\2$\u01b5"+
		"\3\2\2\2&\u01b7\3\2\2\2(\u01ba\3\2\2\2*\u01c1\3\2\2\2,\u01c3\3\2\2\2."+
		"\u01c5\3\2\2\2\60\u01c7\3\2\2\2\62\u01cb\3\2\2\2\64\u01cd\3\2\2\2\66\u01d7"+
		"\3\2\2\28\u01d9\3\2\2\2:\u01dc\3\2\2\2<\u01f4\3\2\2\2>\u01f9\3\2\2\2@"+
		"\u01fe\3\2\2\2B\u0209\3\2\2\2D\u0211\3\2\2\2F\u0219\3\2\2\2H\u0222\3\2"+
		"\2\2J\u022b\3\2\2\2L\u0239\3\2\2\2N\u023b\3\2\2\2P\u024e\3\2\2\2R\u0257"+
		"\3\2\2\2T\u0262\3\2\2\2V\u027c\3\2\2\2X\u0288\3\2\2\2Z\u028d\3\2\2\2\\"+
		"\u029f\3\2\2\2^\u02aa\3\2\2\2`\u02ae\3\2\2\2b\u02b0\3\2\2\2d\u02b7\3\2"+
		"\2\2f\u02be\3\2\2\2h\u02c6\3\2\2\2j\u02d1\3\2\2\2l\u02d3\3\2\2\2n\u02e9"+
		"\3\2\2\2p\u02ec\3\2\2\2r\u02f0\3\2\2\2t\u02f8\3\2\2\2v\u0300\3\2\2\2x"+
		"\u0308\3\2\2\2z\u0312\3\2\2\2|\u031c\3\2\2\2~\u0333\3\2\2\2\u0080\u0335"+
		"\3\2\2\2\u0082\u035b\3\2\2\2\u0084\u035d\3\2\2\2\u0086\u0376\3\2\2\2\u0088"+
		"\u0378\3\2\2\2\u008a\u038e\3\2\2\2\u008c\u0390\3\2\2\2\u008e\u0394\3\2"+
		"\2\2\u0090\u039f\3\2\2\2\u0092\u03cb\3\2\2\2\u0094\u03cd\3\2\2\2\u0096"+
		"\u03de\3\2\2\2\u0098\u03ff\3\2\2\2\u009a\u0403\3\2\2\2\u009c\u0405\3\2"+
		"\2\2\u009e\u040c\3\2\2\2\u00a0\u0411\3\2\2\2\u00a2\u0418\3\2\2\2\u00a4"+
		"\u041a\3\2\2\2\u00a6\u041f\3\2\2\2\u00a8\u0421\3\2\2\2\u00aa\u0423\3\2"+
		"\2\2\u00ac\u00b2\7$\2\2\u00ad\u00b2\5\34\17\2\u00ae\u00af\5L\'\2\u00af"+
		"\u00b0\7$\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2"+
		"\2\2\u00b1\u00ae\3\2\2\2\u00b2\3\3\2\2\2\u00b3\u00b6\7$\2\2\u00b4\u00b6"+
		"\5\32\16\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2"+
		"\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00ba\u00bb\7\2\2\3\u00bb\5\3\2\2\2\u00bc\u00c0\5\u0090I\2\u00bd"+
		"\u00bf\7$\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c4\7\2\2\3\u00c4\7\3\2\2\2\u00c5\u00c6\7N\2\2\u00c6\u00cc\5D#\2\u00c7"+
		"\u00c9\7\61\2\2\u00c8\u00ca\5\u0096L\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\7\62\2\2\u00cc\u00c7\3\2\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7$\2\2\u00cf\t\3"+
		"\2\2\2\u00d0\u00d2\5\b\5\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\13\3\2\2\2\u00d5\u00d8\5\n\6"+
		"\2\u00d6\u00d9\5\u0094K\2\u00d7\u00d9\5\16\b\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\r\3\2\2\2\u00da\u00db\7\3\2\2\u00db\u00dc\7%\2\2"+
		"\u00dc\u00df\5\20\t\2\u00dd\u00de\7O\2\2\u00de\u00e0\5^\60\2\u00df\u00dd"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\64\2\2"+
		"\u00e2\u00e3\5\\/\2\u00e3\17\3\2\2\2\u00e4\u00e6\7\61\2\2\u00e5\u00e7"+
		"\5\22\n\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2"+
		"\u00e8\u00e9\7\62\2\2\u00e9\21\3\2\2\2\u00ea\u00ed\5\24\13\2\u00eb\u00ec"+
		"\7\67\2\2\u00ec\u00ee\5^\60\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2"+
		"\u00ee\u00f7\3\2\2\2\u00ef\u00f0\7\63\2\2\u00f0\u00f3\5\24\13\2\u00f1"+
		"\u00f2\7\67\2\2\u00f2\u00f4\5^\60\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3"+
		"\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ef\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u0113\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u0111\7\63\2\2\u00fb\u00fd\7\60\2\2\u00fc\u00fe\5\24\13\2\u00fd"+
		"\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0107\3\2\2\2\u00ff\u0100\7\63"+
		"\2\2\u0100\u0103\5\24\13\2\u0101\u0102\7\67\2\2\u0102\u0104\5^\60\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u00ff\3\2"+
		"\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u010d\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7\63\2\2\u010b\u010c\7"+
		"\66\2\2\u010c\u010e\5\24\13\2\u010d\u010a\3\2\2\2\u010d\u010e\3\2\2\2"+
		"\u010e\u0112\3\2\2\2\u010f\u0110\7\66\2\2\u0110\u0112\5\24\13\2\u0111"+
		"\u00fb\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2"+
		"\2\2\u0113\u00fa\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u012c\3\2\2\2\u0115"+
		"\u0117\7\60\2\2\u0116\u0118\5\24\13\2\u0117\u0116\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0121\3\2\2\2\u0119\u011a\7\63\2\2\u011a\u011d\5\24\13"+
		"\2\u011b\u011c\7\67\2\2\u011c\u011e\5^\60\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u0119\3\2\2\2\u0120\u0123\3\2"+
		"\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0127\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0125\7\63\2\2\u0125\u0126\7\66\2\2\u0126\u0128\5"+
		"\24\13\2\u0127\u0124\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012c\3\2\2\2\u0129"+
		"\u012a\7\66\2\2\u012a\u012c\5\24\13\2\u012b\u00ea\3\2\2\2\u012b\u0115"+
		"\3\2\2\2\u012b\u0129\3\2\2\2\u012c\23\3\2\2\2\u012d\u0130\7%\2\2\u012e"+
		"\u012f\7\64\2\2\u012f\u0131\5^\60\2\u0130\u012e\3\2\2\2\u0130\u0131\3"+
		"\2\2\2\u0131\25\3\2\2\2\u0132\u0135\5\30\r\2\u0133\u0134\7\67\2\2\u0134"+
		"\u0136\5^\60\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u013f\3\2"+
		"\2\2\u0137\u0138\7\63\2\2\u0138\u013b\5\30\r\2\u0139\u013a\7\67\2\2\u013a"+
		"\u013c\5^\60\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2"+
		"\2\2\u013d\u0137\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u015b\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0159\7\63"+
		"\2\2\u0143\u0145\7\60\2\2\u0144\u0146\5\30\r\2\u0145\u0144\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u014f\3\2\2\2\u0147\u0148\7\63\2\2\u0148\u014b\5"+
		"\30\r\2\u0149\u014a\7\67\2\2\u014a\u014c\5^\60\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u0147\3\2\2\2\u014e\u0151\3\2"+
		"\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0155\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0153\7\63\2\2\u0153\u0154\7\66\2\2\u0154\u0156\5"+
		"\30\r\2\u0155\u0152\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u015a\3\2\2\2\u0157"+
		"\u0158\7\66\2\2\u0158\u015a\5\30\r\2\u0159\u0143\3\2\2\2\u0159\u0157\3"+
		"\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0142\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u0174\3\2\2\2\u015d\u015f\7\60\2\2\u015e\u0160\5"+
		"\30\r\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0169\3\2\2\2\u0161"+
		"\u0162\7\63\2\2\u0162\u0165\5\30\r\2\u0163\u0164\7\67\2\2\u0164\u0166"+
		"\5^\60\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167"+
		"\u0161\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2"+
		"\2\2\u016a\u016f\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7\63\2\2\u016d"+
		"\u016e\7\66\2\2\u016e\u0170\5\30\r\2\u016f\u016c\3\2\2\2\u016f\u0170\3"+
		"\2\2\2\u0170\u0174\3\2\2\2\u0171\u0172\7\66\2\2\u0172\u0174\5\30\r\2\u0173"+
		"\u0132\3\2\2\2\u0173\u015d\3\2\2\2\u0173\u0171\3\2\2\2\u0174\27\3\2\2"+
		"\2\u0175\u0176\7%\2\2\u0176\31\3\2\2\2\u0177\u017a\5\34\17\2\u0178\u017a"+
		"\5L\'\2\u0179\u0177\3\2\2\2\u0179\u0178\3\2\2\2\u017a\33\3\2\2\2\u017b"+
		"\u0180\5\36\20\2\u017c\u017d\7\65\2\2\u017d\u017f\5\36\20\2\u017e\u017c"+
		"\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0185\7\65\2\2\u0184\u0183\3"+
		"\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\7$\2\2\u0187"+
		"\35\3\2\2\2\u0188\u0191\5 \21\2\u0189\u0191\5&\24\2\u018a\u0191\5(\25"+
		"\2\u018b\u0191\5*\26\2\u018c\u0191\5\66\34\2\u018d\u0191\5F$\2\u018e\u0191"+
		"\5H%\2\u018f\u0191\5J&\2\u0190\u0188\3\2\2\2\u0190\u0189\3\2\2\2\u0190"+
		"\u018a\3\2\2\2\u0190\u018b\3\2\2\2\u0190\u018c\3\2\2\2\u0190\u018d\3\2"+
		"\2\2\u0190\u018e\3\2\2\2\u0190\u018f\3\2\2\2\u0191\37\3\2\2\2\u0192\u01a2"+
		"\5\"\22\2\u0193\u0196\5$\23\2\u0194\u0197\5\u00a0Q\2\u0195\u0197\5\u0090"+
		"I\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197\u01a3\3\2\2\2\u0198"+
		"\u019b\7\67\2\2\u0199\u019c\5\u00a0Q\2\u019a\u019c\5\"\22\2\u019b\u0199"+
		"\3\2\2\2\u019b\u019a\3\2\2\2\u019c\u019e\3\2\2\2\u019d\u0198\3\2\2\2\u019e"+
		"\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a3\3\2"+
		"\2\2\u01a1\u019f\3\2\2\2\u01a2\u0193\3\2\2\2\u01a2\u019f\3\2\2\2\u01a3"+
		"!\3\2\2\2\u01a4\u01a7\5^\60\2\u01a5\u01a7\5p9\2\u01a6\u01a4\3\2\2\2\u01a6"+
		"\u01a5\3\2\2\2\u01a7\u01af\3\2\2\2\u01a8\u01ab\7\63\2\2\u01a9\u01ac\5"+
		"^\60\2\u01aa\u01ac\5p9\2\u01ab\u01a9\3\2\2\2\u01ab\u01aa\3\2\2\2\u01ac"+
		"\u01ae\3\2\2\2\u01ad\u01a8\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2"+
		"\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"\u01b4\7\63\2\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4#\3\2\2\2"+
		"\u01b5\u01b6\t\2\2\2\u01b6%\3\2\2\2\u01b7\u01b8\7 \2\2\u01b8\u01b9\5\u008e"+
		"H\2\u01b9\'\3\2\2\2\u01ba\u01bb\7!\2\2\u01bb)\3\2\2\2\u01bc\u01c2\5,\27"+
		"\2\u01bd\u01c2\5.\30\2\u01be\u01c2\5\60\31\2\u01bf\u01c2\5\64\33\2\u01c0"+
		"\u01c2\5\62\32\2\u01c1\u01bc\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c1\u01be\3"+
		"\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2+\3\2\2\2\u01c3\u01c4"+
		"\7#\2\2\u01c4-\3\2\2\2\u01c5\u01c6\7\"\2\2\u01c6/\3\2\2\2\u01c7\u01c9"+
		"\7\4\2\2\u01c8\u01ca\5\u0090I\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2"+
		"\2\u01ca\61\3\2\2\2\u01cb\u01cc\5\u00a0Q\2\u01cc\63\3\2\2\2\u01cd\u01d3"+
		"\7\5\2\2\u01ce\u01d1\5^\60\2\u01cf\u01d0\7\6\2\2\u01d0\u01d2\5^\60\2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01ce\3\2"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4\65\3\2\2\2\u01d5\u01d8\58\35\2\u01d6\u01d8"+
		"\5:\36\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8\67\3\2\2\2\u01d9"+
		"\u01da\7\7\2\2\u01da\u01db\5B\"\2\u01db9\3\2\2\2\u01dc\u01e9\7\6\2\2\u01dd"+
		"\u01df\t\3\2\2\u01de\u01dd\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2"+
		"\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3"+
		"\u01ea\5D#\2\u01e4\u01e6\t\3\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e7\3\2\2"+
		"\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e0"+
		"\3\2\2\2\u01e9\u01e5\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01f2\7\7\2\2\u01ec"+
		"\u01f3\7\60\2\2\u01ed\u01ee\7\61\2\2\u01ee\u01ef\5@!\2\u01ef\u01f0\7\62"+
		"\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01f3\5@!\2\u01f2\u01ec\3\2\2\2\u01f2\u01ed"+
		"\3\2\2\2\u01f2\u01f1\3\2\2\2\u01f3;\3\2\2\2\u01f4\u01f7\7%\2\2\u01f5\u01f6"+
		"\7\b\2\2\u01f6\u01f8\7%\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"=\3\2\2\2\u01f9\u01fc\5D#\2\u01fa\u01fb\7\b\2\2\u01fb\u01fd\7%\2\2\u01fc"+
		"\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd?\3\2\2\2\u01fe\u0203\5<\37\2"+
		"\u01ff\u0200\7\63\2\2\u0200\u0202\5<\37\2\u0201\u01ff\3\2\2\2\u0202\u0205"+
		"\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0207\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0206\u0208\7\63\2\2\u0207\u0206\3\2\2\2\u0207\u0208\3"+
		"\2\2\2\u0208A\3\2\2\2\u0209\u020e\5> \2\u020a\u020b\7\63\2\2\u020b\u020d"+
		"\5> \2\u020c\u020a\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020fC\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0216\7%\2\2\u0212"+
		"\u0213\7.\2\2\u0213\u0215\7%\2\2\u0214\u0212\3\2\2\2\u0215\u0218\3\2\2"+
		"\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217E\3\2\2\2\u0218\u0216"+
		"\3\2\2\2\u0219\u021a\7\t\2\2\u021a\u021f\7%\2\2\u021b\u021c\7\63\2\2\u021c"+
		"\u021e\7%\2\2\u021d\u021b\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u021d\3\2"+
		"\2\2\u021f\u0220\3\2\2\2\u0220G\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0223"+
		"\7\n\2\2\u0223\u0228\7%\2\2\u0224\u0225\7\63\2\2\u0225\u0227\7%\2\2\u0226"+
		"\u0224\3\2\2\2\u0227\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2"+
		"\2\2\u0229I\3\2\2\2\u022a\u0228\3\2\2\2\u022b\u022c\7\13\2\2\u022c\u022f"+
		"\5^\60\2\u022d\u022e\7\63\2\2\u022e\u0230\5^\60\2\u022f\u022d\3\2\2\2"+
		"\u022f\u0230\3\2\2\2\u0230K\3\2\2\2\u0231\u023a\5N(\2\u0232\u023a\5P)"+
		"\2\u0233\u023a\5R*\2\u0234\u023a\5T+\2\u0235\u023a\5V,\2\u0236\u023a\5"+
		"\16\b\2\u0237\u023a\5\u0094K\2\u0238\u023a\5\f\7\2\u0239\u0231\3\2\2\2"+
		"\u0239\u0232\3\2\2\2\u0239\u0233\3\2\2\2\u0239\u0234\3\2\2\2\u0239\u0235"+
		"\3\2\2\2\u0239\u0236\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u0238\3\2\2\2\u023a"+
		"M\3\2\2\2\u023b\u023c\7\f\2\2\u023c\u023d\5^\60\2\u023d\u023e\7\64\2\2"+
		"\u023e\u0246\5\\/\2\u023f\u0240\7\r\2\2\u0240\u0241\5^\60\2\u0241\u0242"+
		"\7\64\2\2\u0242\u0243\5\\/\2\u0243\u0245\3\2\2\2\u0244\u023f\3\2\2\2\u0245"+
		"\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024c\3\2"+
		"\2\2\u0248\u0246\3\2\2\2\u0249\u024a\7\16\2\2\u024a\u024b\7\64\2\2\u024b"+
		"\u024d\5\\/\2\u024c\u0249\3\2\2\2\u024c\u024d\3\2\2\2\u024dO\3\2\2\2\u024e"+
		"\u024f\7\17\2\2\u024f\u0250\5^\60\2\u0250\u0251\7\64\2\2\u0251\u0255\5"+
		"\\/\2\u0252\u0253\7\16\2\2\u0253\u0254\7\64\2\2\u0254\u0256\5\\/\2\u0255"+
		"\u0252\3\2\2\2\u0255\u0256\3\2\2\2\u0256Q\3\2\2\2\u0257\u0258\7\20\2\2"+
		"\u0258\u0259\5\u008eH\2\u0259\u025a\7\21\2\2\u025a\u025b\5\u0090I\2\u025b"+
		"\u025c\7\64\2\2\u025c\u0260\5\\/\2\u025d\u025e\7\16\2\2\u025e\u025f\7"+
		"\64\2\2\u025f\u0261\5\\/\2\u0260\u025d\3\2\2\2\u0260\u0261\3\2\2\2\u0261"+
		"S\3\2\2\2\u0262\u0263\7\22\2\2\u0263\u0264\7\64\2\2\u0264\u027a\5\\/\2"+
		"\u0265\u0266\5Z.\2\u0266\u0267\7\64\2\2\u0267\u0268\5\\/\2\u0268\u026a"+
		"\3\2\2\2\u0269\u0265\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u0269\3\2\2\2\u026b"+
		"\u026c\3\2\2\2\u026c\u0270\3\2\2\2\u026d\u026e\7\16\2\2\u026e\u026f\7"+
		"\64\2\2\u026f\u0271\5\\/\2\u0270\u026d\3\2\2\2\u0270\u0271\3\2\2\2\u0271"+
		"\u0275\3\2\2\2\u0272\u0273\7\23\2\2\u0273\u0274\7\64\2\2\u0274\u0276\5"+
		"\\/\2\u0275\u0272\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u027b\3\2\2\2\u0277"+
		"\u0278\7\23\2\2\u0278\u0279\7\64\2\2\u0279\u027b\5\\/\2\u027a\u0269\3"+
		"\2\2\2\u027a\u0277\3\2\2\2\u027bU\3\2\2\2\u027c\u027d\7\24\2\2\u027d\u0282"+
		"\5X-\2\u027e\u027f\7\63\2\2\u027f\u0281\5X-\2\u0280\u027e\3\2\2\2\u0281"+
		"\u0284\3\2\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2"+
		"\2\2\u0284\u0282\3\2\2\2\u0285\u0286\7\64\2\2\u0286\u0287\5\\/\2\u0287"+
		"W\3\2\2\2\u0288\u028b\5^\60\2\u0289\u028a\7\b\2\2\u028a\u028c\5r:\2\u028b"+
		"\u0289\3\2\2\2\u028b\u028c\3\2\2\2\u028cY\3\2\2\2\u028d\u0293\7\25\2\2"+
		"\u028e\u0291\5^\60\2\u028f\u0290\7\b\2\2\u0290\u0292\7%\2\2\u0291\u028f"+
		"\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0294\3\2\2\2\u0293\u028e\3\2\2\2\u0293"+
		"\u0294\3\2\2\2\u0294[\3\2\2\2\u0295\u02a0\5\34\17\2\u0296\u0297\7$\2\2"+
		"\u0297\u0299\7`\2\2\u0298\u029a\5\32\16\2\u0299\u0298\3\2\2\2\u029a\u029b"+
		"\3\2\2\2\u029b\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d"+
		"\u029e\7a\2\2\u029e\u02a0\3\2\2\2\u029f\u0295\3\2\2\2\u029f\u0296\3\2"+
		"\2\2\u02a0]\3\2\2\2\u02a1\u02a7\5f\64\2\u02a2\u02a3\7\f\2\2\u02a3\u02a4"+
		"\5f\64\2\u02a4\u02a5\7\16\2\2\u02a5\u02a6\5^\60\2\u02a6\u02a8\3\2\2\2"+
		"\u02a7\u02a2\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02ab\3\2\2\2\u02a9\u02ab"+
		"\5b\62\2\u02aa\u02a1\3\2\2\2\u02aa\u02a9\3\2\2\2\u02ab_\3\2\2\2\u02ac"+
		"\u02af\5f\64\2\u02ad\u02af\5d\63\2\u02ae\u02ac\3\2\2\2\u02ae\u02ad\3\2"+
		"\2\2\u02afa\3\2\2\2\u02b0\u02b2\7\26\2\2\u02b1\u02b3\5\26\f\2\u02b2\u02b1"+
		"\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\7\64\2\2"+
		"\u02b5\u02b6\5^\60\2\u02b6c\3\2\2\2\u02b7\u02b9\7\26\2\2\u02b8\u02ba\5"+
		"\26\f\2\u02b9\u02b8\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb"+
		"\u02bc\7\64\2\2\u02bc\u02bd\5`\61\2\u02bde\3\2\2\2\u02be\u02c3\5h\65\2"+
		"\u02bf\u02c0\7\27\2\2\u02c0\u02c2\5h\65\2\u02c1\u02bf\3\2\2\2\u02c2\u02c5"+
		"\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4g\3\2\2\2\u02c5"+
		"\u02c3\3\2\2\2\u02c6\u02cb\5j\66\2\u02c7\u02c8\7\30\2\2\u02c8\u02ca\5"+
		"j\66\2\u02c9\u02c7\3\2\2\2\u02ca\u02cd\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb"+
		"\u02cc\3\2\2\2\u02cci\3\2\2\2\u02cd\u02cb\3\2\2\2\u02ce\u02cf\7\31\2\2"+
		"\u02cf\u02d2\5j\66\2\u02d0\u02d2\5l\67\2\u02d1\u02ce\3\2\2\2\u02d1\u02d0"+
		"\3\2\2\2\u02d2k\3\2\2\2\u02d3\u02d9\5p9\2\u02d4\u02d5\5n8\2\u02d5\u02d6"+
		"\5p9\2\u02d6\u02d8\3\2\2\2\u02d7\u02d4\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9"+
		"\u02d7\3\2\2\2\u02d9\u02da\3\2\2\2\u02dam\3\2\2\2\u02db\u02d9\3\2\2\2"+
		"\u02dc\u02ea\7G\2\2\u02dd\u02ea\7H\2\2\u02de\u02ea\7I\2\2\u02df\u02ea"+
		"\7J\2\2\u02e0\u02ea\7K\2\2\u02e1\u02ea\7L\2\2\u02e2\u02ea\7M\2\2\u02e3"+
		"\u02ea\7\21\2\2\u02e4\u02e5\7\31\2\2\u02e5\u02ea\7\21\2\2\u02e6\u02ea"+
		"\7\32\2\2\u02e7\u02e8\7\32\2\2\u02e8\u02ea\7\31\2\2\u02e9\u02dc\3\2\2"+
		"\2\u02e9\u02dd\3\2\2\2\u02e9\u02de\3\2\2\2\u02e9\u02df\3\2\2\2\u02e9\u02e0"+
		"\3\2\2\2\u02e9\u02e1\3\2\2\2\u02e9\u02e2\3\2\2\2\u02e9\u02e3\3\2\2\2\u02e9"+
		"\u02e4\3\2\2\2\u02e9\u02e6\3\2\2\2\u02e9\u02e7\3\2\2\2\u02eao\3\2\2\2"+
		"\u02eb\u02ed\7\60\2\2\u02ec\u02eb\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ee"+
		"\3\2\2\2\u02ee\u02ef\5r:\2\u02efq\3\2\2\2\u02f0\u02f5\5t;\2\u02f1\u02f2"+
		"\7:\2\2\u02f2\u02f4\5t;\2\u02f3\u02f1\3\2\2\2\u02f4\u02f7\3\2\2\2\u02f5"+
		"\u02f3\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6s\3\2\2\2\u02f7\u02f5\3\2\2\2"+
		"\u02f8\u02fd\5v<\2\u02f9\u02fa\7;\2\2\u02fa\u02fc\5v<\2\u02fb\u02f9\3"+
		"\2\2\2\u02fc\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe"+
		"u\3\2\2\2\u02ff\u02fd\3\2\2\2\u0300\u0305\5x=\2\u0301\u0302\7<\2\2\u0302"+
		"\u0304\5x=\2\u0303\u0301\3\2\2\2\u0304\u0307\3\2\2\2\u0305\u0303\3\2\2"+
		"\2\u0305\u0306\3\2\2\2\u0306w\3\2\2\2\u0307\u0305\3\2\2\2\u0308\u030f"+
		"\5z>\2\u0309\u030a\7=\2\2\u030a\u030e\5z>\2\u030b\u030c\7>\2\2\u030c\u030e"+
		"\5z>\2\u030d\u0309\3\2\2\2\u030d\u030b\3\2\2\2\u030e\u0311\3\2\2\2\u030f"+
		"\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310y\3\2\2\2\u0311\u030f\3\2\2\2"+
		"\u0312\u0319\5|?\2\u0313\u0314\7?\2\2\u0314\u0318\5|?\2\u0315\u0316\7"+
		"@\2\2\u0316\u0318\5|?\2\u0317\u0313\3\2\2\2\u0317\u0315\3\2\2\2\u0318"+
		"\u031b\3\2\2\2\u0319\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a{\3\2\2\2"+
		"\u031b\u0319\3\2\2\2\u031c\u0329\5~@\2\u031d\u031e\7\60\2\2\u031e\u0328"+
		"\5~@\2\u031f\u0320\7A\2\2\u0320\u0328\5~@\2\u0321\u0322\7B\2\2\u0322\u0328"+
		"\5~@\2\u0323\u0324\7C\2\2\u0324\u0328\5~@\2\u0325\u0326\7N\2\2\u0326\u0328"+
		"\5~@\2\u0327\u031d\3\2\2\2\u0327\u031f\3\2\2\2\u0327\u0321\3\2\2\2\u0327"+
		"\u0323\3\2\2\2\u0327\u0325\3\2\2\2\u0328\u032b\3\2\2\2\u0329\u0327\3\2"+
		"\2\2\u0329\u032a\3\2\2\2\u032a}\3\2\2\2\u032b\u0329\3\2\2\2\u032c\u032d"+
		"\7?\2\2\u032d\u0334\5~@\2\u032e\u032f\7@\2\2\u032f\u0334\5~@\2\u0330\u0331"+
		"\7D\2\2\u0331\u0334\5~@\2\u0332\u0334\5\u0080A\2\u0333\u032c\3\2\2\2\u0333"+
		"\u032e\3\2\2\2\u0333\u0330\3\2\2\2\u0333\u0332\3\2\2\2\u0334\177\3\2\2"+
		"\2\u0335\u0339\5\u0082B\2\u0336\u0338\5\u0086D\2\u0337\u0336\3\2\2\2\u0338"+
		"\u033b\3\2\2\2\u0339\u0337\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033e\3\2"+
		"\2\2\u033b\u0339\3\2\2\2\u033c\u033d\7\66\2\2\u033d\u033f\5~@\2\u033e"+
		"\u033c\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0081\3\2\2\2\u0340\u0343\7\61"+
		"\2\2\u0341\u0344\5\u00a0Q\2\u0342\u0344\5\u0084C\2\u0343\u0341\3\2\2\2"+
		"\u0343\u0342\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u035c"+
		"\7\62\2\2\u0346\u0348\78\2\2\u0347\u0349\5\u0084C\2\u0348\u0347\3\2\2"+
		"\2\u0348\u0349\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u035c\79\2\2\u034b\u034d"+
		"\7E\2\2\u034c\u034e\5\u0092J\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2\2\2"+
		"\u034e\u034f\3\2\2\2\u034f\u035c\7F\2\2\u0350\u035c\7%\2\2\u0351\u035c"+
		"\5\u00a6T\2\u0352\u0354\5\u00a4S\2\u0353\u0352\3\2\2\2\u0354\u0355\3\2"+
		"\2\2\u0355\u0353\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u035c\3\2\2\2\u0357"+
		"\u035c\7/\2\2\u0358\u035c\7\33\2\2\u0359\u035c\7\34\2\2\u035a\u035c\7"+
		"\35\2\2\u035b\u0340\3\2\2\2\u035b\u0346\3\2\2\2\u035b\u034b\3\2\2\2\u035b"+
		"\u0350\3\2\2\2\u035b\u0351\3\2\2\2\u035b\u0353\3\2\2\2\u035b\u0357\3\2"+
		"\2\2\u035b\u0358\3\2\2\2\u035b\u0359\3\2\2\2\u035b\u035a\3\2\2\2\u035c"+
		"\u0083\3\2\2\2\u035d\u0369\5^\60\2\u035e\u036a\5\u009cO\2\u035f\u0360"+
		"\7\63\2\2\u0360\u0362\5^\60\2\u0361\u035f\3\2\2\2\u0362\u0365\3\2\2\2"+
		"\u0363\u0361\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0367\3\2\2\2\u0365\u0363"+
		"\3\2\2\2\u0366\u0368\7\63\2\2\u0367\u0366\3\2\2\2\u0367\u0368\3\2\2\2"+
		"\u0368\u036a\3\2\2\2\u0369\u035e\3\2\2\2\u0369\u0363\3\2\2\2\u036a\u0085"+
		"\3\2\2\2\u036b\u036d\7\61\2\2\u036c\u036e\5\u0096L\2\u036d\u036c\3\2\2"+
		"\2\u036d\u036e\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0377\7\62\2\2\u0370"+
		"\u0371\78\2\2\u0371\u0372\5\u0088E\2\u0372\u0373\79\2\2\u0373\u0377\3"+
		"\2\2\2\u0374\u0375\7.\2\2\u0375\u0377\7%\2\2\u0376\u036b\3\2\2\2\u0376"+
		"\u0370\3\2\2\2\u0376\u0374\3\2\2\2\u0377\u0087\3\2\2\2\u0378\u037d\5\u008a"+
		"F\2\u0379\u037a\7\63\2\2\u037a\u037c\5\u008aF\2\u037b\u0379\3\2\2\2\u037c"+
		"\u037f\3\2\2\2\u037d\u037b\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u0381\3\2"+
		"\2\2\u037f\u037d\3\2\2\2\u0380\u0382\7\63\2\2\u0381\u0380\3\2\2\2\u0381"+
		"\u0382\3\2\2\2\u0382\u0089\3\2\2\2\u0383\u038f\5^\60\2\u0384\u0386\5^"+
		"\60\2\u0385\u0384\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0387\3\2\2\2\u0387"+
		"\u0389\7\64\2\2\u0388\u038a\5^\60\2\u0389\u0388\3\2\2\2\u0389\u038a\3"+
		"\2\2\2\u038a\u038c\3\2\2\2\u038b\u038d\5\u008cG\2\u038c\u038b\3\2\2\2"+
		"\u038c\u038d\3\2\2\2\u038d\u038f\3\2\2\2\u038e\u0383\3\2\2\2\u038e\u0385"+
		"\3\2\2\2\u038f\u008b\3\2\2\2\u0390\u0392\7\64\2\2\u0391\u0393\5^\60\2"+
		"\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u008d\3\2\2\2\u0394\u0399"+
		"\5p9\2\u0395\u0396\7\63\2\2\u0396\u0398\5p9\2\u0397\u0395\3\2\2\2\u0398"+
		"\u039b\3\2\2\2\u0399\u0397\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039d\3\2"+
		"\2\2\u039b\u0399\3\2\2\2\u039c\u039e\7\63\2\2\u039d\u039c\3\2\2\2\u039d"+
		"\u039e\3\2\2\2\u039e\u008f\3\2\2\2\u039f\u03a4\5^\60\2\u03a0\u03a1\7\63"+
		"\2\2\u03a1\u03a3\5^\60\2\u03a2\u03a0\3\2\2\2\u03a3\u03a6\3\2\2\2\u03a4"+
		"\u03a2\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a8\3\2\2\2\u03a6\u03a4\3\2"+
		"\2\2\u03a7\u03a9\7\63\2\2\u03a8\u03a7\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9"+
		"\u0091\3\2\2\2\u03aa\u03ab\5^\60\2\u03ab\u03ac\7\64\2\2\u03ac\u03bb\5"+
		"^\60\2\u03ad\u03bc\5\u009cO\2\u03ae\u03af\7\63\2\2\u03af\u03b0\5^\60\2"+
		"\u03b0\u03b1\7\64\2\2\u03b1\u03b2\5^\60\2\u03b2\u03b4\3\2\2\2\u03b3\u03ae"+
		"\3\2\2\2\u03b4\u03b7\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6"+
		"\u03b9\3\2\2\2\u03b7\u03b5\3\2\2\2\u03b8\u03ba\7\63\2\2\u03b9\u03b8\3"+
		"\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bc\3\2\2\2\u03bb\u03ad\3\2\2\2\u03bb"+
		"\u03b5\3\2\2\2\u03bc\u03cc\3\2\2\2\u03bd\u03c9\5^\60\2\u03be\u03ca\5\u009c"+
		"O\2\u03bf\u03c0\7\63\2\2\u03c0\u03c2\5^\60\2\u03c1\u03bf\3\2\2\2\u03c2"+
		"\u03c5\3\2\2\2\u03c3\u03c1\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c7\3\2"+
		"\2\2\u03c5\u03c3\3\2\2\2\u03c6\u03c8\7\63\2\2\u03c7\u03c6\3\2\2\2\u03c7"+
		"\u03c8\3\2\2\2\u03c8\u03ca\3\2\2\2\u03c9\u03be\3\2\2\2\u03c9\u03c3\3\2"+
		"\2\2\u03ca\u03cc\3\2\2\2\u03cb\u03aa\3\2\2\2\u03cb\u03bd\3\2\2\2\u03cc"+
		"\u0093\3\2\2\2\u03cd\u03ce\7\36\2\2\u03ce\u03d4\7%\2\2\u03cf\u03d1\7\61"+
		"\2\2\u03d0\u03d2\5\u0096L\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2"+
		"\u03d3\3\2\2\2\u03d3\u03d5\7\62\2\2\u03d4\u03cf\3\2\2\2\u03d4\u03d5\3"+
		"\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d7\7\64\2\2\u03d7\u03d8\5\\/\2\u03d8"+
		"\u0095\3\2\2\2\u03d9\u03da\5\u0098M\2\u03da\u03db\7\63\2\2\u03db\u03dd"+
		"\3\2\2\2\u03dc\u03d9\3\2\2\2\u03dd\u03e0\3\2\2\2\u03de\u03dc\3\2\2\2\u03de"+
		"\u03df\3\2\2\2\u03df\u03f5\3\2\2\2\u03e0\u03de\3\2\2\2\u03e1\u03e3\5\u0098"+
		"M\2\u03e2\u03e4\7\63\2\2\u03e3\u03e2\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4"+
		"\u03f6\3\2\2\2\u03e5\u03e6\7\60\2\2\u03e6\u03eb\5^\60\2\u03e7\u03e8\7"+
		"\63\2\2\u03e8\u03ea\5\u0098M\2\u03e9\u03e7\3\2\2\2\u03ea\u03ed\3\2\2\2"+
		"\u03eb\u03e9\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03f1\3\2\2\2\u03ed\u03eb"+
		"\3\2\2\2\u03ee\u03ef\7\63\2\2\u03ef\u03f0\7\66\2\2\u03f0\u03f2\5^\60\2"+
		"\u03f1\u03ee\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f6\3\2\2\2\u03f3\u03f4"+
		"\7\66\2\2\u03f4\u03f6\5^\60\2\u03f5\u03e1\3\2\2\2\u03f5\u03e5\3\2\2\2"+
		"\u03f5\u03f3\3\2\2\2\u03f6\u0097\3\2\2\2\u03f7\u03f9\5^\60\2\u03f8\u03fa"+
		"\5\u009cO\2\u03f9\u03f8\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u0400\3\2\2"+
		"\2\u03fb\u03fc\5^\60\2\u03fc\u03fd\7\67\2\2\u03fd\u03fe\5^\60\2\u03fe"+
		"\u0400\3\2\2\2\u03ff\u03f7\3\2\2\2\u03ff\u03fb\3\2\2\2\u0400\u0099\3\2"+
		"\2\2\u0401\u0404\5\u009cO\2\u0402\u0404\5\u009eP\2\u0403\u0401\3\2\2\2"+
		"\u0403\u0402\3\2\2\2\u0404\u009b\3\2\2\2\u0405\u0406\7\20\2\2\u0406\u0407"+
		"\5\u008eH\2\u0407\u0408\7\21\2\2\u0408\u040a\5f\64\2\u0409\u040b\5\u009a"+
		"N\2\u040a\u0409\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u009d\3\2\2\2\u040c"+
		"\u040d\7\f\2\2\u040d\u040f\5`\61\2\u040e\u0410\5\u009aN\2\u040f\u040e"+
		"\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u009f\3\2\2\2\u0411\u0413\7\37\2\2"+
		"\u0412\u0414\5\u00a2R\2\u0413\u0412\3\2\2\2\u0413\u0414\3\2\2\2\u0414"+
		"\u00a1\3\2\2\2\u0415\u0416\7\6\2\2\u0416\u0419\5^\60\2\u0417\u0419\5\u0090"+
		"I\2\u0418\u0415\3\2\2\2\u0418\u0417\3\2\2\2\u0419\u00a3\3\2\2\2\u041a"+
		"\u041b\t\4\2\2\u041b\u00a5\3\2\2\2\u041c\u0420\5\u00a8U\2\u041d\u0420"+
		"\7,\2\2\u041e\u0420\7-\2\2\u041f\u041c\3\2\2\2\u041f\u041d\3\2\2\2\u041f"+
		"\u041e\3\2\2\2\u0420\u00a7\3\2\2\2\u0421\u0422\t\5\2\2\u0422\u00a9\3\2"+
		"\2\2\u0423\u0424\7^\2\2\u0424\u00ab\3\2\2\2\u0098\u00b1\u00b5\u00b7\u00c0"+
		"\u00c9\u00cc\u00d3\u00d8\u00df\u00e6\u00ed\u00f3\u00f7\u00fd\u0103\u0107"+
		"\u010d\u0111\u0113\u0117\u011d\u0121\u0127\u012b\u0130\u0135\u013b\u013f"+
		"\u0145\u014b\u014f\u0155\u0159\u015b\u015f\u0165\u0169\u016f\u0173\u0179"+
		"\u0180\u0184\u0190\u0196\u019b\u019f\u01a2\u01a6\u01ab\u01af\u01b3\u01c1"+
		"\u01c9\u01d1\u01d3\u01d7\u01e0\u01e7\u01e9\u01f2\u01f7\u01fc\u0203\u0207"+
		"\u020e\u0216\u021f\u0228\u022f\u0239\u0246\u024c\u0255\u0260\u026b\u0270"+
		"\u0275\u027a\u0282\u028b\u0291\u0293\u029b\u029f\u02a7\u02aa\u02ae\u02b2"+
		"\u02b9\u02c3\u02cb\u02d1\u02d9\u02e9\u02ec\u02f5\u02fd\u0305\u030d\u030f"+
		"\u0317\u0319\u0327\u0329\u0333\u0339\u033e\u0343\u0348\u034d\u0355\u035b"+
		"\u0363\u0367\u0369\u036d\u0376\u037d\u0381\u0385\u0389\u038c\u038e\u0392"+
		"\u0399\u039d\u03a4\u03a8\u03b5\u03b9\u03bb\u03c3\u03c7\u03c9\u03cb\u03d1"+
		"\u03d4\u03de\u03e3\u03eb\u03f1\u03f5\u03f9\u03ff\u0403\u040a\u040f\u0413"+
		"\u0418\u041f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
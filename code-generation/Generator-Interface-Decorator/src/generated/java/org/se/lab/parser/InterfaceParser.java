// $ANTLR 3.5.2 org/se/lab/parser/Interface.g 2026-01-24 10:45:50
 
	package org.se.lab.parser; 
	import org.se.lab.metamodel.*;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InterfaceParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGLETTER", "COMMA", "COMMENT", 
		"DOT", "IDENTIFIER", "INTERFACE", "LCURLY", "LETTER", "LINE_COMMENT", 
		"LPAREN", "NUMBER", "PACKAGE", "RCURLY", "RPAREN", "SEMI", "SMALLLETTER", 
		"UNDER", "WS", "'boolean'", "'char'", "'double'", "'float'", "'int'", 
		"'long'", "'private'", "'protected'", "'public'", "'short'", "'void'"
	};
	public static final int EOF=-1;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int BIGLETTER=4;
	public static final int COMMA=5;
	public static final int COMMENT=6;
	public static final int DOT=7;
	public static final int IDENTIFIER=8;
	public static final int INTERFACE=9;
	public static final int LCURLY=10;
	public static final int LETTER=11;
	public static final int LINE_COMMENT=12;
	public static final int LPAREN=13;
	public static final int NUMBER=14;
	public static final int PACKAGE=15;
	public static final int RCURLY=16;
	public static final int RPAREN=17;
	public static final int SEMI=18;
	public static final int SMALLLETTER=19;
	public static final int UNDER=20;
	public static final int WS=21;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public InterfaceParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InterfaceParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return InterfaceParser.tokenNames; }
	@Override public String getGrammarFileName() { return "org/se/lab/parser/Interface.g"; }



	// $ANTLR start "package_def"
	// org/se/lab/parser/Interface.g:21:1: package_def returns [MPackage pkg] : PACKAGE qualifiedName SEMI interface_list ;
	public final MPackage package_def() throws RecognitionException {
		MPackage pkg = null;


		ParserRuleReturnScope qualifiedName1 =null;
		List<MInterface> interface_list2 =null;

		try {
			// org/se/lab/parser/Interface.g:22:2: ( PACKAGE qualifiedName SEMI interface_list )
			// org/se/lab/parser/Interface.g:22:4: PACKAGE qualifiedName SEMI interface_list
			{
			match(input,PACKAGE,FOLLOW_PACKAGE_in_package_def39); 
			pushFollow(FOLLOW_qualifiedName_in_package_def41);
			qualifiedName1=qualifiedName();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_package_def43); 
			pushFollow(FOLLOW_interface_list_in_package_def45);
			interface_list2=interface_list();
			state._fsp--;


					pkg = new MPackage((qualifiedName1!=null?input.toString(qualifiedName1.start,qualifiedName1.stop):null));
					pkg.setInterfaces(interface_list2);
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return pkg;
	}
	// $ANTLR end "package_def"



	// $ANTLR start "interface_list"
	// org/se/lab/parser/Interface.g:30:1: interface_list returns [List<MInterface> list] : (ife= interface_def )* ;
	public final List<MInterface> interface_list() throws RecognitionException {
		List<MInterface> list = null;


		MInterface ife =null;


				list = new ArrayList<MInterface>();
			
		try {
			// org/se/lab/parser/Interface.g:35:2: ( (ife= interface_def )* )
			// org/se/lab/parser/Interface.g:35:4: (ife= interface_def )*
			{
			// org/se/lab/parser/Interface.g:35:4: (ife= interface_def )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==INTERFACE||(LA1_0 >= 28 && LA1_0 <= 30)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/se/lab/parser/Interface.g:35:5: ife= interface_def
					{
					pushFollow(FOLLOW_interface_def_in_interface_list76);
					ife=interface_def();
					state._fsp--;

					list.add(ife);
					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return list;
	}
	// $ANTLR end "interface_list"



	// $ANTLR start "interface_def"
	// org/se/lab/parser/Interface.g:38:1: interface_def returns [MInterface ife] : ( type_modifier )? INTERFACE IDENTIFIER LCURLY opl= operation_list RCURLY ;
	public final MInterface interface_def() throws RecognitionException {
		MInterface ife = null;


		Token IDENTIFIER3=null;
		List<MOperation> opl =null;
		ParserRuleReturnScope type_modifier4 =null;

		try {
			// org/se/lab/parser/Interface.g:39:2: ( ( type_modifier )? INTERFACE IDENTIFIER LCURLY opl= operation_list RCURLY )
			// org/se/lab/parser/Interface.g:39:4: ( type_modifier )? INTERFACE IDENTIFIER LCURLY opl= operation_list RCURLY
			{
			// org/se/lab/parser/Interface.g:39:4: ( type_modifier )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= 28 && LA2_0 <= 30)) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/se/lab/parser/Interface.g:39:4: type_modifier
					{
					pushFollow(FOLLOW_type_modifier_in_interface_def96);
					type_modifier4=type_modifier();
					state._fsp--;

					}
					break;

			}

			match(input,INTERFACE,FOLLOW_INTERFACE_in_interface_def99); 
			IDENTIFIER3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interface_def101); 
			match(input,LCURLY,FOLLOW_LCURLY_in_interface_def104); 
			pushFollow(FOLLOW_operation_list_in_interface_def108);
			opl=operation_list();
			state._fsp--;

			match(input,RCURLY,FOLLOW_RCURLY_in_interface_def110); 

					ife = new MInterface((IDENTIFIER3!=null?IDENTIFIER3.getText():null));
					ife.setPublic("public".equals((type_modifier4!=null?input.toString(type_modifier4.start,type_modifier4.stop):null)));
					ife.setOperations(opl);
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ife;
	}
	// $ANTLR end "interface_def"



	// $ANTLR start "operation_list"
	// org/se/lab/parser/Interface.g:48:1: operation_list returns [List<MOperation> list] : (op= operation_def )* ;
	public final List<MOperation> operation_list() throws RecognitionException {
		List<MOperation> list = null;


		MOperation op =null;


				list = new ArrayList<MOperation>();
			
		try {
			// org/se/lab/parser/Interface.g:53:2: ( (op= operation_def )* )
			// org/se/lab/parser/Interface.g:53:4: (op= operation_def )*
			{
			// org/se/lab/parser/Interface.g:53:4: (op= operation_def )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 22 && LA3_0 <= 27)||(LA3_0 >= 31 && LA3_0 <= 32)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// org/se/lab/parser/Interface.g:53:5: op= operation_def
					{
					pushFollow(FOLLOW_operation_def_in_operation_list142);
					op=operation_def();
					state._fsp--;

					list.add(op);
					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return list;
	}
	// $ANTLR end "operation_list"



	// $ANTLR start "operation_def"
	// org/se/lab/parser/Interface.g:56:1: operation_def returns [MOperation op] : type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI ;
	public final MOperation operation_def() throws RecognitionException {
		MOperation op = null;


		Token IDENTIFIER5=null;
		MType type_def6 =null;
		List<MParameter> parameter_list7 =null;

		try {
			// org/se/lab/parser/Interface.g:57:2: ( type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI )
			// org/se/lab/parser/Interface.g:57:4: type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI
			{
			pushFollow(FOLLOW_type_def_in_operation_def161);
			type_def6=type_def();
			state._fsp--;

			IDENTIFIER5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operation_def163); 
			match(input,LPAREN,FOLLOW_LPAREN_in_operation_def165); 
			pushFollow(FOLLOW_parameter_list_in_operation_def167);
			parameter_list7=parameter_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_operation_def169); 
			match(input,SEMI,FOLLOW_SEMI_in_operation_def171); 

					op = new MOperation((IDENTIFIER5!=null?IDENTIFIER5.getText():null), type_def6);
					op.setParameters(parameter_list7);
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return op;
	}
	// $ANTLR end "operation_def"



	// $ANTLR start "parameter_list"
	// org/se/lab/parser/Interface.g:65:1: parameter_list returns [List<MParameter> list] : (p1= parameter_def )? ( COMMA pn= parameter_def )* ;
	public final List<MParameter> parameter_list() throws RecognitionException {
		List<MParameter> list = null;


		MParameter p1 =null;
		MParameter pn =null;


			list = new ArrayList<MParameter>();
			
		try {
			// org/se/lab/parser/Interface.g:70:2: ( (p1= parameter_def )? ( COMMA pn= parameter_def )* )
			// org/se/lab/parser/Interface.g:70:4: (p1= parameter_def )? ( COMMA pn= parameter_def )*
			{
			// org/se/lab/parser/Interface.g:70:6: (p1= parameter_def )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= 22 && LA4_0 <= 27)||(LA4_0 >= 31 && LA4_0 <= 32)) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/se/lab/parser/Interface.g:70:6: p1= parameter_def
					{
					pushFollow(FOLLOW_parameter_def_in_parameter_list199);
					p1=parameter_def();
					state._fsp--;

					}
					break;

			}


					if (p1 != null) list.add(p1);
				
			// org/se/lab/parser/Interface.g:74:2: ( COMMA pn= parameter_def )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==COMMA) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// org/se/lab/parser/Interface.g:74:3: COMMA pn= parameter_def
					{
					match(input,COMMA,FOLLOW_COMMA_in_parameter_list208); 
					pushFollow(FOLLOW_parameter_def_in_parameter_list212);
					pn=parameter_def();
					state._fsp--;

					list.add(pn);
					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return list;
	}
	// $ANTLR end "parameter_list"



	// $ANTLR start "parameter_def"
	// org/se/lab/parser/Interface.g:77:1: parameter_def returns [MParameter param] : type_def IDENTIFIER ;
	public final MParameter parameter_def() throws RecognitionException {
		MParameter param = null;


		Token IDENTIFIER8=null;
		MType type_def9 =null;

		try {
			// org/se/lab/parser/Interface.g:78:2: ( type_def IDENTIFIER )
			// org/se/lab/parser/Interface.g:78:4: type_def IDENTIFIER
			{
			pushFollow(FOLLOW_type_def_in_parameter_def232);
			type_def9=type_def();
			state._fsp--;

			IDENTIFIER8=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parameter_def234); 

					param = new MParameter((IDENTIFIER8!=null?IDENTIFIER8.getText():null), type_def9);
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "parameter_def"



	// $ANTLR start "type_def"
	// org/se/lab/parser/Interface.g:85:1: type_def returns [MType type] : type_specifier ;
	public final MType type_def() throws RecognitionException {
		MType type = null;


		ParserRuleReturnScope type_specifier10 =null;

		try {
			// org/se/lab/parser/Interface.g:86:3: ( type_specifier )
			// org/se/lab/parser/Interface.g:86:7: type_specifier
			{
			pushFollow(FOLLOW_type_specifier_in_type_def256);
			type_specifier10=type_specifier();
			state._fsp--;


			      type = new MType((type_specifier10!=null?input.toString(type_specifier10.start,type_specifier10.stop):null));
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "type_def"


	public static class type_specifier_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "type_specifier"
	// org/se/lab/parser/Interface.g:94:1: type_specifier : ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'boolean' );
	public final InterfaceParser.type_specifier_return type_specifier() throws RecognitionException {
		InterfaceParser.type_specifier_return retval = new InterfaceParser.type_specifier_return();
		retval.start = input.LT(1);

		try {
			// org/se/lab/parser/Interface.g:95:2: ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'boolean' )
			// org/se/lab/parser/Interface.g:
			{
			if ( (input.LA(1) >= 22 && input.LA(1) <= 27)||(input.LA(1) >= 31 && input.LA(1) <= 32) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_specifier"


	public static class type_modifier_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "type_modifier"
	// org/se/lab/parser/Interface.g:106:1: type_modifier : ( 'public' | 'private' | 'protected' );
	public final InterfaceParser.type_modifier_return type_modifier() throws RecognitionException {
		InterfaceParser.type_modifier_return retval = new InterfaceParser.type_modifier_return();
		retval.start = input.LT(1);

		try {
			// org/se/lab/parser/Interface.g:107:2: ( 'public' | 'private' | 'protected' )
			// org/se/lab/parser/Interface.g:
			{
			if ( (input.LA(1) >= 28 && input.LA(1) <= 30) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_modifier"


	public static class qualifiedName_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "qualifiedName"
	// org/se/lab/parser/Interface.g:112:1: qualifiedName : IDENTIFIER ( DOT IDENTIFIER )* ;
	public final InterfaceParser.qualifiedName_return qualifiedName() throws RecognitionException {
		InterfaceParser.qualifiedName_return retval = new InterfaceParser.qualifiedName_return();
		retval.start = input.LT(1);

		try {
			// org/se/lab/parser/Interface.g:113:2: ( IDENTIFIER ( DOT IDENTIFIER )* )
			// org/se/lab/parser/Interface.g:113:4: IDENTIFIER ( DOT IDENTIFIER )*
			{
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName351); 
			// org/se/lab/parser/Interface.g:113:15: ( DOT IDENTIFIER )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DOT) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// org/se/lab/parser/Interface.g:113:16: DOT IDENTIFIER
					{
					match(input,DOT,FOLLOW_DOT_in_qualifiedName354); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName356); 
					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "qualifiedName"

	// Delegated rules



	public static final BitSet FOLLOW_PACKAGE_in_package_def39 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_qualifiedName_in_package_def41 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_package_def43 = new BitSet(new long[]{0x0000000070000200L});
	public static final BitSet FOLLOW_interface_list_in_package_def45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_interface_def_in_interface_list76 = new BitSet(new long[]{0x0000000070000202L});
	public static final BitSet FOLLOW_type_modifier_in_interface_def96 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_INTERFACE_in_interface_def99 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_interface_def101 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LCURLY_in_interface_def104 = new BitSet(new long[]{0x000000018FC10000L});
	public static final BitSet FOLLOW_operation_list_in_interface_def108 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_RCURLY_in_interface_def110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operation_def_in_operation_list142 = new BitSet(new long[]{0x000000018FC00002L});
	public static final BitSet FOLLOW_type_def_in_operation_def161 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operation_def163 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_LPAREN_in_operation_def165 = new BitSet(new long[]{0x000000018FC20020L});
	public static final BitSet FOLLOW_parameter_list_in_operation_def167 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_RPAREN_in_operation_def169 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SEMI_in_operation_def171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_def_in_parameter_list199 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_COMMA_in_parameter_list208 = new BitSet(new long[]{0x000000018FC00000L});
	public static final BitSet FOLLOW_parameter_def_in_parameter_list212 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_type_def_in_parameter_def232 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_parameter_def234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_specifier_in_type_def256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName351 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_DOT_in_qualifiedName354 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName356 = new BitSet(new long[]{0x0000000000000082L});
}

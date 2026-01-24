// $ANTLR 3.5.2 org/se/lab/parser/Interface.g 2026-01-24 10:45:50
 
	package org.se.lab.parser; 
	import org.se.lab.metamodel.*;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InterfaceLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public InterfaceLexer() {} 
	public InterfaceLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public InterfaceLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/se/lab/parser/Interface.g"; }

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:7:7: ( 'boolean' )
			// org/se/lab/parser/Interface.g:7:9: 'boolean'
			{
			match("boolean"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:8:7: ( 'char' )
			// org/se/lab/parser/Interface.g:8:9: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:9:7: ( 'double' )
			// org/se/lab/parser/Interface.g:9:9: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:10:7: ( 'float' )
			// org/se/lab/parser/Interface.g:10:9: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:11:7: ( 'int' )
			// org/se/lab/parser/Interface.g:11:9: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:12:7: ( 'long' )
			// org/se/lab/parser/Interface.g:12:9: 'long'
			{
			match("long"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:13:7: ( 'private' )
			// org/se/lab/parser/Interface.g:13:9: 'private'
			{
			match("private"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:14:7: ( 'protected' )
			// org/se/lab/parser/Interface.g:14:9: 'protected'
			{
			match("protected"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:15:7: ( 'public' )
			// org/se/lab/parser/Interface.g:15:9: 'public'
			{
			match("public"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:16:7: ( 'short' )
			// org/se/lab/parser/Interface.g:16:9: 'short'
			{
			match("short"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:17:7: ( 'void' )
			// org/se/lab/parser/Interface.g:17:9: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:120:8: ( ',' )
			// org/se/lab/parser/Interface.g:120:10: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:121:7: ( ';' )
			// org/se/lab/parser/Interface.g:121:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:122:9: ( '(' )
			// org/se/lab/parser/Interface.g:122:11: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:123:9: ( ')' )
			// org/se/lab/parser/Interface.g:123:11: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		try {
			int _type = LCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:124:9: ( '{' )
			// org/se/lab/parser/Interface.g:124:11: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:125:9: ( '}' )
			// org/se/lab/parser/Interface.g:125:11: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:126:7: ( '.' )
			// org/se/lab/parser/Interface.g:126:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "UNDER"
	public final void mUNDER() throws RecognitionException {
		try {
			int _type = UNDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:127:8: ( '_' )
			// org/se/lab/parser/Interface.g:127:10: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDER"

	// $ANTLR start "PACKAGE"
	public final void mPACKAGE() throws RecognitionException {
		try {
			int _type = PACKAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:128:10: ( 'package' )
			// org/se/lab/parser/Interface.g:128:12: 'package'
			{
			match("package"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PACKAGE"

	// $ANTLR start "INTERFACE"
	public final void mINTERFACE() throws RecognitionException {
		try {
			int _type = INTERFACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:129:11: ( 'interface' )
			// org/se/lab/parser/Interface.g:129:13: 'interface'
			{
			match("interface"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTERFACE"

	// $ANTLR start "SMALLLETTER"
	public final void mSMALLLETTER() throws RecognitionException {
		try {
			// org/se/lab/parser/Interface.g:134:2: ( ( 'a' .. 'z' ) )
			// org/se/lab/parser/Interface.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SMALLLETTER"

	// $ANTLR start "BIGLETTER"
	public final void mBIGLETTER() throws RecognitionException {
		try {
			// org/se/lab/parser/Interface.g:138:2: ( ( 'A' .. 'Z' ) )
			// org/se/lab/parser/Interface.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BIGLETTER"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			// org/se/lab/parser/Interface.g:142:2: ( ( '0' .. '9' ) )
			// org/se/lab/parser/Interface.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// org/se/lab/parser/Interface.g:146:2: ( BIGLETTER | SMALLLETTER | UNDER )
			// org/se/lab/parser/Interface.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:152:2: ( LETTER ( LETTER | NUMBER )* )
			// org/se/lab/parser/Interface.g:152:4: LETTER ( LETTER | NUMBER )*
			{
			mLETTER(); 

			// org/se/lab/parser/Interface.g:152:11: ( LETTER | NUMBER )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/se/lab/parser/Interface.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:156:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// org/se/lab/parser/Interface.g:156:9: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// org/se/lab/parser/Interface.g:156:14: ( options {greedy=false; } : . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='*') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='/') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// org/se/lab/parser/Interface.g:156:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:160:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// org/se/lab/parser/Interface.g:160:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// org/se/lab/parser/Interface.g:160:12: (~ ( '\\n' | '\\r' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// org/se/lab/parser/Interface.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			// org/se/lab/parser/Interface.g:160:26: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// org/se/lab/parser/Interface.g:160:26: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/se/lab/parser/Interface.g:163:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// org/se/lab/parser/Interface.g:163:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// org/se/lab/parser/Interface.g:1:8: ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | COMMA | SEMI | LPAREN | RPAREN | LCURLY | RCURLY | DOT | UNDER | PACKAGE | INTERFACE | IDENTIFIER | COMMENT | LINE_COMMENT | WS )
		int alt5=25;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// org/se/lab/parser/Interface.g:1:10: T__22
				{
				mT__22(); 

				}
				break;
			case 2 :
				// org/se/lab/parser/Interface.g:1:16: T__23
				{
				mT__23(); 

				}
				break;
			case 3 :
				// org/se/lab/parser/Interface.g:1:22: T__24
				{
				mT__24(); 

				}
				break;
			case 4 :
				// org/se/lab/parser/Interface.g:1:28: T__25
				{
				mT__25(); 

				}
				break;
			case 5 :
				// org/se/lab/parser/Interface.g:1:34: T__26
				{
				mT__26(); 

				}
				break;
			case 6 :
				// org/se/lab/parser/Interface.g:1:40: T__27
				{
				mT__27(); 

				}
				break;
			case 7 :
				// org/se/lab/parser/Interface.g:1:46: T__28
				{
				mT__28(); 

				}
				break;
			case 8 :
				// org/se/lab/parser/Interface.g:1:52: T__29
				{
				mT__29(); 

				}
				break;
			case 9 :
				// org/se/lab/parser/Interface.g:1:58: T__30
				{
				mT__30(); 

				}
				break;
			case 10 :
				// org/se/lab/parser/Interface.g:1:64: T__31
				{
				mT__31(); 

				}
				break;
			case 11 :
				// org/se/lab/parser/Interface.g:1:70: T__32
				{
				mT__32(); 

				}
				break;
			case 12 :
				// org/se/lab/parser/Interface.g:1:76: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 13 :
				// org/se/lab/parser/Interface.g:1:82: SEMI
				{
				mSEMI(); 

				}
				break;
			case 14 :
				// org/se/lab/parser/Interface.g:1:87: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 15 :
				// org/se/lab/parser/Interface.g:1:94: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 16 :
				// org/se/lab/parser/Interface.g:1:101: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 17 :
				// org/se/lab/parser/Interface.g:1:108: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 18 :
				// org/se/lab/parser/Interface.g:1:115: DOT
				{
				mDOT(); 

				}
				break;
			case 19 :
				// org/se/lab/parser/Interface.g:1:119: UNDER
				{
				mUNDER(); 

				}
				break;
			case 20 :
				// org/se/lab/parser/Interface.g:1:125: PACKAGE
				{
				mPACKAGE(); 

				}
				break;
			case 21 :
				// org/se/lab/parser/Interface.g:1:133: INTERFACE
				{
				mINTERFACE(); 

				}
				break;
			case 22 :
				// org/se/lab/parser/Interface.g:1:143: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 23 :
				// org/se/lab/parser/Interface.g:1:154: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 24 :
				// org/se/lab/parser/Interface.g:1:162: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 25 :
				// org/se/lab/parser/Interface.g:1:175: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\1\uffff\11\22\7\uffff\1\40\3\uffff\13\22\3\uffff\4\22\1\64\10\22\1\75"+
		"\3\22\1\uffff\1\101\5\22\1\107\1\22\1\uffff\1\22\1\112\1\22\1\uffff\4"+
		"\22\1\120\1\uffff\1\22\1\122\1\uffff\3\22\1\126\1\22\1\uffff\1\130\1\uffff"+
		"\1\22\1\132\1\22\1\uffff\1\134\1\uffff\1\22\1\uffff\1\22\1\uffff\1\137"+
		"\1\140\2\uffff";
	static final String DFA5_eofS =
		"\141\uffff";
	static final String DFA5_minS =
		"\1\11\1\157\1\150\1\157\1\154\1\156\1\157\1\141\1\150\1\157\7\uffff\1"+
		"\60\1\uffff\1\52\1\uffff\1\157\1\141\1\165\1\157\1\164\1\156\1\151\1\142"+
		"\1\143\1\157\1\151\3\uffff\1\154\1\162\1\142\1\141\1\60\1\147\1\166\1"+
		"\164\1\154\1\153\1\162\1\144\1\145\1\60\1\154\1\164\1\162\1\uffff\1\60"+
		"\1\141\1\145\1\151\1\141\1\164\1\60\1\141\1\uffff\1\145\1\60\1\146\1\uffff"+
		"\1\164\2\143\1\147\1\60\1\uffff\1\156\1\60\1\uffff\1\141\1\145\1\164\1"+
		"\60\1\145\1\uffff\1\60\1\uffff\1\143\1\60\1\145\1\uffff\1\60\1\uffff\1"+
		"\145\1\uffff\1\144\1\uffff\2\60\2\uffff";
	static final String DFA5_maxS =
		"\1\175\1\157\1\150\1\157\1\154\1\156\1\157\1\165\1\150\1\157\7\uffff\1"+
		"\172\1\uffff\1\57\1\uffff\1\157\1\141\1\165\1\157\1\164\1\156\1\157\1"+
		"\142\1\143\1\157\1\151\3\uffff\1\154\1\162\1\142\1\141\1\172\1\147\1\166"+
		"\1\164\1\154\1\153\1\162\1\144\1\145\1\172\1\154\1\164\1\162\1\uffff\1"+
		"\172\1\141\1\145\1\151\1\141\1\164\1\172\1\141\1\uffff\1\145\1\172\1\146"+
		"\1\uffff\1\164\2\143\1\147\1\172\1\uffff\1\156\1\172\1\uffff\1\141\1\145"+
		"\1\164\1\172\1\145\1\uffff\1\172\1\uffff\1\143\1\172\1\145\1\uffff\1\172"+
		"\1\uffff\1\145\1\uffff\1\144\1\uffff\2\172\2\uffff";
	static final String DFA5_acceptS =
		"\12\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\uffff\1\26\1\uffff\1\31"+
		"\13\uffff\1\23\1\27\1\30\21\uffff\1\5\10\uffff\1\2\3\uffff\1\6\5\uffff"+
		"\1\13\2\uffff\1\4\5\uffff\1\12\1\uffff\1\3\3\uffff\1\11\1\uffff\1\1\1"+
		"\uffff\1\7\1\uffff\1\24\2\uffff\1\25\1\10";
	static final String DFA5_specialS =
		"\141\uffff}>";
	static final String[] DFA5_transitionS = {
			"\2\24\1\uffff\2\24\22\uffff\1\24\7\uffff\1\14\1\15\2\uffff\1\12\1\uffff"+
			"\1\20\1\23\13\uffff\1\13\5\uffff\32\22\4\uffff\1\21\1\uffff\1\22\1\1"+
			"\1\2\1\3\1\22\1\4\2\22\1\5\2\22\1\6\3\22\1\7\2\22\1\10\2\22\1\11\4\22"+
			"\1\16\1\uffff\1\17",
			"\1\25",
			"\1\26",
			"\1\27",
			"\1\30",
			"\1\31",
			"\1\32",
			"\1\35\20\uffff\1\33\2\uffff\1\34",
			"\1\36",
			"\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			"\1\41\4\uffff\1\42",
			"",
			"\1\43",
			"\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51\5\uffff\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"",
			"",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\4\22\1\63\25\22",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\76",
			"\1\77",
			"\1\100",
			"",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\110",
			"",
			"\1\111",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\113",
			"",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			"\1\121",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			"\1\123",
			"\1\124",
			"\1\125",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\127",
			"",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			"\1\131",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\133",
			"",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			"\1\135",
			"",
			"\1\136",
			"",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | COMMA | SEMI | LPAREN | RPAREN | LCURLY | RCURLY | DOT | UNDER | PACKAGE | INTERFACE | IDENTIFIER | COMMENT | LINE_COMMENT | WS );";
		}
	}

}

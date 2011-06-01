/*
 * @LANG: java
 */
 
package com.blogspot.radialmind.csp.parser;

import java.util.Vector;

public class Parser
{
	private ICSPEngine engine;
	private int line = 0;
	
	%%{
		machine Parser;

		action newline { line++; engine.reset(); }

		action call_expr {
			engine.execute();
		}

		# Append to the buffer.
		action append {
			engine.appendChar( fc );
		}
		
		# Terminate a buffer.
		action termword {
			engine.finishWord();
		}

		action termstring {
			engine.finishString();
		}

		#action termfloat {
		#	engine.finishFloat();
		#}
		
		#action termint {
		#	engine.finishInteger();
		#}

		NL = (0xd | 0xd? 0xa | 0x85) @newline;
		WS	= [ \t];
		NoNums = [ \t\(\)0-9\.\"];
		InvalidChars = [ \t\(\)\"];
		StringChars = [\"];

		word = (^NoNums $append) (^InvalidChars $append)*;
		string = '"' (^StringChars $append)* '"';

		numericint = ( '-'? $append '0' $append | '-'? $append [1-9] $append ([0-9] $append)* );
		numericfloat = ( '-'? $append) (digit $append)* '.' $append (digit $append)+ | ( '-'? $append) (digit $append)+ '.' $append;

		# term = numericint %termint | numericfloat %termfloat | word %termword | string %termstring;
		term = word %termword | string %termstring;

		line = (term WS* '(' WS* term (WS+ term)* WS* ')' WS* ';' WS* ) @call_expr NL |
			(term WS* '(' WS* ')' ';' WS*) @call_expr NL |  
			WS* NL;

		file = (line)*;

		main := (file);
	}%%

	%% write data;

	public boolean parse( ICSPEngine engine, char data[] )
	{
		int cs, p = 0, pe = data.length;
		int top = 0;
		int stack[] = new int[ 16384 ];
		
		this.engine = engine;
		engine.reset();

		try {

			%% write init;
			%% write exec;
			
		} catch (EngineException ee) {
			ee.printStackTrace();
			return false;
		}

		if (( cs >= Parser_first_final ) && ( top == 0 ))
			return true;
		else
			return false;
	}
}

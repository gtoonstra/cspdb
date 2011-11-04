package com.blogspot.radialmind.csp.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.blogspot.radialmind.csp.IAssertion;
import com.blogspot.radialmind.csp.IncrementalMySQLAssertion;
import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class AddIncrementalAssertionFunction extends AbstractFunction implements IFunction {

	public AddIncrementalAssertionFunction( CSPEngine engine ) {
		super( engine );
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 3 );
		
		String assertion = args.get( 0 );
		String query = args.get( 1 );
		List<String> keys = new ArrayList<String>();

		if ( args.size() > 2 ) {
			ListIterator<String> iter = args.listIterator( 2 );
			while ( iter.hasNext() ) {
				keys.add( iter.next() );			
			}
		}

		IAssertion ast = new IncrementalMySQLAssertion( assertion, assertion, query, keys );
		engine.addAssertion( ast );
	}

	@Override
	public String getName() {
		return "add-incremental-assertion";
	}
}

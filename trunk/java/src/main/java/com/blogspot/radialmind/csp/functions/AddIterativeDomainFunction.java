package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.MySQLIterativeDomain;
import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class AddIterativeDomainFunction extends AbstractFunction implements IFunction {

	public AddIterativeDomainFunction( CSPEngine engine ) {
		super( engine );
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 2 );

		String name = args.get( 0 );
		String clause = args.get( 1 );
		engine.addDomain( new MySQLIterativeDomain( name, clause ) );
	}

	@Override
	public String getName() {
		return "add-iterative-domain";
	}
}

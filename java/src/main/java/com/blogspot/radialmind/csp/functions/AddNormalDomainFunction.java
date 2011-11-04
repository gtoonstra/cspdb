package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.MySQLDomain;
import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class AddNormalDomainFunction extends AbstractFunction implements IFunction {

	public AddNormalDomainFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 2 );
		
		String name = args.get( 0 );
		String clause = args.get( 1 );
		engine.addDomain( new MySQLDomain( name, clause ) );
	}

	@Override
	public String getName() {
		return "add-normal-domain";
	}
}

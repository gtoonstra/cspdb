package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class AddArgumentToDomainFunction extends AbstractFunction implements IFunction {

	public AddArgumentToDomainFunction( CSPEngine engine ) {
		super( engine );
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 2 );
		
		String name = args.get( 0 );
		String argument = args.get( 1 );
		engine.addArgumentToDomain( name, argument );
	}

	@Override
	public String getName() {
		return "add-argument-to-domain";
	}
}

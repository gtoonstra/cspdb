package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class SetNthArgumentFunction extends AbstractFunction implements IFunction {

	public SetNthArgumentFunction( CSPEngine engine ) {
		super( engine );
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 2 );
		
		String name = args.get( 0 );
		Integer argNum = new Integer( args.get( 1 ) );
		engine.setArgNum( name, argNum );
	}

	@Override
	public String getName() {
		return "set-nth-argument";
	}
}

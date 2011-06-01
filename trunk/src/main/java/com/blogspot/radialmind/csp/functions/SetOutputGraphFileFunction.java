package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class SetOutputGraphFileFunction extends AbstractFunction implements IFunction {

	public SetOutputGraphFileFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 1 );
		engine.setOutputGraphFile( args.get( 0 ));
	}

	@Override
	public String getName() {
		return "set-output-graph-file";
	}
}

package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class GoFunction extends AbstractFunction implements IFunction {

	public GoFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		engine.go();
	}

	@Override
	public String getName() {
		return "go";
	}
}

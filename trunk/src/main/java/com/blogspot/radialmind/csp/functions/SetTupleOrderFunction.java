package com.blogspot.radialmind.csp.functions;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class SetTupleOrderFunction extends AbstractFunction implements IFunction {

	public SetTupleOrderFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		List<String> order = new ArrayList<String>();
		for ( String s: args ) {
			order.add( s );
		}
		engine.setOrder( order );
	}

	@Override
	public String getName() {
		return "set-tuple-order";
	}
}

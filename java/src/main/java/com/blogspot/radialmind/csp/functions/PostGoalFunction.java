package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.PostGoalAssertion;
import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class PostGoalFunction extends AbstractFunction implements IFunction {

	public PostGoalFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 1 );
		
		String assertion = args.get( 0 );

		PostGoalAssertion pga = new PostGoalAssertion( assertion );
		engine.setPostGoal( pga );
	}

	@Override
	public String getName() {
		return "post-goal";
	}
}

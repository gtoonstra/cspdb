package com.blogspot.radialmind.csp.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.blogspot.radialmind.csp.goals.IGoal;
import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class SetGoalFunction extends AbstractFunction implements IFunction {

	public SetGoalFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 1);

		String goalName = args.get( 0 );
		try {
			Object goal = createObject( goalName );
		    if (!( goal instanceof IGoal )) {
		        throw new EngineException( goalName + " does not implement the IGoal interface" );
		    }

		    List<String> goalArgs = new ArrayList<String>();
			if ( args.size() > 1 ) {
				ListIterator<String> iter = args.listIterator( 1 );
				while ( iter.hasNext() ) {
					goalArgs.add( iter.next() );			
				}
			}
			((IGoal)goal).setArguments(goalArgs);
		    
		    engine.setGoal( (IGoal)goal );
		} catch (ClassNotFoundException e) {
			throw new EngineException( "Class not found: " + goalName, e );
		} catch (InstantiationException e) {
			throw new EngineException( "Class could not be instantiated: " + goalName, e );
		} catch (IllegalAccessException e) {
			throw new EngineException( "Illegal access exception to: " + goalName, e );
		}
	}

	@Override
	public String getName() {
		return "set-goal";
	}
}

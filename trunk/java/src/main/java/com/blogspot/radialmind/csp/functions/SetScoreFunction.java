package com.blogspot.radialmind.csp.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;
import com.blogspot.radialmind.csp.score.IScore;

public class SetScoreFunction extends AbstractFunction implements IFunction {
	
	public SetScoreFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 1);

		String scorerName = args.get( 0 );
		try {
			Object score = createObject( scorerName );
		    if (!( score instanceof IScore )) {
		        throw new EngineException( scorerName + " does not implement the IScore interface" );
		    }

		    List<String> scoreArgs = new ArrayList<String>();
			if ( args.size() > 1 ) {
				ListIterator<String> iter = args.listIterator( 1 );
				while ( iter.hasNext() ) {
					scoreArgs.add( iter.next() );			
				}
			}
			((IScore)score).setArguments(scoreArgs);
		    
		    engine.setScore( (IScore)score );
		} catch (ClassNotFoundException e) {
			throw new EngineException( "Class not found: " + scorerName, e );
		} catch (InstantiationException e) {
			throw new EngineException( "Class could not be instantiated: " + scorerName, e );
		} catch (IllegalAccessException e) {
			throw new EngineException( "Illegal access exception to: " + scorerName, e );
		}
	}

	@Override
	public String getName() {
		return "set-score";
	}
}

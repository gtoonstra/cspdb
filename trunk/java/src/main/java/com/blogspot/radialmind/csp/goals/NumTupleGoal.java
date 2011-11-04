package com.blogspot.radialmind.csp.goals;

import java.util.List;

import com.blogspot.radialmind.csp.IStateManager;

public class NumTupleGoal implements IGoal {

	private int numTuples = -1;
	
	public NumTupleGoal() {
		super();
	}
	
	public void setArguments( List<String> args ) {
		if ( args.size() < 1 ) {
			throw new RuntimeException( "Must specify number of tuples required" );
		}
		this.numTuples = new Integer( args.get( 0 ) );		 
	}
	
	@Override
	public boolean achieved(IStateManager manager) {
		if ( manager.getNumTuples() == numTuples ) {
			return true;
		}
		return false;
	}
}

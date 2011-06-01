package com.blogspot.radialmind.csp;

public interface IStateManager {
	public void assertTuple( Tuple tuple );
	public void backtrackMostRecentTuple();
	public void backtrackTuple( Tuple tuple );
	public int getNumTuples();
	public int foundSolution();
	public boolean shouldContinue();
}

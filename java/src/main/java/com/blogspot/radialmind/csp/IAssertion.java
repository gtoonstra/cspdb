package com.blogspot.radialmind.csp;

public interface IAssertion {
	public void doAssert( Tuple tuple );
	public void doRetract( Tuple tuple );
}

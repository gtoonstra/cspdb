package com.blogspot.radialmind.csp.algorithms;

import java.util.Iterator;
import java.util.List;

import com.blogspot.radialmind.csp.IDomain;
import com.blogspot.radialmind.csp.Tuple;

public class RecursiveDepthFirstAlgorithm {
	public RecursiveDepthFirstAlgorithm() {
		super();
	}
	
	public Tuple getTuple( List<IDomain> domains, int stacksize, int counter ) {
		return calcTuple( domains, stacksize, counter );
	}
	
	public Tuple calcTuple( List<IDomain> domains, int stacksize, int counter ) {
		IDomain ad = domains.get( counter );
		List<String> values = null;
		String s = null;

		if ( ad.getStackSize() < stacksize ) {
			values = ad.getDomain();
			ad.pushDomain( values );
		} else {
			values = ad.getValues();			
		}
		
		Iterator<String> iter = values.iterator();
		while ( iter.hasNext() ) {
			s = iter.next();
			ad.setCurrentValue( s );
			if ( ( counter + 1 ) == domains.size() ) {
				iter.remove();
				Tuple tuple = new Tuple();
				for ( IDomain d: domains ) {
					tuple.setValue( d.getDomainName(), d.getCurrentValue() );
				}
				return tuple;
			} else {
				Tuple tuple = calcTuple( domains, stacksize, counter + 1 );
				if ( tuple == null ) {
					iter.remove();
					continue;
				} else {
					return tuple;
				}
			}
		}
		ad.popDomain();
		return null;
	}
}

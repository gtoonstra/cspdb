package com.blogspot.radialmind.csp;

import java.util.List;

public class MySQLAssertion extends AbstractAssertion implements IAssertion {

	private String[] sArgs = new String[ 0 ];
	
	public MySQLAssertion(String assertionTemplate, String retractionTemplate, List<String> keys ) {
		super(assertionTemplate, retractionTemplate, keys );
	}

	@Override
	public void doAssert( Tuple tuple ) {
		if ( keys != null ) {
			sArgs = new String[ keys.size() ];

			// put args in from other domains
			for ( int i = 0; i < keys.size(); i++ ) {
				sArgs[ i ] = tuple.getValue( keys.get( i ) );
			}
		}
		String assertion = String.format( assertionTemplate, sArgs );
		DbUtils.executeUpdate( assertion );

//		System.out.println( "Asserted " + assertionTemplate + " with " + getArray( sArgs ) );
	}

	@Override
	public void doRetract(  Tuple tuple  ) {
		if ( keys != null ) {
			sArgs = new String[ keys.size() ];

			// put args in from other domains
			for ( int i = 0; i < keys.size(); i++ ) {
				sArgs[ i ] = tuple.getValue( keys.get( i ) );
			}
		}
		String retraction = String.format( retractionTemplate, sArgs );
		DbUtils.executeUpdate( retraction );

//		System.out.println( "Retracted " + assertionTemplate + " with " + getArray( sArgs ) );
	}
}

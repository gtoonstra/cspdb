package com.blogspot.radialmind.csp;

import java.util.List;

public class IncrementalMySQLAssertion extends AbstractAssertion implements IAssertion {

	private String queryTemplate;
	private Object[] sArgs = new String[ 1 ];
	
	public IncrementalMySQLAssertion(String assertionTemplate, String retractionTemplate, String queryTemplate, List<String> keys ) {
		super( assertionTemplate, retractionTemplate, keys );
		this.queryTemplate = queryTemplate;
	}

	@Override
	public void doAssert( Tuple tuple ) {
		
		if ( keys != null ) {
			sArgs = new Object[ keys.size() + 1 ];

			// put args in from other domains
			for ( int i = 0; i < keys.size(); i++ ) {
				sArgs[ i ] = tuple.getValue( keys.get( i ) );
			}
		}
		
		String query = String.format( queryTemplate, sArgs );
		Integer result = getInteger( query );
		sArgs[ sArgs.length - 1 ] = new Integer( result + 1);
		query = String.format( assertionTemplate, sArgs );
		DbUtils.executeUpdate( query );
	}

	@Override
	public void doRetract( Tuple tuple  ) {
		
		if ( keys != null ) {
			sArgs = new Object[ keys.size() + 1 ];

			// put args in from other domains
			for ( int i = 0; i < keys.size(); i++ ) {
				sArgs[ i ] = tuple.getValue( keys.get( i ) );
			}
		}
		
		String query = String.format( queryTemplate, sArgs );
		Integer result = getInteger( query );
		sArgs[ sArgs.length - 1 ] = new Integer( result - 1);
		query = String.format( retractionTemplate, sArgs );
		DbUtils.executeUpdate( query );
	}
}

package com.blogspot.radialmind.csp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractAssertion implements IAssertion {
	
	protected String assertionTemplate;
	protected String retractionTemplate;
	protected List<String> keys;

	public AbstractAssertion( String assertionTemplate, String retractionTemplate, List<String> keys ) {
		super();
		this.assertionTemplate = assertionTemplate;
		this.retractionTemplate = retractionTemplate;
		this.keys = keys;
	}
	
	protected Integer getInteger( String query ) {
		ResultSet rs = DbUtils.executeQuery( query );
		try {
			Integer result;
			if ( rs.next() ) {
				result = rs.getInt( 1 );
			} else {
				result = new Integer( 0 );
			}
			DbUtils.close( rs );
			return result;
		} catch (SQLException e) {
			throw new RuntimeException( e.getMessage() );
		}
	}
}

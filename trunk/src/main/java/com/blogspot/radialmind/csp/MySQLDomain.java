package com.blogspot.radialmind.csp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDomain extends AbstractDomain implements IDomain {
	
	private String[] args = new String[ 0 ];
	private String sort = null; 
	               
	public MySQLDomain( String domainName, String queryTemplate ) {
		super( domainName, queryTemplate );
	}

	@Override
	public List<String> getDomain() {
		List<String> list = new ArrayList<String>();

		// reset
		// curValue = null;

		// put args in from other domains
		if ( context != null ) {
			args = new String[ context.size() ];
			for ( int i = 0; i < context.size(); i++ ) {
				args[ i ] = context.get( i ).getCurrentValue();
			}
		}
		String query = String.format( queryTemplate, args );
		try {
			ResultSet rs = DbUtils.executeQuery( query );

			while( rs.next() ) {
				list.add( rs.getString( argNum ) );
			}
			DbUtils.close( rs );
			if ( sort == null ) {
				return list;
			}
		} catch (SQLException sqle ) {
			throw new RuntimeException( sqle.getMessage() );
		}

		return list;
	}
}

package com.blogspot.radialmind.csp;

import java.util.ArrayList;
import java.util.List;

public class MySQLIterativeDomain extends MySQLDomain implements IDomain {
	
	public MySQLIterativeDomain( String domainName, String queryTemplate ) {
		super( domainName, queryTemplate );
	}

	/*
	@Override
	public List<String> getDomain() {
		List<String> list = super.getDomain();
		if ( list.size() > 0 ) {
			return list.subList( 0, 1 );
		}
		return new ArrayList<String>();
	}*/
}

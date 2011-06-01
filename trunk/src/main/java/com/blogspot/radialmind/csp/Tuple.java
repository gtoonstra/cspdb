package com.blogspot.radialmind.csp;

import java.util.HashMap;
import java.util.Map;

public class Tuple {

	private Map<String,String> nameValues = new HashMap<String,String>();

	public Tuple() {
		super();
	}

	public void setValue( String name, String value ) {
		nameValues.put( name, value );
	}

	public String getValue( String name ) {
		return nameValues.get( name );
	}
	
	public int getSize() {
		return nameValues.size();
	}
	
	public String graph() {
		StringBuilder sb = new StringBuilder();
		for ( String key: nameValues.keySet() ) {
			sb.append( nameValues.get( key ) );
			sb.append( '_' );
		}
		return sb.substring(0, sb.length() - 1 );  
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for ( String key: nameValues.keySet() ) {
			sb.append( key );
			sb.append( '_' );
			sb.append( nameValues.get( key ) );
			sb.append( '_' );
		}
		return sb.substring(0, sb.length() - 1 );
	}
}

package com.blogspot.radialmind.csp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDomain implements IDomain {
	private String domainName;
	protected String queryTemplate;
	protected List<IDomain> context = new ArrayList<IDomain>();
	private List<List<String>> contextList = new ArrayList<List<String>>();
	protected Integer argNum = 1;
	private String curValue = null;
	
	public AbstractDomain( String domainName, String queryTemplate ) {
		super();
		this.domainName = domainName;
		this.queryTemplate = queryTemplate;
	}

	public String getDomainName() {
		return domainName;
	}

	@Override
	public void pushDomain( List<String> newContext ) {
		contextList.add( newContext );
		curValue = null;
	}

	@Override
	public void popDomain() {
		contextList.remove( contextList.size() - 1 );
	}
	
	public void clearDomain( int level ) {
		List<String> cl = contextList.get( level );
		if ( cl.size() > 1 ) {
			List<String> replacement = new ArrayList<String>();
			replacement.add( cl.get( 0 ) );
			contextList.set( level, replacement );
		}
	}
	
	public void addContext( IDomain domain ) {
		this.context.add( domain );
	}
	
	public void setArgNum( Integer argNum ) {
		this.argNum = argNum;
	}
	
	public String getCurrentValue() {
		return curValue;
	}
	
	public List<String> getValues() {
		List<String> cl = contextList.get( contextList.size() - 1 );
		return cl;
	}
	
	public void setCurrentValue( String s) {
		curValue = s;
	}
	
	public int getStackSize() {
		return contextList.size();
	}
}

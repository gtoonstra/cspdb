package com.blogspot.radialmind.csp;

import java.util.List;

public interface IDomain {
	public String getDomainName();
	public List<String> getDomain();
	public void pushDomain( List<String> newContext );
	public void popDomain();
	public String getCurrentValue();
	public void setCurrentValue( String s );
	public void addContext( IDomain domain );
	public void setArgNum( Integer number );
	public int getStackSize();
	public List<String> getValues();
	public void clearDomain( int level );
}

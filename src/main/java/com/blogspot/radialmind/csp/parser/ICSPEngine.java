package com.blogspot.radialmind.csp.parser;

public interface ICSPEngine {
	public void reset();
	public void execute() throws EngineException ;
	public void appendChar( char c );
	public void finishWord() throws EngineException ;
	public void finishString();
//	public void finishFloat();
//	public void finishInteger();
}

package com.blogspot.radialmind.csp.parser;

import java.util.List;

public interface IFunction {
	public String getName();
	public void execute( List<String> args) throws EngineException;
}

package com.blogspot.radialmind.csp.functions;

import java.util.List;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public abstract class AbstractFunction implements IFunction {
	
	protected CSPEngine engine;
	
	public AbstractFunction( CSPEngine engine ) {
		super();
		this.engine = engine;
	}
	
	protected void verifyArgsAtLeast( List<String> args, int num ) throws EngineException {
		if ( args == null ) {
			throw new EngineException( getName() + " expects at least " + num + " arguments."); 
		}
		if ( args.size() < num ) {
			throw new EngineException( getName() + " expects at least " + num + " arguments."); 
		}
	}
	
	protected static Object createObject(String className)
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		return Class.forName(className).newInstance();
	}
}

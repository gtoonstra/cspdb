package com.blogspot.radialmind.csp.parser;

import junit.framework.TestCase;

public abstract class AbstractTest extends TestCase {
	private CSPEngine ip;

	public AbstractTest() {
		super();
		ip = new CSPEngine();
	}

	protected void resetInterpreter() {
		// ip = new Interpreter();
		// ip.reset();
	}
}

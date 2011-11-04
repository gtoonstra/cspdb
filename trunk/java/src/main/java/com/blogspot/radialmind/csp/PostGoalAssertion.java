package com.blogspot.radialmind.csp;


public class PostGoalAssertion {

	private String assertionTemplate;
	
	public PostGoalAssertion(String assertionTemplate) {
		super();
		this.assertionTemplate = assertionTemplate;
	}

	public void doAssert( Integer solutionId, Integer score ) {
		String assertion = String.format( assertionTemplate, solutionId, score );
		DbUtils.executeUpdate( assertion );
	}
}

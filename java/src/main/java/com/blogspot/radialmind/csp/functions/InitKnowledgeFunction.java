package com.blogspot.radialmind.csp.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.blogspot.radialmind.csp.DbUtils;
import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.EngineException;
import com.blogspot.radialmind.csp.parser.IFunction;

public class InitKnowledgeFunction extends AbstractFunction implements IFunction {
	
	public InitKnowledgeFunction( CSPEngine engine ) {
		super(engine);
	}
	
	@Override
	public void execute( List<String> args ) throws EngineException {
		verifyArgsAtLeast( args, 3 );

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection con = DriverManager.getConnection( args.get( 0 ), args.get( 1 ), args.get( 2 ) );

		    if ( ! con.isClosed() ) {
		        System.out.println("Successfully connected to MySQL server using TCP/IP...");
		    } else {
		    	System.err.println("Could not connect to: " + args.get( 0 ) );
		    	System.exit( -1 );
		    }
		    
		    DbUtils.setConnection( con );		    
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.exit( -1 );
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit( -1 );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit( -1 );
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit( -1 );
		}
	}

	@Override
	public String getName() {
		return "init-knowledge";
	}
}

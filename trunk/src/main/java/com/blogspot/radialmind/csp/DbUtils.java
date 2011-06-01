package com.blogspot.radialmind.csp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	
	private static Connection conn;
	
	public static void setConnection( Connection connection ) {
		conn = connection;
	}
	
	public static void executeUpdate( String assertion ) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate( assertion );
			stmt.close();
		} catch (SQLException sqle ) {
			throw new RuntimeException( sqle.getMessage() );
		}
	}
	
	public static ResultSet executeQuery( String query ) {
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeQuery( query );
		} catch (SQLException sqle ) {
			throw new RuntimeException( sqle.getMessage() );
		}
	}
	
	public static void close( ResultSet rs ) {
		try {
			rs.getStatement().close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException( e.getMessage() );
		}
	}
}

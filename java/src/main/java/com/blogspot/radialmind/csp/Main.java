package com.blogspot.radialmind.csp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.blogspot.radialmind.csp.parser.CSPEngine;
import com.blogspot.radialmind.csp.parser.Parser;

public class Main {

	public static void main(String[] args ) {

		try {
			BufferedReader br = new BufferedReader( 
				new InputStreamReader( 
					new FileInputStream( args[ 0 ] ) ) );
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null ) {
				sb.append( line + "\n" );
			}
		
			CSPEngine engine = new CSPEngine();
			engine.reset();
			
			Parser parser = new Parser();
			if ( ! parser.parse( engine, sb.toString().toCharArray() ) ) {
				System.out.println("FAIL!");
				return;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}

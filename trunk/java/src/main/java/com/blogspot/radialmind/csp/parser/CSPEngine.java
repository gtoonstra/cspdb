package com.blogspot.radialmind.csp.parser;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.blogspot.radialmind.csp.AbstractDomain;
import com.blogspot.radialmind.csp.IAssertion;
import com.blogspot.radialmind.csp.IDomain;
import com.blogspot.radialmind.csp.IStateManager;
import com.blogspot.radialmind.csp.MySQLIterativeDomain;
import com.blogspot.radialmind.csp.PostGoalAssertion;
import com.blogspot.radialmind.csp.Tuple;
import com.blogspot.radialmind.csp.algorithms.RecursiveDepthFirstAlgorithm;
import com.blogspot.radialmind.csp.functions.AddArgumentToDomainFunction;
import com.blogspot.radialmind.csp.functions.AddDirectAssertionFunction;
import com.blogspot.radialmind.csp.functions.AddIncrementalAssertionFunction;
import com.blogspot.radialmind.csp.functions.AddIterativeDomainFunction;
import com.blogspot.radialmind.csp.functions.AddNormalDomainFunction;
import com.blogspot.radialmind.csp.functions.GoFunction;
import com.blogspot.radialmind.csp.functions.InitKnowledgeFunction;
import com.blogspot.radialmind.csp.functions.PostGoalFunction;
import com.blogspot.radialmind.csp.functions.SetGoalFunction;
import com.blogspot.radialmind.csp.functions.SetNthArgumentFunction;
import com.blogspot.radialmind.csp.functions.SetOutputGraphFileFunction;
import com.blogspot.radialmind.csp.functions.SetScoreFunction;
import com.blogspot.radialmind.csp.functions.SetTupleOrderFunction;
import com.blogspot.radialmind.csp.goals.IGoal;
import com.blogspot.radialmind.csp.score.IScore;

public class CSPEngine implements ICSPEngine, IStateManager {
	
	/** Interpreter and parser stuff (during parsing) */
	private IFunction curFunc = null;
	private List<String> args = new ArrayList<String>();
	private static Map<String, IFunction> functions = new HashMap<String, IFunction>();
	public CharArrayWriter cb = new CharArrayWriter();
	
	/** Reasoning stuff */
	private int highScore = -Integer.MAX_VALUE;
	private List<Tuple> tuples = new ArrayList<Tuple>();
	private Set<String> sets = new HashSet<String>();
	private List<Tuple> bestSolution;
	
	/** List of domains (preserves order) */
	private List<IDomain> domains = new ArrayList<IDomain>();
	private List<IAssertion> assertions = new ArrayList<IAssertion>();
	private PostGoalAssertion postGoal = null;
	private List<String> order = null;
	private String graphFileName = null;
	private long solutions = 0L;
	private IScore scorer = null;
	private IGoal goal = null;
	
	public CSPEngine() {
		super();
		addFunctions();
	}
	
	public void reset() {
		// do nothing for now
		curFunc = null;
		getBufferString();
		args = new ArrayList<String>();
	}

	@Override
	public void appendChar(char c) {
		cb.append( c );
	}

	@Override
	public void execute() throws EngineException {
		if ( curFunc == null ) {
			throw new EngineException("No function specified");
		}
		curFunc.execute( args );
		curFunc = null;
	}

	@Override
	public void finishString() {
		String str = getBufferString();
		args.add( str );
	}

	@Override
	public void finishWord() throws EngineException {
		String word = getBufferString();
		if ( curFunc == null ) {
			curFunc = functions.get( word );
			if ( curFunc == null ) {
				throw new EngineException( "Function does not exist: " + word );
			}
		}
	}
	
	public void addDomain( AbstractDomain domain ) {
		domains.add( domain );
	}
	
	public void addArgumentToDomain( String name, String argument ) throws EngineException {
		IDomain srcDomain = getDomain( name );
		IDomain argDomain = getDomain( argument );
		srcDomain.addContext( argDomain );
	}
	
	public void setArgNum( String name, Integer num ) throws EngineException {
		IDomain srcDomain = getDomain( name );
		srcDomain.setArgNum( num );		
	}
	
	public void addAssertion( IAssertion assertion ) throws EngineException {
		assertions.add( assertion );
	}
	
	public void setPostGoal( PostGoalAssertion pga ) throws EngineException {
		this.postGoal = pga;
	}
	
	public void setOrder( List<String> order ) {
		this.order = order;
	}
	
	public void setOutputGraphFile( String graphFileName ) {
		this.graphFileName = graphFileName;
	}
	
	public void setGoal( IGoal goal ) throws EngineException {
		this.goal = goal;
	}
	
	public void setScore( IScore scorer ) throws EngineException {
		this.scorer = scorer;		
	}
	
	public void go() throws EngineException {
		RecursiveDepthFirstAlgorithm algorithm = new RecursiveDepthFirstAlgorithm();

		int solutionId = 1;
		
		while (true) {			

			Tuple tuple = algorithm.getTuple( domains, tuples.size() + 1, 0 );
			if ( tuple != null ) {
				assertTuple( tuple );

				for ( IDomain ad: domains ) {
					if ( ad instanceof MySQLIterativeDomain ) {
						ad.clearDomain( tuples.size() - 1 );
					}
				}
				
				if ( goal.achieved( this ) ) {
					// So that was one solution... let's
					// get rid of it and try another from this domain 
					// above (iterator still runs).
					int score = foundSolution();
					if ( postGoal != null ) {
						postGoal.doAssert( new Integer( solutionId ), new Integer( score ) );
					}
					if ( ! shouldContinue() ) {
						break;
					}
					backtrackMostRecentTuple();
					solutionId++;
				}
			} else {
				if ( domains.get( 0 ).getStackSize() == 0 ) {
					// end of possible solutions
					break;
				}
				backtrackMostRecentTuple();
			}
		}

		try {     
			FileWriter fw = new FileWriter( new File( graphFileName ) );
			fw.write( "digraph G {\n" );
			for ( String s: sets ) {
				fw.write( "   " + s + ";\n" );
			}
			fw.write( "}\n" );
			fw.flush();
			fw.close();
		} catch(Exception e) {
			System.out.println("Could not load file!");
		}
		
		if ( bestSolution != null ) {
			System.out.println("===== BEST SOLUTION ====");
			for ( Tuple t: bestSolution ) {
				System.out.println( t );
			}
		}
		
		System.out.println( "Found " + solutions + " solutions.");
	}

	@Override
	public void assertTuple( Tuple tuple ) {
		for ( IAssertion ast: assertions ) {
			ast.doAssert( tuple );
		}
		tuples.add( tuple );
		//System.out.println( "Asserting: " + tuple );
	}

	@Override
	public void backtrackMostRecentTuple() {
		if ( tuples.size() == 0 ) {
			return;
		}
		Tuple tuple = tuples.get( tuples.size() - 1 );
		for ( IAssertion ast: assertions ) {
			ast.doRetract( tuple );
		}
		tuples.remove( tuple );
		//System.out.println( "Retracting: " + tuple );
	}

	@Override
	public void backtrackTuple( Tuple tuple ) {
		for ( IAssertion ast: assertions ) {
			ast.doRetract( tuple );
		}
		tuples.remove( tuple );
	}
	
	@Override
	public int getNumTuples() {
		return tuples.size();
	}

	@Override
	public int foundSolution() {
		int score = verifySolution();
		
		solutions++;		
		
		System.out.println("===== SOLUTION ====");
		for ( Tuple t: tuples ) {
			System.out.println( t );
		}
		System.out.println( solutions + " solutions found so far...");
		System.out.flush();
		
		return score;
	}

	@Override
	public boolean shouldContinue() {
		return true;
	}

	private int verifySolution() {
		Tuple prevTuple = null;
		List<Tuple> ordered = null;
		
		int score = 0;
		int ctr = 0;

		// Order the tuples;
		if ( order != null ) {
			ordered = order( (Tuple[])tuples.toArray( new Tuple[ 0 ] ), order );
		} else {
			ordered = tuples;
		}
		
		for ( Tuple t: ordered ) {
			StringBuilder sb = new StringBuilder();			
			if ( prevTuple == null ) {
				sb.append( "START -> " );
			} else {
//				sb.append( prevTuple.graph() + "_" + (ctr-1) );
//				sb.append( prevTuple.graph() + "_" + numSets );
				sb.append( prevTuple.graph() );
				sb.append( " -> " );
			}
			sb.append( t.graph() );
			sets.add( sb.toString() );
			
			if ( scorer != null ) {
				score += scorer.rateTuple( t, prevTuple );
			}
			prevTuple = t;
			ctr++;
		}
		
		System.out.println("Score: " + score);
		
		if (( scorer != null ) && ( score > highScore )) {
			bestSolution = new ArrayList<Tuple>();
			bestSolution.addAll( ordered );
			highScore = score;
		}
		
		return score;
	}
	
	private void addFunctions() {
		addFunction( new InitKnowledgeFunction( this ));
		addFunction( new AddArgumentToDomainFunction( this ));
		addFunction( new AddDirectAssertionFunction( this ));
		addFunction( new AddIncrementalAssertionFunction( this ));
		addFunction( new AddIterativeDomainFunction( this ));
		addFunction( new AddNormalDomainFunction( this ));
		addFunction( new GoFunction( this ));
		addFunction( new SetTupleOrderFunction( this ));
		addFunction( new SetOutputGraphFileFunction( this ));
		addFunction( new SetGoalFunction( this ));
		addFunction( new SetNthArgumentFunction( this ));
		addFunction( new SetScoreFunction( this ));
		addFunction( new PostGoalFunction( this ));
	}
	
	private void addFunction( IFunction func ) {
		functions.put( func.getName(), func );
	}
	
	private String getBufferString() {
		cb.flush();
		String word = cb.toString();
		cb.close();
		cb.reset();	
		return word;
	}
	
	private List<Tuple> order( Tuple[] tuples, List<String> order ) {
		Arrays.sort( tuples, new TupleOrderComparator( order ) );
		List<Tuple> result = new ArrayList<Tuple>();
		for ( int i = 0; i < tuples.length; i++ ) {
			result.add( tuples[ i ] );
		}
		return result;
	}
	
	private static class TupleOrderComparator implements Comparator<Tuple> {

		private List<String> order;
		
		public TupleOrderComparator( List<String> order ) {
			super();
			this.order = order;
		}
		
		@Override
		public int compare(Tuple t1, Tuple t2) {
			int ret = 0;
			
			for ( String s: order ) {
				ret = t1.getValue( s ).compareTo( t2.getValue( s ) );
				if ( ret != 0 ) {
					return ret;
				}
			}
			return 0;
		}
	}
	
	private IDomain getDomain( String name ) throws EngineException {
		for ( IDomain domain: domains ) {
			if ( domain.getDomainName().equals( name )) {
				return domain;
			}
		}
		throw new EngineException( "No domain available with specified name: " + name );
	}
}

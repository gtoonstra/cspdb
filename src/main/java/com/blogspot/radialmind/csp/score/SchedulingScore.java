package com.blogspot.radialmind.csp.score;

import java.util.List;

import com.blogspot.radialmind.csp.Tuple;

public class SchedulingScore implements IScore {
	public void setArguments( List<String> args ) {
		if (( args != null) && (args.size() > 0 )) {
			throw new RuntimeException("This score function does not accept arguments");
		}
	}
	
	@Override
	public int rateTuple( Tuple tuple, Tuple prevTuple ) { 
		int score = 0;
		
		if ( "2".equals( tuple.getValue( "timeslot" ) ) ) {
			// favour courses provided in the middle of the day;
			score++;
		}
		if ( "3".equals( tuple.getValue( "timeslot" ) ) ) {
			// favour courses provided in the middle of the day;
			score++;
			}
		if ( prevTuple != null ) {
			if (( tuple.getValue( "course" ).equals( prevTuple.getValue( "course" ) )) &&
				( tuple.getValue( "room" ).equals( prevTuple.getValue( "room" ))) &&
				( tuple.getValue( "prof" ).equals( prevTuple.getValue( "prof" ))) ) 
			{
				// favour schedules where the previous tuple room and course
				// is equal (hours following up one another).
				score++;
			}
		}
		
		if ( "4".equals( tuple.getValue( "room" ) ) ) {
			// keep auditorium free
			score--;
		}
		return score;
	}
}

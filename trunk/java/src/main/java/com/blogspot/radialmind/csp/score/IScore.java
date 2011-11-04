package com.blogspot.radialmind.csp.score;

import java.util.List;

import com.blogspot.radialmind.csp.Tuple;

public interface IScore {
	public void setArguments( List<String> args );
	public int rateTuple( Tuple tuple, Tuple prevTuple );
}

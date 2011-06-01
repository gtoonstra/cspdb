package com.blogspot.radialmind.csp.goals;

import java.util.List;

import com.blogspot.radialmind.csp.IStateManager;

public interface IGoal {
	public void setArguments( List<String> args );
	public boolean achieved( IStateManager manager );
}

package com.somena.job;

import com.somena.exceptions.InvalidStateTransitionException;

public abstract class JobState 
{
	protected Job ownerJob;
	
	public JobState(Job job) {
		this.ownerJob = job;
	}
	
	public abstract JobState nextState();
	public abstract JobState previousState();
	public abstract String currentStateName();

}

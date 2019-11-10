package com.somena.job;

public class ArchivedState extends JobState
{
	public ArchivedState(Job job) {
		super(job);
	}

	@Override
	public JobState nextState() {
		return null;
	}

	@Override
	public JobState previousState() {
		return null;
	}

	@Override
	public String currentStateName() {
		return "Archived";
	}

}

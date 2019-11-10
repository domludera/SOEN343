package com.somena.job;

public class CompleteState extends JobState
{
	public CompleteState(Job job) {
		super(job);
	}

	@Override
	public JobState nextState() {
		return ownerJob.ArchivedState;
	}

	@Override
	public JobState previousState() {
		return ownerJob.inProgressState;
	}

	@Override
	public String currentStateName() {
		return "Complete";
	}
}

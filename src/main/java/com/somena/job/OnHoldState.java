package com.somena.job;

public class OnHoldState extends JobState
{
	public OnHoldState(Job job) {
		super(job);
	}

	@Override
	public JobState nextState() {
		return ownerJob.inProgressState;
	}

	@Override
	public JobState previousState() {
		return null;
	}

	@Override
	public String currentStateName() {
		return "on hold";
	}

}

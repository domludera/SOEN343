package com.soen343.gms.model;

public class CompleteState extends JobStateEnum
{
	public CompleteState(Job job) {
		super(job);
	}

	@Override
	public JobStateEnum nextState() {
		return ownerJob.ArchivedState;
	}

	@Override
	public JobStateEnum previousState() {
		return ownerJob.inProgressState;
	}

	@Override
	public String currentStateName() {
		return "Complete";
	}
}

package com.soen343.gms.model;

public class ArchivedState extends JobStateEnum
{
	public ArchivedState(Job job) {
		super(job);
	}

	@Override
	public JobStateEnum nextState() {
		return null;
	}

	@Override
	public JobStateEnum previousState() {
		return null;
	}

	@Override
	public String currentStateName() {
		return "Archived";
	}

}

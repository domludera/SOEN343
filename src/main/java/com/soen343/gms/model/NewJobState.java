package com.soen343.gms.model;

public class NewJobState extends JobStateEnum {

	public NewJobState(Job job) {
		super(job);
	}

	@Override
	public JobStateEnum nextState() {
		return ownerJob.inProgressState;
	}

	@Override
	public JobStateEnum previousState() {
		return null;
	}

	@Override
	public String currentStateName() {
		return "new";
	}

}

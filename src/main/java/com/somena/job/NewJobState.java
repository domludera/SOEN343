package com.somena.job;

public class NewJobState extends JobState{

	public NewJobState(Job job) {
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
		return "new";
	}

}

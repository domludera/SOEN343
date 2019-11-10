package com.somena.job;

public class PendingApprovalState extends JobState{
	
	public PendingApprovalState(Job job) {
		super(job);
	}

	@Override
	public JobState nextState() {
		return ownerJob.completeState;
	}

	@Override
	public JobState previousState() {
		return ownerJob.inProgressState;
	}

	@Override
	public String currentStateName() {
		return "pending approval";
	}

}

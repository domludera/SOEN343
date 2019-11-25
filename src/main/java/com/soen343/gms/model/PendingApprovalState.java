package com.soen343.gms.model;

public class PendingApprovalState extends JobStateEnum {
	
	public PendingApprovalState(Job job) {
		super(job);
	}

	@Override
	public JobStateEnum nextState() {
		return ownerJob.completeState;
	}

	@Override
	public JobStateEnum previousState() {
		return ownerJob.inProgressState;
	}

	@Override
	public String currentStateName() {
		return "pending approval";
	}

}

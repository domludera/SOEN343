package com.soen343.gms.model;

import com.somena.exceptions.InvalidStateTransitionException;
import com.somena.task.Task;

public class InProgressState extends JobStateEnum
{
	public InProgressState(Job job) {
		super(job);
	}

	@Override
	public JobStateEnum nextState(){
		
		return ownerJob.pendingApprovalState;
	}

	@Override
	public JobStateEnum previousState() {
		return ownerJob.onHoldState;
	}

	@Override
	public String currentStateName() {
		return "in progress";
	}

}

package com.somena.job;

import com.somena.exceptions.InvalidStateTransitionException;
import com.somena.task.Task;

public class InProgressState extends JobState
{
	public InProgressState(Job job) {
		super(job);
	}

	@Override
	public JobState nextState(){
		
		return ownerJob.pendingApprovalState;
	}

	@Override
	public JobState previousState() {
		return ownerJob.onHoldState;
	}

	@Override
	public String currentStateName() {
		return "in progress";
	}

}

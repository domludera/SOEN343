package com.somena.job;

import com.somena.exceptions.InvalidStateTransitionException;
import com.somena.task.Task;

public class Job {
	protected JobState currentState;
	protected JobState newState;
	protected JobState inProgressState;
	protected JobState onHoldState;
	protected JobState pendingApprovalState;
	protected JobState completeState;
	protected JobState ArchivedState;
	protected Task[] task;
	
	protected boolean paid;
	protected boolean approvedByManager;
	
	public Job()
	{
		newState = new NewJobState(this);
		currentState = newState;
		inProgressState = new InProgressState(this);
		onHoldState = new OnHoldState(this);
		pendingApprovalState = new PendingApprovalState(this);
		completeState = new CompleteState(this);
		ArchivedState = new ArchivedState(this);
	}
	
	public JobState getNextState()
	{
		return currentState.nextState();
	}
	
	public JobState getPreviousState()
	{
		return currentState.previousState();
	}
	
	public void toTheNextState() throws InvalidStateTransitionException{
		if(!validNextJobStateTransition())
		{
			throw new InvalidStateTransitionException();
		}
		
		currentState = currentState.nextState();
	}
	
	public void toThePreviousState() throws InvalidStateTransitionException
	{
		if(!validPreviousJobStateTransition())
		{
			throw new InvalidStateTransitionException();
		}
		
		currentState = currentState.nextState();
	}
	
	public boolean validNextJobStateTransition()
	{
		if(currentState.nextState() == null)
		{
			return false;
		}
		
		if(currentState.nextState() == pendingApprovalState)
		{
			for(Task t : task)
			{
				if(!t.isComplete())
				{
					return false;
				}
			}
		}
		
		if(currentState.nextState() == completeState)
		{
			if(!approvedByManager)
				return false;
		}
		
		if(currentState.nextState() == ArchivedState)
		{
			if(!paid)
				return false;
		}

		
		return true;
	}
	
	public boolean validPreviousJobStateTransition() 
	{
		if(currentState.previousState() == null)
		{
			return false;
		}
		
		return true;
	}

	
	
}

package com.soen343.gms.model;

import com.somena.exceptions.InvalidStateTransitionException;
import com.somena.task.Task;

public class Job {
	protected JobStateEnum currentState;
	protected JobStateEnum newState;
	protected JobStateEnum inProgressState;
	protected JobStateEnum onHoldState;
	protected JobStateEnum pendingApprovalState;
	protected JobStateEnum completeState;
	protected JobStateEnum ArchivedState;
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
	
	public JobStateEnum getNextState()
	{
		return currentState.nextState();
	}
	
	public JobStateEnum getPreviousState()
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

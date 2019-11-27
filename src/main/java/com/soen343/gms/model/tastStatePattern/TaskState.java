package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;
import com.soen343.gms.model.tastStatePattern.invalidStateTransition.InvalidStateTransitionException;

public abstract class TaskState {
    protected Task taskContext;

    public TaskState(Task contextTask){
        taskContext = contextTask;
    }

    public abstract void nextState(Task contextTask) throws InvalidStateTransitionException;
    public abstract void previousState(Task contextTask) throws InvalidStateTransitionException;
    public abstract String currentState(Task contextTask);

}

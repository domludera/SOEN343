package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;
import com.soen343.gms.model.tastStatePattern.invalidStateTransition.InvalidStateTransitionException;

public class InProgressTaskState extends TaskState {
    public InProgressTaskState(Task task) {
        super(task);
    }

    @Override
    public void nextState(Task contextTask) throws InvalidStateTransitionException {
        
    }

    @Override
    public void previousState(Task contextTask) throws InvalidStateTransitionException {

    }

    @Override
    public String currentState(Task contextTask) {
        return null;
    }
}

package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;
import com.soen343.gms.model.tastStatePattern.invalidStateTransition.InvalidStateTransitionException;

public class NewTaskState extends TaskState {
    public NewTaskState(Task task) {
        super(task);
    }

    @Override
    public void nextState(Task contextTask) throws InvalidStateTransitionException {
        contextTask.currentState = new InProgressTaskState(contextTask);
    }

    @Override
    public void previousState(Task contextTask) throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException();
    }

    @Override
    public String currentState(Task contextTask) {
        return null;
    }
}

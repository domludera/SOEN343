package com.soen343.gms.model.taskStatePattern;

import com.soen343.gms.model.Task;

public class CompleteTaskState extends TaskState {

    public CompleteTaskState(Task wrapperTask) {
        super(wrapperTask);
    }

    @Override
    public void nextState() {

    }

    @Override
    public void previousState() {

    }

    @Override
    public String currentState() {
        return null;
    }
}

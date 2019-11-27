package com.soen343.gms.model.taskStatePattern;

import com.soen343.gms.model.Task;

public class OnHoldTaskState extends TaskState {
    public OnHoldTaskState(Task wrapperTask) {
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

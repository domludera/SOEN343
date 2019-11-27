package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;

public class OnHoldTaskState extends TaskState {
    public OnHoldTaskState(Task task) {
        super(task);
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

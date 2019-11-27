package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;

public class CompleteTaskState extends TaskState {
    public CompleteTaskState(Task task) {
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

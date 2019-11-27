package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;

public class InProgressTaskState extends TaskState {
    public InProgressTaskState(Task task) {
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

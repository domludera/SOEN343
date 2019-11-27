package com.soen343.gms.model.taskStatePattern;

import com.soen343.gms.model.Task;

public class InProgressTaskState extends TaskState {
    public InProgressTaskState(Task wrapperTask) {
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



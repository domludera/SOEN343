package com.soen343.gms.model.tastStatePattern;

import com.soen343.gms.model.Task;

public abstract class TaskState {
    protected Task taskWrapper;

    public TaskState(Task task){
        taskWrapper = task;
    }

    public abstract void nextState();
    public abstract void previousState();
    public abstract String currentState();

}

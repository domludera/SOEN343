package com.soen343.gms.model;

import com.soen343.gms.model.tastStatePattern.NewTaskState;
import com.soen343.gms.model.tastStatePattern.TaskState;

public class Task {
    public TaskState currentState;

    public Task(){
        currentState = new NewTaskState(this);
    }

    public void goToNextState(){
        //Will Have to be put in a try-catch since this may throw an invalidTransitionException
        currentState.nextState();
    }

    public void goToPreviousState(){
        //Will Have to be put in a try-catch since this may throw an invalidTransitionException
        currentState.previousState();
    }
}

package com.soen343.gms.model;

import com.soen343.gms.model.tastStatePattern.NewTaskState;
import com.soen343.gms.model.tastStatePattern.TaskState;
import com.soen343.gms.model.tastStatePattern.invalidStateTransition.InvalidStateTransitionException;

public class Task {
    public TaskState currentState;

    public Task(){
        currentState = new NewTaskState(this);
    }

    public void goToNextState(){
        try{
            currentState.nextState(this);
        }
        catch(InvalidStateTransitionException e){
            e.printStackTrace();
        }
    }

    public void goToPreviousState(){
        try{
            currentState.previousState(this);
        }
        catch(InvalidStateTransitionException e){
            e.printStackTrace();
        }

    }
}

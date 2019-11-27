package com.soen343.gms.model.taskStatePattern;
import com.soen343.gms.model.*;

public abstract class TaskState {
     protected Task wrapperTask;

     public TaskState(Task wrapperTask){
         this.wrapperTask = wrapperTask;
     }

     public abstract void nextState();
     public abstract void previousState();
     public abstract String currentState();

}

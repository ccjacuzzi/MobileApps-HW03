package com.ualr.simpletasklist.model;

public class Task {


    // TODO 01. Define two attributes for the Task class: one to store the task description and a second one that
    //  indicates whether the task is done or not
    private String taskDescription;  // A description of the task
    private Boolean isComplete; // A boolean variable to track if the task is complete (true)


    // TODO 02. Define the class constructor and the corresponding getters and setters.
    // The constructor will create a new instance of the Task class.
    // The taskDescription attribute will be set to the value of the string parameter newDescription
    public Task(){
        this.taskDescription = "";
        this.isComplete = false;
    }

    // Getter and Setter: taskDescription
    public String getTaskDescription(){
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription; // "this" refers to the current instance of the Task class
    }

    // Getter and Setter: isComplete
    public Boolean getIsComplete(){
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete){
        this.isComplete = isComplete;
    }

}

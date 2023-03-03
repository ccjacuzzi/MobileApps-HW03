package com.ualr.simpletasklist.model;


import java.util.HashMap;
import java.util.Map;

public class TaskList {

    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.

    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object

    private HashMap<Integer, Task> tasks;
    private int nextTaskID = 1;  // This will be used to track off and assign the keys for the hashmap

    // TODO 04. Define the class constructor and the corresponding getters and setters.
    // Class constructor
    public TaskList(){
        tasks = new HashMap<Integer, Task>();
    }

    //Getter
    public HashMap<Integer, Task> getTasks(){
        return tasks;
    }

    //Setter
    // Used if you were importing an existing hashmap of tasks
    public void setTasks(HashMap<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.
    public void add(String taskDescription){
        // creates a new task and adds it to the task list
        Task task = new Task();
        task.setTaskDescription(taskDescription);
        tasks.put(nextTaskID, task);
        nextTaskID++;
    }

    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line
    // Example: "6 - This is the task description - Done"
    public String toString() {
        StringBuilder taskBuilder = new StringBuilder();

        // For Each Loop iterates through all entries in the hashmap
        for (Map.Entry<Integer,Task> entry : tasks.entrySet()){
            taskBuilder.append(entry.getKey() + " - ");
            taskBuilder.append(entry.getValue().getTaskDescription());
            if (entry.getValue().getIsComplete()){
                taskBuilder.append(" - Done" + "\n");
            } else {
                taskBuilder.append("\n");
            }
        }

        return taskBuilder.toString();
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.
    public void delete(int taskID){
        tasks.remove(taskID);
    }

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.
    public void markDone(int taskID){
        Task task = tasks.get(taskID);
        if(task != null){
            task.setIsComplete(true);
        }
        // Else: Alert user that no task matches the entered ID
    }

}

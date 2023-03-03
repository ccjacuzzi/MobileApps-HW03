package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.TaskList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    // TODO 05. Add a TaskList member to the MainActivity. Initialize the new member.
    private TaskList taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Initialize the task list
        taskList = new TaskList();

        //TODO 06.02 Bind the onAddBtnClicked method to the add button, so the onAddBtnClicked is
        // triggered whenever the user clicks on that button
        this.binding.addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onAddBtnClicked();
            }
        });

        //TODO 07.02 Bind the onDeleteBtnClicked method to the delete button, so that method is
        // triggered whenever the user clicks on that button

        this.binding.deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onDeleteBtnClicked();
            }
        });

        //TODO 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
        this.binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDoneBtnClicked();
            }
        });

    }


    // TODO 06. Create a new functionality to add a new task using the description provided
    //  through the text field on the top of the screen by tapping the "+" on the right

    // TODO 06.01. Create a new method called onAddBtnClicked.

    // TODO 06.05. Invoke TaskList class' add method to ask the TaskList to
    //  add a new Task with the description provided through the text field.

    // TODO 06.06. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView" (Did you mean "taskList"?)
    private void onAddBtnClicked(){
        // Get the string that the user types in the textview
        String description = binding.taskDescription.getText().toString();
        // Pass the string description into the "add" method
        taskList.add(description);
        // Clean the textview
        binding.taskDescription.setText("");

        // Use TaskList toString method and display the output in the "taskList"
        binding.taskList.setText(taskList.toString());
    }


    // TODO 07. Create a new functionality to delete a task from the task list

    // TODO 07.01. Create a new method called onDeleteBtnClicked.

    // TODO 07.04. Invoke TaskList class' delete method to ask the TaskList to
    //  delete a Task given the id provided through the text field on the bottom.

    // TODO 07.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"

    private void onDeleteBtnClicked(){
        // Get the id that the user types in
        String id = binding.editTextTaskId.getText().toString();
        
        try{
            // TODO casey_1: Update this function to check if a task with the entered id exists
            // Convert string to int
            int intID = Integer.parseInt(id);
            // Pass the id to the "delete" method
            taskList.delete(intID);
            // Display the updated task list
            binding.taskList.setText(taskList.toString());
            //Clean the text input field
            binding.editTextTaskId.setText("");
        } catch (NumberFormatException e){
            // Shows error if text entered cannot become an int
            Toast.makeText(this, "Please enter an integer!", Toast.LENGTH_SHORT).show();
        }
        
    }

    // TODO 08. Create a new functionality to mark a task as done.

    // TODO 08.01. Create a new method called onDoneBtnClicked

    // TODO 08.04. Invoke TaskList class' markDone method to ask the TaskList to
    //  mark a Task given the id provided through the text field on the bottom.

    // TODO 08.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"
    private void onDoneBtnClicked(){
        String id = binding.editTextTaskId.getText().toString();

        try{
            // TODO casey_2: Update this function to check if a task with the entered id exists
            //  and to make sure the entered task is not already marked done.
            // Convert string to int
            int intID = Integer.parseInt(id);
            // Pass the id to the "markDone" method
            taskList.markDone(intID);
            // Display the updated task list
            binding.taskList.setText(taskList.toString());
            //Clean the text input field
            binding.editTextTaskId.setText("");
        } catch (NumberFormatException e){
            // Shows error if text entered cannot become an int
            Toast.makeText(this, "Please enter an integer!", Toast.LENGTH_SHORT).show();
        }
    }
}
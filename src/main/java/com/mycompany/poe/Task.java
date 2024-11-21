/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author User
 */
public class Task {
     String name;
    String lastName;
    String taskName;
    String taskDescription;
    static int taskNumber = -1;
    
     /*
      Constructor for the Task class to set task information.
     */
    
    public Task(String name, String lastName, String taskName, String taskDescription) {
       this.name = name;
        this.lastName = lastName;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskNumber = taskNumber;
    }
    
    /*
      Checks if the task description is under 50 characters long.
      Returns true if the description is valid, false otherwise.
     */
    
    public boolean checkTaskDescription(String taskDescription ){
        return taskDescription.length()<50;
    }
    
    /*
      Prints task details including the developer's name, task name, and description.
     */
    
    public String printTaskDetails(String name, String lastName, String taskName, String taskDescription){

        
        
        return name + " " + lastName + 
               "\n" + taskName + 
               "\nDescription: " + taskDescription;
    }
    
    /*
      Generates a unique task ID in the format [First 2 letters of task name]:[task number]:[Last 3 letters of developer's name].
     This format is case-insensitive.
     */
    
        String TaskID(String taskName, String name) {
        taskNumber++;  // Increment task number for each new task

        // Get first two letters of taskName, handling case where the name is shorter than 2 characters
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;

        // Get last three letters of the developer's name, handling case where the name is shorter than 3 characters
        String developerPart = name.length() >= 3 ? name.substring(name.length() - 3) : name;

        // Generate the TaskID in the format: AD:0:INA
        String taskID = (taskNamePart + ":" + taskNumber + ":" + developerPart).toUpperCase();

        return taskID;
       
    }
        
     //Returns the accumulated total hours worked on tasks.
public int returnTotalHours(int hours){
   
    return hours;
}

}

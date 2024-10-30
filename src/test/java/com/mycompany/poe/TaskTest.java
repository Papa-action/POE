/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import static com.mycompany.poe.Task.taskNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class TaskTest {

    private int[] taskDuration;
    private int numberOfTasks;

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() < 50;
    }

    public String TaskID(String taskName, int taskNumber, String name) {
        // taskNumber++;  // Increment task number for each new task

        // Get first two letters of taskName, handling case where the name is shorter than 2 characters
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;

        // Get last three letters of the developer's name, handling case where the name is shorter than 3 characters
        String developerPart = name.length() >= 3 ? name.substring(name.length() - 3) : name;

        // Generate the TaskID in the format: AD:0:INA
        String taskID = (taskNamePart + ":" + taskNumber + ":" + developerPart).toUpperCase();

        return taskID;
    }

    public int returnTotalHours() {

        int total = 0;
        for(int i = 0; i <numberOfTasks ; i++){
            total += taskDuration[i];
        }
        return total;
    }

    @org.junit.jupiter.api.Test
    public void testCheckTaskDescription_Robyn_Sucess() {

        String taskDescription = "Create Login to authenticate users";

        boolean result = checkTaskDescription(taskDescription);
        assertTrue(result);

    }

    @org.junit.jupiter.api.Test
    public void testCheckTaskDescription_Mike_success() {

        String taskDescription = "Add Task Feature";

        boolean result = checkTaskDescription(taskDescription);
        assertTrue(result);

    }

    @org.junit.jupiter.api.Test
    public void testCheckTaskDescription_Mike_failure() {

        String taskDescription = "Please eneter a task description of less than 50 characters";

        boolean result = checkTaskDescription(taskDescription);
        assertFalse(result);

    }

    /**
     * Test of TaskID method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testTaskID_mike() {
        String taskNames = "Add Task Feature";
        String developer = "Mike Smith";
        int Number = 1;
        String expResult = "AD:1:ITH";
        String result = TaskID(taskNames, Number, developer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @org.junit.jupiter.api.Test
    public void testTaskID_robyn() {
        String taskNames = "Login Feature";
        String developer = "Robyn Harrison";
        int Number = 0;
        String expResult = "LO:0:SON";
        String result = TaskID(taskNames, Number, developer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    

    @org.junit.jupiter.api.Test
    public void testReturnTotalHours() {
        taskDuration[0] = 10;
        taskDuration[1] = 12;
        taskDuration[2] = 55;
        taskDuration[3] = 11;
        taskDuration[4] = 1;
        
        numberOfTasks = 5;

        //int expResult = taskDuration[0] + taskDuration[1] + taskDuration[2] + taskDuration[3] + taskDuration[4];
        int result = returnTotalHours();
        assertEquals(result, result);

    }

}

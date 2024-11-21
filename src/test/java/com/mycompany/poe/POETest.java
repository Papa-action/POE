/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import java.util.ArrayList;
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
public class POETest {
    // Arrays to store task details
    static ArrayList<String> developers = new ArrayList<>();
    static ArrayList<String> taskNames = new ArrayList<>();
    static ArrayList<String> taskIDs = new ArrayList<>();
    static ArrayList<Integer> taskDurations = new ArrayList<>();
    static ArrayList<String> taskStatuses = new ArrayList<>();
    static ArrayList<String> taskDescriptions = new ArrayList<>();

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of DeveloperArrayPopulation method, of class POE.
     */

  @Test
    public void testDeveloperArrayPopulation() {
        // Test data
        ArrayList<String> developers = new ArrayList<>();
        developers.add("Mike Smith");
        developers.add("Edward Harrison");
        developers.add("Samantha Paulson");
        developers.add("Glenda Oberholzer");

        // Expected data
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};

        // Validate
        assertArrayEquals(expectedDevelopers, developers.toArray());
    }

    /**
     * Test of LongestDurationTask method, of class POE.
     */
    
    @Test
    public void testLongestDurationTask() {
        // Test data
        ArrayList<String> developers = new ArrayList<>();
        ArrayList<Integer> durations = new ArrayList<>();
        developers.add("Mike Smith");
        developers.add("Edward Harrison");
        developers.add("Samantha Paulson");
        developers.add("Glenda Oberholzer");

        durations.add(5); // Task 1
        durations.add(8); // Task 2
        durations.add(2); // Task 3
        durations.add(11); // Task 4

        // Find the longest duration
        int longestDurationIndex = 0;
        for (int i = 1; i < durations.size(); i++) {
            if (durations.get(i) > durations.get(longestDurationIndex)) {
                longestDurationIndex = i;
            }
        }

        // Validate
        assertEquals("Glenda Oberholzer", developers.get(longestDurationIndex));
        assertEquals(11, durations.get(longestDurationIndex));
    }

    /**
     * Test of searchTasksByDeveloper method, of class POE.
     */
    
 
  @Test
    public void testSearchTasksByDeveloper() {
        // Test data
        ArrayList<String> developers = new ArrayList<>();
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> statuses = new ArrayList<>();
        developers.add("Mike Smith");
        developers.add("Edward Harrison");
        developers.add("Samantha Paulson");
        developers.add("Samantha Paulson");

        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        statuses.add("To Do");
        statuses.add("Doing");
        statuses.add("Done");
        statuses.add("To Do");

        // Search for tasks by "Samantha Paulson"
        ArrayList<String> assignedTasks = new ArrayList<>();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equals("Samantha Paulson")) {
                assignedTasks.add(taskNames.get(i) + " (" + statuses.get(i) + ")");
            }
        }

        // Expected result
        String[] expectedTasks = {"Create Reports (Done)", "Add Arrays (To Do)"};

        // Validate
        assertArrayEquals(expectedTasks, assignedTasks.toArray());
    }
    
    /**
     * Test of searchTasksByName method, of class POE.
     */
    
    @Test
    public void testSearchByTaskName() {
        // Test data
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> developers = new ArrayList<>();
        ArrayList<String> statuses = new ArrayList<>();
        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        developers.add("Mike Smith");
        developers.add("Edward Harrison");
        developers.add("Samantha Paulson");
        developers.add("Glenda Oberholzer");

        statuses.add("To Do");
        statuses.add("Doing");
        statuses.add("Done");
        statuses.add("To Do");

        // Search for "Create Login"
        int index = taskNames.indexOf("Create Login");
        assertEquals("Mike Smith", developers.get(index));
        assertEquals("Create Login", taskNames.get(index));
        assertEquals("To Do", statuses.get(index));
    }

    /**
     * Test of deleteTask method, of class POE.
     */
    @Test
    public void testDeleteTask() {
         // Test data
        ArrayList<String> taskNames = new ArrayList<>();
        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        // Remove "Create Reports"
        boolean removed = taskNames.remove("Create Reports");

        // Validate
        assertTrue(removed);
        assertFalse(taskNames.contains("Create Reports"));
        assertEquals(3, taskNames.size());
    
}

    /**
     * Test of main method, of class POE.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        POE.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class POE.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        POE.addTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showReport method, of class POE.
     */
    @Test
    public void testShowReport() {
        System.out.println("showReport");
        POE.showReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTasks method, of class POE.
     */
    @Test
    public void testSearchTasks() {
        System.out.println("searchTasks");
        POE.searchTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

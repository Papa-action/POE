/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class POE {
    // Arrays to store task details
    static ArrayList<String> developers = new ArrayList<>();
    static ArrayList<String> taskNames = new ArrayList<>();
    static ArrayList<String> taskIDs = new ArrayList<>();
    static ArrayList<Integer> taskDurations = new ArrayList<>();
    static ArrayList<String> taskStatuses = new ArrayList<>();
    static ArrayList<String> taskDescriptions = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login checker = new Login();

        // Registration and Login logic (unchanged)
        String firstName = "", lastName = "";
        System.out.println("Enter your first name:");
        firstName = input.next();
        System.out.println("Enter your last name:");
        lastName = input.next();

        boolean registered = false;
        while (!registered) {
            System.out.println("Create a username:");
            String username = input.next();
            System.out.println("Create a password:");
            String password = input.next();
            registered = checker.registerUser(firstName, lastName, username, password);
        }

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Enter your username to login:");
            String username = input.next();
            System.out.println("Enter your password:");
            String password = input.next();
            loggedIn = checker.loginUser(username, password);
            System.out.println(checker.returnLoginStatus(loggedIn));
        }

        if (loggedIn) {
            String welcome = "Welcome to EasyKanban";
            JOptionPane.showMessageDialog(null, welcome);

            while (true) {
                String choicestr = JOptionPane.showInputDialog(null,
                        "1. Add task\n"
                                + "2. Show report\n"
                                + "3. Search tasks\n"
                                + "4. Delete task\n"
                                + "5. Quit");
                int choice = Integer.parseInt(choicestr);

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        showReport();
                        break;
                    case 3:
                        searchTasks();
                        break;
                    case 4:
                        deleteTask();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "You selected: Quit");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
                        break;
                }
            }
        }
    }

    public static void addTask() {
        String developer = JOptionPane.showInputDialog(null, "Enter developer's name:");
        String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
        String taskDescription = JOptionPane.showInputDialog(null, "Enter task description:");
        String taskID = developer.substring(0, 2).toUpperCase() + ":" + taskNames.size() + ":" + taskName.substring(0, 2).toUpperCase();
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter task duration (hours):"));
        String taskStatus = JOptionPane.showInputDialog(null, "Enter task status (To Do/Doing/Done):");

        // Add task details to arrays
        developers.add(developer);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
        taskDescriptions.add(taskDescription);

        JOptionPane.showMessageDialog(null, "Task added successfully!");
    }

    public static void showReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task ID: ").append(taskIDs.get(i))
                    .append("\nDeveloper: ").append(developers.get(i))
                    .append("\nTask Name: ").append(taskNames.get(i))
                    .append("\nDuration: ").append(taskDescriptions.get(i))
                    .append("\nDuration: ").append(taskDurations.get(i))
                    .append(" hours\nStatus: ").append(taskStatuses.get(i))
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public static void searchTasks() {
        String searchOption = JOptionPane.showInputDialog(null,
                "1. Search by Task Name\n"
                        + "2. Search by Developer Name");
        int option = Integer.parseInt(searchOption);

        switch (option) {
            case 1:
                String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
                for (int i = 0; i < taskNames.size(); i++) {
                    if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                        JOptionPane.showMessageDialog(null, "Developer: " + developers.get(i)
                                + "\nTask Name: " + taskNames.get(i)
                                + "\nTask Description: " + taskDescriptions.get(i)
                                + "\nStatus: " + taskStatuses.get(i));
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Task not found.");
                break;

            case 2:
                String developer = JOptionPane.showInputDialog(null, "Enter developer's name:");
                StringBuilder tasksByDeveloper = new StringBuilder("Tasks for " + developer + ":\n");
                for (int i = 0; i < developers.size(); i++) {
                    if (developers.get(i).equalsIgnoreCase(developer)) {
                        tasksByDeveloper.append(taskNames.get(i)).append(" (").append(taskDescriptions.get(i)).append(" (").append(taskStatuses.get(i)).append(")\n");
                    }
                }
                JOptionPane.showMessageDialog(null, tasksByDeveloper.toString());
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice!");
                break;
        }
    }

    public static void deleteTask() {
        String taskName = JOptionPane.showInputDialog(null, "Enter task name to delete:");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                // Remove task details from arrays
                developers.remove(i);
                taskNames.remove(i);
               taskDescriptions.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task successfully deleted!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
}

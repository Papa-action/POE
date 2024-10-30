/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class POE {

    public static void main(String[] args) {
     
                Scanner input = new Scanner (System.in);
        Login checker = new Login();
       //boolean login
        String name ="";
        String lastName="";
        String taskName="";
        String taskDescription="";
        int a;
        int b = 0;
        String num1;
        int taskNumber = -1;
        int hours = 0;
        int addhours = 0 ;
        String firstName = null;
        String lastname = null;
        
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
       
   
        if(loggedIn){
        
        Task currentTask = new Task(name, lastName, taskName, taskDescription);      
       
        String welcome = "Welcome to EasyKanban";
        
        JOptionPane.showMessageDialog(null, welcome);
        
        

        while (true) {
            
            String choicestr = JOptionPane.showInputDialog(null,
                    "1. Add task\n"
                    + "2. Show report\n"
                    + "3. Quit"
            );

            
            int choice = Integer.parseInt(choicestr);

            
            switch (choice) {
                case 1:
                    
                    JOptionPane.showMessageDialog(null, "You selected: Add task");

                    
                    num1 = JOptionPane.showInputDialog(null, "Select the number of tasks to be added:");
                    a = Integer.parseInt(num1);

                    
                    while (b < a) {
                        b++;  
                //introdice for loop
                //task[i].na
                
                        name = JOptionPane.showInputDialog(null, "Enter first name:");
                        lastName = JOptionPane.showInputDialog(null, "Enter last name:");
                        taskName = JOptionPane.showInputDialog(null, "Enter task name:");
                        taskDescription = JOptionPane.showInputDialog(null, "Enter task description:");
                        // Task tasks[]=new Task()
                    String c = JOptionPane.showInputDialog(null, "enter duration of task ");
                    addhours = Integer.parseInt(c);
                
                    hours  = hours + addhours;
                        
                        while (!(currentTask.checkTaskDescription(taskDescription ))) {
                            taskDescription = JOptionPane.showInputDialog(null, "Task description must be less than 50 characters long.");
                        }

                        
                        JOptionPane.showMessageDialog(null,
                                currentTask.printTaskDetails(name, lastName, taskName, taskDescription)
                                + "\n " + currentTask.TaskID(taskName, name)
                                +"\n Duration:"+addhours);
                        
                        
                  }  
                       JOptionPane.showMessageDialog(null,"Total hours:" + currentTask.returnTotalHours(hours));
                    
                    
                    break;

                case 2:
                   
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    
                    break;

                case 3:
                    
                    JOptionPane.showMessageDialog(null, "You selected: Quit");
                    System.exit(0);  // Exit the program
                    break;

                default:
                    
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select 1, 2, or 3.");
                    break;
            }
        

               choicestr = JOptionPane.showInputDialog(null, "Choose an option:\n1. To Do\n2. Doing\n3. Done");

               
                choice = Integer.parseInt(choicestr);

               
                
                

        } 
        }
    }
}

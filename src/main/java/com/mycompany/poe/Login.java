/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author User
 */
public class Login {
    String firstName;
String lastname;
String password; 
String username;

 /*public Login(String Name, String password, String createPassword, String createUsername){
        this.Name = Name;
        this.password = password;
        this.createPassword = createPassword;
        this.createUsername = createUsername;
        
}*/

    
            boolean checkUserName(String username){
         if (username == null) {
            return false; // Return false if username does not contain an underscore and more than 5 characters long
        }
        //Reurn true if Name contains undersore and is no more than 5 characters long  
        return username.contains("_")&& username.length()<=5; 
    }  

            boolean checkPasswordComplexity(String password){
         if (password == null) {
            return false; // Return false if the password does not meet the conditions
        }
        // Return true if password contains atleast 8 characters,a capital letter, a number and a special character 
        return password.length()>=8&& password.matches(".*[A-Z].*")&& password.matches(".*\\d.*")
                && password.contains("@")
                || password.contains("!")                
                || password.contains("#") 
                || password.contains("%")
                || password.contains("$")
                || password.contains("&")
                || password.contains("*")
                || password.contains("?");
    }

        //this method will return true if checkPasswordComplexity and checkUserName both return true 
        public boolean registerUser(String firstName ,String lastname, String username, String password){ 
                if(!checkUserName(username)){
                  System.out.println("Username is not correctly formatted.");
            return false;
                }
                if(!checkPasswordComplexity(password)){
                   System.out.println("Password is not correctly formatted.");
            return false;
                }
                
        this.firstName = firstName;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        System.out.println("Both username and password are correctly formatted.");
        return true;
            }

        
        //this method will return true if username and password are re-entered correctly
        boolean loginUser(String username, String password){
            
        return username.equals(this.username) && password.equals(this.password);   
        }
        
        
       // this method will return login status if loginUser returns true 
       public String returnLoginStatus(boolean login){
            
           if (login){
                return "Welcome " + this.firstName + " " + this.lastname + " "+"It's great to see you again";
            }else{
                return "Failed login";
            }

       }
}

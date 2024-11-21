/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

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
public class LoginTest {

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
     * Test of checkUserName method, of class Login.
     * Tests a valid username format (with underscore and no more than 5 characters).
     */
    @Test
    public void testCheckUserNameValid() {
        System.out.println("checkUserName");
        
        Login instance = new Login();
        
        // Test data
        String username = "kyl_1"; // Valid username format
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUserName method, of class Login.
     * Tests an invalid username format (no underscore and too long).
     */
    @Test
    public void testCheckUserNameInvalid() {
        System.out.println("checkUserName");
        
        Login instance = new Login();
        
        // Test data
        String username = "kyle!!!!!!!"; // Invalid username (too long and no underscore)
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     * Tests a valid password that meets complexity requirements.
     */
    @Test
    public void testCheckPasswordComplexityValid() {
        System.out.println("checkPasswordComplexity");
        
        Login instance = new Login();
        
        // Test data
        String password = "Ch&&sec@kegg!"; // Valid password with complexity
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     * Tests an invalid password that doesn't meet complexity requirements.
     */
    @Test
    public void testCheckPasswordComplexityInvalid() {
        System.out.println("checkPasswordComplexity");
        
        Login instance = new Login();
        
        // Test data
        String password = "password"; // Invalid password (too simple)
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     * Tests user registration with valid data.
     */
    @Test
    public void testRegisterUserValid() {
        System.out.println("registerUser");
        
        Login instance = new Login();
        
        // Test data for valid registration
        String firstName = "John";
        String lastName = "Doe";
        String username = "kyl_1";
        String password = "Ch&&sec@kegg!";
        
        boolean expResult = true;
        boolean result = instance.registerUser(firstName, lastName, username, password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     * Tests user registration with invalid username.
     */
    @Test
    public void testRegisterUserInvalidUsername() {
        System.out.println("registerUser");
        
        Login instance = new Login();
        
        // Test data for invalid username
        String firstName = "John";
        String lastName = "Doe";
        String username = "kyle!!!!!!!"; // Invalid username
        String password = "Ch&&sec@kegg!";
        
        boolean expResult = false;
        boolean result = instance.registerUser(firstName, lastName, username, password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     * Tests user registration with invalid password.
     */
    @Test
    public void testRegisterUserInvalidPassword() {
        System.out.println("registerUser");
        
        Login instance = new Login();
        
        // Test data for valid username and invalid password
        String firstName = "John";
        String lastName = "Doe";
        String username = "kyl_1";
        String password = "password"; // Invalid password
        
        boolean expResult = false;
        boolean result = instance.registerUser(firstName, lastName, username, password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class Login.
     * Tests user login with correct credentials.
     */
    @Test
    public void testLoginUserValid() {
        System.out.println("loginUser");
        
        Login instance = new Login();
        
        // Test data for valid credentials
        String firstName = "John";
        String lastName = "Doe";
        String username = "kyl_1";
        String password = "Ch&&sec@kegg!";
        
        instance.registerUser(firstName, lastName, username, password); // Register the user
        boolean expResult = true;
        boolean result = instance.loginUser(username, password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class Login.
     * Tests user login with incorrect credentials.
     */
    @Test
    public void testLoginUserInvalid() {
        System.out.println("loginUser");
        
        Login instance = new Login();
        
        // Test data for invalid credentials
        String username = "wrong_username";
        String password = "wrong_password";
        
        boolean expResult = false;
        boolean result = instance.loginUser(username, password);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     * Verifies that the correct message is returned for successful login.
     */
    @Test
    public void testReturnLoginStatusSuccess() {
        System.out.println("returnLoginStatus");
        
        Login instance = new Login();
        
        // Test data for valid credentials
        String firstName = "John";
        String lastName = "Doe";
        String username = "kyl_1";
        String password = "Ch&&sec@kegg!";
        
        instance.registerUser(firstName, lastName, username, password); // Register the user
        boolean login = instance.loginUser(username, password); // Login
        
        String expResult = "Welcome John Doe, it is great to see you.";
        String result = instance.returnLoginStatus(login);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     * Verifies that the correct message is returned for failed login.
     */
    @Test
    public void testReturnLoginStatusFailure() {
        System.out.println("returnLoginStatus");
        
        Login instance = new Login();
        
        // Test data for failed login
        boolean login = false; // Simulate failed login
        
        String expResult = "Login failed, please try again.";
        String result = instance.returnLoginStatus(login);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String firstName = "";
        String lastname = "";
        String username = "";
        String password = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.registerUser(firstName, lastname, username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "";
        String password = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean login = false;
        Login instance = new Login();
        String expResult = "";
        String result = instance.returnLoginStatus(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}


package com.mycompany.registrationlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author student
 */
public class LoginTest {
    
    private LoginClass instance;

    @BeforeEach
    public void setUp() {
        instance = new LoginClass();
    }

    @Test
    public void testFullAuthenticationFlow() {
        System.out.println("Running Full Authentication Test...");
                
        String username = "kyl_e";
        assertTrue(instance.checkUserName(username));
        System.out.println("Enter Username: " + username);
        System.out.println("Username successfully captured");
        
        String password = "Ch3ckpass!";
        assertTrue(instance.checkPasswordComplexity(password));
        System.out.println("Enter Password: Password successfully captured");
        
        String cell = "+27123456789";
        assertTrue(instance.checkCellPhoneNumber(cell));
        System.out.println("Enter South African Cell Number: " + cell);
       
        String regStatus = instance.registerUser(username, password, cell);
        assertEquals("The two above conditions have been met, and the user has been registered successfully.", regStatus);
        System.out.println(regStatus);
        
        System.out.println("\n--- LOGIN ---");
        boolean loginCheck = instance.loginUser(username, password);
        assertTrue(loginCheck);
                
        String finalStatus = instance.returnLoginStatus(loginCheck, "John", "Doe");
        System.out.println("Username: Password: " + finalStatus);
                
        assertEquals("Welcome John Doe, it is great to see you again.", finalStatus);
    }
}
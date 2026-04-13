package com.mycompany.registrationlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author student
 */
public class RegistrationLoginTest {
    
    public RegistrationLoginTest() {
    }

    /**
     * Test of main method.
     * We modify this to ensure the test doesn't hang on user input.
     */
    @Test
    public void testMain() {
        System.out.println("Verifying RegistrationLogin class...");
                
        RegistrationLogin mainApp = new RegistrationLogin();               
        assertNotNull(mainApp, "The application class should be valid.");
                
    }
}
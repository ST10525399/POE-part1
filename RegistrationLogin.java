/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationlogin;

/**
 *
 * @author Student
 */

import java.util.Scanner;


public class RegistrationLogin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("--- CREATE YOUR ACCOUNT ---");
        System.out.print("Enter First Name: ");
        String first = input.nextLine();

        System.out.print("Enter Last Name: ");
        String last = input.nextLine();
        
        String username = "";
        while (true) {
            System.out.print("Enter Username: ");
            username = input.nextLine();
            if (auth.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }
        
        String password = "";
        while (true) {
            System.out.print("Enter Password: ");
            password = input.nextLine();
            if (auth.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }
        
        String cell = "";
        while (true) {
            System.out.print("Enter Phone Number: ");
            cell = input.nextLine();
            if (auth.checkCellPhoneNumber(cell)) {
                break;
            } else {
                System.out.println("The phone number format is not correct. It must start with '+' and be 13 digits or fewer.");
            }
        }
        
        String regStatus = auth.registerUser(username, password, cell);
        System.out.println("\n" + regStatus);
        
        if (regStatus.contains("successfully")) {
            System.out.println("\n--- SIGN IN ---");
            boolean loginSuccessful = false;

            while (!loginSuccessful) {
                System.out.print("Username: ");
                String logUsername = input.nextLine();

                System.out.print("Password: ");
                String logPassword = input.nextLine();

                loginSuccessful = auth.loginUser(logUsername, logPassword);
                System.out.println(auth.returnLoginStatus(loginSuccessful, first, last));
            }
        }
    }
}

class Login {

    private String userStore;
    private String passStore;

    public boolean checkUserName(String username) {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null) return false;
        boolean length = password.length() >= 8;
        boolean caps = !password.equals(password.toLowerCase());
        boolean nums = password.matches(".*[0-9].*");
        boolean syms = password.matches(".*[!@#$%^&*()].*");
        return length && caps && nums && syms;
    }

    public boolean checkCellPhoneNumber(String cell) {
        if (cell == null) return false;
        return cell.startsWith("+") && cell.length() <= 13;
    }

    public String registerUser(String username, String password, String cell) {
        if (!checkUserName(username)) return "The username is incorrectly formatted.";
        if (!checkPasswordComplexity(password)) return "The password does not meet the complexity requirements.";
        if (!checkCellPhoneNumber(cell)) return "The phone number format is not correct.";

        this.userStore = username;
        this.passStore = password;
        return "The two above conditions have been met, and the user has been registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        if (userStore == null || passStore == null) return false;
        return username.equals(userStore) && password.equals(passStore);
    }

    public String returnLoginStatus(boolean ok, String f, String l) {
        if (ok) {
            return "Welcome " + f + " " + l + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

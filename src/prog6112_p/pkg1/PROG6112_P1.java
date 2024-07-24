package prog6112_p.pkg1;

import java.util.Scanner;

/**
 * Student Management Application
 * Author: L Kwinana
 * Part 1 of the assignment
 * Student ID: ST10445079
 */
public class PROG6112_P1 {

    /**
     * Main method of the application
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Create a new Scanner object to read input from the user
        Scanner keyboard = new Scanner(System.in);
        
        // Display the application header
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*******************************");
        
        // Prompt the user to launch the menu or exit
        System.out.println("Enter (1) Launch Menu Or Any Key To Exit.");
        String launcher = keyboard.next();
        
        // Check if the user wants to launch the menu
        if (launcher.contains("1")) {
            // Create a new Student object to launch the menu
            Student student = new Student();
        } else {
            // Display a message if the user chooses to exit
            System.out.println("You have exited the STUDENT MANAGEMENT APPLICATION.");
        }
    }
}
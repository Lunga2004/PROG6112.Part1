package prog6112_p.pkg1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ST10445079
 * L Kwinana
 * This is the Student class, which represents a student management system.
 */
public class Student {
    int studentNumber;
    ArrayList<ArrayList<String>> students = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);

    /**
     * This is the constructor for the Student class. It initializes the student management system.
     */
    public Student() {
        // Initialize the ArrayLists for storing student information
        students.add(new ArrayList<>()); // for name
        students.add(new ArrayList<>()); // for age
        students.add(new ArrayList<>()); // for email
        students.add(new ArrayList<>()); // for course

        // Main menu loop
        while (true) {
            System.out.println("Please select one of the following menu items:\n" +
                    "(1) Capture a new student.\n" +
                    "(2) Search for a student.\n" +
                    "(3) Delete a student.\n" +
                    "(4) Print student report.\n" +
                    "(5) Exit Application.");
            System.out.println();
            String menu = keyboard.nextLine();

            switch (menu) {
                case "1":
                    saveStudent();
                    break;
                case "2":
                    searchStudent(students);
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    studentReport(students);
                    break;
                case "5":
                    exitStudentApplication();
                    break;
                default:
                    System.out.println("That is not a valid option!");
            }
        }
    }

    /**
     * This method captures a new student's information.
     */
    public void saveStudent() {
        System.out.println("How Many Students Are being added?");
        studentNumber = keyboard.nextInt();
        keyboard.nextLine(); // add this line to consume the newline character

        for (int i = 0; i < studentNumber; i++) {
            System.out.println();
            System.out.println("Enter Student Details.");
            System.out.println();

            System.out.print("Enter Student ID: ");
            String id = keyboard.nextLine();
            students.get(0).add(id);
            System.out.println();

            System.out.print("Enter Student Name: ");
            String name = keyboard.nextLine();
            students.get(1).add(name);
            System.out.println();

            int age;
            while (true) {
                try {
                    System.out.print("Enter Student Age: ");
                    age = keyboard.nextInt();
                    keyboard.nextLine(); // add this line to consume the newline character
                    if (age < 16) {
                        System.out.println("Age should be over 15 years old. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("You have entered a invalid age.");
                    System.out.print("Please re-enter the student age >> ");
                    keyboard.nextLine(); // clear the invalid input
                }
            }
            students.get(2).add(String.valueOf(age));

            System.out.println();
            System.out.print("Enter Student Email: ");
            String email = keyboard.nextLine();
            students.get(3).add(email);
            System.out.println();

            System.out.print("Enter Student Course: ");
            String course = keyboard.nextLine();
            students.add(new ArrayList<>()); // add a new ArrayList for course
            students.get(4).add(course); // add the course to the new ArrayList
            System.out.println("----------------------------------------");
            System.out.println("STUDENT CAPTURED.");
        }
        System.out.println();
        System.out.println("Students were captured and stored.");
        System.out.println();
        exit();
    }

    /**
     * This method searches for a student by ID.
     * @param students The ArrayList of student information
     */
    public void searchStudent(ArrayList<ArrayList<String>> students) {
        System.out.print("Enter the Student ID to be search: ");
        String id = keyboard.nextLine();

        boolean found = false;

        for (int i = 0; i < students.get(0).size(); i++) {
            if (students.get(0).get(i).equals(id)) {
                found = true;
                System.out.println("----------------------------------");
                System.out.println("Student ID "+ id);
                System.out.println("Name: " + students.get(1).get(i));
                System.out.println("Age: " + students.get(2).get(i));
                System.out.println("Email: " + students.get(3).get(i));
                System.out.println("Course: " + students.get(4).get(i));
                System.out.println("----------------------------------");

                break;
            }
        }

        if (!found) {
            System.out.println("----------------------------------");
            System.out.println("Error: " + id +" Student not found.");
            System.out.println("----------------------------------");
        }
        exit();
    }

    /**
     * This method deletes a student by ID.
     */
    public void deleteStudent() {
        System.out.println("Enter the Student ID to delete: ");
        String id = keyboard.nextLine();
        System.out.println("Are you sure you want to student "+ id +" from the system? Yes (y) to delete.");
        String input =keyboard.nextLine();
        
        boolean found = false;

        for (int i = 0; i < students.get(0).size(); i++) {
            
            if (students.get(0).get(i).equals(id)) {
                if (input.contains("y")) {

                    students.get(0).remove(i);
                    students.get(1).remove(i);
                    students.get(2).remove(i);
                    students.get(3).remove(i);
                    students.get(4).remove(i);
                    System.out.println("Student "+ id +" WAS DELETED!!.");
                    System.out.println();
                    break;
                } else {
                    exit();
                }
            }
        }

        if (!found) {
            System.out.println("Error: "+ id +" Student not found.");
        }
        exit();
    }

    /**
     * This method prints a report of all students.
     * @param students The ArrayList of student information
     */
    public void studentReport(ArrayList<ArrayList<String>> students) {
        if (students.get(0).size() > 0) {
            for (int i = 0; i < students.get(0).size(); i++) {
                System.out.println("-----------------------------------");
                System.out.println("Student "+ (i+1) + ":");
                System.out.println("-----------------------------------");
                System.out.println("ID: " + students.get(0).get(i) ); 
                System.out.println("Name: " + students.get(1).get(i));
                System.out.println("Age: " + students.get(2).get(i));
                System.out.println("Email: " + students.get(3).get(i));
                System.out.println("Course: " + students.get(4).get(i));
            }
        } else {
            System.out.println("No students were added.");
        }
        exit();
    }

    /**
     * This method exits the student management system.
     */
    public void exitStudentApplication() {
        System.out.println("Enter (1) Launch Menu Or Any Key To Exit.");
        String launcher = keyboard.next();
        if (launcher.contains("1")) {
            new Student();
        } else {
            System.out.println("You have exited the STUDENT MANAGEMENT APPLICATION.");
            System.exit(0);
        }
    }
    /**
     * This method exits the current menu.
     */
    public void exit() {
        System.out.println("Enter (1) Launch Menu Or Any Key To Exit.");
        String launcher = keyboard.next();
        if (launcher.contains("1")) {

        } else {
            System.out.println("You have exited the STUDENT MANAGEMENT APPLICATION.");
            System.exit(0);
        }
    }

}
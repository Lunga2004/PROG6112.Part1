/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package prog6112_p.pkg1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Private
 */
public class StudentTest {

    private Student student;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        student = new Student();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSaveStudent() {
        String input = "1\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.saveStudent();

        assertEquals(1, student.students.get(0).size());
        assertEquals("John Doe", student.students.get(1).get(0));
        assertEquals("20", student.students.get(2).get(0));
        assertEquals("john.doe@example.com", student.students.get(3).get(0));
        assertEquals("Computer Science", student.students.get(4).get(0));
    }

    @Test
    public void testSearchStudent() {
        String input = "1\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.saveStudent();

        input = "John Doe\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.searchStudent(student.students);

        String output = outContent.toString();
        assertTrue(output.contains("John Doe"));
        assertTrue(output.contains("20"));
        assertTrue(output.contains("john.doe@example.com"));
        assertTrue(output.contains("Computer Science"));
    }

    @Test
    public void testDeleteStudent() {
        String input = "1\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.saveStudent();

        input = "John Doe\ny\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.deleteStudent();

        assertEquals(0, student.students.get(0).size());
    }

    @Test
    public void testStudentReport() {
        String input = "1\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.saveStudent();

        student.studentReport(student.students);

        String output = outContent.toString();
        assertTrue(output.contains("John Doe"));
        assertTrue(output.contains("20"));
        assertTrue(output.contains("john.doe@example.com"));
        assertTrue(output.contains("Computer Science"));
    }

    @Test
    public void testExitStudentApplication() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        student.exitStudentApplication();

        String output = outContent.toString();
        assertTrue(output.contains("You have exited the STUDENT MANAGEMENT APPLICATION."));
    }
}

package prog6112_p.pkg1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

    @Test
public class PROG6112_P1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testLaunchMenu() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PROG6112_P1.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("STUDENT MANAGEMENT APPLICATION"));
        assertTrue(output.contains("Enter (1) Launch Menu Or Any Key To Exit."));
        // Assuming the Student class will display some initial message or menu
        assertTrue(output.contains("Please select one of the following menu items:"));
    }

    @Test
    public void testExitApplication() {
        String input = "x\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PROG6112_P1.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("STUDENT MANAGEMENT APPLICATION"));
        assertTrue(output.contains("Enter (1) Launch Menu Or Any Key To Exit."));
        assertTrue(output.contains("You have exited the STUDENT MANAGEMENT APPLICATION."));
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}

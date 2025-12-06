import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest{
  // @Test
  // void testMainRunsWithNoIssues(){
  //     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  //     System.setOut(new PrintStream(outContent));
  //     Main.main(new String[]{"50"});
  //     System.setOut(System.out);

  //     assertFalse(outContent.toString().contains("Impossible"));
  // }

  // @Test
  // void testMainTriggerImpossible(){
  //     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  //     System.setOut(new PrintStream(outContent));
  //     Main.main(new String[]{"150"});
  //     System.setOut(System.out);
    
  //     assertTrue(outContent.toString().contains("Impossible"));
  // }
    @Test
    void testMainTriggersImpossible() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{"150"});  // x > 100

        System.setOut(originalOut);
        String[] lines = outContent.toString().trim().split("\\r?\\n");

        // Assert exact outputs in order
        assertEquals("New average GPA after removal:3.7", lines[0].trim());
        assertEquals("Top Student: Bob", lines[1].trim());
        assertEquals("Average GPA: 3.7", lines[2].trim());
        assertEquals("Impossible", lines[3].trim());
    }

    @Test
    void testMainDoesNotTriggerImpossible() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{"50"});  // x < 100

        System.setOut(originalOut);
        String[] lines = outContent.toString().trim().split("\\r?\\n");

        // Assert exact outputs in order
        assertEquals("New average GPA after removal:3.7", lines[0].trim());
        assertEquals("Top Student: Bob", lines[1].trim());
        assertEquals("Average GPA: 3.7", lines[2].trim());
        assertEquals(3, lines.length);  // no "Impossible"
    }

    @Test
    void testMainBoundaryAt100() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{"100"});  // x == 100

        System.setOut(originalOut);
        String[] lines = outContent.toString().trim().split("\\r?\\n");

        // Assert exact outputs in order
        assertEquals("New average GPA after removal:3.7", lines[0].trim());
        assertEquals("Top Student: Bob", lines[1].trim());
        assertEquals("Average GPA: 3.7", lines[2].trim());
        assertEquals(3, lines.length);  // no "Impossible"
    }
}

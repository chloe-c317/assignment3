import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest{
  @Test
  void testMainRunsWithNoIssues(){
      // Capture System.out
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));

      // Default run (x = 42 or args empty)
      Main.main(new String[]{});

      // Restore System.out
      System.setOut(System.out);

      // Assert that "Impossible" was NOT printed
      assertFalse(outContent.toString().contains("Impossible"));
  }

  @Test
  void testMainTriggerImpossible(){
          // Capture System.out
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));

      // Run with x > 100 (e.g., pass "150" as arg)
      Main.main(new String[]{"150"});

      // Restore System.out
      System.setOut(System.out);

      // Assert that "Impossible" WAS printed
      assertTrue(outContent.toString().contains("Impossible"));
  }
}

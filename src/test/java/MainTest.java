import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest{
  @Test
  void testMainRunsWithNoIssues(){
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      Main.main(new String[]{"50"});
      System.setOut(System.out);

      assertFalse(outContent.toString().contains("Impossible"));
  }

  @Test
  void testMainTriggerImpossible(){
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      Main.main(new String[]{"150"});
      System.setOut(System.out);
    
      assertTrue(outContent.toString().contains("Impossible"));
  }
}

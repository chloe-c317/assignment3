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
void testMainDoesNotTriggerImpossible() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Main.main(new String[]{"50"});  // false branch

    System.setOut(originalOut);
    assertEquals("", outContent.toString().trim());
}

@Test
void testMainTriggersImpossible() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Main.main(new String[]{"150"});  // true branch

    System.setOut(originalOut);
    assertEquals("Impossible", outContent.toString().trim());
}
  
@Test
void testMainBoundaryAt100() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Main.main(new String[]{"100"});
    System.setOut(System.out);
    assertEquals("", outContent.toString().trim());
}

}

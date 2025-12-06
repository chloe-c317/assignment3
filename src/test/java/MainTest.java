import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest{
  @Test
  void testMainRunsWithNoIssues(){
    assertDoesNotThrow(()->Main.main(new String[]{}));
  }

  @Test
  void testMainTriggerImpossible(){
    assertDoesNotThrow(() -> Main.main(new String[]{}));
  }
}

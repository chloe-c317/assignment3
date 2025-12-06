
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest{
  @Test
  void testCheckNameValid(){
    assertTrue(Utils.checkName("Alice"));
  }

  @Test
  void testCheckWhitespaceName(){
    assertTrue(Utils.checkName("  "));
  }

  @Test
  void testCheckNameEmpty(){
    assertFalse(Utils.checkName(""));
  }

  @Test
  void testCheckNameNull(){
    assertFalse(Utils.checkName(null));
  }

  @Test
  void testIsValidNegativeAge(){
    assertFalse(Utils.isValidAge(-5));
  }

  @Test
  void testIsValidZeroAge(){
    assertTrue(Utils.isValidAge(0));
  }

  @Test
  void testIsValidAgeNormal(){
    assertTrue(Utils.isValidAge(25));
  }

  @Test
  void testIsValidAgeTooHigh(){
    assertTrue(Utils.isValidAge(150));
  }
  
}

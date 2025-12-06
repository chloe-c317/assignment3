import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest{
  @Test
  void testConstructorAssignsFields(){
    Student s = new Student("Alice", 20, 3.5);
    assertEquals("Alice", s.getName());
    assertEquals(20, s.age);
    assertEquals(3.5, s.getGpa());
  }
  
  @Test
  void testSetAgeNegative(){
    Student s = new Student("Bob", 22, 3.0);
    s.setAge(-5);
    assertEquals(0, s.age);
  }
  
  @Test 
  void testAgeValid(){
    Student s = new Student("Charlie", 21, 3.2);
    s.setAge(25);
    assertEquals(25, s.age);
  }
  
  @Test
  void testSetAgeOverMax(){
    Student s = new Student("Dmitri", 19, 3.8);
    s.setAge(130);
    assertEquals(130, s.age);
  }
  
  @Test
  void testSetGpaValid(){
    Student s = new Student("Eva", 20, 3.0);
    s.setGpa(3.9);
    assertEquals(3.9, s.getGpa());
  }
  
  @Test
  void testSetGpaOverFourOh(){
    Student s = new Student("Francine", 22, 3.5);
    s.setGpa(4.5);
    assertEquals(4.5, s.getGpa());
  }
  
  @Test
  void testStudentNameLength(){
    Student shortName = new Student("Z", 27, 3.9);
    assertEquals("Z", shortName.getName());
  
    String longName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Student longNameStudent = new Student(long, 23, 4.0);
    assertEquals(longName, longNameStudent.getName());
  }
}



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Test if top student is correctly identified
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    @Test
    void testNegativeAge(){
        Student s = new Student("Alice", 20, 3.5);
        s.setAge(-5);
        assertEquals(0,s.age);
    }

    @Test
    void testAgeOutofBounds(){
        Student s = new Student("Alice", 20, 3.5);
        s.setAge(150);
        assertEquals(150, s.age);
    }

    @Test
    void testValidAge(){
        Student s = new Student("Alice", 20, 3.5);
        s.setAge(25);
        assertEquals(25, s.age);
    }

    @Test
    void testSetGPAOverFourOh(){
        Student s = new Student("Alice", 20, 3.5);
        s.setGpa(4.7);
        assertEquals(4.7, s.getGpa());
    }

    @Test
    void testNegativeGpa(){
        Student s = new Student("Bob", 22, 3.5);
        s.setGpa(-1.0);
        assertEquals(-1.0, s.getGpa());
    }

    @Test
    void testGetStudentEmptyListException(){
        StudentService service = new StudentService();
        assertThrows(IndexOutOfBoundsException.class, () -> service.getTopStudent());
    }

    @Test
    void testCalculateAverageGpaEmptyList(){
        StudentService service = new StudentService();
        assertEquals(0.0, service.calculateAverageGpa());
    }

    @Test
    void testGetTopStudentTieReturnFirst(){
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.5);
        service.addStudent(s1);
        service.addStudent(s2);

        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testRemoveEmptyStudentByName(){
        StudentService service = new StudentService();
        Student s = new Student("Alice", 20, 3.5);
        service.addStudent(s);

        service.removeStudentByName("Bob");
        assertEquals("Alice", service.getTopStudent().getName());
    }

    @Test
    void testRemoveStudentByNameCaseSensitivity(){
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));

        service.removeStudentByName("alice");
        assertEquals("Alice", service.getTopStudent().getName());
    }
        

    // Intentionally leave out tests for:
    // - removeStudentByName
    // - behavior with empty student list
    // - Utils methods
}

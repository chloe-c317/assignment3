package org.csu713.exercise.service;

import org.csu713.exercise.student.Student;
import org.csu713.exercise.service.StudentService;
import org.csu713.exercise.model.Student;

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
    void testGetStudentEmptyListException(){
        StudentService service = new StudentService();
        assertThrows(IndexOutOfBoundsException.class, ()->service.getTopStudent());
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
    void testRemoveExistingStudentByName(){
        StudentService service = new StudentService();
        Student s = new Student("Alice", 20, 3.5);
        service.addStudent(s);

        service.removeStudentByName("Alice");
    }

    @Test
    void testRemoveEmptyStudentByName(){
        StudentService service = new StudentService();
        Student s = new Student("Alice", 20, 3.5);
        service.addStudent(s);

        service.removeStudentByName("Bob");
    }

    @Test
    void testRemoveStudentByNameMultipleSameName(){
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Alice", 22, 3.8);
        service.addStudent(s1);
        service.addStudent(s2);

        service.removeStudentByName("Alice");
    }
        

    // Intentionally leave out tests for:
    // - removeStudentByName
    // - behavior with empty student list
    // - Utils methods
}

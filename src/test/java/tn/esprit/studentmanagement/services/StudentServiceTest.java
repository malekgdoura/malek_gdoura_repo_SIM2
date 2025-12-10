package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetStudentById() {
        Student s = new Student();
        s.setIdStudent(1L);
        s.setFirstName("John");
        s.setLastName("Doe");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(s));

        Student result = studentService.getStudentById(1L);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }

    @Test
    void testSaveStudent() {
        Student s = new Student();
        s.setFirstName("Alex");

        when(studentRepository.save(s)).thenReturn(s);

        Student result = studentService.saveStudent(s);

        assertNotNull(result);
        assertEquals("Alex", result.getFirstName());
    }

    @Test
    void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(new Student(), new Student()));

        assertEquals(2, studentService.getAllStudents().size());
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }
}

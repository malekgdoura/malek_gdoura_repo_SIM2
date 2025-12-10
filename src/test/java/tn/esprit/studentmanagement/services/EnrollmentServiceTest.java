package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.repositories.EnrollmentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @Test
    void testGetEnrollmentById() {
        Enrollment e = new Enrollment();
        e.setIdEnrollment(1L);

        when(enrollmentRepository.findById(1L)).thenReturn(Optional.of(e));

        Enrollment result = enrollmentService.getEnrollmentById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getIdEnrollment());
    }

    @Test
    void testSaveEnrollment() {
        Enrollment enrollment = new Enrollment();
        enrollment.setIdEnrollment(2L);

        when(enrollmentRepository.save(enrollment)).thenReturn(enrollment);

        Enrollment result = enrollmentService.saveEnrollment(enrollment);

        assertNotNull(result);
        assertEquals(2L, result.getIdEnrollment());
    }

    @Test
    void testGetAllEnrollments() {
        when(enrollmentRepository.findAll()).thenReturn(java.util.List.of(new Enrollment(), new Enrollment(), new Enrollment()));

        assertEquals(3, enrollmentService.getAllEnrollments().size());
    }
}

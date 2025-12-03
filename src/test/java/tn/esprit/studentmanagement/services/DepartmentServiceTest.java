package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository repository;

    @InjectMocks
    private DepartmentService service;

    @Test
    void testGetDepartmentById() {
        Department d = new Department();
        d.setIdDepartment(1L);
        d.setName("IT");

        when(repository.findById(1L)).thenReturn(Optional.of(d));

        Department result = service.getDepartmentById(1L);

        assertNotNull(result);
        assertEquals("IT", result.getName());
    }
}

package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
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

    @Test
    void testGetAllDepartments() {
        List<Department> list = List.of(new Department(), new Department());
        when(repository.findAll()).thenReturn(list);

        List<Department> result = service.getAllDepartments();

        assertEquals(2, result.size());
    }

    @Test
    void testSaveDepartment() {
        Department d = new Department();
        d.setName("HR");
        when(repository.save(d)).thenReturn(d);

        Department result = service.saveDepartment(d);

        assertEquals("HR", result.getName());
    }

    @Test
    void testDeleteDepartment() {
        doNothing().when(repository).deleteById(1L);

        service.deleteDepartment(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}

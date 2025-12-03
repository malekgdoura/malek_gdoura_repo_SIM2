import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;
import tn.esprit.studentmanagement.services.DepartmentService;
@SpringBootTest
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository repository;

    @InjectMocks
    private DepartmentService service;

    public DepartmentServiceTest() {
        MockitoAnnotations.openMocks(this); // Initialize @Mock and @InjectMocks
    }

    @Test
    void testGetDepartmentById() {
        Department d = new Department();
        d.setId(1L);
        d.setName("IT");

        when(repository.findById(1L)).thenReturn(Optional.of(d));

        Department result = service.getDepartmentById(1L);

        assertNotNull(result);
        assertEquals("IT", result.getName());
    }
}

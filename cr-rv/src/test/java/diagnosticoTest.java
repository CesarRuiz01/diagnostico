import com.example.crrv.Entity.diagnostico;
import com.example.crrv.Repository.diagnosticoRepo;
import com.example.crrv.Service.diagnosticoServiceIMPL.dSIMPL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class diagnosticoTest {

    @Mock
    private diagnosticoRepo repo;

    @InjectMocks
    private dSIMPL service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreardiagnostico() {
        diagnostico inputDiagnostico = new diagnostico();
        inputDiagnostico.setDescripcion("Test Descripcion");
        inputDiagnostico.setEstado("Activo");

        diagnostico savedDiagnostico = new diagnostico();
        savedDiagnostico.setId(1);
        savedDiagnostico.setDescripcion("Test Descripcion");
        savedDiagnostico.setEstado("Activo");

        when(repo.save(any(diagnostico.class))).thenReturn(savedDiagnostico);

        diagnostico result = service.Creardiagnostico(inputDiagnostico);

        assertEquals(savedDiagnostico.getId(), result.getId());
        assertEquals(savedDiagnostico.getDescripcion(), result.getDescripcion());
        assertEquals(savedDiagnostico.getEstado(), result.getEstado());

        verify(repo, times(1)).save(any(diagnostico.class));
    }
    @Test
    public void testBuscardiagnostico() {
        int id = 6;
        diagnostico expectedDiagnostico = new diagnostico();
        expectedDiagnostico.setId(id);
        expectedDiagnostico.setDescripcion("Test Descripcion");
        expectedDiagnostico.setEstado("Activo");

        when(repo.findById(id)).thenReturn(java.util.Optional.of(expectedDiagnostico));

        diagnostico result = service.Buscardiagnostico(id);

        assertNotNull(result);
        assertEquals(expectedDiagnostico.getId(), result.getId());
        assertEquals(expectedDiagnostico.getDescripcion(), result.getDescripcion());
        assertEquals(expectedDiagnostico.getEstado(), result.getEstado());

        verify(repo, times(1)).findById(id);
    }

    @Test
    public void testBuscardiagnostico_Interactions() {

        service.Consultardiagnostico();

        verify(repo, times(1)).findAll();;
    }


}
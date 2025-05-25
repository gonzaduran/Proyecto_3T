package modelo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class ActividadesTest {

    private Actividades actividades;

    @BeforeEach
    public void setUp() {
        actividades = new Actividades();
    }

    @Test
    public void testVentanaInicialVisible() {
        assertNotNull(actividades);
        assertTrue(actividades instanceof JFrame);
    }

    @Test
    public void testPanelPrincipalNoEsNull() {
        JPanel panel = (JPanel) actividades.getContentPane();
        assertNotNull(panel);
    }

    @Test
    public void testTituloVentana() {
        actividades.setTitle("Título prueba");
        assertEquals("Título prueba", actividades.getTitle());
    }

}

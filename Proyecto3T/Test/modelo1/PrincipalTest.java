package modelo1;

import static org.junit.Assert.*;

import java.awt.Component;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para la clase Principal.
 */
public class PrincipalTest {

    private Principal principal;

    /**
     * Se ejecuta antes de cada prueba.
     */
    @Before
    public void setUp() {
        principal = new Principal();
    }

    /**
     * Verifica que la ventana principal se haya creado correctamente.
     */
    @Test
    public void testVentanaCreada() {
        assertNotNull("La instancia de Principal no debe ser null", principal);
        assertEquals("El ancho debe ser 850", 850, principal.getWidth());
        assertEquals("El alto debe ser 580", 580, principal.getHeight());
    }

    /**
     * Verifica que existen los botones del menú principal.
     */
    @Test
    public void testBotonesExistentes() {
        boolean socios = false;
        boolean actividades = false;
        boolean entrenadores = false;
        boolean instalaciones = false;

        for (Component comp : principal.getContentPane().getComponents()) {
            if (comp instanceof JButton) {
                String text = ((JButton) comp).getText();
                if (text.equals("SOCIOS")) socios = true;
                if (text.equals("ACTIVIDADES")) actividades = true;
                if (text.equals("ENTRENADORES")) entrenadores = true;
                if (text.equals("INSTALACIONES")) instalaciones = true;
            }
        }

        assertTrue("Debe contener botón SOCIOS", socios);
        assertTrue("Debe contener botón ACTIVIDADES", actividades);
        assertTrue("Debe contener botón ENTRENADORES", entrenadores);
        assertTrue("Debe contener botón INSTALACIONES", instalaciones);
    }
}

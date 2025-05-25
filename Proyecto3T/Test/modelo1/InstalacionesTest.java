package modelo1;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase Instalaciones.
 */
class InstalacionesTest {

    private Instalaciones frame;

    @BeforeEach
    void setUp() {
        frame = new Instalaciones();
    }

    @Test
    void testVentanaNoEsNula() {
        assertNotNull(frame, "La ventana no debería ser nula.");
    }

    @Test
    void testTituloVentana() {
        JLabel label = (JLabel) frame.getContentPane().getComponent(0);
        assertEquals("INSTALACIONES", label.getText());
    }

    @Test
    void testBotonAnadirInstalacion() {
        JButton boton = (JButton) frame.getContentPane().getComponent(1);
        assertEquals("AÑADIR INSTALACIÓN", boton.getText());
    }

    @Test
    void testBotonBorrarInstalacion() {
        JButton boton = (JButton) frame.getContentPane().getComponent(2);
        assertEquals("BORRAR INSTALACIÓN", boton.getText());
    }

    @Test
    void testBotonVerInstalaciones() {
        JButton boton = (JButton) frame.getContentPane().getComponent(3);
        assertEquals("VER INSTALACIONES", boton.getText());
    }
}

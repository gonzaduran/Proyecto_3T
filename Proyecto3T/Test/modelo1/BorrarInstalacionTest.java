package modelo1;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase BorrarInstalacion.
 */
public class BorrarInstalacionTest {

    private BorrarInstalacion ventana;

    @BeforeEach
    public void setUp() {
        ventana = new BorrarInstalacion();
    }

    @Test
    public void testVentanaNoEsNula() {
        assertNotNull(ventana, "La ventana debe estar instanciada.");
    }

    @Test
    public void testCamposTextoExisten() {
        Component[] components = ventana.getContentPane().getComponents();
        boolean tieneTextField1 = false;
        boolean tieneTextField2 = false;

        for (Component c : components) {
            if (c instanceof JTextField) {
                if (!tieneTextField1) {
                    tieneTextField1 = true;
                } else {
                    tieneTextField2 = true;
                }
            }
        }

        assertTrue(tieneTextField1 && tieneTextField2, "Debe haber dos campos JTextField.");
    }

    @Test
    public void testBotonesBorrarExisten() {
        Component[] components = ventana.getContentPane().getComponents();
        int contadorBotones = 0;

        for (Component c : components) {
            if (c instanceof JButton) {
                JButton btn = (JButton) c;
                if (btn.getText().equals("BORRAR")) {
                    contadorBotones++;
                }
            }
        }

        assertEquals(2, contadorBotones, "Debe haber dos botones con texto 'BORRAR'.");
    }
}

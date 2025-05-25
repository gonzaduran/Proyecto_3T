package modelo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import javax.swing.*;

class NuevaInstalacionTest {

    private NuevaInstalacion ventana;

    @BeforeEach
    void setUp() {
        // Instanciar la ventana antes de cada prueba
        ventana = new NuevaInstalacion();
    }

    @AfterEach
    void tearDown() {
        // Cerrar la ventana después de cada prueba
        ventana.dispose();
    }

    @Test
    void testVentanaNoEsNull() {
        assertNotNull(ventana);
    }

    @Test
    void testComponentesPrincipalesExisten() {
        JPanel panel = (JPanel) ventana.getContentPane();
        assertNotNull(panel);

        boolean tieneBotonGuardar = false;
        boolean tieneCampoNombre = false;
        boolean tieneCampoTipo = false;

        for (java.awt.Component comp : panel.getComponents()) {
            if (comp instanceof JButton && ((JButton) comp).getText().equals("GUARDAR")) {
                tieneBotonGuardar = true;
            }
            if (comp instanceof JTextField) {
                JTextField txt = (JTextField) comp;
                if (txt.getBounds().y == 191) tieneCampoNombre = true;
                if (txt.getBounds().y == 239) tieneCampoTipo = true;
            }
        }

        assertTrue(tieneBotonGuardar, "Falta el botón GUARDAR");
        assertTrue(tieneCampoNombre, "Falta el campo de nombre");
        assertTrue(tieneCampoTipo, "Falta el campo de tipo");
    }

    @Test
    void testCamposInicialmenteVacios() {
        JTextField nombre = getTextFieldEnY(191);
        JTextField tipo = getTextFieldEnY(239);

        assertNotNull(nombre);
        assertNotNull(tipo);

        assertEquals("", nombre.getText());
        assertEquals("", tipo.getText());
    }

    // Utilidad: buscar un JTextField por su coordenada Y
    private JTextField getTextFieldEnY(int y) {
        for (java.awt.Component comp : ventana.getContentPane().getComponents()) {
            if (comp instanceof JTextField) {
                JTextField field = (JTextField) comp;
                if (field.getBounds().y == y) {
                    return field;
                }
            }
        }
        return null;
    }
}

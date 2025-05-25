package modelo1;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerInstalacionTest {

    private VerInstalacion ventana;

    @BeforeEach
    void setUp() {
        // Inicializamos la ventana antes de cada prueba
        ventana = new VerInstalacion();
    }

    @Test
    void testConstructor_NoExcepciones() {
        assertDoesNotThrow(() -> new VerInstalacion());
    }
}

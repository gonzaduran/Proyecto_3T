package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class SociosAltaTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        FailOnThreadViolationRepaintManager.install();
        SociosAlta frame = new SociosAlta();
        window = new FrameFixture(robot(), frame);
        window.show(); // Muestra la ventana para test
    }

    @Test
    public void testComponentesVisiblesYEditables() {
        window.textBox("textNombre").requireVisible().requireEnabled();
        window.textBox("textApellido1").requireVisible().requireEnabled();
        window.textBox("textApellido2").requireVisible().requireEnabled();
        window.textBox("textEdad").requireVisible().requireEnabled();
        window.button("btnGuardar").requireVisible().requireEnabled();
    }

    @Test
    public void testInsertarDatos() {
        window.textBox("textNombre").enterText("Carlos");
        window.textBox("textApellido1").enterText("Gómez");
        window.textBox("textApellido2").enterText("López");
        window.textBox("textEdad").enterText("30");

        window.button("btnGuardar").click();

        // Aquí puedes validar si aparece un JOptionPane con mensaje de éxito
        // Solo si manejas un entorno con la base de datos real o mockeada
    }

    @Override
    protected void onTearDown() {
        window.cleanUp();
    }
}

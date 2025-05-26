package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class SociosTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        // Verifica que los accesos a Swing se hacen en el EDT
        FailOnThreadViolationRepaintManager.install();

        Socios frame = new Socios();
        window = new FrameFixture(robot(), frame);
        window.show(); // muestra la ventana
    }

    @Test
    public void testComponentesVisibles() {
        window.label("lblSOCIOS").requireVisible().requireText("SOCIOS");

        window.button("btnALTAS").requireVisible().requireText("ALTAS");
        window.button("btnBUSCAR").requireVisible().requireText("BUSCAR");
        window.button("btnEDITAR").requireVisible().requireText("EDITAR");
        window.button("btnBAJAS").requireVisible().requireText("BAJAS");
    }

    @Test
    public void testClickEnAltas() {
        window.button("btnALTAS").click();
        // Aquí podrías comprobar si la nueva ventana se abre si la clase SociosAlta tiene un setName.
    }

    @Test
    public void testClickEnBuscar() {
        window.button("btnBUSCAR").click();
        // Similar a lo anterior: idealmente verificar el comportamiento.
    }

    @Test
    public void testClickEnEditar() {
        window.button("btnEDITAR").click();
    }

    @Test
    public void testClickEnBajas() {
        window.button("btnBAJAS").click();
    }

    @Override
    protected void onTearDown() {
        window.cleanUp();
    }
}

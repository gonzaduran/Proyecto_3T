package modelo1;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class SociosEditarTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        FailOnThreadViolationRepaintManager.install();
        SociosEditar frame = new SociosEditar();
        window = new FrameFixture(robot(), frame);
        window.show(); // Muestra la ventana para pruebas
    }

    @Test
    public void testBuscarSocioNoEncontrado() {
        window.textBox("txtIdSocioEditar").setText("9999999");
        window.button("btnBuscarSocio").click();

        window.optionPane().requireVisible().requireMessage("Socio no encontrado");
        window.optionPane().okButton().click();
    }

    @Test
    public void testBuscarYEditarSocio() {
        // Aquí tendrías que usar un ID real de tu BD para que funcione.
        window.textBox("txtIdSocioEditar").setText("1");
        window.button("btnBuscarSocio").click();

        // Esperar que el campo Nombre se llene (no vacío)
        window.textBox("txtNombre").requireTextNotEmpty();

        // Cambiar nombre y guardar
        window.textBox("txtNombre").setText("Nombre Editado");
        window.button("btnGuardarCambios").click();

        window.optionPane().requireVisible().requireMessage("Socio actualizado correctamente.");
        window.optionPane().okButton().click();
    }
}

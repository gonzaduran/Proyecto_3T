package modelo1;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class SociosBuscarTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        FailOnThreadViolationRepaintManager.install();
        SociosBuscar frame = new SociosBuscar();
        window = new FrameFixture(robot(), frame);
        window.show(); // Muestra la ventana para pruebas
    }

    @Test
    public void testBusquedaIdNoValido() {
        window.textBox("txtIdSocioBuscar").setText("abc");
        window.button("btnBuscarSocio").click();

        // Aquí se lanza un JOptionPane con el error
        window.optionPane().requireVisible().requireMessage("Por favor, introduce un número válido para el ID.");
        window.optionPane().okButton().click();
    }

    @Test
    public void testBusquedaIdNoExistente() {
        window.textBox("txtIdSocioBuscar").setText("999999"); // ID muy alto que no existe
        window.button("btnBuscarSocio").click();

        window.textBox("txtResultadoSocio").requireText("No se encontró ningún socio con ese ID.");
    }

    // Para hacer pruebas con datos reales, tendrías que tener un ID existente en la base
    // @Test
    // public void testBusquedaIdExistente() {
    //     window.textBox("txtIdSocioBuscar").setText("1");
    //     window.button("btnBuscarSocio").click();
    //     window.textBox("txtResultadoSocio").requireTextNotEmpty();
    // }
}

package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class SociosBajasTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        FailOnThreadViolationRepaintManager.install();
        SociosBajas frame = new SociosBajas();
        window = new FrameFixture(robot(), frame);
        window.show();
    }

    @Test
    public void testComponentesVisiblesYEditables() {
        window.textBox("txtIdSocio").requireVisible().requireEnabled();
        window.button("btnBajaTemporal").requireVisible().requireEnabled();
        window.button("btnBajaDefinitiva").requireVisible().requireEnabled();
    }

    @Test
    public void testClickBotonesConEntradaDummy() {
        window.textBox("txtIdSocio").setText("1");
        window.button("btnBajaTemporal").click(); // Se espera JOptionPane
        // Se puede simular clic en JOptionPane si usas mocking o entorno controlado

        window.textBox("txtIdSocio").setText("2");
        window.button("btnBajaDefinitiva").click(); // Abre confirmación
        // Aquí puedes añadir lógica para aceptar el diálogo si lo mockeas
    }

    @Override
    protected void onTearDown() {
        window.cleanUp();
    }
}

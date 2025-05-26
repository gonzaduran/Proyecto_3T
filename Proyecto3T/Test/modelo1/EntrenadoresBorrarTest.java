package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

public class EntrenadoresBorrarTest {

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        EntrenadoresBorrar frame = new EntrenadoresBorrar();
        window = new FrameFixture(frame);
        window.show();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testCamposYBotonesVisibles() {
        window.textBox("txtIdEntrenador").requireVisible();
        window.button("btnBajaTemporal").requireVisible().requireEnabled();
        window.button("btnBajaDefinitiva").requireVisible().requireEnabled();
    }

    @Test
    public void testEntradaDeId() {
        window.textBox("txtIdEntrenador").enterText("5");
        assertThat(window.textBox("txtIdEntrenador").text()).isEqualTo("5");
    }

    @Test
    public void testClickBajaTemporal() {
        window.textBox("txtIdEntrenador").enterText("1");
        window.button("btnBajaTemporal").click();
    }

    @Test
    public void testClickBajaDefinitiva() {
        window.button("btnBajaDefinitiva").click();
    }
}

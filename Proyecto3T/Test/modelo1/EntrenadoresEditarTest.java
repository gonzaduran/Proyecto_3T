package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

public class EntrenadoresEditarTest {

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        EntrenadoresEditar frame = new EntrenadoresEditar();
        window = new FrameFixture(frame);
        window.show();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testCamposVisibles() {
        window.textBox("txtIdEntrenador").requireVisible();
        window.textBox("txtNombre").requireVisible();
        window.textBox("txtApellido1").requireVisible();
        window.textBox("txtApellido2").requireVisible();
        window.textBox("txtEspecialidad").requireVisible();
    }

    @Test
    public void testBotonesVisiblesYActivos() {
        window.button("btnBuscar").requireVisible().requireEnabled();
        window.button("btnGuardar").requireVisible().requireEnabled();
    }

    @Test
    public void testEntradaDatos() {
        window.textBox("txtIdEntrenador").enterText("1");
        window.textBox("txtNombre").enterText("Carlos");
        window.textBox("txtApellido1").enterText("Sánchez");
        window.textBox("txtApellido2").enterText("Gómez");
        window.textBox("txtEspecialidad").enterText("Baloncesto");

        assertThat(window.textBox("txtNombre").text()).isEqualTo("Carlos");
        assertThat(window.textBox("txtApellido1").text()).isEqualTo("Sánchez");
        assertThat(window.textBox("txtApellido2").text()).isEqualTo("Gómez");
        assertThat(window.textBox("txtEspecialidad").text()).isEqualTo("Baloncesto");
    }

    @Test
    public void testClickBotonBuscarYGuardar() {
        window.textBox("txtIdEntrenador").enterText("1");
        window.button("btnBuscar").click();  // Verifica que puede hacer clic (no testea SQL)
        window.button("btnGuardar").click(); // Igual, testea interacción
    }
}

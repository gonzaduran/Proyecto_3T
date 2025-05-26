package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

public class EntrenadoresAltaTest {

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        EntrenadoresAlta frame = new EntrenadoresAlta();
        window = new FrameFixture(frame);
        window.show(); // muestra la ventana para los tests
    }

    @After
    public void tearDown() {
        window.cleanUp(); // cierra la ventana después del test
    }

    @Test
    public void testCamposVisibles() {
        window.textBox("textNombre").requireVisible();
        window.textBox("textApellido1").requireVisible();
        window.textBox("textApellido2").requireVisible();
        window.textBox("textEspecialidad").requireVisible();
    }

    @Test
    public void testBotonGuardarVisible() {
        window.button("btnGuardar").requireVisible().requireEnabled();
    }

    @Test
    public void testEntradaDatos() {
        window.textBox("textNombre").enterText("Juan");
        window.textBox("textApellido1").enterText("Pérez");
        window.textBox("textApellido2").enterText("López");
        window.textBox("textEspecialidad").enterText("Fútbol");

        assertThat(window.textBox("textNombre").text()).isEqualTo("Juan");
        assertThat(window.textBox("textApellido1").text()).isEqualTo("Pérez");
        assertThat(window.textBox("textApellido2").text()).isEqualTo("López");
        assertThat(window.textBox("textEspecialidad").text()).isEqualTo("Fútbol");
    }

    @Test
    public void testClickBotonGuardarSinErroresVisibles() {
        // Esto solo prueba que el botón se puede pulsar
        // NO prueba la base de datos (sin mocks)
        window.button("btnGuardar").click();
    }
}

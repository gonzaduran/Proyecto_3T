package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

public class EntrenadoresListadoTest {

	private FrameFixture window;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() {
		EntrenadoresListado frame = new EntrenadoresListado();
		window = new FrameFixture(frame);
		window.show(); // Muestra la ventana para que AssertJ pueda interactuar
	}

	@After
	public void tearDown() {
		window.cleanUp(); // Cierra la ventana y libera recursos
	}

	@Test
	public void testComponentesVisibles() {
		window.textBox("textFieldNombre").requireVisible();
		window.textBox("textFieldId").requireVisible();
		window.textBox("textFieldNombre").requireEnabled();
		window.textBox("textFieldId").requireEnabled();
		window.textBox("textArea").requireVisible(); // Aunque es JTextArea, se accede igual
		window.button("btnBuscarNombre").requireVisible().requireEnabled();
		window.button("btnBuscarId").requireVisible().requireEnabled();
	}

	@Test
	public void testEntradaDatosYBotones() {
		window.textBox("textFieldNombre").enterText("Juan");
		window.textBox("textFieldId").enterText("5");

		assertThat(window.textBox("textFieldNombre").text()).isEqualTo("Juan");
		assertThat(window.textBox("textFieldId").text()).isEqualTo("5");

		window.button("btnBuscarNombre").click();
		window.button("btnBuscarId").click();
	}
}

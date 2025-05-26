package modelo1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.*;

public class EntrenadoresTest {

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        Entrenadores frame = new Entrenadores();
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testWindowIsVisible() {
        window.requireVisible();
    }

    @Test
    public void testLabelIsPresent() {
        window.label().requireText("ENTRENADORES");
    }

    @Test
    public void testRegistrarButtonExistsAndClickable() {
        window.button("REGISTRAR").requireVisible().click();
    }

    @Test
    public void testListadoButtonExistsAndClickable() {
        window.button("LISTADO").requireVisible().click();
    }

    @Test
    public void testEditarButtonExistsAndClickable() {
        window.button("EDITAR").requireVisible().click();
    }

    @Test
    public void testBorrarButtonExistsAndClickable() {
        window.button("BORRAR").requireVisible().click();
    }
}

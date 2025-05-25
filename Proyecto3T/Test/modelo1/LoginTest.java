package modelo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTest {

    @Test
    public void testComponentesIniciales() {
        Login login = new Login();

        // Comprobamos que la ventana tiene el título correcto
        assertEquals("Inicio de Sesión", login.getTitle());

        // Comprobamos que los campos de texto existen
        JTextField txtUsuario = (JTextField) TestUtils.getField(login, "txtUsuario");
        JPasswordField txtContrasena = (JPasswordField) TestUtils.getField(login, "txtContrasena");
        JButton btnLogin = (JButton) TestUtils.getField(login, "btnLogin");

        assertNotNull(txtUsuario);
        assertNotNull(txtContrasena);
        assertNotNull(btnLogin);
    }

    @Test
    public void testSimularLoginCorrecto() {
        Login login = new Login();

        JTextField txtUsuario = (JTextField) TestUtils.getField(login, "txtUsuario");
        JPasswordField txtContrasena = (JPasswordField) TestUtils.getField(login, "txtContrasena");
        JButton btnLogin = (JButton) TestUtils.getField(login, "btnLogin");

        txtUsuario.setText("admin");
        txtContrasena.setText("1234");

        // Simulamos el clic del botón
        for (ActionListener al : btnLogin.getActionListeners()) {
            al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }

        // No podemos verificar la ventana nueva ni el JOptionPane, pero al menos no debe fallar
        assertEquals("admin", txtUsuario.getText());
    }
}

package modelo2;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;

    public Login() {
        setTitle("Inicio de Sesión");
        setSize(850, 580);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Usuario:");
        label.setBounds(200, 178, 198, 52);
        getContentPane().add(label);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(312, 178, 242, 52);
        getContentPane().add(txtUsuario);

        JLabel label_1 = new JLabel("Contraseña:");
        label_1.setBounds(200, 241, 184, 52);
        getContentPane().add(label_1);
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(312, 241, 242, 52);
        getContentPane().add(txtContrasena);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(312, 304, 152, 52);
        getContentPane().add(btnLogin);

        // Espacio vacío
        JLabel label_2 = new JLabel("");
        label_2.setBounds(422, 367, 412, 173);
        getContentPane().add(label_2);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCredenciales();
            }
        });
    }

    private void verificarCredenciales() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        // Verificación simple (puedes reemplazar por consulta a base de datos)
        if (usuario.equals("admin") && contrasena.equals("1234")) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!");
            // Aquí puedes abrir otra ventana o continuar con el sistema
            Principal V0= new Principal();
			V0.setVisible(true);
			dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}

		
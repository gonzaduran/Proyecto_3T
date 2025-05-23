package modelo1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;

    public Login() {
    	getContentPane().setBackground(new Color(100, 119, 168));
        setTitle("Inicio de Sesión");
        setSize(850, 580);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Usuario:");
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(new Color(255, 255, 255));
        label.setBounds(183, 178, 198, 52);
        getContentPane().add(label);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(325, 178, 242, 52);
        getContentPane().add(txtUsuario);

        JLabel label_1 = new JLabel("Contraseña:");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setFont(new Font("SansSerif", Font.BOLD, 18));
        label_1.setBounds(183, 244, 184, 52);
        getContentPane().add(label_1);
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(325, 244, 242, 52);
        getContentPane().add(txtContrasena);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setForeground(new Color(128, 128, 128));
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnLogin.setBounds(310, 331, 173, 52);
        getContentPane().add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("Inicio de Sesión");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblNewLabel.setBounds(281, 77, 358, 52);
        getContentPane().add(lblNewLabel);

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

		
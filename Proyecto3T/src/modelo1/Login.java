package modelo1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase Login que representa una ventana de inicio de sesión usando Swing.
 * 
 * Permite al usuario introducir su nombre de usuario y contraseña, y valida las credenciales
 * de manera básica. Si son correctas, abre la ventana principal del sistema.
 * 
 * @author  
 */
public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    // Componentes de la interfaz
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;

    /**
     * Constructor de la clase Login.
     * Inicializa y organiza los componentes gráficos de la ventana.
     */
    public Login() {
        // Configuración de la ventana
        getContentPane().setBackground(new Color(100, 119, 168));
        setTitle("Inicio de Sesión");
        setSize(850, 580);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Etiqueta "Usuario"
        JLabel label = new JLabel("Usuario:");
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setBounds(183, 178, 198, 52);
        getContentPane().add(label);

        // Campo de texto para el usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(325, 178, 242, 52);
        getContentPane().add(txtUsuario);

        // Etiqueta "Contraseña"
        JLabel label_1 = new JLabel("Contraseña:");
        label_1.setFont(new Font("SansSerif", Font.BOLD, 18));
        label_1.setForeground(Color.WHITE);
        label_1.setBounds(183, 244, 184, 52);
        getContentPane().add(label_1);

        // Campo de texto para la contraseña
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(325, 244, 242, 52);
        getContentPane().add(txtContrasena);

        // Botón de inicio de sesión
        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnLogin.setForeground(new Color(128, 128, 128));
        btnLogin.setBounds(310, 331, 173, 52);
        getContentPane().add(btnLogin);

        // Título principal
        JLabel lblNewLabel = new JLabel("Inicio de Sesión");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(281, 77, 358, 52);
        getContentPane().add(lblNewLabel);

        // Acción del botón
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCredenciales();
            }
        });
    }

    /**
     * Método que verifica las credenciales introducidas por el usuario.
     * Si el usuario es "admin" y la contraseña "1234", se muestra un mensaje de éxito
     * y se abre la ventana principal. En caso contrario, se muestra un mensaje de error.
     */
    private void verificarCredenciales() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        // Verificación simple (puedes reemplazar por consulta a base de datos)
        if (usuario.equals("admin") && contrasena.equals("1234")) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!");
            Principal V0 = new Principal();
            V0.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método principal que lanza la aplicación.
     * 
     * @param args Argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}


		
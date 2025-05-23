package modelo2;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import modelo2.ConexionMySQL;

public class EntrenadoresAlta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEspecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				EntrenadoresAlta frame = new EntrenadoresAlta();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EntrenadoresAlta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlta = new JLabel("DAR ALTA ENTRENADOR");
		lblAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlta.setBounds(100, 11, 250, 25);
		contentPane.add(lblAlta);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 60, 80, 14);
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(130, 57, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblApellido1 = new JLabel("Apellido 1");
		lblApellido1.setBounds(37, 95, 80, 14);
		contentPane.add(lblApellido1);

		textApellido1 = new JTextField();
		textApellido1.setBounds(130, 92, 150, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);

		JLabel lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setBounds(37, 130, 80, 14);
		contentPane.add(lblApellido2);

		textApellido2 = new JTextField();
		textApellido2.setBounds(130, 127, 150, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(37, 165, 80, 14);
		contentPane.add(lblEspecialidad);

		textEspecialidad = new JTextField();
		textEspecialidad.setBounds(130, 162, 150, 20);
		contentPane.add(textEspecialidad);
		textEspecialidad.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(290, 210, 100, 25);
		contentPane.add(btnGuardar);

		btnGuardar.addActionListener((ActionEvent e) -> {
			ConexionMySQL conexion = new ConexionMySQL("root", "", "club_deportivo");
			try {
				conexion.conectar();
				String sentencia = "INSERT INTO entrenadores (nombre, apellido_1, apellido_2, especialidad, estado) VALUES ('"
						+ textNombre.getText() + "','"
						+ textApellido1.getText() + "','"
						+ textApellido2.getText() + "','"
						+ textEspecialidad.getText() + "','Activo')";
				conexion.ejecutarInsertDeleteUpdate(sentencia);
				conexion.desconectar();
				JOptionPane.showMessageDialog(null, "Entrenador guardado correctamente.");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error al guardar: " + e1.getMessage());
				e1.printStackTrace();
			}
		});
	}
}

package modelo1;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlta = new JLabel("DAR ALTA ENTRENADOR");
		lblAlta.setForeground(new Color(255, 255, 255));
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlta.setBounds(300, 114, 297, 25);
		contentPane.add(lblAlta);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(282, 177, 80, 14);
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(400, 174, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblApellido1 = new JLabel("Primer apellido");
		lblApellido1.setForeground(new Color(255, 255, 255));
		lblApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido1.setBounds(282, 208, 108, 14);
		contentPane.add(lblApellido1);

		textApellido1 = new JTextField();
		textApellido1.setBounds(400, 205, 150, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);

		JLabel lblApellido2 = new JLabel("Segundo apellido");
		lblApellido2.setForeground(new Color(255, 255, 255));
		lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido2.setBounds(282, 239, 108, 14);
		contentPane.add(lblApellido2);

		textApellido2 = new JTextField();
		textApellido2.setBounds(400, 236, 150, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspecialidad.setForeground(new Color(255, 255, 255));
		lblEspecialidad.setBounds(282, 270, 80, 14);
		contentPane.add(lblEspecialidad);

		textEspecialidad = new JTextField();
		textEspecialidad.setBounds(400, 267, 150, 20);
		contentPane.add(textEspecialidad);
		textEspecialidad.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setForeground(new Color(128, 128, 128));
		btnGuardar.setBackground(new Color(192, 192, 192));
		btnGuardar.setBounds(346, 320, 100, 25);
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

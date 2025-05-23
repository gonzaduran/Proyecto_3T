package modelo1;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;
import java.awt.Color;
import java.awt.Font;

public class NuevaInstalacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// Datos de conexión
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				NuevaInstalacion frame = new NuevaInstalacion();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public NuevaInstalacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NUEVA INSTALACIÓN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(272, 94, 392, 69);
		contentPane.add(lblNewLabel);

		textField = new JTextField(); // Nombre
		textField.setBounds(374, 191, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // Tipo (lo usaremos como categoría o descripción)
		textField_1.setBounds(374, 239, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(284, 194, 100, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(284, 242, 100, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(348, 300, 114, 29);
		contentPane.add(btnNewButton);

		// Acción botón GUARDAR
		btnNewButton.addActionListener(e -> {
			String nombre = textField.getText();
			String tipo = textField_1.getText();
			int capacidad = 20; // valor fijo o puedes agregar un campo si quieres hacerlo editable
			String estado = "Libre";

			if (nombre.isEmpty() || tipo.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Rellena todos los campos.");
				return;
			}

			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("INSERT INTO zonas (nomZona, capacidad, estado) VALUES (?, ?, ?)")) {

				stmt.setString(1, nombre + " (" + tipo + ")");
				stmt.setInt(2, capacidad);
				stmt.setString(3, estado);

				stmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "Instalación guardada correctamente.");

				textField.setText("");
				textField_1.setText("");

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
			}
		});
	}
}

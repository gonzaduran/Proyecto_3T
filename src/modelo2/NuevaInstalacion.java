package modelo2;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo2.ConexionMySQL;

public class NuevaInstalacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// Datos de conexión
	private final String DB_URL = "jdbc:mysql://localhost:3306/club deportivo";
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NUEVA INSTALACIÓN");
		lblNewLabel.setBounds(152, 26, 200, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField(); // Nombre
		textField.setBounds(220, 75, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // Tipo (lo usaremos como categoría o descripción)
		textField_1.setBounds(220, 122, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(99, 78, 100, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TIPO");
		lblNewLabel_2.setBounds(99, 125, 100, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.setBounds(290, 203, 100, 23);
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

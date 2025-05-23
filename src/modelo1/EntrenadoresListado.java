package modelo1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;
import java.awt.Color;

public class EntrenadoresListado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldId;
	private JTextArea textArea;

	// Configuración de la base de datos
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				EntrenadoresListado frame = new EntrenadoresListado();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public EntrenadoresListado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscar = new JLabel("BUSCAR ENTRENADOR");
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBuscar.setBounds(266, 67, 312, 38);
		contentPane.add(lblBuscar);

		JLabel lblPorNombre = new JLabel("Por Nombre:");
		lblPorNombre.setForeground(new Color(255, 255, 255));
		lblPorNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPorNombre.setBounds(180, 133, 100, 14);
		contentPane.add(lblPorNombre);

		JLabel lblPorNumero = new JLabel("Por ID Entrenador:");
		lblPorNumero.setForeground(new Color(255, 255, 255));
		lblPorNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPorNumero.setBounds(180, 168, 136, 14);
		contentPane.add(lblPorNumero);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(312, 130, 186, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldId = new JTextField();
		textFieldId.setBounds(312, 165, 186, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnBuscarNombre = new JButton("BUSCAR");
		btnBuscarNombre.setForeground(new Color(128, 128, 128));
		btnBuscarNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscarNombre.setBounds(521, 129, 100, 23);
		contentPane.add(btnBuscarNombre);

		JButton btnBuscarId = new JButton("BUSCAR");
		btnBuscarId.setForeground(new Color(128, 128, 128));
		btnBuscarId.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscarId.setBounds(521, 164, 100, 23);
		contentPane.add(btnBuscarId);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(55, 213, 710, 224);
		contentPane.add(textArea);

		// Acción buscar por nombre
		btnBuscarNombre.addActionListener((ActionEvent e) -> buscarPorNombre());

		// Acción buscar por ID
		btnBuscarId.addActionListener((ActionEvent e) -> buscarPorId());
	}

	private void buscarPorNombre() {
		String nombre = textFieldNombre.getText();

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM entrenadores WHERE nombre = ?")) {

			stmt.setString(1, nombre);
			ResultSet rs = stmt.executeQuery();

			StringBuilder resultado = new StringBuilder();
			while (rs.next()) {
				resultado.append(String.format(
					"ID: %d\nNombre: %s %s %s\nEspecialidad: %s\nEstado: %s\n\n",
					rs.getInt("id_entrenador"),
					rs.getString("nombre"),
					rs.getString("apellido_1"),
					rs.getString("apellido_2"),
					rs.getString("especialidad"),
					rs.getString("estado")
				));
			}

			if (resultado.length() == 0) {
				textArea.setText("No se encontró ningún entrenador con ese nombre.");
			} else {
				textArea.setText(resultado.toString());
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
		}
	}

	private void buscarPorId() {
		String idTexto = textFieldId.getText();

		try {
			int idEntrenador = Integer.parseInt(idTexto);

			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM entrenadores WHERE id_entrenador = ?")) {

				stmt.setInt(1, idEntrenador);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					String resultado = String.format(
						"ID: %d\nNombre: %s %s %s\nEspecialidad: %s\nEstado: %s",
						rs.getInt("id_entrenador"),
						rs.getString("nombre"),
						rs.getString("apellido_1"),
						rs.getString("apellido_2"),
						rs.getString("especialidad"),
						rs.getString("estado")
					);
					textArea.setText(resultado);
				} else {
					textArea.setText("No se encontró ningún entrenador con ese ID.");
				}
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Introduce un número válido para el ID.");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
		}
	}
}

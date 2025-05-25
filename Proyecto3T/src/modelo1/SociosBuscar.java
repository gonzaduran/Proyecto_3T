package modelo1;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;
import java.awt.Color;

public class SociosBuscar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextArea textAreaResultado;

	// Configuración base de datos
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SociosBuscar frame = new SociosBuscar();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SociosBuscar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("BUSCAR SOCIO");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(293, 72, 258, 29);
		contentPane.add(lblTitulo);

		JLabel lblIdSocio = new JLabel("ID del Socio:");
		lblIdSocio.setForeground(new Color(255, 255, 255));
		lblIdSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdSocio.setBounds(141, 145, 100, 14);
		contentPane.add(lblIdSocio);

		textFieldId = new JTextField();
		textFieldId.setBounds(256, 142, 229, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(new Color(128, 128, 128));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(525, 141, 100, 23);
		contentPane.add(btnBuscar);

		textAreaResultado = new JTextArea();
		textAreaResultado.setEditable(false);
		textAreaResultado.setBounds(50, 197, 728, 245);
		contentPane.add(textAreaResultado);

		btnBuscar.addActionListener(e -> buscarSocio());
	}

	private void buscarSocio() {
		String idTexto = textFieldId.getText();

		try {
			int idSocio = Integer.parseInt(idTexto);

			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM socios WHERE id_socio = ?")) {

				stmt.setInt(1, idSocio);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					String resultado = String.format(
						"Nombre: %s\nApellido 1: %s\nApellido 2: %s\nEdad: %d\nEstado: %s\nInscripción: %s\nID Cuota: %d",
						rs.getString("nombre"),
						rs.getString("apellido_1"),
						rs.getString("apellido_2"),
						rs.getInt("edad"),
						rs.getString("estado"),
						rs.getString("inscripcion"),
						rs.getInt("id_cuota")
					);
					textAreaResultado.setText(resultado);
				} else {
					textAreaResultado.setText("No se encontró ningún socio con ese ID.");
				}
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido para el ID.");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
		}
	}
}

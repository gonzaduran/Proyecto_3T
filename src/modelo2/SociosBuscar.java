package modelo2;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo2.ConexionMySQL;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("BUSCAR SOCIO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(170, 20, 200, 22);
		contentPane.add(lblTitulo);

		JLabel lblIdSocio = new JLabel("ID del Socio:");
		lblIdSocio.setBounds(50, 70, 100, 14);
		contentPane.add(lblIdSocio);

		textFieldId = new JTextField();
		textFieldId.setBounds(150, 67, 100, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(270, 65, 100, 23);
		contentPane.add(btnBuscar);

		textAreaResultado = new JTextArea();
		textAreaResultado.setEditable(false);
		textAreaResultado.setBounds(50, 110, 380, 170);
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

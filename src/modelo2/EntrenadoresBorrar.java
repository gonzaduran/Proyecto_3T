package modelo2;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo2.ConexionMySQL;

public class EntrenadoresBorrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEntrenador;

	private final String DB_URL = "jdbc:mysql://localhost:3306/club deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				EntrenadoresBorrar frame = new EntrenadoresBorrar();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public EntrenadoresBorrar() {
		setTitle("Baja de Entrenadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("BAJA DE ENTRENADORES");
		lblTitulo.setBounds(110, 10, 250, 30);
		contentPane.add(lblTitulo);

		JLabel lblId = new JLabel("ID Entrenador:");
		lblId.setBounds(40, 60, 100, 20);
		contentPane.add(lblId);

		txtIdEntrenador = new JTextField();
		txtIdEntrenador.setBounds(150, 60, 200, 20);
		contentPane.add(txtIdEntrenador);
		txtIdEntrenador.setColumns(10);

		JButton btnBajaTemporal = new JButton("Baja Temporal");
		btnBajaTemporal.setBounds(40, 110, 140, 25);
		contentPane.add(btnBajaTemporal);

		JButton btnBajaDefinitiva = new JButton("Baja Definitiva");
		btnBajaDefinitiva.setBounds(200, 110, 140, 25);
		contentPane.add(btnBajaDefinitiva);

		// --- Baja Temporal ---
		btnBajaTemporal.addActionListener(e -> {
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("UPDATE entrenadores SET estado = 'inactivo' WHERE id_entrenador = ?")) {

				int id = Integer.parseInt(txtIdEntrenador.getText());
				stmt.setInt(1, id);

				int affected = stmt.executeUpdate();
				if (affected > 0) {
					JOptionPane.showMessageDialog(this, "Entrenador dado de baja temporal correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "No se encontró el entrenador.");
				}

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
			}
		});

		// --- Baja Definitiva (bloqueada por trigger) ---
		btnBajaDefinitiva.addActionListener(e -> {
			JOptionPane.showMessageDialog(this,
				"No se permite eliminar entrenadores.\nUsa 'Baja Temporal' (estado = inactivo).",
				"Operación no permitida", JOptionPane.WARNING_MESSAGE);
		});
	}
}

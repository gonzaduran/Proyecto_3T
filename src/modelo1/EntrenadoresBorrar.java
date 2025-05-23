package modelo1;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;
import java.awt.Color;
import java.awt.Font;

public class EntrenadoresBorrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEntrenador;

	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("BAJA DE ENTRENADORES");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(241, 143, 419, 35);
		contentPane.add(lblTitulo);

		JLabel lblId = new JLabel("ID Entrenador:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(241, 218, 100, 20);
		contentPane.add(lblId);

		txtIdEntrenador = new JTextField();
		txtIdEntrenador.setBounds(342, 218, 200, 20);
		contentPane.add(txtIdEntrenador);
		txtIdEntrenador.setColumns(10);

		JButton btnBajaTemporal = new JButton("Baja Temporal");
		btnBajaTemporal.setForeground(new Color(128, 128, 128));
		btnBajaTemporal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBajaTemporal.setBounds(210, 276, 170, 35);
		contentPane.add(btnBajaTemporal);

		JButton btnBajaDefinitiva = new JButton("Baja Definitiva");
		btnBajaDefinitiva.setForeground(new Color(128, 128, 128));
		btnBajaDefinitiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBajaDefinitiva.setBounds(418, 276, 170, 35);
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

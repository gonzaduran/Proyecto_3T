package modelo1;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;
import java.awt.Color;
import java.awt.Font;

public class SociosBajas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdSocio;
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SociosBajas frame = new SociosBajas();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SociosBajas() {
		setTitle("Baja de Socios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("BAJA DE SOCIOS");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(100, 32, 200, 30);
		contentPane.add(lblTitulo);

		JLabel lblId = new JLabel("ID Socio:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(50, 73, 80, 20);
		contentPane.add(lblId);

		txtIdSocio = new JTextField();
		txtIdSocio.setBounds(140, 73, 200, 20);
		contentPane.add(txtIdSocio);
		txtIdSocio.setColumns(10);

		JButton btnBajaTemporal = new JButton("Baja Temporal");
		btnBajaTemporal.setForeground(new Color(128, 128, 128));
		btnBajaTemporal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBajaTemporal.setBounds(50, 121, 140, 25);
		contentPane.add(btnBajaTemporal);

		JButton btnBajaDefinitiva = new JButton("Baja Definitiva");
		btnBajaDefinitiva.setForeground(new Color(128, 128, 128));
		btnBajaDefinitiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBajaDefinitiva.setBounds(200, 121, 140, 25);
		contentPane.add(btnBajaDefinitiva);

		// Acción baja temporal
		btnBajaTemporal.addActionListener(e -> {
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("UPDATE socios SET estado = 'inactivo' WHERE id_socio = ?")) {

				int id = Integer.parseInt(txtIdSocio.getText());
				stmt.setInt(1, id);

				int affected = stmt.executeUpdate();
				if (affected > 0) {
					JOptionPane.showMessageDialog(this, "Socio dado de baja temporal correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "No se encontró el socio.");
				}

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
			}
		});

		// Acción baja definitiva
		btnBajaDefinitiva.addActionListener(e -> {
			int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar permanentemente este socio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					 PreparedStatement stmt = conn.prepareStatement("DELETE FROM socios WHERE id_socio = ?")) {

					int id = Integer.parseInt(txtIdSocio.getText());
					stmt.setInt(1, id);

					int affected = stmt.executeUpdate();
					if (affected > 0) {
						JOptionPane.showMessageDialog(this, "Socio eliminado permanentemente.");
					} else {
						JOptionPane.showMessageDialog(this, "No se encontró el socio.");
					}

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
				}
			}
		});
	}
}

package modelo2;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo2.ConexionMySQL;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("BAJA DE SOCIOS");
		lblTitulo.setBounds(140, 10, 200, 30);
		contentPane.add(lblTitulo);

		JLabel lblId = new JLabel("ID Socio:");
		lblId.setBounds(40, 60, 80, 20);
		contentPane.add(lblId);

		txtIdSocio = new JTextField();
		txtIdSocio.setBounds(120, 60, 200, 20);
		contentPane.add(txtIdSocio);
		txtIdSocio.setColumns(10);

		JButton btnBajaTemporal = new JButton("Baja Temporal");
		btnBajaTemporal.setBounds(40, 110, 140, 25);
		contentPane.add(btnBajaTemporal);

		JButton btnBajaDefinitiva = new JButton("Baja Definitiva");
		btnBajaDefinitiva.setBounds(200, 110, 140, 25);
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

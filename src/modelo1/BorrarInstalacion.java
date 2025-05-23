package modelo1;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class BorrarInstalacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// Configuración base de datos
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				BorrarInstalacion frame = new BorrarInstalacion();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public BorrarInstalacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBAJAS = new JLabel("BORRAR INSTALACIÓN");
		lblBAJAS.setForeground(new Color(255, 255, 255));
		lblBAJAS.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBAJAS.setBounds(265, 109, 433, 43);
		contentPane.add(lblBAJAS);

		JLabel lblNumero = new JLabel("NÚMERO INSTALACIÓN:");
		lblNumero.setForeground(new Color(255, 255, 255));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(182, 183, 200, 14);
		contentPane.add(lblNumero);

		JLabel lblEliminarTemporalmente = new JLabel("BAJA TEMPORAL");
		lblEliminarTemporalmente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarTemporalmente.setForeground(new Color(255, 255, 255));
		lblEliminarTemporalmente.setBounds(182, 231, 140, 14);
		contentPane.add(lblEliminarTemporalmente);

		JLabel lblEliminarDefinitivamente = new JLabel("BAJA DEFINITIVA");
		lblEliminarDefinitivamente.setForeground(new Color(255, 255, 255));
		lblEliminarDefinitivamente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarDefinitivamente.setBounds(182, 279, 140, 14);
		contentPane.add(lblEliminarDefinitivamente);

		textField = new JTextField(); // Baja temporal
		textField.setBounds(313, 228, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // Baja definitiva
		textField_1.setBounds(313, 276, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnBorrarTemporal = new JButton("BORRAR");
		btnBorrarTemporal.setForeground(new Color(128, 128, 128));
		btnBorrarTemporal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarTemporal.setBounds(529, 227, 100, 23);
		contentPane.add(btnBorrarTemporal);

		JButton btnBorrarDefinitiva = new JButton("BORRAR");
		btnBorrarDefinitiva.setForeground(new Color(128, 128, 128));
		btnBorrarDefinitiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarDefinitiva.setBounds(529, 275, 100, 23);
		contentPane.add(btnBorrarDefinitiva);

		// Acción baja temporal
		btnBorrarTemporal.addActionListener(e -> {
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("UPDATE zonas SET estado = 'Inactiva' WHERE idZona = ?")) {

				int idZona = Integer.parseInt(textField.getText());
				stmt.setInt(1, idZona);
				int result = stmt.executeUpdate();

				if (result > 0) {
					JOptionPane.showMessageDialog(this, "Instalación dada de baja temporal correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "No se encontró la instalación.");
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
			}
		});

		// Acción baja definitiva
		btnBorrarDefinitiva.addActionListener(e -> {
			int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar esta instalación permanentemente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					 PreparedStatement stmt = conn.prepareStatement("DELETE FROM zonas WHERE idZona = ?")) {

					int idZona = Integer.parseInt(textField_1.getText());
					stmt.setInt(1, idZona);
					int result = stmt.executeUpdate();

					if (result > 0) {
						JOptionPane.showMessageDialog(this, "Instalación eliminada correctamente.");
					} else {
						JOptionPane.showMessageDialog(this, "No se encontró la instalación.");
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(this, "Error SQL: " + ex.getMessage());
				}
			}
		});
	}
}

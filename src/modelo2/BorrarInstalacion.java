package modelo2;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo2.ConexionMySQL;

public class BorrarInstalacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// Configuración base de datos
	private final String DB_URL = "jdbc:mysql://localhost:3306/club deportivo";
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBAJAS = new JLabel("BORRAR INSTALACIÓN");
		lblBAJAS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBAJAS.setBounds(130, 20, 246, 22);
		contentPane.add(lblBAJAS);

		JLabel lblNumero = new JLabel("NÚMERO INSTALACIÓN:");
		lblNumero.setBounds(140, 60, 200, 14);
		contentPane.add(lblNumero);

		JLabel lblEliminarTemporalmente = new JLabel("BAJA TEMPORAL");
		lblEliminarTemporalmente.setBounds(30, 110, 140, 14);
		contentPane.add(lblEliminarTemporalmente);

		JLabel lblEliminarDefinitivamente = new JLabel("BAJA DEFINITIVA");
		lblEliminarDefinitivamente.setBounds(30, 160, 140, 14);
		contentPane.add(lblEliminarDefinitivamente);

		textField = new JTextField(); // Baja temporal
		textField.setBounds(180, 107, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // Baja definitiva
		textField_1.setBounds(180, 157, 100, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnBorrarTemporal = new JButton("BORRAR");
		btnBorrarTemporal.setBounds(300, 106, 100, 23);
		contentPane.add(btnBorrarTemporal);

		JButton btnBorrarDefinitiva = new JButton("BORRAR");
		btnBorrarDefinitiva.setBounds(300, 156, 100, 23);
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

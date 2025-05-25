package modelo1;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/**
 * Clase que proporciona una interfaz gráfica para gestionar la eliminación
 * (temporal o definitiva) de instalaciones del sistema.
 * 
 * Esta ventana permite al usuario introducir el número de una instalación
 * para realizar una baja temporal (marcarla como "Inactiva") o una baja
 * definitiva (eliminarla de la base de datos).
 * 
 * Conecta con una base de datos MySQL para realizar las operaciones.
 * 
 * @author 
 */
public class BorrarInstalacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// Configuración base de datos
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	/**
	 * Método principal. Inicia la aplicación y muestra la ventana.
	 * 
	 * @param args Argumentos de línea de comandos (no se utilizan).
	 */
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

	/**
	 * Constructor de la clase BorrarInstalacion.
	 * Configura la interfaz gráfica y los eventos asociados a los botones.
	 */
	public BorrarInstalacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta de título
		JLabel lblBAJAS = new JLabel("BORRAR INSTALACIÓN");
		lblBAJAS.setForeground(new Color(255, 255, 255));
		lblBAJAS.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBAJAS.setBounds(265, 109, 433, 43);
		contentPane.add(lblBAJAS);

		// Etiqueta del número de instalación
		JLabel lblNumero = new JLabel("NÚMERO INSTALACIÓN:");
		lblNumero.setForeground(new Color(255, 255, 255));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(182, 183, 200, 14);
		contentPane.add(lblNumero);

		// Etiqueta para baja temporal
		JLabel lblEliminarTemporalmente = new JLabel("BAJA TEMPORAL");
		lblEliminarTemporalmente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarTemporalmente.setForeground(new Color(255, 255, 255));
		lblEliminarTemporalmente.setBounds(182, 231, 140, 14);
		contentPane.add(lblEliminarTemporalmente);

		// Etiqueta para baja definitiva
		JLabel lblEliminarDefinitivamente = new JLabel("BAJA DEFINITIVA");
		lblEliminarDefinitivamente.setForeground(new Color(255, 255, 255));
		lblEliminarDefinitivamente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarDefinitivamente.setBounds(182, 279, 140, 14);
		contentPane.add(lblEliminarDefinitivamente);

		// Campo de texto para baja temporal
		textField = new JTextField(); // Baja temporal
		textField.setBounds(313, 228, 192, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		// Campo de texto para baja definitiva
		textField_1 = new JTextField(); // Baja definitiva
		textField_1.setBounds(313, 276, 192, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		// Botón para ejecutar baja temporal
		JButton btnBorrarTemporal = new JButton("BORRAR");
		btnBorrarTemporal.setForeground(new Color(128, 128, 128));
		btnBorrarTemporal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarTemporal.setBounds(529, 227, 100, 23);
		contentPane.add(btnBorrarTemporal);

		// Botón para ejecutar baja definitiva
		JButton btnBorrarDefinitiva = new JButton("BORRAR");
		btnBorrarDefinitiva.setForeground(new Color(128, 128, 128));
		btnBorrarDefinitiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarDefinitiva.setBounds(529, 275, 100, 23);
		contentPane.add(btnBorrarDefinitiva);

		/**
		 * Acción asociada al botón de baja temporal.
		 * Cambia el estado de la instalación a 'Inactiva' en la base de datos.
		 */
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

		/**
		 * Acción asociada al botón de baja definitiva.
		 * Elimina la instalación de la base de datos tras confirmación.
		 */
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

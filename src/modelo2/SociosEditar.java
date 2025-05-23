package modelo2;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo2.ConexionMySQL;

public class SociosEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEDITAR, textField, textField_1, textField_2, textField_3;

	// Cambia por los valores de tu base de datos
	private final String DB_URL = "jdbc:mysql://localhost:3306/club deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SociosEditar frame = new SociosEditar();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SociosEditar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEDITAR = new JLabel("EDITAR");
		lblEDITAR.setBounds(194, 10, 46, 14);
		contentPane.add(lblEDITAR);

		textEDITAR = new JTextField();
		textEDITAR.setBounds(194, 56, 86, 20);
		contentPane.add(textEDITAR);
		textEDITAR.setColumns(10);

		JButton btnEDITAR = new JButton("BUSCAR");
		btnEDITAR.setBounds(317, 55, 89, 23);
		contentPane.add(btnEDITAR);

		JLabel lblINTRODUCIRNÚMERO = new JLabel("Introduzca número de socio");
		lblINTRODUCIRNÚMERO.setBounds(21, 59, 193, 14);
		contentPane.add(lblINTRODUCIRNÚMERO);

		textField_3 = new JTextField(); // Nombre
		textField_3.setBounds(122, 114, 118, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField = new JTextField(); // Apellido 1
		textField.setBounds(122, 142, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // Apellido 2
		textField_1.setBounds(122, 169, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField(); // Edad
		textField_2.setBounds(122, 200, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnGUARDARCAMBIOS = new JButton("GUARDAR CAMBIOS");
		btnGUARDARCAMBIOS.setBounds(278, 227, 131, 23);
		contentPane.add(btnGUARDARCAMBIOS);

		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(43, 117, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("APELLIDO 1");
		lblNewLabel_1.setBounds(43, 144, 86, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("APELLIDO 2");
		lblNewLabel_2.setBounds(43, 172, 75, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setBounds(43, 203, 46, 14);
		contentPane.add(lblNewLabel_3);

		// --- Acción BUSCAR ---
		btnEDITAR.addActionListener(e -> {
			String idSocio = textEDITAR.getText();
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM socios WHERE id_socio = ?")) {

				stmt.setInt(1, Integer.parseInt(idSocio));
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					textField_3.setText(rs.getString("nombre"));
					textField.setText(rs.getString("apellido_1"));
					textField_1.setText(rs.getString("apellido_2"));
					textField_2.setText(String.valueOf(rs.getInt("edad")));
				} else {
					JOptionPane.showMessageDialog(this, "Socio no encontrado");
				}

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al buscar socio: " + ex.getMessage());
			}
		});

		// --- Acción GUARDAR CAMBIOS ---
		btnGUARDARCAMBIOS.addActionListener(e -> {
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement(
						 "UPDATE socios SET nombre = ?, apellido_1 = ?, apellido_2 = ?, edad = ? WHERE id_socio = ?")) {

				stmt.setString(1, textField_3.getText());
				stmt.setString(2, textField.getText());
				stmt.setString(3, textField_1.getText());
				stmt.setInt(4, Integer.parseInt(textField_2.getText()));
				stmt.setInt(5, Integer.parseInt(textEDITAR.getText()));

				int rows = stmt.executeUpdate();
				if (rows > 0) {
					JOptionPane.showMessageDialog(this, "Socio actualizado correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "No se actualizó ningún socio.");
				}

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al guardar cambios: " + ex.getMessage());
			}
		});
	}
}

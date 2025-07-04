package modelo1;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;
import java.awt.Color;
import java.awt.Font;

public class EntrenadoresEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEntrenador, txtNombre, txtApellido1, txtApellido2, txtEspecialidad;

	// Cambia esto según tu configuración
	private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
	private final String USER = "root";
	private final String PASS = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				EntrenadoresEditar frame = new EntrenadoresEditar();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public EntrenadoresEditar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEDITAR = new JLabel("EDITAR ENTRENADOR");
		lblEDITAR.setForeground(new Color(255, 255, 255));
		lblEDITAR.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEDITAR.setBounds(277, 66, 314, 35);
		contentPane.add(lblEDITAR);

		JLabel lblIntro = new JLabel("Introduzca ID entrenador:");
		lblIntro.setForeground(new Color(255, 255, 255));
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntro.setBounds(190, 128, 180, 14);
		contentPane.add(lblIntro);

		txtIdEntrenador = new JTextField();
		txtIdEntrenador.setBounds(376, 125, 86, 20);
		contentPane.add(txtIdEntrenador);
		txtIdEntrenador.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(472, 124, 100, 23);
		contentPane.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(217, 183, 86, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido1 = new JLabel("Primer apellido");
		lblApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido1.setForeground(new Color(255, 255, 255));
		lblApellido1.setBounds(217, 214, 124, 14);
		contentPane.add(lblApellido1);

		JLabel lblApellido2 = new JLabel("Segundo apellido");
		lblApellido2.setForeground(new Color(255, 255, 255));
		lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido2.setBounds(217, 245, 124, 14);
		contentPane.add(lblApellido2);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setForeground(new Color(255, 255, 255));
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspecialidad.setBounds(217, 276, 100, 14);
		contentPane.add(lblEspecialidad);

		txtNombre = new JTextField();
		txtNombre.setBounds(351, 180, 200, 20);
		contentPane.add(txtNombre);

		txtApellido1 = new JTextField();
		txtApellido1.setBounds(351, 211, 200, 20);
		contentPane.add(txtApellido1);

		txtApellido2 = new JTextField();
		txtApellido2.setBounds(351, 242, 200, 20);
		contentPane.add(txtApellido2);

		txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(351, 273, 200, 20);
		contentPane.add(txtEspecialidad);

		JButton btnGuardar = new JButton("GUARDAR CAMBIOS");
		btnGuardar.setForeground(new Color(128, 128, 128));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(310, 327, 160, 25);
		contentPane.add(btnGuardar);

		// --- Acción BUSCAR ---
		btnBuscar.addActionListener(e -> {
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM entrenadores WHERE id_entrenador = ?")) {

				stmt.setInt(1, Integer.parseInt(txtIdEntrenador.getText()));
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					txtNombre.setText(rs.getString("nombre"));
					txtApellido1.setText(rs.getString("apellido_1"));
					txtApellido2.setText(rs.getString("apellido_2"));
					txtEspecialidad.setText(rs.getString("especialidad"));
				} else {
					JOptionPane.showMessageDialog(this, "Entrenador no encontrado.");
				}

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al buscar: " + ex.getMessage());
			}
		});

		// --- Acción GUARDAR CAMBIOS ---
		btnGuardar.addActionListener(e -> {
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				 PreparedStatement stmt = conn.prepareStatement(
						 "UPDATE entrenadores SET nombre=?, apellido_1=?, apellido_2=?, especialidad=? WHERE id_entrenador=?")) {

				stmt.setString(1, txtNombre.getText());
				stmt.setString(2, txtApellido1.getText());
				stmt.setString(3, txtApellido2.getText());
				stmt.setString(4, txtEspecialidad.getText());
				stmt.setInt(5, Integer.parseInt(txtIdEntrenador.getText()));

				int updated = stmt.executeUpdate();
				if (updated > 0) {
					JOptionPane.showMessageDialog(this, "Entrenador actualizado correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "No se encontró el entrenador.");
				}

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
			}
		});
	}
}

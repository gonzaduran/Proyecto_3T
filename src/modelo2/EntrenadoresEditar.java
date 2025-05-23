package modelo2;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import modelo2.ConexionMySQL;
import javax.swing.border.EmptyBorder;

public class EntrenadoresEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEntrenador, txtNombre, txtApellido1, txtApellido2, txtEspecialidad;

	// Cambia esto según tu configuración
	private final String DB_URL = "jdbc:mysql://localhost:3306/club deportivo";
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEDITAR = new JLabel("EDITAR ENTRENADOR");
		lblEDITAR.setBounds(170, 10, 200, 20);
		contentPane.add(lblEDITAR);

		JLabel lblIntro = new JLabel("Introduzca ID entrenador:");
		lblIntro.setBounds(20, 50, 180, 14);
		contentPane.add(lblIntro);

		txtIdEntrenador = new JTextField();
		txtIdEntrenador.setBounds(200, 47, 86, 20);
		contentPane.add(txtIdEntrenador);
		txtIdEntrenador.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(310, 46, 100, 23);
		contentPane.add(btnBuscar);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(43, 90, 86, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido1 = new JLabel("APELLIDO 1");
		lblApellido1.setBounds(43, 120, 86, 14);
		contentPane.add(lblApellido1);

		JLabel lblApellido2 = new JLabel("APELLIDO 2");
		lblApellido2.setBounds(43, 150, 86, 14);
		contentPane.add(lblApellido2);

		JLabel lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setBounds(43, 180, 100, 14);
		contentPane.add(lblEspecialidad);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 87, 200, 20);
		contentPane.add(txtNombre);

		txtApellido1 = new JTextField();
		txtApellido1.setBounds(150, 117, 200, 20);
		contentPane.add(txtApellido1);

		txtApellido2 = new JTextField();
		txtApellido2.setBounds(150, 147, 200, 20);
		contentPane.add(txtApellido2);

		txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(150, 177, 200, 20);
		contentPane.add(txtEspecialidad);

		JButton btnGuardar = new JButton("GUARDAR CAMBIOS");
		btnGuardar.setBounds(150, 220, 160, 25);
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

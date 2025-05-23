package modelo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo1.ConexionMySQL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SociosAlta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SociosAlta frame = new SociosAlta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SociosAlta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNombre = new JTextField();
		textNombre.setBounds(420, 170, 113, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel Nombre = new JLabel("Nombre");
		Nombre.setForeground(new Color(255, 255, 255));
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		Nombre.setBounds(305, 173, 46, 14);
		contentPane.add(Nombre);

		JLabel lblApellido1 = new JLabel("Primer apellido");
		lblApellido1.setForeground(new Color(255, 255, 255));
		lblApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido1.setBounds(305, 204, 104, 14);
		contentPane.add(lblApellido1);

		textApellido1 = new JTextField();
		textApellido1.setBounds(420, 201, 113, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);

		JLabel lblAlta = new JLabel("ALTAS");
		lblAlta.setForeground(new Color(255, 255, 255));
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAlta.setBounds(369, 101, 139, 29);
		contentPane.add(lblAlta);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(128, 128, 128));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConexionMySQL conexion = new ConexionMySQL("root", "", "club_deportivo");
				try {
					conexion.conectar();
					String sentencia = "INSERT INTO `socios`(`nombre`, `edad`, `apellido_1`, `apellido_2`) VALUES ('"
							+ textNombre.getText() + "','" + textEdad.getText() + "','" + textApellido1.getText()
							+ "','" + textApellido2.getText() + "')";
					conexion.ejecutarInsertDeleteUpdate(sentencia); 
					conexion.desconectar();
					JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnGuardar.setBounds(369, 322, 89, 23);
		contentPane.add(btnGuardar);

		textApellido2 = new JTextField();
		textApellido2.setBounds(420, 232, 113, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);

		JLabel lblApellido2 = new JLabel("Segundo apellido");
		lblApellido2.setForeground(new Color(255, 255, 255));
		lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido2.setBounds(305, 235, 104, 14);
		contentPane.add(lblApellido2);

		textEdad = new JTextField();
		textEdad.setBounds(420, 263, 113, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEdad.setBounds(305, 266, 46, 14);
		contentPane.add(lblEdad);
	}
}

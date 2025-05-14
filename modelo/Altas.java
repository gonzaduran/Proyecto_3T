package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Altas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textTeléfono;
	private JTextField textApellido2;
	private JTextField textEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Altas frame = new Altas();
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
	public Altas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(109, 60, 113, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setBounds(37, 63, 46, 14);
		contentPane.add(Nombre);
		
		JLabel lblApellido1 = new JLabel("Apellido 1");
		lblApellido1.setBounds(37, 100, 46, 14);
		contentPane.add(lblApellido1);
		
		textApellido1 = new JTextField();
		textApellido1.setBounds(109, 97, 113, 20);
		contentPane.add(textApellido1);
		textApellido1.setColumns(10);
		
		JLabel lblAlta = new JLabel("DAR ALTA");
		lblAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlta.setBounds(159, 11, 90, 20);
		contentPane.add(lblAlta);
		
		JLabel lblTeléfono = new JLabel("Teléfono");
		lblTeléfono.setBounds(37, 172, 46, 14);
		contentPane.add(lblTeléfono);
		
		textTeléfono = new JTextField();
		textTeléfono.setBounds(109, 169, 113, 20);
		contentPane.add(textTeléfono);
		textTeléfono.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(293, 212, 89, 23);
		contentPane.add(btnGuardar);
		
		textApellido2 = new JTextField();
		textApellido2.setBounds(109, 138, 113, 20);
		contentPane.add(textApellido2);
		textApellido2.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setBounds(37, 141, 46, 14);
		contentPane.add(lblApellido2);
		
		textEdad = new JTextField();
		textEdad.setBounds(109, 199, 113, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(37, 202, 46, 14);
		contentPane.add(lblEdad);
	}
}

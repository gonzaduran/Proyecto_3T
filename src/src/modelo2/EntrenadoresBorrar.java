package modelo2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EntrenadoresBorrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntrenadoresBorrar frame = new EntrenadoresBorrar();
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
	public EntrenadoresBorrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBAJAS = new JLabel("BAJAS");
		lblBAJAS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBAJAS.setBounds(178, 25, 79, 14);
		contentPane.add(lblBAJAS);
	
		JButton btnBorrarT = new JButton("BORRAR");
		btnBorrarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarT.setBounds(302, 110, 89, 23);
		contentPane.add(btnBorrarT);
		
		JButton btnBorrarD = new JButton("BORRAR");
		btnBorrarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarD.setBounds(302, 157, 89, 23);
		contentPane.add(btnBorrarD);
		
		JLabel lblNúmeroSocio = new JLabel("NÚMERO ENTRENADOR");
		lblNúmeroSocio.setBounds(174, 74, 121, 14);
		contentPane.add(lblNúmeroSocio);
		
		JLabel lblEliminarTemporalmente = new JLabel("ELIMINAR TEMPORALMENTE");
		lblEliminarTemporalmente.setBounds(10, 114, 147, 14);
		contentPane.add(lblEliminarTemporalmente);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setBounds(54, 161, 79, 14);
		contentPane.add(lblEliminar);
		
		textField = new JTextField();
		textField.setBounds(178, 111, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 158, 104, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}

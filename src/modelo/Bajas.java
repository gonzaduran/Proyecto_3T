package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bajas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTemporal;
	private JTextField textFieldDefinitivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bajas frame = new Bajas();
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
	public Bajas() {
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
		
		textFieldTemporal = new JTextField();
		textFieldTemporal.setBounds(160, 79, 86, 20);
		contentPane.add(textFieldTemporal);
		textFieldTemporal.setColumns(10);
		
		textFieldDefinitivo = new JTextField();
		textFieldDefinitivo.setBounds(160, 131, 86, 20);
		contentPane.add(textFieldDefinitivo);
		textFieldDefinitivo.setColumns(10);
		
		JButton btnBorrarT = new JButton("Borrar");
		btnBorrarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarT.setBounds(302, 78, 89, 23);
		contentPane.add(btnBorrarT);
		
		JButton btnBorrarD = new JButton("Borrar");
		btnBorrarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarD.setBounds(302, 130, 89, 23);
		contentPane.add(btnBorrarD);
		
		JLabel lblNúmeroSocio = new JLabel("Número Socio");
		lblNúmeroSocio.setBounds(168, 54, 89, 14);
		contentPane.add(lblNúmeroSocio);
		
		JLabel lblEliminarTemporalmente = new JLabel("Eliminar temporalmente");
		lblEliminarTemporalmente.setBounds(27, 82, 133, 14);
		contentPane.add(lblEliminarTemporalmente);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(62, 134, 46, 14);
		contentPane.add(lblEliminar);
	}
}

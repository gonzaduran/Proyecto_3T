package modelo2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class EntrenadoresEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SociosEditar frame = new SociosEditar();
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
	public EntrenadoresEditar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEDITAR = new JLabel("EDITAR");
		lblEDITAR.setBounds(194, 10, 46, 14);
		contentPane.add(lblEDITAR);
		
		
		JButton btnEDITAR = new JButton("BUSCAR");
		btnEDITAR.setBounds(317, 55, 89, 23);
		contentPane.add(btnEDITAR);
		
		JLabel lblINTRODUCIRNÚMERO = new JLabel("Introduzca número de entrenador");
		lblINTRODUCIRNÚMERO.setBounds(21, 59, 163, 14);
		contentPane.add(lblINTRODUCIRNÚMERO);
		
	
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
		
		textField = new JTextField();
		textField.setBounds(221, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 114, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 144, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 172, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(139, 200, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}

}

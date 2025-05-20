package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SociosEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEDITAR;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setBounds(122, 142, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 169, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 200, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 114, 118, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
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
	}

}

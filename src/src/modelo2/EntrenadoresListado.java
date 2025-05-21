package modelo2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EntrenadoresListado extends JFrame {

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
					SociosBuscar frame = new SociosBuscar();
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
	public EntrenadoresListado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBUSCAR = new JLabel("BUSCAR");
		lblBUSCAR.setBounds(190, 21, 46, 14);
		contentPane.add(lblBUSCAR);
		
		
		JLabel lblNÚMEROSOCIO = new JLabel("POR NÚMERO DE ENTRENADOR");
		lblNÚMEROSOCIO.setBounds(40, 97, 151, 14);
		contentPane.add(lblNÚMEROSOCIO);
		
		JLabel lblNOMBRE = new JLabel("POR NOMBRE");
		lblNOMBRE.setBounds(40, 66, 131, 14);
		contentPane.add(lblNOMBRE);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(51, 138, 285, 98);
		contentPane.add(textArea);
		
		JButton btnBUSCARNOMBRE = new JButton("BUSCAR");
		btnBUSCARNOMBRE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBUSCARNOMBRE.setBounds(308, 62, 89, 23);
		contentPane.add(btnBUSCARNOMBRE);
		
		JButton btnBUSCARNÚMERO = new JButton("BUSCAR");
		btnBUSCARNÚMERO.setBounds(308, 93, 89, 23);
		contentPane.add(btnBUSCARNÚMERO);
		
		textField = new JTextField();
		textField.setBounds(212, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 94, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}}
		
package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Buscar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNÚMERO;
	private JTextField textNOMBRE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBUSCAR = new JLabel("BUSCAR");
		lblBUSCAR.setBounds(194, 10, 46, 14);
		contentPane.add(lblBUSCAR);
		
		textNÚMERO = new JTextField();
		textNÚMERO.setBounds(212, 94, 86, 20);
		contentPane.add(textNÚMERO);
		textNÚMERO.setColumns(10);
		
		textNOMBRE = new JTextField();
		textNOMBRE.setBounds(212, 63, 86, 20);
		contentPane.add(textNOMBRE);
		textNOMBRE.setColumns(10);
		
		JLabel lblNÚMEROSOCIO = new JLabel("POR NÚMERO DE SOCIO");
		lblNÚMEROSOCIO.setBounds(51, 97, 119, 14);
		contentPane.add(lblNÚMEROSOCIO);
		
		JLabel lblNOMBRE = new JLabel("POR NOMBRE");
		lblNOMBRE.setBounds(51, 66, 131, 14);
		contentPane.add(lblNOMBRE);
		
		JButton btnBUSCARNOMBRE = new JButton("BUSCAR");
		btnBUSCARNOMBRE.setBounds(318, 62, 89, 23);
		contentPane.add(btnBUSCARNOMBRE);
		
		JButton btnBUSCARNÚMERO = new JButton("BUSCAR");
		btnBUSCARNÚMERO.setBounds(318, 93, 89, 23);
		contentPane.add(btnBUSCARNÚMERO);
	}
}

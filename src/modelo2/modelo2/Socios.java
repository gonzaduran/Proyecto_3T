package modelo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Socios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Socios frame = new Socios();
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
	public Socios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSOCIOS = new JLabel("SOCIOS");
		lblSOCIOS.setBounds(197, 10, 39, 14);
		contentPane.add(lblSOCIOS);
		
		JButton btnALTAS = new JButton("ALTAS");
		btnALTAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosAlta V1= new SociosAlta();
				V1.setVisible(true);
				
			}
		});
		btnALTAS.setBounds(37, 70, 89, 23);
		contentPane.add(btnALTAS);
		
		JButton btnBUSCAR = new JButton("BUSCAR");
		btnBUSCAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosBuscar V2= new SociosBuscar();
				V2.setVisible(true);
			}
		});
		btnBUSCAR.setBounds(227, 70, 89, 23);
		contentPane.add(btnBUSCAR);
		
		JButton btnEDITAR = new JButton("EDITAR");
		btnEDITAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosEditar V3= new SociosEditar();
				V3.setVisible(true);
			}
		});
		btnEDITAR.setBounds(227, 124, 89, 23);
		contentPane.add(btnEDITAR);
		
		JButton btnBAJAS = new JButton("BAJAS");
		btnBAJAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosBajas V4= new SociosBajas();
				V4.setVisible(true);
			}
		});
		btnBAJAS.setBounds(47, 124, 89, 23);
		contentPane.add(btnBAJAS);
	}

}

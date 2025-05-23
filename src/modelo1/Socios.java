package modelo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSOCIOS = new JLabel("SOCIOS");
		lblSOCIOS.setForeground(new Color(255, 255, 255));
		lblSOCIOS.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSOCIOS.setBounds(348, 142, 158, 31);
		contentPane.add(lblSOCIOS);
		
		JButton btnALTAS = new JButton("ALTAS");
		btnALTAS.setForeground(new Color(128, 128, 128));
		btnALTAS.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnALTAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosAlta V1= new SociosAlta();
				V1.setVisible(true);
				
			}
		});
		btnALTAS.setBounds(260, 218, 114, 32);
		contentPane.add(btnALTAS);
		
		JButton btnBUSCAR = new JButton("BUSCAR");
		btnBUSCAR.setForeground(new Color(128, 128, 128));
		btnBUSCAR.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBUSCAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosBuscar V2= new SociosBuscar();
				V2.setVisible(true);
			}
		});
		btnBUSCAR.setBounds(417, 218, 114, 32);
		contentPane.add(btnBUSCAR);
		
		JButton btnEDITAR = new JButton("EDITAR");
		btnEDITAR.setForeground(new Color(128, 128, 128));
		btnEDITAR.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEDITAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosEditar V3= new SociosEditar();
				V3.setVisible(true);
			}
		});
		btnEDITAR.setBounds(417, 277, 114, 31);
		contentPane.add(btnEDITAR);
		
		JButton btnBAJAS = new JButton("BAJAS");
		btnBAJAS.setForeground(new Color(128, 128, 128));
		btnBAJAS.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBAJAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SociosBajas V4= new SociosBajas();
				V4.setVisible(true);
			}
		});
		btnBAJAS.setBounds(260, 277, 114, 31);
		contentPane.add(btnBAJAS);
	}

}

package modelo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo1.Entrenadores;
import modelo1.Instalaciones;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSOCIOS = new JButton("SOCIOS");
		btnSOCIOS.setForeground(new Color(128, 128, 128));
		btnSOCIOS.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSOCIOS.setBounds(320, 169, 196, 39);
		btnSOCIOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socios V1= new Socios();
				V1.setVisible(true);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSOCIOS);
		
		JButton btnACTIVIDADES = new JButton("ACTIVIDADES");
		btnACTIVIDADES.setForeground(new Color(128, 128, 128));
		btnACTIVIDADES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnACTIVIDADES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actividades V2= new Actividades();
				V2.setVisible(true);
			}
		});
		btnACTIVIDADES.setBounds(320, 228, 196, 39);
		contentPane.add(btnACTIVIDADES);
		
		JLabel lblMenusocios = new JLabel("MENÚ PRINCIPAL");
		lblMenusocios.setForeground(new Color(255, 255, 255));
		lblMenusocios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMenusocios.setBounds(288, 90, 332, 56);
		contentPane.add(lblMenusocios);
		
		JButton btnENTRENADORES = new JButton("ENTRENADORES");
		btnENTRENADORES.setForeground(new Color(128, 128, 128));
		btnENTRENADORES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnENTRENADORES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrenadores V3= new Entrenadores();
				V3.setVisible(true);
			}
		});
		btnENTRENADORES.setBounds(320, 284, 196, 39);
		contentPane.add(btnENTRENADORES);
		
		JButton btnINSTALACIONES = new JButton("INSTALACIONES");
		btnINSTALACIONES.setForeground(new Color(128, 128, 128));
		btnINSTALACIONES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnINSTALACIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instalaciones V6= new Instalaciones();
				V6.setVisible(true);
			}
		});
		btnINSTALACIONES.setBounds(320, 341, 196, 39);
		contentPane.add(btnINSTALACIONES);
	}
}

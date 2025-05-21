package modelo2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo2.Entrenadores;
import modelo2.Instalaciones;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSOCIOS = new JButton("SOCIOS");
		btnSOCIOS.setBounds(32, 63, 155, 23);
		btnSOCIOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socios V1= new Socios();
				V1.setVisible(true);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSOCIOS);
		
		JButton btnACTIVIDADES = new JButton("ACTIVIDADES");
		btnACTIVIDADES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actividades V2= new Actividades();
				V2.setVisible(true);
			}
		});
		btnACTIVIDADES.setBounds(229, 63, 155, 23);
		contentPane.add(btnACTIVIDADES);
		
		JLabel lblMenusocios = new JLabel("MENÚ PRINCIPAL");
		lblMenusocios.setFont(new Font("Noto Naskh Arabic", Font.BOLD | Font.ITALIC, 20));
		lblMenusocios.setBounds(115, 11, 204, 39);
		contentPane.add(lblMenusocios);
		
		JButton btnENTRENADORES = new JButton("ENTRENADORES");
		btnENTRENADORES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrenadores V3= new Entrenadores();
				V3.setVisible(true);
			}
		});
		btnENTRENADORES.setBounds(32, 97, 155, 23);
		contentPane.add(btnENTRENADORES);
		
		JButton btnPAGOSYCUOTAS = new JButton("PAGOS Y CUOTAS");
		btnPAGOSYCUOTAS.setBounds(229, 97, 155, 23);
		contentPane.add(btnPAGOSYCUOTAS);
		
		JButton btnASISTENCIASYRESERVAS = new JButton("ASISTENCIAS Y RESERVAS");
		btnASISTENCIASYRESERVAS.setBounds(75, 165, 248, 23);
		contentPane.add(btnASISTENCIASYRESERVAS);
		
		JButton btnINSTALACIONES = new JButton("INSTALACIONES");
		btnINSTALACIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instalaciones V6= new Instalaciones();
				V6.setVisible(true);
			}
		});
		btnINSTALACIONES.setBounds(229, 131, 155, 23);
		contentPane.add(btnINSTALACIONES);
		
		JButton btnADMINISTRACIÓN = new JButton("ADMINISTRACIÓN");
		btnADMINISTRACIÓN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnADMINISTRACIÓN.setBounds(32, 131, 155, 23);
		contentPane.add(btnADMINISTRACIÓN);
	}
}

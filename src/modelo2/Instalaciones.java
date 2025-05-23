package modelo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo2.ConexionMySQL;

public class Instalaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instalaciones frame = new Instalaciones();
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
	public Instalaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSTALACIONES");
		lblNewLabel.setBounds(172, 22, 88, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("AÑADIR INSTALACIÓN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaInstalacion V1= new NuevaInstalacion();
				V1.setVisible(true);
			}
		});
		btnNewButton.setBounds(36, 68, 154, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BORRAR INSTALACIÓN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrarInstalacion V2= new BorrarInstalacion();
				V2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(234, 68, 168, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VER INSTALACIONES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerInstalacion V3= new VerInstalacion();
				V3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(124, 149, 181, 23);
		contentPane.add(btnNewButton_2);
		
	}}

package modelo1;

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

import modelo1.ConexionMySQL;
import java.awt.Color;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSTALACIONES");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(319, 82, 322, 71);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("AÑADIR INSTALACIÓN");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaInstalacion V1= new NuevaInstalacion();
				V1.setVisible(true);
			}
		});
		btnNewButton.setBounds(316, 179, 218, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BORRAR INSTALACIÓN");
		btnNewButton_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrarInstalacion V2= new BorrarInstalacion();
				V2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(316, 240, 218, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VER INSTALACIONES");
		btnNewButton_2.setForeground(new Color(128, 128, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerInstalacion V3= new VerInstalacion();
				V3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(316, 300, 218, 38);
		contentPane.add(btnNewButton_2);
		
	}}

package modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VSocios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VSocios frame = new VSocios();
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
	public VSocios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAlta = new JButton("Dar Alta");
		btnAlta.setBounds(27, 142, 71, 23);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Altas V1= new Altas();
				V1.setVisible(true);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAlta);
		
		JButton btnBaja = new JButton("Dar Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bajas V1= new Bajas();
				V1.setVisible(true);
			}
		});
		btnBaja.setBounds(108, 142, 89, 23);
		contentPane.add(btnBaja);
		
		JLabel lblMenusocios = new JLabel("MENÚ SOCIOS");
		lblMenusocios.setFont(new Font("Noto Naskh Arabic", Font.BOLD | Font.ITALIC, 20));
		lblMenusocios.setBounds(133, 11, 168, 39);
		contentPane.add(lblMenusocios);
	}
}

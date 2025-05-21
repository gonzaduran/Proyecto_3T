package modelo2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entrenadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrenadores frame = new Entrenadores();
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
	public Entrenadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTRENADORES");
		lblNewLabel.setBounds(171, 26, 104, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntrenadoresAlta V1= new EntrenadoresAlta();
				V1.setVisible(true);
			}
		});
		btnNewButton.setBounds(80, 71, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LISTADO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntrenadoresListado V3= new EntrenadoresListado();
				V3.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(249, 71, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDITAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntrenadoresEditar V2= new EntrenadoresEditar();
				V2.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(80, 151, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BORRAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntrenadoresBorrar V4= new EntrenadoresBorrar();
				V4.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(249, 151, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}

package PROYECTODEF;

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
import javax.swing.SwingConstants;

public class VPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
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
	public VPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSocios = new JButton("Socios");
		btnSocios.setBackground(new Color(255, 255, 255));
		btnSocios.setBounds(0, 39, 210, 23);
		btnSocios.addActionListener(new ActionListener() {
			
			//Para que lleve a la proxima clase socios
			public void actionPerformed(ActionEvent e) {
				VSocios v1 = new VSocios();
				v1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSocios);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VActividades v2 = new VActividades();
				v2.setVisible(true);
			}
		});
		btnActividades.setBounds(209, 39, 216, 23);
		contentPane.add(btnActividades);
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VTienda v3 = new VTienda();
				v3.setVisible(true);
			}
		});
		btnTienda.setBounds(424, 39, 210, 23);
		contentPane.add(btnTienda);
		
		JLabel lblTitutlo = new JLabel("NombreClubDeportivo");
		lblTitutlo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitutlo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitutlo.setBounds(0, 0, 634, 41);
		contentPane.add(lblTitutlo);
	}

}

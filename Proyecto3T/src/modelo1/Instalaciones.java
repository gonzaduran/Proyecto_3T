package modelo1;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Clase Instalaciones que representa la ventana principal de gestión de instalaciones.
 * Permite acceder a las acciones de añadir, borrar y ver instalaciones deportivas.
 * 
 * Esta clase extiende {@link JFrame} y utiliza {@link JPanel} como contenedor principal.
 * Los botones abren otras ventanas correspondientes a las funcionalidades respectivas.
 * 
 * Autor: [Tu Nombre]
 */
public class Instalaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Método principal que lanza la aplicación.
	 * 
	 * @param args Argumentos de línea de comandos (no se utilizan).
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
	 * Constructor de la clase Instalaciones.
	 * Configura la interfaz gráfica y los botones de navegación.
	 */
	public Instalaciones() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta principal
		JLabel lblNewLabel = new JLabel("INSTALACIONES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(319, 82, 322, 71);
		contentPane.add(lblNewLabel);

		// Botón para añadir instalación
		JButton btnNewButton = new JButton("AÑADIR INSTALACIÓN");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(316, 179, 218, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaInstalacion V1 = new NuevaInstalacion();
				V1.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);

		// Botón para borrar instalación
		JButton btnNewButton_1 = new JButton("BORRAR INSTALACIÓN");
		btnNewButton_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(316, 240, 218, 38);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrarInstalacion V2 = new BorrarInstalacion();
				V2.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);

		// Botón para ver instalaciones
		JButton btnNewButton_2 = new JButton("VER INSTALACIONES");
		btnNewButton_2.setForeground(new Color(128, 128, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(316, 300, 218, 38);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerInstalacion V3 = new VerInstalacion();
				V3.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
	}
}

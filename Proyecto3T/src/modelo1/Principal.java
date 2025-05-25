package modelo1;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Clase Principal que representa el menú principal del sistema.
 * 
 * Desde esta ventana se puede acceder a diferentes módulos:
 * - Socios
 * - Actividades
 * - Entrenadores
 * - Instalaciones
 * 
 * Cada botón abre una nueva ventana correspondiente a cada módulo.
 * 
 * Esta clase extiende {@link JFrame}.
 * 
 * @author  
 */
public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Método main. Lanza la aplicación principal.
	 * 
	 * @param args Argumentos de la línea de comandos (no utilizados).
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
	 * Constructor de la clase Principal.
	 * Inicializa y configura la ventana principal y sus componentes.
	 */
	public Principal() {
		// Configuración de la ventana principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		setLocationRelativeTo(null);

		// Panel principal de contenido
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 119, 168));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Botón SOCIOS
		JButton btnSOCIOS = new JButton("SOCIOS");
		btnSOCIOS.setForeground(new Color(128, 128, 128));
		btnSOCIOS.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSOCIOS.setBounds(320, 169, 196, 39);
		btnSOCIOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socios V1 = new Socios();
				V1.setVisible(true);
			}
		});
		contentPane.add(btnSOCIOS);

		// Botón ACTIVIDADES
		JButton btnACTIVIDADES = new JButton("ACTIVIDADES");
		btnACTIVIDADES.setForeground(new Color(128, 128, 128));
		btnACTIVIDADES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnACTIVIDADES.setBounds(320, 228, 196, 39);
		btnACTIVIDADES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actividades V2 = new Actividades();
				V2.setVisible(true);
			}
		});
		contentPane.add(btnACTIVIDADES);

		// Botón ENTRENADORES
		JButton btnENTRENADORES = new JButton("ENTRENADORES");
		btnENTRENADORES.setForeground(new Color(128, 128, 128));
		btnENTRENADORES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnENTRENADORES.setBounds(320, 284, 196, 39);
		btnENTRENADORES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrenadores V3 = new Entrenadores();
				V3.setVisible(true);
			}
		});
		contentPane.add(btnENTRENADORES);

		// Botón INSTALACIONES
		JButton btnINSTALACIONES = new JButton("INSTALACIONES");
		btnINSTALACIONES.setForeground(new Color(128, 128, 128));
		btnINSTALACIONES.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnINSTALACIONES.setBounds(320, 341, 196, 39);
		btnINSTALACIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instalaciones V6 = new Instalaciones();
				V6.setVisible(true);
			}
		});
		contentPane.add(btnINSTALACIONES);

		// Título del menú
		JLabel lblMenusocios = new JLabel("MENÚ PRINCIPAL");
		lblMenusocios.setForeground(new Color(255, 255, 255));
		lblMenusocios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMenusocios.setBounds(288, 90, 332, 56);
		contentPane.add(lblMenusocios);
	}
}

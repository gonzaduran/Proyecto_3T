package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;

public class Actividades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividades frame = new Actividades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String dates[]
	        = { "1", "2", "3", "4", "5",
	            "6", "7", "8", "9", "10",
	            "11", "12", "13", "14", "15",
	            "16", "17", "18", "19", "20",
	            "21", "22", "23", "24", "25",
	            "26", "27", "28", "29", "30",
	            "31" };
	private String months[]
	        = { "Jan", "feb", "Mar", "Apr",
	            "May", "Jun", "July", "Aug",
	            "Sup", "Oct", "Nov", "Dec" };
	private String years[]
	        = { "2025", "2026", "2027", "2028", "2029", "2030"};
	
	
	/**
	 * Create the frame.
	 */
	public Actividades() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton CrearActividadButton = new JButton("Crear actividad");
		CrearActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel NombreLabel = new JLabel("New label");
				NombreLabel.setBounds(52, 165, 46, 14);
				contentPane.add(NombreLabel);
				
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setBounds(52, 199, 46, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setBounds(52, 233, 46, 14);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("New label");
				lblNewLabel_3.setBounds(52, 268, 46, 14);
				contentPane.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("New label");
				lblNewLabel_4.setBounds(52, 298, 46, 14);
				contentPane.add(lblNewLabel_4);
				
				
				JFormattedTextField NombreTextField = new JFormattedTextField();
				NombreTextField.setBounds(108, 162, 160, 20);
				contentPane.add(NombreTextField);
				
				JFormattedTextField EntrenadorTextField = new JFormattedTextField();
				EntrenadorTextField.setBounds(108, 196, 160, 20);
				contentPane.add(EntrenadorTextField);
				
				JFormattedTextField ZonaTextField = new JFormattedTextField();
				ZonaTextField.setBounds(108, 230, 160, 20);
				contentPane.add(ZonaTextField);
				
				JComboBox dia1 = new JComboBox(dates);
				dia1.setBounds(108, 264, 50, 22);
				contentPane.add(dia1);
				
				JComboBox dia2 = new JComboBox(dates);
				dia2.setBounds(108, 294, 50, 22);
				contentPane.add(dia2);
				
				JComboBox mes2 = new JComboBox(months);
				mes2.setBounds(156, 294, 64, 22);
				contentPane.add(mes2);
				
				JComboBox mes1 = new JComboBox(months);
				mes1.setBounds(156, 264, 64, 22);
				contentPane.add(mes1);
				
				JComboBox año1 = new JComboBox(years);
				año1.setBounds(220, 264, 64, 22);
				contentPane.add(año1);
				
				JComboBox año2 = new JComboBox(years);
				año2.setBounds(220, 294, 64, 22);
				contentPane.add(año2);
				
				JButton ConfirmarCreacionButton = new JButton("Confirmar");
				ConfirmarCreacionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if() {
						//	JOptionPane.showMessageDialog(this, "¡Chachi!");
						//}
					}
				});
				ConfirmarCreacionButton.setBounds(75, 350, 89, 23);
				contentPane.add(ConfirmarCreacionButton);
				
				JButton CancelarCreacionButton = new JButton("Cancelar");
				CancelarCreacionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String def = " ";
							NombreTextField.setText(def);
							EntrenadorTextField.setText(def);
							ZonaTextField.setText(def);
							dia1.setSelectedIndex(0);
							mes1.setSelectedIndex(0);
							año1.setSelectedIndex(0);
							dia2.setSelectedIndex(0);
							mes2.setSelectedIndex(0);
							año2.setSelectedIndex(0);
					}
				});
				CancelarCreacionButton.setBounds(186, 350, 89, 23);
				contentPane.add(CancelarCreacionButton);
			}
		});
		CrearActividadButton.setBounds(519, 161, 218, 23);
		contentPane.add(CrearActividadButton);
		
		JButton ModActividadButton = new JButton("Modificar actividad");
		ModActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ModActividadButton.setBounds(519, 195, 218, 23);
		contentPane.add(ModActividadButton);
		
		JButton EliminarActividadButton = new JButton("Eliminar actividad");
		EliminarActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EliminarActividadButton.setBounds(519, 229, 218, 23);
		contentPane.add(EliminarActividadButton);
		
		JButton CalendarioActividadesButton = new JButton("Calendario de actividades");
		CalendarioActividadesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CalendarioActividadesButton.setBounds(519, 316, 218, 23);
		contentPane.add(CalendarioActividadesButton);
		
		JLabel ActividadesLabel = new JLabel("ACTIVIDADES");
		ActividadesLabel.setBounds(530, 56, 228, 94);
		contentPane.add(ActividadesLabel);
		
		JButton SociosXActividadButton = new JButton("Socios en actividades");
		SociosXActividadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SociosXActividadButton.setBounds(519, 350, 218, 23);
		contentPane.add(SociosXActividadButton);
		
		
	}
}

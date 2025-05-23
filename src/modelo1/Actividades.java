package modelo1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class Actividades extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTable table_1;
    private JTable table_2;

    static final String DB_URL = "jdbc:mysql://localhost/club_deportivo";
    static final String USER = "adminsql";
    static final String PASS = "admin";
    private JTextField mxtIdActividad;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Actividades frame = new Actividades();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Actividades() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 850, 580);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(10, 10, 820, 520);
        contentPane.add(cardPanel);

        // Panel menú principal
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(100, 119, 168));
        menuPanel.setLayout(null);

        JLabel tituloLabel = new JLabel("ACTIVIDADES");
        tituloLabel.setForeground(new Color(255, 255, 255));
        tituloLabel.setBounds(250, 88, 300, 50);
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        menuPanel.add(tituloLabel);

        JButton btnCrear = new JButton("Crear actividad");
        btnCrear.setForeground(new Color(128, 128, 128));
        btnCrear.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnCrear.setBounds(278, 170, 257, 33);
        menuPanel.add(btnCrear);

        JButton btnCalendario = new JButton("Calendario de actividades");
        btnCalendario.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnCalendario.setForeground(new Color(128, 128, 128));
        btnCalendario.setBounds(278, 341, 257, 33);
        menuPanel.add(btnCalendario);

        cardPanel.add(menuPanel, "menu");
        
        JButton btnModificar = new JButton("Modificar actividad");
        btnModificar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnModificar.setForeground(new Color(128, 128, 128));
        btnModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnModificar.setBounds(278, 214, 257, 33);
        menuPanel.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar actividad");
        btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnEliminar.setForeground(new Color(128, 128, 128));
        btnEliminar.setBounds(278, 258, 257, 33);
        menuPanel.add(btnEliminar);

        // Panel crear actividad
        JPanel crearPanel = new JPanel();
        crearPanel.setBackground(new Color(100, 119, 168));
        crearPanel.setLayout(null);

        JLabel lblCrear = new JLabel("Crear Actividad");
        lblCrear.setForeground(new Color(255, 255, 255));
        lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrear.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblCrear.setBounds(248, 82, 300, 30);
        crearPanel.add(lblCrear);

        JLabel lblNombre = new JLabel("Nombre Actividad:");
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNombre.setBounds(185, 150, 189, 28);
        crearPanel.add(lblNombre);

        JLabel lblEntrenador = new JLabel("ID Entrenador:");
        lblEntrenador.setForeground(new Color(255, 255, 255));
        lblEntrenador.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblEntrenador.setBounds(185, 189, 189, 32);
        crearPanel.add(lblEntrenador);

        JLabel lblZona = new JLabel("ID Zona:");
        lblZona.setForeground(new Color(255, 255, 255));
        lblZona.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblZona.setBounds(185, 232, 139, 30);
        crearPanel.add(lblZona);

        JLabel lblHorario = new JLabel("Horario:");
        lblHorario.setForeground(new Color(255, 255, 255));
        lblHorario.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblHorario.setBounds(185, 269, 139, 28);
        crearPanel.add(lblHorario);

        JFormattedTextField txtNombre = new JFormattedTextField();
        txtNombre.setBounds(369, 148, 208, 30);
        crearPanel.add(txtNombre);

        JFormattedTextField txtEntrenador = new JFormattedTextField();
        txtEntrenador.setBounds(369, 189, 208, 30);
        crearPanel.add(txtEntrenador);

        JFormattedTextField txtZona = new JFormattedTextField();
        txtZona.setBounds(369, 230, 208, 30);
        crearPanel.add(txtZona);

        JFormattedTextField txtInicio = new JFormattedTextField();
        txtInicio.setBounds(369, 271, 208, 30);
        crearPanel.add(txtInicio);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnConfirmar.setForeground(new Color(128, 128, 128));
        btnConfirmar.setBounds(145, 340, 133, 30);
        crearPanel.add(btnConfirmar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnCancelar.setForeground(new Color(128, 128, 128));
        btnCancelar.setBounds(288, 340, 133, 30);
        crearPanel.add(btnCancelar);

        JButton btnVolver1 = new JButton("Volver al menú");
        btnVolver1.setForeground(new Color(128, 128, 128));
        btnVolver1.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnVolver1.setBounds(431, 340, 194, 30);
        crearPanel.add(btnVolver1);

        cardPanel.add(crearPanel, "crear");

        
        // Acción botón confirmar creación
        btnConfirmar.addActionListener(e -> {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
            	String sql = "INSERT INTO Actividades (nomAct, horario, idEntre, idZona) values ('"
                        + txtNombre.getText() + "','" + txtInicio.getText()
                        + "'," + txtEntrenador.getText() + ","
                        + txtZona.getText() + ")";
            	
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(contentPane, "Actividad añadida exitosamente!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            txtNombre.setText("");
            txtEntrenador.setText("");
            txtZona.setText("");
            txtInicio.setText(""); 
        });

        btnVolver1.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        
        
        
        
        
        
        
        
        
        
        
        // Panel modificar actividad
        JPanel modificarPanel = new JPanel();
        modificarPanel.setBackground(new Color(100, 119, 168));
        modificarPanel.setLayout(null);

        JLabel lblmodificar = new JLabel("Modificar Actividad");
        lblmodificar.setForeground(new Color(255, 255, 255));
        lblmodificar.setBounds(253, 72, 300, 30);
        lblmodificar.setHorizontalAlignment(SwingConstants.CENTER);
        lblmodificar.setFont(new Font("Tahoma", Font.BOLD, 26));
        modificarPanel.add(lblmodificar);

        JLabel mblNombre = new JLabel("Nombre Actividad:");
        mblNombre.setForeground(new Color(255, 255, 255));
        mblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
        mblNombre.setBounds(253, 158, 120, 20);
        modificarPanel.add(mblNombre);

        JLabel mblEntrenador = new JLabel("ID Entrenador:");
        mblEntrenador.setForeground(new Color(255, 255, 255));
        mblEntrenador.setFont(new Font("Tahoma", Font.BOLD, 11));
        mblEntrenador.setBounds(253, 189, 120, 20);
        modificarPanel.add(mblEntrenador);

        JLabel mblZona = new JLabel("ID Zona:");
        mblZona.setFont(new Font("Tahoma", Font.BOLD, 11));
        mblZona.setForeground(new Color(255, 255, 255));
        mblZona.setBounds(253, 220, 120, 20);
        modificarPanel.add(mblZona);

        JLabel mblHorario = new JLabel("Horario:");
        mblHorario.setFont(new Font("Tahoma", Font.BOLD, 11));
        mblHorario.setForeground(new Color(255, 255, 255));
        mblHorario.setBounds(253, 251, 120, 20);
        modificarPanel.add(mblHorario);

        JFormattedTextField mxtNombre = new JFormattedTextField();
        mxtNombre.setBounds(369, 158, 200, 20);
        modificarPanel.add(mxtNombre);

        JFormattedTextField mxtEntrenador = new JFormattedTextField();
        mxtEntrenador.setBounds(369, 189, 200, 20);
        modificarPanel.add(mxtEntrenador);

        JFormattedTextField mxtZona = new JFormattedTextField();
        mxtZona.setBounds(369, 220, 200, 20);
        modificarPanel.add(mxtZona);

        JFormattedTextField mxtInicio = new JFormattedTextField();
        mxtInicio.setBounds(369, 251, 200, 20);
        modificarPanel.add(mxtInicio);

        JButton mtnConfirmar = new JButton("Confirmar");
        mtnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
        mtnConfirmar.setForeground(new Color(128, 128, 128));
        mtnConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            			Statement stmt = conn.createStatement()) {
            			String sql = "UPDATE Actividades set nomAct = '"+ mxtNombre.getText()+"', idEntre ="+ mxtEntrenador.getText() +", idZona ="+ mxtZona.getText() +", horario ='"+ mxtInicio.getText() +"' WHERE idAct =" + mxtIdActividad.getText()+";";
            			
            			 stmt.executeUpdate(sql);
                         JOptionPane.showMessageDialog(contentPane, "Actividad mnodificada correctamente!");
            		}
            		
            		catch (SQLException errorsql) {
                        JOptionPane.showMessageDialog(contentPane,errorsql, "Modificación de la actividad fallida", JOptionPane.ERROR_MESSAGE);
                        errorsql.printStackTrace();
                    }
        	}
        });
        mtnConfirmar.setBounds(237, 314, 100, 25);
        modificarPanel.add(mtnConfirmar);

        JButton mtnCancelar = new JButton("Cancelar");
        mtnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
        mtnCancelar.setForeground(new Color(128, 128, 128));
        mtnCancelar.setBounds(347, 314, 100, 25);
        modificarPanel.add(mtnCancelar);

        JButton mtnVolver1 = new JButton("Volver al menú");
        mtnVolver1.setFont(new Font("Tahoma", Font.BOLD, 11));
        mtnVolver1.setForeground(new Color(128, 128, 128));
        mtnVolver1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        mtnVolver1.setBounds(457, 314, 120, 25);
        mtnVolver1.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        modificarPanel.add(mtnVolver1);

        cardPanel.add(modificarPanel, "Modificar");
        
        JLabel mblIdActividad = new JLabel("ID Actividad:");
        mblIdActividad.setForeground(new Color(255, 255, 255));
        mblIdActividad.setFont(new Font("Tahoma", Font.BOLD, 11));
        mblIdActividad.setBounds(253, 133, 106, 14);
        modificarPanel.add(mblIdActividad);
        
        mxtIdActividad = new JTextField();
        mxtIdActividad.setBounds(369, 130, 200, 20);
        modificarPanel.add(mxtIdActividad);
        mxtIdActividad.setColumns(10);

        
        // Acción botón confirmar creación
        btnConfirmar.addActionListener(e -> {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
            	String sql = "INSERT INTO Actividades (nomAct, horario, idEntre, idZona) values ('"
                        + txtNombre.getText() + "','" + txtInicio.getText()
                        + "'," + txtEntrenador.getText() + ","
                        + txtZona.getText() + ")";
            	
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(contentPane, "Actividad añadida exitosamente!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            txtNombre.setText("");
            txtEntrenador.setText("");
            txtZona.setText("");
            txtInicio.setText(""); 
        });

        btnVolver1.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
        
        
        
        
        
     // Panel borrarActividad
        JPanel borrarActividadPanel = new JPanel();
        borrarActividadPanel.setBackground(new Color(100, 119, 168));
        borrarActividadPanel.setLayout(null);

        JLabel lblborrarActividad = new JLabel("Eliminar Actividades");
        lblborrarActividad.setForeground(new Color(255, 255, 255));
        lblborrarActividad.setHorizontalAlignment(SwingConstants.CENTER);
        lblborrarActividad.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblborrarActividad.setBounds(241, 19, 350, 30);
        borrarActividadPanel.add(lblborrarActividad);

        table_2 = new JTable();
        JScrollPane scroll2 = new JScrollPane(table_2);
        scroll2.setBounds(50, 60, 700, 263);
        borrarActividadPanel.add(scroll2);

        JButton btnVolver3 = new JButton("Volver al menú");
        btnVolver3.setForeground(new Color(128, 128, 128));
        btnVolver3.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnVolver3.setBounds(389, 430, 150, 30);
        borrarActividadPanel.add(btnVolver3);

        cardPanel.add(borrarActividadPanel, "borrarActividad");

        // Acción para mostrar el borrarActividad y cargar datos
        btnEliminar.addActionListener(e -> {
            DefaultTableModel model = new DefaultTableModel();
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                String sql = "SELECT A.idAct, A.nomAct AS Actividad,A.horario,Z.nomZona AS Zona,Z.capacidad,E.nombre AS EntrenadorNombre,E.apellido_1 AS EntrenadorApellido,E.especialidad FROM Actividades A JOIN Zonas Z ON A.idZona = Z.idZona JOIN Entrenadores E ON A.idEntre = E.id_entrenador;";                                   
                ResultSet rs = stmt.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columns = rsmd.getColumnCount();
                String[] columnNames = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    columnNames[i - 1] = rsmd.getColumnName(i);
                }
                model.setColumnIdentifiers(columnNames);
                while (rs.next()) {
                    String[] row = new String[columns];
                    for (int i = 0; i < columns; i++) {
                        row[i] = rs.getString(i + 1);
                    }
                    model.addRow(row);
                }
                table_2.setModel(model);
                
                JLabel lblEliminarID = new JLabel("ID Actividad a eliminar:");
                lblEliminarID.setForeground(new Color(255, 255, 255));
                lblEliminarID.setFont(new Font("Tahoma", Font.BOLD, 11));
                lblEliminarID.setBounds(179, 340, 159, 30);
                borrarActividadPanel.add(lblEliminarID);
                
                textField = new JTextField();
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                textField.setBounds(344, 340, 236, 30);
                borrarActividadPanel.add(textField);
                textField.setColumns(10);
                
                JButton btnBorrarAct = new JButton("Eliminar actividad");
                btnBorrarAct.setForeground(new Color(128, 128, 128));
                btnBorrarAct.setFont(new Font("Tahoma", Font.BOLD, 11));
                btnBorrarAct.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                			Statement stmt = conn.createStatement()) {
                			String sql = "DELETE FROM actividades WHERE idAct = "+textField.getText()+";";
                			
                			 stmt.executeUpdate(sql);
                             JOptionPane.showMessageDialog(contentPane, "Actividad eliminada correctamente!");
                		}
                		
                		catch (SQLException errorsql) {
                            JOptionPane.showMessageDialog(contentPane,errorsql, "Eliminación fallida", JOptionPane.ERROR_MESSAGE);
                            errorsql.printStackTrace();
                        }
                	}
                });
                btnBorrarAct.setBounds(229, 430, 150, 30);
                borrarActividadPanel.add(btnBorrarAct);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
            cardLayout.show(cardPanel, "borrarActividad");
        });

        btnVolver3.addActionListener(e -> cardLayout.show(cardPanel, "menu"));

        // Acción para botón de crear
        btnCrear.addActionListener(e -> cardLayout.show(cardPanel, "crear"));
        
     // Acción para botón de crear
        btnModificar.addActionListener(e -> cardLayout.show(cardPanel, "Modificar"));
        
        
        
        
        
        
        
        
        

        // Panel calendario
        JPanel calendarioPanel = new JPanel();
        calendarioPanel.setBackground(new Color(100, 119, 168));
        calendarioPanel.setLayout(null);

        JLabel lblCalendario = new JLabel("Calendario de Actividades");
        lblCalendario.setForeground(new Color(255, 255, 255));
        lblCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        lblCalendario.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblCalendario.setBounds(234, 19, 350, 30);
        calendarioPanel.add(lblCalendario);

        table_1 = new JTable();
        JScrollPane scroll = new JScrollPane(table_1);
        scroll.setBounds(50, 60, 700, 350);
        calendarioPanel.add(scroll);

        JButton btnVolver2 = new JButton("Volver al menú");
        btnVolver2.setForeground(new Color(128, 128, 128));
        btnVolver2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnVolver2.setBounds(325, 433, 150, 30);
        calendarioPanel.add(btnVolver2);

        cardPanel.add(calendarioPanel, "calendario");

        // Acción para mostrar el calendario y cargar datos
        btnCalendario.addActionListener(e -> {
            DefaultTableModel model = new DefaultTableModel();
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                String sql = "SELECT idAct, A.nomAct AS Actividad,A.horario,Z.nomZona AS Zona,Z.capacidad,E.nombre AS EntrenadorNombre,E.apellido_1 AS EntrenadorApellido,E.especialidad FROM Actividades A JOIN Zonas Z ON A.idZona = Z.idZona JOIN Entrenadores E ON A.idEntre = E.id_entrenador;";                                   
                ResultSet rs = stmt.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columns = rsmd.getColumnCount();
                String[] columnNames = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    columnNames[i - 1] = rsmd.getColumnName(i);
                }
                model.setColumnIdentifiers(columnNames);
                while (rs.next()) {
                    String[] row = new String[columns];
                    for (int i = 0; i < columns; i++) {
                        row[i] = rs.getString(i + 1);
                    }
                    model.addRow(row);
                }
                table_1.setModel(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
            cardLayout.show(cardPanel, "calendario");
        });

        btnVolver2.addActionListener(e -> cardLayout.show(cardPanel, "menu"));

        // Acción para botón de crear
        btnCrear.addActionListener(e -> cardLayout.show(cardPanel, "crear"));
        
     // Acción para botón de crear
        btnModificar.addActionListener(e -> cardLayout.show(cardPanel, "Modificar"));
    }
}
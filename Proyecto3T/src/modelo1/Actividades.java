package modelo1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

/**
 * Clase principal para gestionar actividades en un club deportivo.
 * Proporciona una interfaz gráfica para crear, modificar, eliminar y consultar actividades.
 * Utiliza una base de datos MySQL para almacenar los datos.
 * 
 * @author 
 */
public class Actividades extends JFrame {

    private static final long serialVersionUID = 1L;
    
    /** Panel principal del contenido */
    private JPanel contentPane;
    
    /** Layout para cambiar entre paneles */
    private CardLayout cardLayout;
    
    /** Panel que contiene los diferentes "cards" (pantallas) */
    private JPanel cardPanel;
    
    /** Tabla para mostrar el calendario de actividades */
    private JTable table_1;
    
    /** Tabla para mostrar las actividades a eliminar */
    private JTable table_2;

    /** URL de conexión a la base de datos MySQL */
    static final String DB_URL = "jdbc:mysql://localhost/club_deportivo";
    
    /** Usuario para conexión a la base de datos */
    static final String USER = "adminsql";
    
    /** Contraseña para conexión a la base de datos */
    static final String PASS = "admin";
    
    /** Campo de texto para el ID de actividad en el panel modificar */
    private JTextField mxtIdActividad;
    
    /** Campo de texto para el ID de actividad a eliminar */
    private JTextField textField;

    /**
     * Método principal que inicia la aplicación.
     * @param args argumentos de línea de comandos (no usados)
     */
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

    /**
     * Constructor que inicializa la interfaz gráfica y la configuración de los componentes.
     */
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
                // Acción vacía (se añade más abajo)
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

        // Acción botón cancelar creación: limpia campos
        btnCancelar.addActionListener(e -> {
            txtNombre.setText("");
            txtEntrenador.setText("");
            txtZona.setText("");
            txtInicio.setText(""); 
        });

        // Acción botón volver al menú
        btnVolver1.addActionListener(e -> cardLayout.show(cardPanel, "menu"));

        // Panel modificar actividad
        JPanel modificarPanel = new JPanel();
        modificarPanel.setBackground(new Color(100, 119, 168));
        modificarPanel.setLayout(null);

        JLabel lblModificar = new JLabel("Modificar actividad");
        lblModificar.setForeground(new Color(255, 255, 255));
        lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
        lblModificar.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblModificar.setBounds(245, 80, 300, 30);
        modificarPanel.add(lblModificar);

        JLabel lblIdActividad = new JLabel("ID Actividad:");
        lblIdActividad.setForeground(new Color(255, 255, 255));
        lblIdActividad.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblIdActividad.setBounds(175, 140, 120, 28);
        modificarPanel.add(lblIdActividad);

        mxtIdActividad = new JTextField();
        mxtIdActividad.setBounds(300, 140, 180, 30);
        modificarPanel.add(mxtIdActividad);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnBuscar.setForeground(new Color(128, 128, 128));
        btnBuscar.setBounds(500, 140, 120, 30);
        modificarPanel.add(btnBuscar);

        // Campos para modificar (nombre, entrenador, zona, horario)
        JLabel lblNombreMod = new JLabel("Nombre Actividad:");
        lblNombreMod.setForeground(new Color(255, 255, 255));
        lblNombreMod.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblNombreMod.setBounds(175, 190, 170, 28);
        modificarPanel.add(lblNombreMod);

        JTextField txtNombreMod = new JTextField();
        txtNombreMod.setBounds(350, 190, 270, 30);
        modificarPanel.add(txtNombreMod);

        JLabel lblEntrenadorMod = new JLabel("ID Entrenador:");
        lblEntrenadorMod.setForeground(new Color(255, 255, 255));
        lblEntrenadorMod.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblEntrenadorMod.setBounds(175, 230, 170, 28);
        modificarPanel.add(lblEntrenadorMod);

        JTextField txtEntrenadorMod = new JTextField();
        txtEntrenadorMod.setBounds(350, 230, 270, 30);
        modificarPanel.add(txtEntrenadorMod);

        JLabel lblZonaMod = new JLabel("ID Zona:");
        lblZonaMod.setForeground(new Color(255, 255, 255));
        lblZonaMod.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblZonaMod.setBounds(175, 270, 170, 28);
        modificarPanel.add(lblZonaMod);

        JTextField txtZonaMod = new JTextField();
        txtZonaMod.setBounds(350, 270, 270, 30);
        modificarPanel.add(txtZonaMod);

        JLabel lblHorarioMod = new JLabel("Horario:");
        lblHorarioMod.setForeground(new Color(255, 255, 255));
        lblHorarioMod.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblHorarioMod.setBounds(175, 310, 170, 28);
        modificarPanel.add(lblHorarioMod);

        JTextField txtHorarioMod = new JTextField();
        txtHorarioMod.setBounds(350, 310, 270, 30);
        modificarPanel.add(txtHorarioMod);

        JButton btnModificarConfirmar = new JButton("Modificar");
        btnModificarConfirmar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnModificarConfirmar.setForeground(new Color(128, 128, 128));
        btnModificarConfirmar.setBounds(175, 360, 150, 30);
        modificarPanel.add(btnModificarConfirmar);

        JButton btnVolverMod = new JButton("Volver al menú");
        btnVolverMod.setForeground(new Color(128, 128, 128));
        btnVolverMod.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnVolverMod.setBounds(400, 360, 220, 30);
        modificarPanel.add(btnVolverMod);

        cardPanel.add(modificarPanel, "modificar");

        // Acción botón buscar en modificar
        btnBuscar.addActionListener(e -> {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM Actividades WHERE idAct = " + mxtIdActividad.getText();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    txtNombreMod.setText(rs.getString("nomAct"));
                    txtEntrenadorMod.setText(rs.getString("idEntre"));
                    txtZonaMod.setText(rs.getString("idZona"));
                    txtHorarioMod.setText(rs.getString("horario"));
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Actividad no encontrada");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción botón modificar confirmar
        btnModificarConfirmar.addActionListener(e -> {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                String sql = "UPDATE Actividades SET nomAct = '" + txtNombreMod.getText()
                        + "', idEntre = " + txtEntrenadorMod.getText()
                        + ", idZona = " + txtZonaMod.getText()
                        + ", horario = '" + txtHorarioMod.getText()
                        + "' WHERE idAct = " + mxtIdActividad.getText();
                int result = stmt.executeUpdate(sql);
                if (result > 0) {
                    JOptionPane.showMessageDialog(contentPane, "Actividad modificada correctamente");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "No se pudo modificar la actividad");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción botón volver al menú modificar
        btnVolverMod.addActionListener(e -> cardLayout.show(cardPanel, "menu"));

        // Panel eliminar actividad
        JPanel eliminarPanel = new JPanel();
        eliminarPanel.setBackground(new Color(100, 119, 168));
        eliminarPanel.setLayout(null);

        JLabel lblEliminar = new JLabel("Eliminar actividad");
        lblEliminar.setForeground(new Color(255, 255, 255));
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblEliminar.setBounds(248, 30, 300, 30);
        eliminarPanel.add(lblEliminar);

        JLabel lblIdEliminar = new JLabel("ID Actividad:");
        lblIdEliminar.setForeground(new Color(255, 255, 255));
        lblIdEliminar.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblIdEliminar.setBounds(175, 100, 150, 30);
        eliminarPanel.add(lblIdEliminar);

        textField = new JTextField();
        textField.setBounds(320, 100, 200, 30);
        eliminarPanel.add(textField);

        JButton btnEliminarConfirmar = new JButton("Eliminar");
        btnEliminarConfirmar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnEliminarConfirmar.setForeground(new Color(128, 128, 128));
        btnEliminarConfirmar.setBounds(175, 150, 150, 30);
        eliminarPanel.add(btnEliminarConfirmar);

        JButton btnVolverEliminar = new JButton("Volver al menú");
        btnVolverEliminar.setForeground(new Color(128, 128, 128));
        btnVolverEliminar.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnVolverEliminar.setBounds(400, 150, 220, 30);
        eliminarPanel.add(btnVolverEliminar);

        // Tabla para mostrar actividades
        DefaultTableModel model = new DefaultTableModel(new String[]{"idAct", "nomAct", "idEntre", "idZona", "horario"}, 0);
        table_2 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table_2);
        scrollPane.setBounds(50, 220, 700, 270);
        eliminarPanel.add(scrollPane);

        // Rellenar tabla con actividades
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Actividades";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("idAct"),
                        rs.getString("nomAct"),
                        rs.getInt("idEntre"),
                        rs.getInt("idZona"),
                        rs.getString("horario")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }

        cardPanel.add(eliminarPanel, "eliminar");

        // Acción botón eliminar confirmar
        btnEliminarConfirmar.addActionListener(e -> {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                String sql = "DELETE FROM Actividades WHERE idAct = " + textField.getText();
                int result = stmt.executeUpdate(sql);
                if (result > 0) {
                    JOptionPane.showMessageDialog(contentPane, "Actividad eliminada correctamente");
                    model.setRowCount(0); // Vaciar tabla
                    try (ResultSet rs = stmt.executeQuery("SELECT * FROM Actividades")) {
                        while (rs.next()) {
                            model.addRow(new Object[]{
                                    rs.getInt("idAct"),
                                    rs.getString("nomAct"),
                                    rs.getInt("idEntre"),
                                    rs.getInt("idZona"),
                                    rs.getString("horario")
                            });
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "No se pudo eliminar la actividad");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción botón volver al menú eliminar
        btnVolverEliminar.addActionListener(e -> cardLayout.show(cardPanel, "menu"));

        // Panel calendario actividades
        JPanel calendarioPanel = new JPanel();
        calendarioPanel.setBackground(new Color(100, 119, 168));
        calendarioPanel.setLayout(null);

        JLabel lblCalendario = new JLabel("Calendario de actividades");
        lblCalendario.setForeground(new Color(255, 255, 255));
        lblCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        lblCalendario.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblCalendario.setBounds(225, 20, 350, 40);
        calendarioPanel.add(lblCalendario);

        DefaultTableModel modelCal = new DefaultTableModel(new String[]{"ID", "Nombre", "Entrenador", "Zona", "Horario"}, 0);
        table_1 = new JTable(modelCal);
        JScrollPane scrollPaneCal = new JScrollPane(table_1);
        scrollPaneCal.setBounds(50, 90, 700, 350);
        calendarioPanel.add(scrollPaneCal);

        JButton btnVolverCal = new JButton("Volver al menú");
        btnVolverCal.setForeground(new Color(128, 128, 128));
        btnVolverCal.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnVolverCal.setBounds(300, 460, 220, 30);
        calendarioPanel.add(btnVolverCal);

        cardPanel.add(calendarioPanel, "calendario");

        // Rellenar tabla calendario
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Actividades";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                modelCal.addRow(new Object[]{
                        rs.getInt("idAct"),
                        rs.getString("nomAct"),
                        rs.getInt("idEntre"),
                        rs.getInt("idZona"),
                        rs.getString("horario")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }

        // Acciones botones menú principal para cambiar vistas
        btnCrear.addActionListener(e -> cardLayout.show(cardPanel, "crear"));
        btnCalendario.addActionListener(e -> cardLayout.show(cardPanel, "calendario"));
        btnModificar.addActionListener(e -> cardLayout.show(cardPanel, "modificar"));
        btnEliminar.addActionListener(e -> cardLayout.show(cardPanel, "eliminar"));
        btnVolverCal.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
    }
}

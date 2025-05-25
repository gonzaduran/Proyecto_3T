package modelo1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 * Clase VerInstalacion.
 * Esta clase permite mostrar una ventana con un listado de instalaciones del club deportivo.
 * Conecta a una base de datos MySQL, recupera los datos de la tabla 'zonas' y los muestra en una tabla.
 * 
 * @author 
 */
public class VerInstalacion extends JFrame {

    private static final long serialVersionUID = 1L;

    /** Panel principal del contenido */
    private JPanel contentPane;

    /** Tabla para mostrar los datos de las instalaciones */
    private JTable table;

    /** Modelo de la tabla para definir columnas y filas */
    private DefaultTableModel modeloTabla;

    /** URL de conexión a la base de datos */
    private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";

    /** Usuario de la base de datos */
    private final String USER = "root";

    /** Contraseña de la base de datos */
    private final String PASS = "";

    /**
     * Método principal.
     * Ejecuta la aplicación.
     * 
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VerInstalacion frame = new VerInstalacion();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Constructor de la clase VerInstalacion.
     * Configura la ventana, crea los componentes gráficos y carga los datos de la base de datos.
     */
    public VerInstalacion() {
        setTitle("Listado de Instalaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 350);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(100, 119, 168));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("LISTA DE INSTALACIONES", SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Nombre", "Capacidad", "Estado"});

        table = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        cargarDatos();
    }

    /**
     * Carga los datos de las instalaciones desde la base de datos.
     * Realiza una consulta SQL y agrega las filas al modelo de la tabla.
     */
    private void cargarDatos() {
        String query = "SELECT * FROM zonas";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("idZona");
                String nombre = rs.getString("nomZona");
                int capacidad = rs.getInt("capacidad");
                String estado = rs.getString("estado");

                modeloTabla.addRow(new Object[]{id, nombre, capacidad, estado});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage());
        }
    }
}

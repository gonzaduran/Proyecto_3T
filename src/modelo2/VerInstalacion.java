package modelo2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import modelo2.ConexionMySQL;

public class VerInstalacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel modeloTabla;

    // Datos de conexión
    private final String DB_URL = "jdbc:mysql://localhost:3306/club_deportivo";
    private final String USER = "root";
    private final String PASS = "";

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

    public VerInstalacion() {
        setTitle("Listado de Instalaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("LISTA DE INSTALACIONES", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Nombre", "Capacidad", "Estado"});

        table = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        cargarDatos();
    }

    private void cargarDatos() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM zonas")) {

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

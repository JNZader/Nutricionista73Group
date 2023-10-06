package Conexion;

import static Conexion.Conexion.getConnection;
import Entidades.Consulta;
import Entidades.Dieta;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultaDAO {

    private Connection con;

    public ConsultaDAO() {
        con = getConnection();
    }

    public ArrayList<Consulta> buscar() {
        String SQL_SELECT = "SELECT * FROM consulta";
        Consulta consulta= null;
        ArrayList<Consulta> consultaList = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                    consulta = new Consulta();
                    consulta.setIdConsulta(rs.getInt("idConsulta"));
                    consulta.setIdPaciente(rs.getInt("idPaciente"));
                    consulta.setFecha(rs.getDate("fecha").toLocalDate());
                    consulta.setPesoActual(rs.getDouble("pesoActual"));

                consultaList.add(consulta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener consultas");
        }
        return consultaList; // retorna la lista 
    }

    public Consulta buscarPorId(int idConsulta) {
        String SQL_SELECT_ID = "SELECT * FROM consulta WHERE idConsulta = ?";
        Consulta consulta= null;

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID)) {
            ps.setInt(1, idConsulta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    consulta = new Consulta();
                    consulta.setIdConsulta(idConsulta);
                    consulta.setIdPaciente(rs.getInt("idPaciente"));
                    consulta.setFecha(rs.getDate("fecha").toLocalDate());
                    consulta.setPesoActual(rs.getDouble("pesoActual"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener la Consulta por ID");
        }
        return consulta;
    }

    public void insertar(Consulta consulta) {
        String SQL_INSERT = "INSERT INTO consulta (idPaciente, fecha, pesoActual) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, consulta.getIdPaciente());
            ps.setDate(2, Date.valueOf(consulta.getFecha()));
            ps.setDouble(3, consulta.getPesoActual());
            ps.executeUpdate(); // ejecuta la inserción en la base de datos
            try (ResultSet rs = ps.getGeneratedKeys()) { // obtiene las claves generadas automáticamente
                if (rs.next()) {
                    consulta.setIdConsulta(rs.getInt(1)); // establece el ID generado en el objeto 
                    JOptionPane.showMessageDialog(null, "Dieta inscripta");
                } else {
                    JOptionPane.showMessageDialog(null, "Inscripcion fallida");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al insertar dieta");
        }
    }

    public void actualizar(Consulta consulta) {
        String SQL_UPDATE = "UPDATE consulta SET idPaciente = ?, fecha = ?, pesoActual = ? WHERE idConsulta = ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {

            ps.setInt(1, consulta.getIdPaciente());
            ps.setDate(2, Date.valueOf(consulta.getFecha()));
            ps.setDouble(3, consulta.getPesoActual());
            ps.setInt(4, consulta.getIdConsulta());

            int on = ps.executeUpdate(); // Ejecuta la actualización en la base de datos
            if (on > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion realizada");
            } else {
                JOptionPane.showMessageDialog(null, "Actualizacion fallida");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al actualizar Dieta");
        }
    }

    public void eliminar(int idConsulta) {
        String sql = "DELETE FROM consulta WHERE idConsulta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idConsulta);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al eliminar Consulta");
        }
    }

}

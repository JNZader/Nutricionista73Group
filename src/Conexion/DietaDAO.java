package Conexion;

import static Conexion.Conexion.getConnection;
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

public class DietaDAO {

    private PacienteDAO pd;
    private Connection con;

    public DietaDAO() {
        con = getConnection();
    }

    public ArrayList<Dieta> buscar(int estado) {
        String SQL_SELECT = null;

        switch (estado) {
            case 1:
                SQL_SELECT = "SELECT idDieta, nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado FROM dieta WHERE estado=1";
                break;
            case 0:
                SQL_SELECT = "SELECT idDieta, nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado FROM dieta WHERE estado=0";
                break;
            default:
                SQL_SELECT = "SELECT idDieta, nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado FROM dieta";
                break;
        }

        Dieta dieta = null;
        ArrayList<Dieta> dietaList = new ArrayList<>();
        pd = new PacienteDAO();
        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dieta = new Dieta();
                dieta.setNombre(rs.getString("nombre"));
                int idPaciente = rs.getInt("idpaciente");
                Paciente p = pd.buscarPaciente(idPaciente, 3);
                dieta.setPaciente(p);
                dieta.setFechaInicial(rs.getDate("fechaInicio").toLocalDate());
                dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setEstado(rs.getBoolean("estado"));

                dietaList.add(dieta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener Dietas");
        }
        return dietaList; // retorna la lista 
    }

    public Dieta buscarPorId(int idDieta, int estado) {
        String SQL_SELECT_ID = null;
        Dieta dieta = null;
        pd = new PacienteDAO();
        switch (estado) {
            case 1:
                SQL_SELECT_ID = "SELECT nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado FROM dieta WHERE idDieta = ? AND estado=1";
                break;
            case 0:
                SQL_SELECT_ID = "SELECT nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado FROM dieta WHERE idDieta = ? AND estado=0";
                break;
            default:
                SQL_SELECT_ID = "SELECT nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado FROM dieta WHERE idDieta = ?";
                break;
        }
        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID)) {
            ps.setInt(1, idDieta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dieta = new Dieta();
                    dieta.setNombre(rs.getString("nombre"));
                    int idPaciente = rs.getInt("idpaciente");
                    Paciente p = pd.buscarPaciente(idPaciente, 3);
                    dieta.setPaciente(p);
                    dieta.setFechaInicial(rs.getDate("fechaInicio").toLocalDate());
                    dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
                    dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                    dieta.setIdDieta(idDieta);
                    dieta.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener la Dieta por ID");
        }
        return dieta;
    }

    public void insertar(Dieta dieta) {
        String SQL_INSERT = "INSERT INTO dieta(nombre, idPaciente, fechaInicio, fechaFin, pesoFinal, estado) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, dieta.getNombre());
            int id = dieta.getPaciente().getIdPaciente();
            ps.setInt(2, id);
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(4, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setBoolean(6, true);
            ps.executeUpdate(); // ejecuta la inserción en la base de datos
            try (ResultSet rs = ps.getGeneratedKeys()) { // obtiene las claves generadas automáticamente
                if (rs.next()) {
                    dieta.setIdDieta(rs.getInt(1)); // establece el ID generado en el objeto 
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

    public void actualizar(Dieta dieta) {
        String SQL_UPDATE = "UPDATE dieta SET idPaciente = ?, fechaInicio = ?, fechaFin = ?, pesoFinal = ?, estado=? WHERE idDieta = ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {

            ps.setInt(1, dieta.getPaciente().getIdPaciente());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(3, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(4, dieta.getPesoFinal());
            ps.setBoolean(5, dieta.isEstado());
            ps.setInt(6, dieta.getIdDieta());

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

    public void eliminarDieta(int idDieta) {
        String sql = "DELETE FROM dieta WHERE idDieta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idDieta);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al eliminar Dieta");
        }
    }

    public void anularDieta(int idDieta) {
        String sql = "UPDATE dieta SET estado=0 WHERE idDieta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idDieta);
            int updel = ps.executeUpdate();
            if (updel == 1) {
                System.out.println("se ha eliminado una Dieta");
            } else {
                System.out.println("error al eliminar Dieta");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error SQL al eliminar Dieta");
        }
    }
}

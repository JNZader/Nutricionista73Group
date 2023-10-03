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

    public ArrayList<Dieta> seleccionar() {
        String SQL_SELECT = "SELECT idDieta, nombre, idPaciente, fechaInicio, fechaFin, pesoFinal FROM dieta";
        Dieta dieta = null;
        ArrayList<Dieta> dietaList = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dieta = new Dieta();
                dieta.setNombre(rs.getString("nombre"));
                Paciente p = pd.buscarPaciente(rs.getInt("idpaciente"));
                dieta.setPaciente(p);
                dieta.setFechaInicial(rs.getDate("fechaInicio").toLocalDate());
                dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));

                dietaList.add(dieta); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener Dietas");
        }
        return dietaList; // retorna la lista 
    }

    public Dieta seleccionarPorId(int idDieta) {
        String SQL_SELECT_ID = "SELECT nombre, idPaciente, fechaInicio, fechaFin, pesoFinal FROM dieta WHERE idDieta = ?";
        Dieta dieta = null;

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID)) {
            ps.setInt(1, idDieta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dieta = new Dieta();
                    dieta.setNombre(rs.getString("nombre"));
                    Paciente p = pd.buscarPaciente(rs.getInt("idpaciente"));
                    dieta.setPaciente(p);
                    dieta.setFechaInicial(rs.getDate("fechaInicio").toLocalDate());
                    dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
                    dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                    dieta.setIdDieta(idDieta);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener la Dieta por ID");
        }
        return dieta;
    }

    public void insertar(Dieta dieta) {
        String SQL_INSERT = "INSERT INTO dieta(nombre, idPaciente, fechaInicio, fechaFin, pesoFinal) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(4, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(5, dieta.getPesoFinal());
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
        String SQL_UPDATE = "UPDATE Dieta SET idPaciente = ?, fechaInicio = ?, fechaFin = ?, PesoFin = ? WHERE idDieta = ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {

            ps.setInt(1, dieta.getPaciente().getIdPaciente());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(3, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(4, dieta.getPesoFinal());
            ps.setInt(5, dieta.getIdDieta());

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
}

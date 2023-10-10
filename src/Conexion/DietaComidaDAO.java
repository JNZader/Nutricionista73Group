package Conexion;

import static Conexion.Conexion.getConnection;
import Entidades.Comida;
import Entidades.Dieta;
import Entidades.DietaComida;
import Entidades.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DietaComidaDAO {

    private Connection con;

    public DietaComidaDAO() {
        con = getConnection();
    }

    public void insertar(DietaComida dietacomida) {
        String SQL_INSERT = "INSERT INTO dietacomida (idComida,idDieta, porcion, horario,estado) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, dietacomida.getComida().getIdComida());
            ps.setInt(2, dietacomida.getDieta().getIdDieta());
            ps.setInt(3, dietacomida.getPorcion());
            ps.setString(4, "" + dietacomida.getHorario());
            ps.setBoolean(5, dietacomida.isEstado());

            ps.executeUpdate(); // ejecuta la inserción en la base de datos
            try (ResultSet rs = ps.getGeneratedKeys()) { // obtiene las claves generadas automáticamente
                if (rs.next()) {
                    dietacomida.setId(rs.getInt(1)); // establece el ID generado en el objeto 
                    JOptionPane.showMessageDialog(null, "DietaComida inscripta");
                } else {
                    JOptionPane.showMessageDialog(null, "Inscripcion fallida");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al insertar DietaComida");
        }
    }

    public void actualizar(DietaComida dietaComida) {
        String SQL_UPDATE = "UPDATE dietaComida  SET  porcion = ?, horario = ? WHERE idComida  = ? AND idDieta  = ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, dietaComida.getPorcion());
            ps.setObject(2, dietaComida.getHorario());
            ps.setInt(3, dietaComida.getComida().getIdComida());
            ps.setInt(4, dietaComida.getDieta().getIdDieta());

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

    public void eliminarDietaComida(int idDietaComida) {

        String sql = "UPDATE  dietaComida SET estado = 0 Where idDietaComida = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idDietaComida);

            int on = ps.executeUpdate(); // Ejecuta la actualización en la base de datos
            if (on > 0) {
                JOptionPane.showMessageDialog(null, "DietaComida eliminada!!");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion fallida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al eliminar Dieta");
        }
    }

    public ArrayList<DietaComida> buscar(int estado) {
        String SQL_SELECT = null;

        switch (estado) {
            case 1:
                SQL_SELECT = "SELECT id, idComida, idDieta, porcion, horario FROM dietacomida WHERE estado=1";
                break;
            case 0:
                SQL_SELECT = "SELECT id, idComida, idDieta, porcion, horario FROM dietacomida WHERE estado=0";
                break;
            default:
                SQL_SELECT = "SELECT id, idComida, idDieta, porcion, horario FROM dietacomida";
                break;
        }

        DietaComida dietaComida = null;
        ArrayList<DietaComida> dietaComidaList = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dietaComida = new DietaComida();
                dietaComida.setId(rs.getInt("id"));

                int idComida = rs.getInt("idComida");
                ComidaDAO comidaDAO = new ComidaDAO(); // Debes crear una instancia de ComidaDAO
                Comida comida = comidaDAO.buscar(idComida); // Implementa un método buscarPorId en ComidaDAO
                dietaComida.setComida(comida);

                int idDieta = rs.getInt("idDieta");
                DietaDAO dietaDAO = new DietaDAO(); // Debes crear una instancia de DietaDAO
                Dieta dieta = dietaDAO.buscarPorId(idDieta, 1); // Implementa un método buscarPorId en DietaDAO
                dietaComida.setDieta(dieta);

                dietaComida.setPorcion(rs.getInt("porcion"));
                dietaComida.setHorario(Horario.valueOf(rs.getString("horario")));

                dietaComidaList.add(dietaComida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener DietasComidas");
        }
        return dietaComidaList;
    }

    public DietaComida buscarPorId(int idDietaComida, int estado) {
        String SQL_SELECT_ID = null;
        DietaComida dietaComida = null;

        switch (estado) {
            case 1:
                SQL_SELECT_ID = "SELECT id, idComida, idDieta, porcion, horario FROM dietacomida WHERE id = ? AND estado=1";
                break;
            case 0:
                SQL_SELECT_ID = "SELECT id, idComida, idDieta, porcion, horario FROM dietacomida WHERE id = ? AND estado=0";
                break;
            default:
                SQL_SELECT_ID = "SELECT id, idComida, idDieta, porcion, horario FROM dietacomida WHERE id = ?";
                break;
        }

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID)) {
            ps.setInt(1, idDietaComida);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dietaComida = new DietaComida();
                    dietaComida.setId(idDietaComida);

                    int idComida = rs.getInt("idComida");
                    ComidaDAO comidaDAO = new ComidaDAO();
                    Comida comida = comidaDAO.buscar(idComida);
                    dietaComida.setComida(comida);

                    int idDieta = rs.getInt("idDieta");
                    DietaDAO dietaDAO = new DietaDAO();
                    Dieta dieta = dietaDAO.buscarPorId(idDieta, 1);
                    dietaComida.setDieta(dieta);

                    dietaComida.setPorcion(rs.getInt("porcion"));
                    dietaComida.setHorario(Horario.valueOf(rs.getString("horario")));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener la DietaComida por ID");
        }
        return dietaComida;
    }

}

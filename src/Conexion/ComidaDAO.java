package Conexion;

import static Conexion.Conexion.getConnection;
import Entidades.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ComidaDAO {

    private ComidaDAO cd;
    private Connection con;

    public ComidaDAO() {
        con = getConnection();

    }

    public void insertar(Comida comida) {
        String SQL_INSERT = "INSERT INTO comida(nombre, detalle, cantCalorias, estado) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setBoolean(4, comida.isEstado());
            int insCom = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al insertar comida");
        }
    }

    public void modificar(Comida comida) {
        String SQL_UPDATE = "UPDATE comida SET nombre = ? , detalle = ? , cantCalorias = ? , estado = ? WHERE idComida = ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
           
            
            ps.setInt(1, comida.getIdComida());
            ps.setString(2, comida.getNombre());
            ps.setString(3, comida.getDetalle());
            ps.setInt(4, comida.getCantCalorias());
            ps.setBoolean(5, comida.isEstado());
            
            int mod = ps.executeUpdate();
            
            if (mod > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion realizada");
            } else {
                JOptionPane.showMessageDialog(null, "Modificacion fallida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla comida");

        }

    }

    public void borrarTotal(Comida comida) {
        String SQL_DELETE = "DELETE FROM comida WHERE idComida = ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, comida.getIdComida());
            int del = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al eliminar una comida");

        }

    }
     public void borrar(Comida comida) {
        String SQL_UPDATE = "UPDATE comida SET estado = 0 WHERE idComida = ? ";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, comida.getIdComida());
            int updel = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al eliminar una comida");

        }

    }

    public ArrayList<Comida> listarcomidas() {
        String SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida";
        Comida comida = null;
        ArrayList<Comida> comidaList = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                comida = new Comida();
                comida.setIdComida(rs.getInt("idcomida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantcalorias"));
                comida.setEstado(true);
                comidaList.add(comida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener comidas");
        }
        return comidaList; // retorna la lista 
    }

    public Comida buscarCantCalorias(int cantCalorias) {
        String SQL_SELECT_ID = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida WHERE cantCalorias = ?";
        Comida calorias = null;

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID)) {
            ps.setInt(1, cantCalorias);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    calorias = new Comida();
                    calorias.setIdComida(rs.getInt("idcomida"));
                    calorias.setNombre(rs.getString("nombre"));
                    calorias.setDetalle(rs.getString("detalle"));
                    calorias.setCantCalorias(rs.getInt("cantcalorias"));
                    calorias.setEstado(true);

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al buscar las comidas por calorias");
        }
        return calorias;
    }

}

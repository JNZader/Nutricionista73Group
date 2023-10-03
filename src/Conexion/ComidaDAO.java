package Conexion;

import static Conexion.Conexion.getConnection;
import Entidades.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ComidaDAO {

    private ComidaDAO cd;
    private Connection con;

    public ComidaDAO() {
        con = getConnection();

    }

    public void insertar(Comida comida) {
        String SQL_INSERT = "INSERT INTO comida(nombre, detalle, cantCalorias) VALUES (?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al insertar comida");
        }
    }

    public void modificar(Comida comida) {
        String SQL_UPDATE = "UPDATE comida SET idComida = ?, nombre = ? , detalle = ? , cantCalorias = ? WHERE ?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, comida.getIdComida());
            ps.setString(2, comida.getNombre());
            ps.setString(3, comida.getDetalle());
            ps.setInt(4, comida.getCantCalorias());
            int mod = ps.executeUpdate();
            if (mod > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion realizada");
            } else {
                JOptionPane.showMessageDialog(null, "Modificacion fallida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al modificar comida");

        }

    }
    public void borrar(Comida comida) {
        String SQL_DELETE = "DELETE FROM comida WHERE idComida = ?";
        
        try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, comida.getIdComida());
            int del = ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al eliminar una comida");

        }

    }
}

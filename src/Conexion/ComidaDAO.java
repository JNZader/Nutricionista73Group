package Conexion;

import static Conexion.Conexion.getConnection;
import Entidades.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ComidaDAO {

    private ComidaDAO cd;
    private Connection con;

    public ComidaDAO() {
        con = getConnection();
    }

    public Comida insertar(Comida comida) {
        String SQL_INSERT = "INSERT INTO comida(nombre, detalle, cantCalorias, estado) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setBoolean(4, comida.isEstado());
            int insCom = ps.executeUpdate();
            if (insCom == 1) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        comida.setIdComida(rs.getInt(1));
                        JOptionPane.showMessageDialog(null, "Comida añadida con éxito");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inserción fallida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al insertar comida");
        }
        return comida;
    }

    public void modificar(Comida comida) {
        String SQL_UPDATE = "UPDATE comida SET nombre=?, detalle=?, cantCalorias=?  WHERE idComida=?";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {

            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setInt(4, comida.getIdComida());
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
            if (del == 1) {
                System.out.println("se ha eliminado la comida");
            } else {
                System.out.println("error al eliminar comida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error SQL al eliminar una comida");
        }
    }

    public void borrar(int id) {
        String SQL_UPDATE = "UPDATE comida SET estado = 0 WHERE idComida = ? ";

        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, id);
            int updel = ps.executeUpdate();
            if (updel == 1) {
                System.out.println("se ha eliminado la comida");
            } else {
                System.out.println("error al eliminar comida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error SQL al eliminar una comida");
        }
    }

    public ArrayList<Comida> listarComidas(int estado) {
        String SQL_SELECT = "";
        Comida comida = null;
        ArrayList<Comida> comidaList = new ArrayList<>();

        switch (estado) {
            case 1:
                SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida WHERE estado=1";
                break;
            case 0:
                SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida WHERE estado=0";
                break;
            default:
                SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida";
                break;
        }

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                comida = new Comida();
                comida.setIdComida(rs.getInt("idcomida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantcalorias"));
                comida.setEstado(rs.getBoolean("estado"));

                comidaList.add(comida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener comidas");
        }
        return comidaList; // retorna la lista 
    }

    public List<Comida> buscarXCantCalorias(int cantCalorias, int condicion) {
        String SQL_SELECT = "";
        Comida calorias = null;
        List<Comida> comidas = new ArrayList<>();
        condicion = (condicion > 0) ? 1 : (condicion < 0) ? -1 : 0;

        switch (condicion) {
            case 0:
                SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida WHERE cantCalorias = ? AND estado=1";
            case 1:
                SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida WHERE cantCalorias > ? AND estado=1";
            case -1:
                SQL_SELECT = "SELECT idComida, nombre, detalle, cantCalorias, estado FROM comida WHERE cantCalorias < ? AND estado=1";
        }

        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
            ps.setInt(1, cantCalorias);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    calorias = new Comida();
                    calorias.setIdComida(rs.getInt("idcomida"));
                    calorias.setNombre(rs.getString("nombre"));
                    calorias.setDetalle(rs.getString("detalle"));
                    calorias.setCantCalorias(rs.getInt("cantcalorias"));
                    calorias.setEstado(true);

                    comidas.add(calorias);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al buscar las comidas por calorias");
        }
        return comidas;
    }

    Comida buscar(int idComida, int estado) {
        String SQL_SELECT_ID = "";
        Comida comida = null;

        switch (estado) {
            case 1:
                SQL_SELECT_ID = "SELECT * FROM comida WHERE idComida = ? AND estado=1";
                break;
            case 0:
                SQL_SELECT_ID = "SELECT * FROM comida WHERE idComida = ? AND estado=0";
                break;
            default:
                SQL_SELECT_ID = "SELECT * FROM comida WHERE idComida = ?";
                break;
        }
        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID)) {
            ps.setInt(1, idComida);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comida = new Comida();
                    comida.setIdComida(rs.getInt("idcomida"));
                    comida.setNombre(rs.getString("nombre"));
                    comida.setDetalle(rs.getString("detalle"));
                    comida.setCantCalorias(rs.getInt("cantcalorias"));
                    comida.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener la Dieta por ID");
        }
        return comida;
    }

    public Comida buscarPorNombre(String nombre, int estado) {
        String SQL_SELECT_NOMBRE = "";
        Comida comida = null;

        switch (estado) {
            case 1:
                SQL_SELECT_NOMBRE = "SELECT * FROM comida WHERE nombre = ? AND estado = 1";
                break;
            case 0:
                SQL_SELECT_NOMBRE = "SELECT * FROM comida WHERE nombre = ? AND estado = 0";
                break;
            default:
                SQL_SELECT_NOMBRE = "SELECT * FROM comida WHERE nombre = ?";
                break;
        }
        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_NOMBRE)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comida = new Comida();
                    comida.setIdComida(rs.getInt("idcomida"));
                    comida.setNombre(rs.getString("nombre"));
                    comida.setDetalle(rs.getString("detalle"));
                    comida.setCantCalorias(rs.getInt("cantcalorias"));
                    comida.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al obtener la comida por nombre");
        }
        return comida;
    }

}

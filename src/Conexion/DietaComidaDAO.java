package Conexion;

import static Conexion.Conexion.getConnection;
import Entidades.DietaComida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DietaComidaDAO {
   
    
    private Connection con;

    public DietaComidaDAO(  ) {
        con = getConnection( );
    }
    public void insertar(DietaComida dietacomida) {
        String SQL_INSERT = "INSERT INTO dieta(idDietacomida, idComida,idDieta, porcion, horario,estado) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, dietacomida.getId());
            ps.setInt(2, dietacomida.getComida().getIdComida());
             ps.setInt(3, dietacomida.getDieta().getIdDieta());
             ps.setInt(4, dietacomida.getPorcion());
              ps.setObject(5,dietacomida.getHorario());
              ps.setBoolean(6,dietacomida.isEstado() );

            
            
           
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

            
            
            ps.setInt(1, dietaComida.getPorcion()) ;
            ps.setObject(2, dietaComida.getHorario());
            ps.setInt(3, dietaComida.getComida().getIdComida()) ;
            ps.setInt(4, dietaComida.getDieta().getIdDieta()) ;
            
            
            

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
}

    


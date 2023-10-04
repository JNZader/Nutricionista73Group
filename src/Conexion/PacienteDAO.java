package Conexion;

import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteDAO {

    private Connection con;

    public PacienteDAO() {
        con = Conexion.getConnection();
    }

    public void guardarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombreCompleto,DNI,celular,pesoActual) VALUES(?,?,?,?)";
//        int dniAumno = alumno.getDni();
//        if (buscarAlumnoPorDni(dniAumno,0) != null) {
//            JOptionPane.showMessageDialog(null, "No se puede añadir el Alumno porque ya hay uno registrado con ese DNI");
//            return;
//        }

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setInt(3, paciente.getTelefono());
            ps.setDouble(4, paciente.getPesoActual());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 1) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        paciente.setIdPaciente(rs.getInt(6));
                        JOptionPane.showMessageDialog(null, "Paciente añadido con éxito");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al añadir el paciente. No se realizaron cambios en la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente");
        }
    }

    public void modificarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nombreCompleto=?,DNI=?,domicilio=?,celular=?,pesoActual=? WHERE idPaciente=? ";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setInt(4, paciente.getTelefono());
            ps.setDouble(5, paciente.getPesoActual());

            // Verificación del resultado de la ejecución
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente ");
        }
    }//REVISAR

    public void eliminarPaciente(int id) {
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            // Verificación del resultado de la ejecución
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el paciente.");
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla paciente");
        }
    }

    public ArrayList<Paciente> listarAlumnos() {
        String sql = "SELECT * FROM paciente ";
        ArrayList<Paciente> pacientes = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            // iterar a través de los resultados
            while (rs.next()) {

                Paciente paciente = new Paciente();

                // setea los atributos del alumno
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getInt("celular"));
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setPesoActual(rs.getDouble("pesoActual"));
                pacientes.add(paciente);// Agregar el alumno a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla paciente ");
        }
        return pacientes;
    }

    public Paciente buscarPacientePorDni(int dni, int jop) {
        String sql = "SELECT nombreCompleto,DNI,nombreCompleto,domicilio,telefono,pesoActual,idPaciente FROM paciente WHERE dni=? ";
        Paciente paciente = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);//asigna el valor del parametro dni a la consulta sql

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setIdPaciente(rs.getInt("idPaciente"));
                    paciente.setDni(dni);
                    paciente.setNombre(rs.getString("nombreCompleto"));
                    paciente.setDomicilio(rs.getString("domicilio"));
                    paciente.setTelefono(rs.getInt("celular"));
                    paciente.setPesoActual(rs.getDouble("pesoActual"));

                } else {
                    if (jop == 1) {//agregamos parametro para elegir si muestro o no el JOptionPane
                        JOptionPane.showMessageDialog(null, "No existe el paciente");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al acceder la tabla paciente");
        }

        return paciente;
    }

    public Paciente buscarPaciente(int id) {
        String sql = "SELECT nombreCompleto,DNI,nombreCompleto,domicilio,telefono,pesoActual,idPaciente FROM paciente WHERE idPaciente=? ";
        Paciente paciente = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);//asigna el valor del parametro dni a la consulta sql

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setIdPaciente(rs.getInt("idPaciente"));
                    paciente.setDni(rs.getInt("DNI"));
                    paciente.setNombre(rs.getString("nombreCompleto"));
                    paciente.setDomicilio(rs.getString("domicilio"));
                    paciente.setTelefono(rs.getInt("celular"));
                    paciente.setPesoActual(rs.getDouble("pesoActual"));

                } else {
                    JOptionPane.showMessageDialog(null, "No existe el paciente");

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al acceder la tabla paciente");
        }

        return paciente;

    }
}

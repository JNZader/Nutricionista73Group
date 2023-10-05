package nutricionista73group;

import Conexion.DietaComidaDAO;
import Conexion.DietaDAO;
import Conexion.PacienteDAO;
import Entidades.Comida;
import Entidades.Dieta;
import Entidades.DietaComida;
import Entidades.Paciente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nutricionista73Group {

    public static void main(String[] args) {
        PacienteDAO pdao = new PacienteDAO();
        Paciente p1=new Paciente("Juan Lencina", 213700255, "Av siempre viva 1234", 353749800, 150.5);
        pdao.guardarPaciente(p1);
        Dieta d1=new Dieta("Mediterranea", p1, LocalDate.parse("2023/09/22",DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse("2023/12/30",DateTimeFormatter.ofPattern("yyyy/MM/dd")), 120.5);
        
        System.out.println(p1.getIdPaciente());
        
        

        DietaDAO ddao=new DietaDAO();
        ddao.insertar(d1);
        
    }
    DietaComidaDAO die = new DietaComidaDAO () ;
    Comida comi = new Comida (  );
    Dieta d1 = Dieta ( )
    
}

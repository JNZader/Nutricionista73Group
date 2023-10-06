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
        Paciente p1=new Paciente("Juan Lencina Rosendo", 213700255, "Av siempre viva 1234", 353749800,11, 150.5,true);
        //guardar paciente
        //pdao.guardarPaciente(p1);
        //Dieta d1=new Dieta("Mediterranea", p1, LocalDate.parse("2023/09/22",DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse("2023/12/30",DateTimeFormatter.ofPattern("yyyy/MM/dd")), 120.5);
        
        //modificar paciente
        //pdao.modificarPaciente(p1);
        
        //buscar paciente
        //System.out.println(pdao.buscarPaciente(1));
        


        DietaDAO ddao=new DietaDAO();
//        ddao.insertar(d1);
        

        //buscar paciente por dni
        System.out.println("paciente encontrado por dni "+pdao.buscarPacientePorDni(32600500));
        
        //eliminar paciente
        //pdao.eliminarPacienteLogico(1);
        
        //listar paciente
        System.out.println(pdao.listarPaciente());
        //DietaDAO ddao=new DietaDAO();
        
        //ddao.insertar(d1);

    }
    DietaComidaDAO die = new DietaComidaDAO () ;
    Comida comi = new Comida (  );
//    Dieta d1 = Dieta ( )
    
}

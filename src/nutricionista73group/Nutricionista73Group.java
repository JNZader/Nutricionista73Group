package nutricionista73group;

import Conexion.DietaDAO;
import Entidades.Dieta;
import Entidades.Paciente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nutricionista73Group {

    public static void main(String[] args) {
        
        Paciente p1=new Paciente("Juan Perez", 32600500, "Av siempre viva 1234", 353749800, 150.5);
        Dieta d1=new Dieta("Mediterranea", p1, LocalDate.parse("2023/09/22",DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse("2023/12/30",DateTimeFormatter.ofPattern("yyyy/MM/dd")), 120.5);
        
        

//        DietaDAO ddao=new DietaDAO();
//        ddao.insertar(d1);
    }
    
}

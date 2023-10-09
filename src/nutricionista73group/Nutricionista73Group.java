package nutricionista73group;

import Conexion.ComidaDAO;
import Conexion.DietaComidaDAO;
import Conexion.DietaDAO;
import Conexion.PacienteDAO;
import Entidades.Comida;
import Entidades.Dieta;
import Entidades.DietaComida;
import Entidades.Horario;
import Entidades.Paciente;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Nutricionista73Group {

    public static void main(String[] args) {

/*     |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|
       |                      Prueba Crud clase Comida                   |
       |                                                                 |
       |_________________________________________________________________|         */
        //probando comidaDAO
//        ComidaDAO comiDao = new ComidaDAO();
//        Comida comi = new Comida(6, 1650, "lomito", "con papas", true);
//        System.out.println("comi = " + comi);
//        //insertar
//        comi = comiDao.insertar(comi);
//        System.out.println("comi = " + comi);

        //modificar
//        Comida comi2 = new Comida(6, 1650, "lomito", "con papas", true);
//        comiDao.modificar(comi2);
        //listar comidas
        //System.out.println(comiDao.listarcomidas());
        //buscar cantidad calorias
        //System.out.println("la comida que se busco por calorias es: "+comiDao.buscarXCantCalorias(10000) );
        //borrado logico
//        comiDao.borrar(3);
//        DietaComidaDAO die = new DietaComidaDAO();
//        Dieta d1 = new Dieta(" Vegetarianismo ", p1, LocalDate.parse("2023/09/22", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse("2023/10/05", DateTimeFormatter.ofPattern("yyyy/MM/dd")), 80.5);
//        Comida comiRocio = new Comida(200, "milanesa", "con papas frita", true);
//        DietaComida dietC = new DietaComida(comiRocio, d1, 500, Horario.ALMUERZO, true);
//        die.insertar(dietC);  
/*     |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|
       |                      Prueba Crud clase Paciente                 |
       |                                                                 |
       |_________________________________________________________________|         */

 /* 
        PacienteDAO pdao = new PacienteDAO();
        Paciente p1=new Paciente("Juan Lencina Rosendo", 213700255, "Av siempre viva 1234", 353749800,11, 150.5,true);
        guardar paciente
        pdao.guardarPaciente(p1);
        Dieta d1=new Dieta("Mediterranea", p1, LocalDate.parse("2023/09/22",DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse("2023/12/30",DateTimeFormatter.ofPattern("yyyy/MM/dd")), 120.5);
        
        modificar paciente
        pdao.modificarPaciente(p1);
        
        buscar paciente
        System.out.println(pdao.buscarPaciente(1));
        


        DietaDAO ddao=new DietaDAO();
        ddao.insertar(d1);
        

        buscar paciente por dni


        System.out.println("paciente encontrado por dni "+pdao.buscarPacientePorDni(32600500));
        

        System.out.println("paciente encontrado por dni "+pdao.buscarPacientePorDni(32600500));
        


        System.out.println("paciente encontrado por dni "+pdao.buscarPacientePorDni(32600500));
        


        eliminar paciente
        pdao.eliminarPacienteLogico(1);
        
        listar paciente



        System.out.println(pdao.listarPaciente());
         */
/*     |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|
       |                      Prueba Crud clase Consulta                 |
       |                                                                 |
       |_________________________________________________________________|         */
 /*    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|
       |                      Prueba Crud clase Dieta                    |
       |                                                                 |
       |_________________________________________________________________|         */
 /*    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|
       |                      Prueba Crud clase DietaComida              |
       |                                                                 |
       |_________________________________________________________________|         */

        
//   DietaComidaDAO die = new DietaComidaDAO();
//        //Dieta d1 = new Dieta(" Vegetarianismo ", p1, LocalDate.parse("2023/09/22", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse("2023/10/05", DateTimeFormatter.ofPattern("yyyy/MM/dd")), 80.5);
//        DietaDAO dieDao = new DietaDAO();
//        Dieta d1 = new Dieta(11,"de la luna", p1, LocalDate.of(2023, Month.NOVEMBER, 02), LocalDate.of(2023, Month.NOVEMBER, 04), 150,true);
//        //dieDao.insertar(d1);
//        Comida comiRocio = new Comida(4,200, "milanesa a la napolitana ", "con papas frita", true);
//        //comiDao.insertar(comiRocio);
//        DietaComida dietC = new DietaComida(comiRocio, d1, 500, Horario.ALMUERZO, true);
//        die.insertar(dietC);
 
    }
}

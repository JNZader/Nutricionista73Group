package Entidades;


public class Paciente {
   String nombre;
   int dni;
   String domicilio;
   int telefono;
   int idPaciente;
   double pesoActual;
   boolean estado;

   
   
    public Paciente(){
    
    }

    public Paciente(String nombre, int dni, String domicilio, int telefono, int idPaciente,double pesoActual,boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.idPaciente = idPaciente;
        this.pesoActual=pesoActual;
        this.estado = estado;
    }

    public Paciente(String nombre, int dni, String domicilio, int telefono,double pesoActual,boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.pesoActual=pesoActual;
        this.estado=estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
     @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", dni=" + dni + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
    
    
    
   
    
   
}

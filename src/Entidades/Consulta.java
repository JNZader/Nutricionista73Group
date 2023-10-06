package Entidades;

import java.time.LocalDate;

public class Consulta {

    private int idConsulta;
    private int idPaciente;
    private LocalDate fecha;
    private double pesoActual;

    public Consulta() {
    }

    public Consulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Consulta(int idPaciente, LocalDate fecha, double pesoActual) {
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.pesoActual = pesoActual;
    }

    public Consulta(int idConsulta, int idPaciente, LocalDate fecha, double pesoActual) {
        this.idConsulta = idConsulta;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.pesoActual = pesoActual;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", idPaciente=" + idPaciente + ", fecha=" + fecha + ", pesoActual=" + pesoActual + '}';
    }
    
    
}

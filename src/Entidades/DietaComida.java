package Entidades;

public class DietaComida {
    private int idDietaComida;
    private int idComida;
    private int idDieta;
    private int porcion ;
    private String horario ;

    public DietaComida(int idComida, int idDieta, int porcion, String horario) {
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.porcion = porcion;
        this.horario = horario;
    }

    public DietaComida(int idDietaComida, int idComida, int idDieta, int porcion, String horario) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
        this.porcion = porcion;
        this.horario = horario;
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public int getPorcion() {
        return porcion;
    }

    public void setPorcion(int porcion) {
        this.porcion = porcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "DietaComida{" + "idDietaComida=" + idDietaComida + ", idComida=" + idComida + ", idDieta=" + idDieta + ", porcion=" + porcion + ", horario=" + horario + '}';
    }
    
    
}

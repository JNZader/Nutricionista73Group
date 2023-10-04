package Entidades;

public class DietaComida {
    private int id;
    private Comida comida;
    private Dieta dieta;
    private int porcion ;
    private Horario horario ;

    public DietaComida() {
    }

    public DietaComida(Comida comida, Dieta dieta, int porcion, Horario horario) {
        this.comida = comida;
        this.dieta = dieta;
        this.porcion = porcion;
        this.horario = horario;
    }

    public DietaComida(int id, Comida comida, Dieta dieta, int porcion, Horario horario) {
        this.id = id;
        this.comida = comida;
        this.dieta = dieta;
        this.porcion = porcion;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public int getPorcion() {
        return porcion;
    }

    public void setPorcion(int porcion) {
        this.porcion = porcion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "DietaComida{" + "id=" + id + ", comida=" + comida + ", dieta=" + dieta + ", porcion=" + porcion + ", horario=" + horario + '}';
    }
    
}

    
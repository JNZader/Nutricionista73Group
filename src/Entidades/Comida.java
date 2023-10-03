package Entidades;

public class Comida {
    private int idComida;
    private int cantCalorias;
    private String nombre, detalle;

    public Comida() {
    }

    public Comida(int idComida, int cantCalorias, String nombre, String detalle) {
        this.idComida = idComida;
        this.cantCalorias = cantCalorias;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public Comida(int cantCalorias, String nombre, String detalle) {
        this.cantCalorias = cantCalorias;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Comida{" + "cantCalorias=" + cantCalorias + ", nombre=" + nombre + ", detalle=" + detalle + '}';
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}

package cl.tdb.voluntariadodb.models;

public class Institucion {
    private Interger id;
    private String nombre;
    private String descripcion;

    public Interger getId() {
        return id;
    }

    public void setId(Interger id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
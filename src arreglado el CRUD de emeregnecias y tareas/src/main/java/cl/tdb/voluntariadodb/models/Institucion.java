package cl.tdb.voluntariadodb.models;

public class Institucion {
    private int id_institucion;
    private String nombre_institucion;
    private String descripcion_institucion;

    public int getId() {
        return id_institucion;
    }

    public void setId(int id) {
        this.id_institucion = id;
    }

    public String getNombre() {
        return nombre_institucion;
    }

    public void setNombre(String nombre) {
        this.nombre_institucion = nombre;
    }
    public String getDescripcion() {
        return descripcion_institucion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion_institucion = descripcion;
    }


}
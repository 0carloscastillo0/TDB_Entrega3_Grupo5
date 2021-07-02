package cl.tdb.voluntariadodb.models;

public class Estado_Tarea {
    private int id_estado_tarea;
    private String descripcion;

    public int getId() {
        return id_estado_tarea;
    }

    public void setId(int id) {
        this.id_estado_tarea = id;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
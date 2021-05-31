package cl.tdb.voluntariadodb.models;

public class Emergencia {
    private int id_emergencia;
    private String nombre_emergencia;
    private String descripcion_emergencia;
    private int id_institucion;

    //Getter de emergencia
    public int getId_emergencia(){
        return id_emergencia;
    }
    public String getNombre_emergencia(){
        return nombre_emergencia;
    }
    public String getDescripcion_emergencia(){
        return descripcion_emergencia;
    }
    public int getId_institucion(){
        return id_institucion;
    }
    //Setter de emergencia
    public void setId_emergencia(int id_emergencia){
        this.id_emergencia = id_emergencia;
    }
    public void setNombre_emergencia(String nombre_emergencia){
        this.nombre_emergencia = nombre_emergencia;
    }
    public void setDescripcion_emergencia(String descripcion_emergencia){
        this.descripcion_emergencia = descripcion_emergencia;
    }
    public void setId_institucion(int id_institucion){
        this.id_institucion = id_institucion;
    }
}
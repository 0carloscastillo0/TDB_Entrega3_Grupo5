package cl.tdb.voluntariadodb.models;

public class Emergencia {
    private Integer id_emergencia;
    private String nombre_emergencia;
    private String descripcion_emergencia;
    private Integer id_institucion;

    //Getter de emergencia
    public Integer getId_emergencia(){
        return id_emergencia;
    }
    public String getNombre_emergencia(){
        return nombre_emergencia;
    }
    public String getDescripcion_emergencia(){
        return descripcion_emergencia;
    }
    public Interger getId_institucion(){
        return id_institucion;
    }
    //Setter de emergencia
    public void setId_emergencia(Integer id_emergencia){
        this.id_emergencia = id_emergencia;
    }
    public void setNombre_emergencia(String nombre_emergencia){
        this.nombre_emergencia = nombre_emergencia;
    }
    public void setDescripcion_emergencia(String descripcion_emergencia){
        this.descripcion_emergencia = descripcion_emergencia;
    }
    public void setId_institucion(Integer id_institucion){
        this.id_institucion = id_institucion;
    }
}
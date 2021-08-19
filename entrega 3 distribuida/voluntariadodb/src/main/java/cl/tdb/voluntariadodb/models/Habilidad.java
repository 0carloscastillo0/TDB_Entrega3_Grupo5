package cl.tdb.voluntariadodb.models;

public class Habilidad {
    private int id_habilidad;
    private String nombre_habilidad;
    private String descripcion_habilidad;
    private int valoracion_habilidad;


    //Getter de habilidad
    public int getId_habilidad(){
        return id_habilidad;
    }
    public String getNombre_habilidad(){
        return nombre_habilidad;
    }
    public String getDescripcion_habilidad(){
        return descripcion_habilidad;
    }
    public int getValoracion_habilidad(){
        return valoracion_habilidad;
    }

    //Setter de habilidad
    public void setId_habilidad(int id_habilidad){
        this.id_habilidad = id_habilidad;
    }
    public void setNombre_habilidad(String nombre_habilidad){
        this.nombre_habilidad = nombre_habilidad;
    }
    public void setDescripcion_habilidad(String descripcion_habilidad){
        this.descripcion_habilidad = descripcion_habilidad;
    }
    public void setValoracion_habilidad(int valoracion_habilidad){
        this.valoracion_habilidad = valoracion_habilidad;
    }

}
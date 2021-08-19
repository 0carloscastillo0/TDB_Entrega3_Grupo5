package cl.tdb.voluntariadodb.models;

public class Eme_Habilidad {
    private int id_eme_habilidad;
    private int id_habilidad;
    private int id_emergencia;
    private String nombre_tabla;

    //Getter de habilidad
    public int getId_habilidad(){
        return id_habilidad;
    }
    public int getId_emergencia(){
        return id_emergencia;
    }
    public int getId_eme_habilidad(){
        return id_eme_habilidad;
    }
    public String getNombre_tabla(){
        return nombre_tabla;
    }

   
    //Setter de habilidad
    public void setId_habilidad(int id_habilidad){
        this.id_habilidad = id_habilidad;
    }
    public void setId_emergencia(int id_emergencia){
        this.id_emergencia = id_emergencia;
    }
    public void setId_eme_habilidad(int id_eme_habilidad){
        this.id_eme_habilidad = id_eme_habilidad;
    }
    public void setNombre_tabla(String nombre){
        this.nombre_tabla=nombre;
    }
 

}
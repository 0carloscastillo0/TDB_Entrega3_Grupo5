package cl.tdb.voluntariadodb.models;

public class Tarea_Habilidad {
    private int id_tarea_habilidad;
    private int id_habilidad;
    private int id_tarea;

    //Getter de habilidad
    public int getId_habilidad(){
        return id_habilidad;
    }
    public int getId_tarea(){
        return id_tarea;
    }
    public int getId_tarea_habilidad(){
        return id_tarea_habilidad;
    }
   
    //Setter de habilidad
    public void setId_habilidad(int id_habilidad){
        this.id_habilidad = id_habilidad;
    }
    public void setId_tarea(int id_tarea){
        this.id_tarea = id_tarea;
    }
    public void setId_tarea_habilidad(int id_tarea_habilidad){
        this.id_tarea_habilidad = id_tarea_habilidad;
    }

}
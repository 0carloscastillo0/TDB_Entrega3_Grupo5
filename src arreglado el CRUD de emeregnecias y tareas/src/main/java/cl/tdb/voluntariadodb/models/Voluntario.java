package cl.tdb.voluntariadodb.models;

public class Voluntario {
    private int id_voluntario;
    private String nombre_voluntario;
    private boolean disponibilidad_voluntario;
    private String fnacimiento_voluntario;

    //Getter de voluntario
    public int getId_voluntario(){
        return id_voluntario;
    }
    public String getNombre_voluntario(){
        return nombre_voluntario;
    }
    public boolean getDisponibilidad(){
        return disponibilidad_voluntario;
    }
    public String getFnacimiento(){
        return fnacimiento_voluntario;
    }
   
    //Setter de voluntario
    public void setId_voluntario(int id_voluntario){
        this.id_voluntario = id_voluntario;
    }
    public void setNombre_voluntario(String nombre_voluntario){
        this.nombre_voluntario = nombre_voluntario;
    }
    public void setDisponibilidad(boolean disponibilidad_voluntario){
        this.disponibilidad_voluntario = disponibilidad_voluntario;
    }
    public void setFnacimiento(String fnacimiento_voluntario){
        this.fnacimiento_voluntario = fnacimiento_voluntario;
    }
  
}

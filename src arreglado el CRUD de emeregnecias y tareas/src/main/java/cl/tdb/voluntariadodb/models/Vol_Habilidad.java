package cl.tdb.voluntariadodb.models;

public class Vol_Habilidad {
    private int id_vol_habilidad;
    private int id_habilidad;
    private int id_voluntario;

    //Getter de habilidad
    public int getId_habilidad(){
        return id_habilidad;
    }
    public int getId_voluntario(){
        return id_voluntario;
    }
    public int getId_vol_habilidad(){
        return id_vol_habilidad;
    }
   
    //Setter de habilidad
    public void setId_habilidad(int id_habilidad){
        this.id_habilidad = id_habilidad;
    }
    public void setId_voluntario(int id_voluntario){
        this.id_voluntario = id_voluntario;
    }
    public void setId_vol_habilidad(int id_vol_habilidad){
        this.id_vol_habilidad = id_vol_habilidad;
    }

}
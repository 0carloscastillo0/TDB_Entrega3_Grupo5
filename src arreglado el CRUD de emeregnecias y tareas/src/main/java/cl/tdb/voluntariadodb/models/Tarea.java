package cl.tdb.voluntariadodb.models;

import org.postgis.Point;
public class Tarea {
    private int id_tarea;
    private String descripcion_tarea;
    private String nombre_tarea;
    private int cant_vol_requeridos;
    private int cant_vol_inscritos;
    private String inicio;
    private String fin;
    private int id_estado;
    private int id_emergencia;
    private double longitud_tarea;
    private double latitud_tarea;

    //Getter de tarea
    public int getId_tarea(){
        return id_tarea;
    }
    public String getDescripcion_tarea(){
        return descripcion_tarea;
    }
    public String getNombre_tarea() {
        return nombre_tarea;
    }
    public int getCant_vol_requeridos(){
        return cant_vol_requeridos;
    }
    public int getCant_vol_inscritos(){
        return cant_vol_inscritos;
    }
    public String getInicio(){
        return inicio;
    }
    public String getFin() {
        return fin;
    }
    public int getId_estado() {
        return id_estado;
    }
    public int getId_emergencia() {
        return id_emergencia;
    }
    public double getLongitud_tarea(){
        return longitud_tarea;
    }
    public double getLatitud_tarea(){
        return latitud_tarea;
    }

    //Setter de tarea
    public void setId_tarea(int id_tarea){
        this.id_tarea = id_tarea;
    }
    public void setDescripcion_tarea(String descripcion_tarea){
        this.descripcion_tarea= descripcion_tarea;
    }
    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }
    public void setCant_vol_requeridos(int cant_vol_requeridos){
        this.cant_vol_requeridos = cant_vol_requeridos;
    }
    public void setCant_vol_inscritos(int cant_vol_inscritos){
        this.cant_vol_inscritos = cant_vol_inscritos;
    }
    public void setInicio(String inicio){
        this.inicio = inicio;
    }
    public void setFin(String fin) {
        this.fin = fin;
    }
    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    public void setId_emergencia(int id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    public void setLongitud_tarea(){
        this.longitud_tarea = longitud_tarea;
    }
    public void setLatitud_tarea(){
        this.latitud_tarea = latitud_tarea;
    }

}
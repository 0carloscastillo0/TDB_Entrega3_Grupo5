package cl.tdb.voluntariadodb.models;

import org.postgis.Point;

public class Emergencia {
    private int id_emergencia;
    private String nombre_emergencia;
    private String descripcion_emergencia;
    private int estado_emergencia;
    private int id_institucion;
    private double longitud_emergencia;
    private double latitud_emergencia;
    private Point location;

    //Getter de emergencia
    public int getId_emergencia(){
        return id_emergencia;
    }
    public double getLongitud_emergencia(){
        return longitud_emergencia;
    }
    public double getLatitud_emergencia(){
        return latitud_emergencia;
    }
    public String getNombre_emergencia(){
        return nombre_emergencia;
    }
    public String getDescripcion_emergencia(){
        return descripcion_emergencia;
    }
    public int getEstado_emergencia(){
        return estado_emergencia;
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
    public void setEstado_emergencia(int estado_emergencia){
        this.estado_emergencia = estado_emergencia;
    }
    public void setId_institucion(int id_institucion){
        this.id_institucion = id_institucion;
    }
    public void setLongitud_emergencia(){
        this.longitud_emergencia = longitud_emergencia;
    }
    public void setLatitud_emergencia(){
        this.latitud_emergencia = latitud_emergencia;
    }
}
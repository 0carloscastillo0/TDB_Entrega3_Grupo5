package cl.tdb.voluntariadodb.models;

public class Log_Emergencia {
    private int id_log;
    private int id_emergencia;
    private String nombre_usuario;

    public int getIdLog() {
        return id_log;
    }
    public void setIdLog(int id_log) {
        this.id_log = id_log;
    }
    public int getIdEmergencia() {
        return id_emergencia;
    }
    public void setIdTarea(int id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
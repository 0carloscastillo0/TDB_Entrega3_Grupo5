package cl.tdb.voluntariadodb.models;

public class Log_Tarea {
    private int id_log;
    private int id_tarea;
    private String nombre_usuario;

    public int getIdLog() {
        return id_log;
    }
    public void setIdLog(int id_log) {
        this.id_log = id_log;
    }
    public int getIdTarea() {
        return id_tarea;
    }
    public void setIdTarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
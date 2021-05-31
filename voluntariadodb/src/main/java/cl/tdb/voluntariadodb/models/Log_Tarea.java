package cl.tdb.voluntariadodb.models;

public class Log_Tarea {
    private Interger id_log;
    private Interger id_tarea;
    private String nombre_usuario;

    public Interger getIdLog() {
        return id_log;
    }
    public void setIdLog(Interger id_log) {
        this.id_log = id_log;
    }
    public Interger getIdTarea() {
        return id_tarea;
    }
    public void setIdTarea(Interger id_tarea) {
        this.id_tarea = id_tarea;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
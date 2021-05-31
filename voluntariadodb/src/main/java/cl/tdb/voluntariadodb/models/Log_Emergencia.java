package cl.tdb.voluntariadodb.models;

public class Log_Emergencia {
    private Interger id_log;
    private Interger id_emergencia;
    private String nombre_usuario;

    public Interger getIdLog() {
        return id_log;
    }
    public void setIdLog(Interger id_log) {
        this.id_log = id_log;
    }
    public Interger getIdEmergencia() {
        return id_emergencia;
    }
    public void setIdTarea(Interger id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
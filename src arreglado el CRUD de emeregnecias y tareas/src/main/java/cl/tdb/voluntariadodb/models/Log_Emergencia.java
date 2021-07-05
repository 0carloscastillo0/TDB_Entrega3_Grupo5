package cl.tdb.voluntariadodb.models;

public class Log_Emergencia {
    private int id_log_emergencia;
    private int id_emergencia;
    private String nombre_coordinador;
    private String accion;
    private String time_stamp;

    public int getIdLogEmergencia() {
        return id_log_emergencia;
    }
    public void setIdLogEmergencia(int id_log) {
        this.id_log_emergencia = id_log_emergencia;
    }

    public int getIdEmergencia() {
        return id_emergencia;
    }
    public void setIdEmergencia(int id_emergencia){
        this.id_emergencia = id_emergencia;
    }

    public String getNombreCoordinador() {
        return nombre_coordinador;
    }
    public void setNombreCoordinador(String nombre_coordinador){
        this.nombre_coordinador = nombre_coordinador;
    }

    public String getAccion(){
        return accion;
    }
    public void setAccion(String accion){
        this.accion = accion;
    }

    public String getTimeStamp(){
        return time_stamp;
    }
    public void setTimeStamp(String time_stamp){
        this.time_stamp = time_stamp;
    }

}
package cl.tdb.voluntariadodb.models;

public class Log_Tarea {
    private int id_log_tarea;
    private int id_tarea;
    private String nombre_coordinador;
    private String accion;
    private String time_stamp;

    public int getIdLogTarea() {
        return id_log_tarea;
    }
    public void setIdLog(int id_log_tarea) {
        this.id_log = id_log_tarea;
    }

    public int getIdTarea() {
        return id_tarea;
    }
    public void setIdTarea(int id_tarea) {
        this.id_tarea = id_tarea;
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
package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Log_Tarea;

import java.util.List;

public interface LogTareaRepository {
    public void crear(int idTarea, String nombreCoordinador, String accionRealizada);
    public String update(Log_Tarea log_tarea, int id);
    public List<Log_Tarea> getAll();
    public List<Log_Tarea> show(int id);
    public void delete(int id);
}
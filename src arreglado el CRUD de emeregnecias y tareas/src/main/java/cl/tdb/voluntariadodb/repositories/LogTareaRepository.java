package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Log_Tarea;

import java.util.List;

public interface LogTareaRepository {
    public Log_Tarea crear(Log_Tarea log_tarea);
    public String update(Log_Tarea log_tarea, int id);
    public List<Log_Tarea> getAll();
    public List<Log_Tarea> show(int id);
    public void delete(int id);
}
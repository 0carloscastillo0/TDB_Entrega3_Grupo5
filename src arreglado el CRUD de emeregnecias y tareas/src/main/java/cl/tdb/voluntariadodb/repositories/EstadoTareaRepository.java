package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Estado_Tarea;

import java.util.List;

public interface EstadoTareaRepository {
    public Estado_Tarea crear(Estado_Tarea estado_tarea);
    public String update(Estado_Tarea estado_tarea, int id);
    public List<Estado_Tarea> getAll();
    public List<Estado_Tarea> show(int id);
    public void delete(int id);
}
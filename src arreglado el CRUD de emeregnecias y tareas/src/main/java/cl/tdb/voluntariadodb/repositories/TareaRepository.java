package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Tarea;
import java.util.List;

public interface TareaRepository {
    public Tarea crear(Tarea tarea);
    public String update(Tarea tarea, int id);
    public List<Tarea> getAll();
    public List<Tarea> show(int id);
    public void delete(int id);
    public List<Tarea> tareas(int id_emergencia);
}


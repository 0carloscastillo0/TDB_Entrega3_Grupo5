package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Tarea;

public interface TareaRepository {
    public Tarea crearTarea(Tarea tarea);
    public String updateTarea(int nuevoNumeroTarea, Tarea tarea);
    public List<Tarea> getAllTareas();
    public Tarea Show(int id);
}


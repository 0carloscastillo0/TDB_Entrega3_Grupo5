package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Tarea_Habilidad;

import java.util.List;

public interface TareaHabilidadRepository {
    public Tarea_Habilidad crear(Tarea_Habilidad tarea_habilidad);
    public String update(Tarea_Habilidad tarea_habilidad, int id);
    public List<Tarea_Habilidad> getAll();
    public List<Tarea_Habilidad> show(int id);
    public void delete(int id);
}
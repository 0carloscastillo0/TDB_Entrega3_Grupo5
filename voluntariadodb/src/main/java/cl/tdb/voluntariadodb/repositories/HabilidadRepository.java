package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Habilidad;

import java.util.List;

public interface HabilidadRepository {
    public Habilidad crear(Habilidad habilidad);
    public String update(Habilidad habilidad, int id);
    public List<Habilidad> getAll();
    public List<Habilidad> show(int id);
    public void delete(int id);
}
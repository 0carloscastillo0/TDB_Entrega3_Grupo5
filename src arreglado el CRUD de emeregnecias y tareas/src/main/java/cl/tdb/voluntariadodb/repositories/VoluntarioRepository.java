package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public Voluntario crear(Voluntario voluntario);
    public String update(Voluntario voluntario, int id);
    public List<Voluntario> getAll();
    public List<Voluntario> show(int id);
    public void delete(int id);
}
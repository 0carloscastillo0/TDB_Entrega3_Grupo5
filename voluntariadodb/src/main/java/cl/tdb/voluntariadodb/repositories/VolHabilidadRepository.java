package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Vol_Habilidad;

import java.util.List;

public interface VolHabilidadRepository {
    public Vol_Habilidad crear(Vol_Habilidad vol_habilidad);
    public String update(Vol_Habilidad vol_habilidad, int id);
    public List<Vol_Habilidad> getAll();
    public List<Vol_Habilidad> show(int id);
    public void delete(int id);
}
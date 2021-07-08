package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public Emergencia crear(Emergencia emergencia);
    public String update(Emergencia emergencia, int id);
    public List<Emergencia> getAll();
    public List<Emergencia> show(int id);
    public void delete(int id);
    public List<Emergencia> getPorRegion(int numero_region);
}
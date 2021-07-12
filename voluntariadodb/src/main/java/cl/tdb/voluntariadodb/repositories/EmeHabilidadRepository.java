package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Eme_Habilidad;

import java.util.List;

public interface EmeHabilidadRepository {
    public Eme_Habilidad crear(Eme_Habilidad eme_habilidad);
    public String update(Eme_Habilidad eme_habilidad, int id);
    public List<Eme_Habilidad> getAll();
    public List<Eme_Habilidad> show(int id);
    public void delete(int id);
}
package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Eme_Habilidad;

import java.util.List;

public interface EmeHabilidadRepository {
    public Eme_Habilidad crear(Eme_Habilidad eme_habilidad);
    public List<String> habilidadesPorEmergencia(int id_emergencia);
}
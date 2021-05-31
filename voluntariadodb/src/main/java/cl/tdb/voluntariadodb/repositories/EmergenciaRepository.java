package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public Emergencia crearEmergencia(Emergencia emergencia);
    public List<Emergencia> obtenerEmergencias1();
    public List<Emergencia> obtenerEmergencias2();
    public List<Emergencia> obtenerEmergencias3();
    public List<Emergencia> obtenerEmergencias4();
}
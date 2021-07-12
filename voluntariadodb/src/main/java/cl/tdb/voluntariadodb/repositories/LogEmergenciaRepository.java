package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Log_Emergencia;

import java.util.List;

public interface LogEmergenciaRepository {
    public void crear(int idEmergencia, String coordinador, String accion);
    public String update(Log_Emergencia log_emergencia, int id);
    public List<Log_Emergencia> getAll();
    public List<Log_Emergencia> show(int id);
    public void delete(int id);
}
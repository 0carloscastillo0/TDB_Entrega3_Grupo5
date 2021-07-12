package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Institucion;


import java.util.List;
public interface InstitucionRepository {
    public int countInstituciones();
     public Institucion crear(Institucion institucion);
    public String update(Institucion institucion, int id);
    public List<Institucion> getAll();
    public List<Institucion> show(int id);
    public void delete(int id);
}
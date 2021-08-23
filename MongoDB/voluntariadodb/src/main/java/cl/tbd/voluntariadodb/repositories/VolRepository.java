package cl.tbd.voluntariadodb.repositories;

import java.util.List;
import org.bson.Document;

import cl.tbd.voluntariadodb.models.Voluntario;
public interface VolRepository{
    public List<Document> habilidadesVoluntarios(String nombre);
    public void createVoluntario(Voluntario voluntario);
}
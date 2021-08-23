package cl.tbd.voluntariadodb.repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.tbd.voluntariadodb.models.Habilidad;

@Repository
public class HabiRepositoryImp implements HabiRepository{

    @Autowired
    MongoDatabase database;

    @Override
    public void createHabilidad(Habilidad habilidad){
        MongoCollection<Document> collection = database.getCollection("habilidad");
        Document nuevo = new Document("info", new Document("nombre_habilidad", habilidad.getNombre_habilidad())
                                            .append("descripcion_habilidad",habilidad.getDescripcion_habilidad())
                                            .append("cod_alfanumerico",habilidad.getAlfanumerico()));
        collection.insertOne(nuevo);
    }
}
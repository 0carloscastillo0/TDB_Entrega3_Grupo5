package cl.tbd.voluntariadodb.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static java.util.stream.Collectors.toList;
import cl.tbd.voluntariadodb.models.Voluntario;
import org.springframework.stereotype.Repository;



@Repository
public class VolRepositoryImp implements VolRepository{

    MongoClient mongoClient = new MongoClient(
            new MongoClientURI(
                "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false"
            )
        );
    MongoDatabase database = mongoClient.getDatabase("voluntariadodb");
    MongoCollection<Document> collection = database.getCollection("voluntario");
    @Override
    public List<Document> habilidadesVoluntarios(String nombre){


        List<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
            new Document("nombre_voluntario", nombre)),
            new Document("$unwind", 
            new Document("path", "$habilidades")), 
            new Document("$lookup", 
            new Document("from", "habilidad")
                    .append("localField", "habilidades")
                    .append("foreignField", "info.nombre_habilidad")
                    .append("as", "Habilidades_vol")))).into(new ArrayList<>()).stream()
                    .filter(Objects::nonNull)
                    .collect(toList());
        return result;
    }
    public void createVoluntario(Voluntario voluntario){
        MongoCollection<Document> collection = database.getCollection("voluntario");
        Document nuevo = new Document("nombre_habilidad", voluntario.getNombre_voluntario())
                                .append("edad_voluntario",voluntario.getEdad_voluntario())
                                .append("direccion_voluntario",voluntario.getDireccion_voluntario())
                                .append("habilidades",voluntario.getHabilidades());
        collection.insertOne(nuevo);
    }
}
package cl.tbd.voluntariadodb.models;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Voluntario{
    @BsonId
    ObjectId _id;

    String nombre_voluntario;
    int edad_voluntario;
    String direccion_voluntario;
    List<String> habilidades;

    public ObjectId getId(){
        return this._id;
    }
    public String getNombre_voluntario(){
        return this.nombre_voluntario;
    }
    public int getEdad_voluntario(){
        return this.edad_voluntario;
    }
    public String getDireccion_voluntario(){
        return this.direccion_voluntario;
    }
    public List<String> getHabilidades(){
        return this.habilidades;
    }

    public void setId(ObjectId id){
        this._id = id;
    }
    public void setNombre_voluntario(String nombre_voluntario){
        this.nombre_voluntario = nombre_voluntario;
    }
    public void setEdad_voluntario(int edad_voluntario){
        this.edad_voluntario = edad_voluntario;
    }
    public void setDireccion_voluntario(String direccion_voluntario){
        this.direccion_voluntario = direccion_voluntario;
    }
    public void setHabilidades(List<String> habilidades){
        this.habilidades = habilidades;
    }
}
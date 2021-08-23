package cl.tbd.voluntariadodb.models;


import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
public class Habilidad{
    @BsonId
    ObjectId _id;
    String nombre_habilidad;
    String descripcion_habilidad;
    String alfanumerico;
    public ObjectId getId(){
        return this._id;
    }
    public String getNombre_habilidad(){
        return this.nombre_habilidad;
    }
    public String getDescripcion_habilidad(){
        return this.descripcion_habilidad;
    }
    public String getAlfanumerico(){
        return this.alfanumerico;
    }

    public void setId(ObjectId id){
        this._id = id;
    }
    public void setNombre_habilidad(String nombre_habilidad){
        this.nombre_habilidad = nombre_habilidad;
    }
    public void setDescripcion_habilidad(String descripcion_habilidad){
        this.descripcion_habilidad = descripcion_habilidad;
    }
    public void setAlfanumerico(String alfanumerico){
        this.alfanumerico = alfanumerico;
    }
}
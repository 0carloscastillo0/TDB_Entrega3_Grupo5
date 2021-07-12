package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabiRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Habilidad crear(Habilidad habilidad){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM habilidad").executeScalar(Integer.class);;
            String sql = "INSERT INTO habilidad (id_habilidad ,nombre_habilidad, descripcion_habilidad, valoracion_habilidad)" +
            "VALUES (:id_habilidad, :nombre_habilidad, :descripcion_habilidad, :valoracion_habilidad)";
            conn.createQuery(sql, true)
                .addParameter("id_habilidad",idAnterior + 1)
                .addParameter("nombre_habilidad", habilidad.getNombre_habilidad())
                .addParameter("descripcion_habilidad", habilidad.getDescripcion_habilidad())
                .addParameter("valoracion_habilidad", habilidad.getValoracion_habilidad())
                .executeUpdate();
                habilidad.setId_habilidad(idAnterior + 1);
                return habilidad;
        }

    }


    
    @Override
    public List<Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from habilidad")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Habilidad> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from habilidad where id_habilidad = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from habilidad where id_habilidad = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de habilidad solo cambia su valoracion, no sus atributos, para ello se debe eliminar la habilidad y crearla de nuevo.
    @Override
    public String update(Habilidad habilidad, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update habilidad set valoracion_habilidad = :id_valoracion, nombre_habilidad=:nombre, descripcion_habilidad=:descripcion where id_habilidad = :id_habilidad";
            conn.createQuery(updateSql)
                .addParameter("id_habilidad",id)
                .addParameter("nombre", habilidad.getNombre_habilidad())
                .addParameter("descripcion", habilidad.getDescripcion_habilidad())
                .addParameter("id_valoracion", habilidad.getValoracion_habilidad())
                .executeUpdate();
            return "Se actualizo la habilidad";
        }
    }

}

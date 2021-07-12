package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Vol_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolHabilRepositoryImp implements VolHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Vol_Habilidad crear(Vol_Habilidad vol_habilidad){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM vol_habilidad").executeScalar(Integer.class);;
            String sql = "INSERT INTO vol_habilidad (id_vol_habilidad ,id_voluntario, id_habilidad)" +
            "VALUES (:id, :id_vol, :id_habil)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_vol", vol_habilidad.getId_voluntario())
                .addParameter("id_habil", vol_habilidad.getId_habilidad())
                .executeUpdate();
                vol_habilidad.setId_vol_habilidad(idAnterior + 1);
                return vol_habilidad;
        }

    }


    
    @Override
    public List<Vol_Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad")
                    .executeAndFetch(Vol_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Vol_Habilidad> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad where id_vol_habilidad = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Vol_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from vol_habilidad where id_vol_habilidad = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de vol_habilidad solo cambia su estado, no sus atributos, para ello se debe eliminar la vol_habilidad y crearla de nuevo.
    @Override
    public String update(Vol_Habilidad vol_habilidad, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update vol_habilidad set id_voluntario=:id_vol, id_habilidad=:id_habil where id_vol_habilidad = :id_vol_habilidad";
            conn.createQuery(updateSql)
                .addParameter("id_vol_habilidad",id)
                .addParameter("id_vol", vol_habilidad.getId_voluntario())
                .addParameter("id_habil", vol_habilidad.getId_habilidad())
                .executeUpdate();
            return "Se actualizo la vol_habilidad";
        }
    }

}

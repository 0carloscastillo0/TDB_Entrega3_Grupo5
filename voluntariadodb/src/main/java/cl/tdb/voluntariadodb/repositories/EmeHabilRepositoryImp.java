package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Eme_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeHabilRepositoryImp implements EmeHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Eme_Habilidad crear(Eme_Habilidad eme_habilidad){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM eme_habilidad").executeScalar(Integer.class);;
            String sql = "INSERT INTO eme_habilidad (id_eme_habilidad ,id_emergencia, id_habilidad)" +
            "VALUES (:id, :id_eme, :id_habil)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_eme", eme_habilidad.getId_emergencia())
                .addParameter("id_habil", eme_habilidad.getId_habilidad())
                .executeUpdate();
                eme_habilidad.setId_eme_habilidad(idAnterior + 1);
                return eme_habilidad;
        }

    }


    
    @Override
    public List<Eme_Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad")
                    .executeAndFetch(Eme_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Eme_Habilidad> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad where id_eme_habilidad = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Eme_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from eme_habilidad where id_eme_habilidad = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de eme_habilidad solo cambia su estado, no sus atributos, para ello se debe eliminar la eme_habilidad y crearla de nuevo.
    @Override
    public String update(Eme_Habilidad eme_habilidad, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update eme_habilidad set id_emergencia=:id_eme, id_habilidad=:id_habil where id_eme_habilidad = :id_eme_habilidad";
            conn.createQuery(updateSql)
                .addParameter("id_eme_habilidad",id)
                .addParameter("id_eme", eme_habilidad.getId_emergencia())
                .addParameter("id_habil", eme_habilidad.getId_habilidad())
                .executeUpdate();
            return "Se actualizo la eme_habilidad";
        }
    }

}

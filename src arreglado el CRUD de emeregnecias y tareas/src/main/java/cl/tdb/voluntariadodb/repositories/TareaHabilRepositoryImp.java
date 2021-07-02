package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Tarea_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaHabilRepositoryImp implements TareaHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea_Habilidad crear(Tarea_Habilidad tarea_habilidad){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM tarea_habilidad").executeScalar(Integer.class);;
            String sql = "INSERT INTO tarea_habilidad (id_tarea_habilidad ,id_tarea, id_habilidad)" +
            "VALUES (:id, :id_tar, :id_habil)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_tar", tarea_habilidad.getId_tarea())
                .addParameter("id_habil", tarea_habilidad.getId_habilidad())
                .executeUpdate();
                tarea_habilidad.setId_tarea_habilidad(idAnterior + 1);
                return tarea_habilidad;
        }

    }


    
    @Override
    public List<Tarea_Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad")
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Tarea_Habilidad> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad where id_tarea_habilidad = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from tarea_habilidad where id_tarea_habilidad = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de tarea_habilidad solo cambia su estado, no sus atributos, para ello se debe eliminar la tarea_habilidad y crearla de nuevo.
    @Override
    public String update(Tarea_Habilidad tarea_habilidad, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update tarea_habilidad set id_tarea=:id_tar, id_habilidad=:id_habil where id_tarea_habilidad = :id_tarea_habilidad";
            conn.createQuery(updateSql)
                .addParameter("id_tarea_habilidad",id)
                .addParameter("id_tar", tarea_habilidad.getId_tarea())
                .addParameter("id_habil", tarea_habilidad.getId_habilidad())
                .executeUpdate();
            return "Se actualizo la tarea_habilidad";
        }
    }

}

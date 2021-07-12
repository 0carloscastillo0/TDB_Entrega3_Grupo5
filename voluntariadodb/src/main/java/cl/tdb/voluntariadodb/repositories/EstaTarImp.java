package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Estado_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EstaTarImp implements EstadoTareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Estado_Tarea crear(Estado_Tarea estado_tarea){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM estado_tarea").executeScalar(Integer.class);;
            String sql = "INSERT INTO estado_tarea (id_estado_tarea,descripcion)" +
            "VALUES (:id, :descripcion)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("descripcion", estado_tarea.getDescripcion())
                .executeUpdate();
                estado_tarea.setId(idAnterior + 1);
                return estado_tarea;
        }

    }


    
    @Override
    public List<Estado_Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from estado_tarea")
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Estado_Tarea> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from estado_tarea where id_estado_tarea = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from estado_tarea where id_estado_tarea = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de estado_tarea solo cambia su estado, no sus atributos, para ello se debe eliminar la estado_tarea y crearla de nuevo.
    @Override
    public String update(Estado_Tarea estado_tarea, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update estado_tarea set descripcion=:descripcionT where id_estado_tarea = :id_estado_tarea";
            conn.createQuery(updateSql)
                .addParameter("id_estado_tarea",id)
                .addParameter("descripcionT", estado_tarea.getDescripcion())
                .executeUpdate();
            return "Se actualizo la estado_tarea";
        }
    }

}

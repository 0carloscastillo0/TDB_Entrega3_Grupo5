package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Log_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmerRepositoryImp implements LogTareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Log_Tarea crear(Log_Tarea log_tarea){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM log_tarea").executeScalar(Integer.class);;
            String sql = "INSERT INTO log_tarea (id_log_tarea ,nombre_log_tarea, descripcion_log_tarea, estado_log_tarea, id_institucion)" +
            "VALUES (:id, :nombre, :descripcion, :estado, :idInstitucion)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", log_tarea.getNombre_log_tarea())
                .addParameter("descripcion", log_tarea.getDescripcion_log_tarea())
                .addParameter("estado", 1)
                .addParameter("idInstitucion", log_tarea.getId_institucion())
                .executeUpdate();
                log_tarea.setId_log_tarea(idAnterior + 1);
                return log_tarea;
        }

    }


    
    @Override
    public List<Log_Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from log_tarea")
                    .executeAndFetch(Log_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Log_Tarea> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from log_tarea where id_log_tarea = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Log_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from log_tarea where id_log_tarea = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de log_tarea solo cambia su estado, no sus atributos, para ello se debe eliminar la log_tarea y crearla de nuevo.
    @Override
    public String update(Log_Tarea log_tarea, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update log_tarea set estado_log_tarea = :id_estado, nombre_log_tarea=:nombre, descripcion_log_tarea=:descripcion, id_institucion=:id_ins where id_log_tarea = :id_log_tarea";
            conn.createQuery(updateSql)
                .addParameter("id_log_tarea",id)
                .addParameter("nombre", log_tarea.getNombre_log_tarea())
                .addParameter("descripcion", log_tarea.getDescripcion_log_tarea())
                .addParameter("id_estado", log_tarea.getEstado_log_tarea())
                .addParameter("id_ins", log_tarea.getId_institucion())
                .executeUpdate();
            return "Se actualizo la log_tarea";
        }
    }

}
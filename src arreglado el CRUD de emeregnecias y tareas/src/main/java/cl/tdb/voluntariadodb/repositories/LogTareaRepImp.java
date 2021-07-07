package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Log_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


import java.sql.Timestamp;
@Repository
public class LogTareaRepImp implements LogTareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public void crear(int idTarea, String nombreCoordinador, String accionRealizada){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM log_tarea").executeScalar(Integer.class);
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            String sql = "INSERT INTO log_tarea (id_log_tarea , id_tarea, nombre_coordinador, accion, time_stamp)" +
            "VALUES (:id, :id_tarea_real, :nombre, :accion, :fecha)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_tarea_real", idTarea)
                .addParameter("nombre", nombreCoordinador)
                .addParameter("accion", accionRealizada)
                .addParameter("fecha",timeStamp )
                .executeUpdate();

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
            String updateSql = "update log_tarea set id_log_tarea=:id, id_tarea=:id_tar, nombre_coordinador=:nombre, accion=:accion_realizada, time_stamp=:fecha where id_log_tarea = :id_log_tarea";
            conn.createQuery(updateSql)
                .addParameter("id",id)
                .addParameter("id_tar", log_tarea.getIdTarea())
                .addParameter("nombre", log_tarea.getNombreCoordinador())
                .addParameter("accion_realizada", log_tarea.getAccion())
                .addParameter("fecha", log_tarea.getTimeStamp())
                .executeUpdate();
            return "Se actualizo la log_tarea";
        }
    }

}


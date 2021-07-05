package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Log_Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmerRepositoryImp implements LogEmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Log_Emergencia crear(Log_Emergencia log_emergencia){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM log_emergencia").executeScalar(Integer.class);;
            String sql = "INSERT INTO log_emergencia (id_log_emergencia ,id_emergencia, nombre_coordinador, accion, time_stamp)" +
            "VALUES (:id, :idEmergencia, :coordinador, :accion, :timeStamp)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("idEmergencia", log_emergencia.getIdEmergencia())
                .addParameter("coordinador", log_emergencia.getNombreCoordinador())
                .addParameter("accion", log_emergencia.getAccion())
                .addParameter("timeStamp", log_emergencia.getTimeStamp())
                .executeUpdate();
                log_emergencia.setIdLogEmergencia(idAnterior + 1);
                return log_emergencia;
        }

    }


    
    @Override
    public List<Log_Emergencia> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from log_emergencia")
                    .executeAndFetch(Log_Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Log_Emergencia> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from log_emergencia where id_log_emergencia = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Log_Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from log_emergencia where id_log_emergencia = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de log_emergencia solo cambia su estado, no sus atributos, para ello se debe eliminar la log_emergencia y crearla de nuevo.
    @Override
    public String update(Log_Emergencia log_emergencia, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update log_emergencia set estado_log_emergencia = :id_log_emergencia, nombre_log_emergencia=:nombre, descripcion_log_emergencia=:descripcion, id_institucion=:id_ins where id_log_emergencia = :id_log_emergencia";
            conn.createQuery(updateSql)
                .addParameter("id_log_emergencia",id)
                .addParameter("nombre", log_emergencia.getNombre_log_emergencia())
                .addParameter("descripcion", log_emergencia.getDescripcion_log_emergencia())
                .addParameter("id_estado", log_emergencia.getEstado_log_emergencia())
                .addParameter("id_ins", log_emergencia.getId_institucion())
                .executeUpdate();
            return "Se actualizo la log_emergencia";
        }
    }

}

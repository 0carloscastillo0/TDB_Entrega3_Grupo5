package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.List;
import org.postgis.Point;

@Repository
public class TarRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea crear(Tarea tarea){
        try(Connection conn = sql2o.open()){
            int idAnterior = 0;
            idAnterior = conn.createQuery("SELECT COUNT(*) FROM tarea").executeScalar(Integer.class);;
            String sql = "INSERT INTO tarea (id_tarea ,nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia, location)" + 
            " VALUES (:id, :nombre, :descripcion, :requeridos, :inscritos, :inicio, :fin, :idEstado, :idEmergencia, :point)";
            String point = "POINT("+emergencia.getLongitud_emergencia()+" "+emergencia.getLatitud_emergencia()+")";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", tarea.getNombre_tarea())
                .addParameter("descripcion", tarea.getDescripcion_tarea())
                .addParameter("requeridos", tarea.getCant_vol_requeridos())
                .addParameter("inscritos", tarea.getCant_vol_inscritos())
                .addParameter("inicio", LocalDate.parse(tarea.getInicio()))
                .addParameter("fin", LocalDate.parse(tarea.getFin()))
                .addParameter("idEstado", tarea.getId_estado())
                .addParameter("idEmergencia", tarea.getId_emergencia())
                .addParameter("point", point)
                .executeUpdate();
                tarea.setId_tarea(idAnterior + 1);
            
            int idAnterior2 = conn.createQuery("SELECT COUNT(*) FROM log_tarea").executeScalar(Integer.class);
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            String sql2 = "INSERT INTO log_tarea (id_log_tarea , id_tarea, nombre_coordinador, accion, time_stamp)" +
            "VALUES (:id, :id_tarea_real, :nombre, :accion, :fecha)";
            conn.createQuery(sql2, true)
                .addParameter("id",idAnterior2 + 1)
                .addParameter("id_tarea_real", idAnterior)
                .addParameter("nombre", "default")
                .addParameter("accion", "CREAR")
                .addParameter("fecha",timeStamp )
                .executeUpdate();
            return tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }


    @Override
    public List<Tarea> getAll() {
        String sql = "select id_tarea ,nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, "+
        "id_emergencia, st_y(st_astext(location)), st_x(st_astext(location)) from Tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Tarea> show(int id) {
        String sql = "select id_tarea ,nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, "+
        "fin, id_estado, id_emergencia, st_y(st_astext(location)), st_x(st_astext(location)) from Tarea where id_tarea = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> tareas(int id_emergencia) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id_tarea, nombre_tarea, cant_vol_inscritos from Tarea where id_emergencia = :id order by cant_vol_inscritos")
                    .addParameter("id",id_emergencia)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Tarea where id_tarea = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de tarea solo cambia su estado, no sus atributos, para ello se debe eliminar la tarea y crearla de nuevo.
    @Override
    public String update(Tarea tarea, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update tarea set id_estado = :idEstado, nombre_tarea = :nombre, descripcion_tarea = :des, cant_vol_requeridos = :r, "+
            "cant_vol_inscritos = :i, inicio = :ini, fin = :fi, id_emergencia = :idEmer, location=:point where id_tarea = :id_tarea";
            String point = "POINT("+emergencia.getLongitud_emergencia()+" "+emergencia.getLatitud_emergencia()+")";
            conn.createQuery(updateSql)
                .addParameter("idEstado", tarea.getId_estado())
                .addParameter("id_tarea", id)
                .addParameter("nombre", tarea.getNombre_tarea())
                .addParameter("des", tarea.getDescripcion_tarea())
                .addParameter("r", tarea.getCant_vol_requeridos())
                .addParameter("i", tarea.getCant_vol_inscritos())
                .addParameter("ini", LocalDate.parse(tarea.getInicio()))
                .addParameter("fi", LocalDate.parse(tarea.getFin()))
                .addParameter("idEmer", tarea.getId_emergencia())
                .addParameter("point", ST_GeomFromText(point, 4326));
                .executeUpdate();
            return "Se actualizo la tarea";
        }
    }
//set nombre_tarea = :nombre set descripcion_tarea = :des set cant_vol_requeridos = :r set cant_vol_inscritos = :i set inicio = :ini set fin = :fi set id_emergencia = :idEmer

}
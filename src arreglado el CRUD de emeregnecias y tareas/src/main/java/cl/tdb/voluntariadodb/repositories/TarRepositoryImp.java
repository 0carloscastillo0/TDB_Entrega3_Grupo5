package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;

import java.util.List;
@Repository
public class TarRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea crear(Tarea tarea){
        try(Connection conn = sql2o.open()){
            int idAnterior = 0;
            idAnterior = conn.createQuery("SELECT COUNT(*) FROM tarea").executeScalar(Integer.class);;
            String sql = "INSERT INTO tarea (id_tarea ,nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia)" + 
            " VALUES (:id, :nombre, :descripcion, :requeridos, :inscritos, :inicio, :fin, :idEstado, :idEmergencia)";
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
                .executeUpdate();
                tarea.setId_tarea(idAnterior + 1);
                return tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }


    @Override
    public List<Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Tarea")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Tarea> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Tarea where id_tarea = :id")
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
            String updateSql = "update tarea set id_estado = :idEstado, nombre_tarea = :nombre, descripcion_tarea = :des, cant_vol_requeridos = :r, cant_vol_inscritos = :i, inicio = :ini, fin = :fi, id_emergencia = :idEmer where id_tarea = :id_tarea";
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
                .executeUpdate();
            return "Se actualizo la tarea";
        }
    }
//set nombre_tarea = :nombre set descripcion_tarea = :des set cant_vol_requeridos = :r set cant_vol_inscritos = :i set inicio = :ini set fin = :fi set id_emergencia = :idEmer

}
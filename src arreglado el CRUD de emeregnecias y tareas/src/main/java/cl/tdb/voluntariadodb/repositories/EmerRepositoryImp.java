package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import cl.tdb.voluntariadodb.repositories.LogEmerRepository;

@Repository
public class EmerRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Emergencia crear(Emergencia emergencia){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);;
            String sql = "INSERT INTO emergencia (id_emergencia ,nombre_emergencia, descripcion_emergencia, estado_emergencia, id_institucion)" +
            "VALUES (:id, :nombre, :descripcion, :estado, :idInstitucion)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())
                .addParameter("estado", 1)
                .addParameter("idInstitucion", emergencia.getId_institucion())
                .executeUpdate();
                emergencia.setId_emergencia(idAnterior + 1);
                LogEmerRepositoryImp.crear(idAnterior + 1, emergencia.getNombre_emergencia(), "Creada");
                return emergencia;
        }

    }


    
    @Override
    public List<Emergencia> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from emergencia")
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Emergencia> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from emergencia where id_emergencia = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from emergencia where id_emergencia = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de emergencia solo cambia su estado, no sus atributos, para ello se debe eliminar la emergencia y crearla de nuevo.
    @Override
    public String update(Emergencia emergencia, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update emergencia set estado_emergencia = :id_estado, nombre_emergencia=:nombre, descripcion_emergencia=:descripcion, id_institucion=:id_ins where id_emergencia = :id_emergencia";
            conn.createQuery(updateSql)
                .addParameter("id_emergencia",id)
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())
                .addParameter("id_estado", emergencia.getEstado_emergencia())
                .addParameter("id_ins", emergencia.getId_institucion())
                .executeUpdate();
            return "Se actualizo la emergencia";
        }
    }

}

package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class VolRepositoryImp implements VoluntarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Voluntario crear(Voluntario voluntario){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);;
            String sql = "INSERT INTO voluntario (id_voluntario ,nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario)" +
            "VALUES (:id, :nombre, :disponibilidad, :fecha)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", voluntario.getNombre_voluntario())
                .addParameter("disponibilidad", voluntario.getDisponibilidad())
                .addParameter("fecha", LocalDate.parse(voluntario.getFnacimiento()))
                .executeUpdate();
                voluntario.setId_voluntario(idAnterior + 1);
                return voluntario;
        }

    }


    
    @Override
    public List<Voluntario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Voluntario> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario where id_voluntario = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from voluntario where id_voluntario = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de voluntario solo cambia su estado, no sus atributos, para ello se debe eliminar la voluntario y crearla de nuevo.
    @Override
    public String update(Voluntario voluntario, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update voluntario set fnacimiento_voluntario = :fecha, nombre_voluntario=:nombre, disponibilidad_voluntario=:disponibilidad where id_voluntario = :id_voluntario";
            conn.createQuery(updateSql)
                .addParameter("id_voluntario",id)
                .addParameter("nombre", voluntario.getNombre_voluntario())
                .addParameter("disponibilidad", voluntario.getDisponibilidad())
                .addParameter("fecha", LocalDate.parse(voluntario.getFnacimiento()))
                .executeUpdate();
            return "Se actualizo la voluntario";
        }
    }

}

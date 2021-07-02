package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class InsRepositoryImp implements InstitucionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countInstituciones() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM institucion";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }


    
    @Override
    public Institucion crear(Institucion institucion){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM institucion").executeScalar(Integer.class);;
            String sql = "INSERT INTO institucion (id_institucion ,nombre_institucion, descripcion_institucion)" +
            "VALUES (:id, :nombre, :descripcion)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", institucion.getNombre())
                .addParameter("descripcion", institucion.getDescripcion())
                .executeUpdate();
                institucion.setId(idAnterior + 1);
                return institucion;
        }

    }


    
    @Override
    public List<Institucion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion")
                    .executeAndFetch(Institucion.class);
        } 
    }


    @Override
    public List<Institucion> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from institucion where id_institucion = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from institucion where id_institucion = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de institucion solo cambia su estado, no sus atributos, para ello se debe eliminar la institucion y crearla de nuevo.
    @Override
    public String update(Institucion institucion, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update institucion set nombre_institucion=:nombre, descripcion_institucion=:descripcion where id_institucion = :id_institucion";
            conn.createQuery(updateSql)
                .addParameter("id_institucion",id)
                .addParameter("nombre", institucion.getNombre())
                .addParameter("descripcion", institucion.getDescripcion())
                .executeUpdate();
            return "Se actualizo la institucion";
        }
    }

}
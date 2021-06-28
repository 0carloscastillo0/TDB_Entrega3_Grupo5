package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;



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

}
package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;



@Repository
public class EmerRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    public Emergencia crearEmergencia(Emergencia emergencia){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO emergencia (nombre_emergencia, descripcion_emergencia, id_institucion) values(:nombre, :descripcion, :idInstitucion)";
            int idInsert = (int) conn.createQuery(sql, true)
                .addParameter("nombre");
        }

    }
}
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

    @Override
    public Emergencia crearEmergencia(Emergencia emergencia){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM institucion").executeScalar(Integer.class);;
            String sql = "INSERT INTO emergencia (id_emergencia ,nombre_emergencia, descripcion_emergencia, id_institucion) VALUES (:id, :nombre, :descripcion, :idInstitucion)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())
                .addParameter("idInstitucion", emergencia.getId_institucion())
                .executeUpdate();
                emergencia.setId_emergencia(idAnterior + 1);
                return emergencia;
        }

    }
}

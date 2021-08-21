package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.sql.Timestamp;
import java.util.List;


@Repository
public class EmerRepositoryImp implements EmergenciaRepository{

    @Autowired
    @Qualifier("dsMaster")
    private Sql2o sql2o0;
    @Autowired
    @Qualifier("dsSlave1")
    private Sql2o sql2o1;
    @Autowired
    @Qualifier("dsSlave2")
    private Sql2o sql2o2;

    private Hash hash=new Hash();


    @Override
    public Emergencia crear(Emergencia emergencia){
        int idAnterior;
        // se calcula el id anterior.
        try(Connection conn0 = sql2o0.open()){
            idAnterior = conn0.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);
            conn0.close();
        }
        try(Connection conn1 = sql2o1.open()){
            idAnterior = idAnterior + conn1.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);
            conn1.close();
        }
        try(Connection conn2 = sql2o2.open()){
            idAnterior = idAnterior + conn2.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);
            conn2.close();        
        }

        //sentencia sql a ejecutar (una insercion).
        String sql = "INSERT INTO emergencia (id_emergencia, nombre_tabla, nombre_emergencia, descripcion_emergencia)" +
        "VALUES (:id, :nombre_tabla, :nombre, :descripcion)";
        
        // hash del id de la insecion.
        int nodo=hash.hashFunction(idAnterior+1,3);

        // se realiza la insercion en el nodo que corresponde.
        if(nodo==0){
            
            emergencia.setNombre_tabla("emergencia0");
            try(Connection conn = sql2o0.open()){
                conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre_tabla", emergencia.getNombre_tabla())
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())
                .executeUpdate();
                conn.close();        
            }
        }
        else if(nodo==1){
           
            emergencia.setNombre_tabla("emergencia1");
            try(Connection conn = sql2o1.open()){
                conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre_tabla", emergencia.getNombre_tabla())
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())              
                .executeUpdate();
                conn.close();        
            }
        }
        else if(nodo==2){

            emergencia.setNombre_tabla("emergencia2");
            try(Connection conn = sql2o2.open()){
                conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre_tabla", emergencia.getNombre_tabla())
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())             
                .executeUpdate();
                conn.close();        
            }
        }

        emergencia.setId_emergencia(idAnterior + 1);
        return emergencia;
    }

}

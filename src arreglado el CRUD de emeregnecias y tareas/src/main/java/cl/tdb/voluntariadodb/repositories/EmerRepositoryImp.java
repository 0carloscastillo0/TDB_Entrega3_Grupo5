package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.sql.Timestamp;
import java.util.List;
import cl.tdb.voluntariadodb.models.Log_Emergencia;
import org.postgis.Point;

@Repository
public class EmerRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Emergencia crear(Emergencia emergencia){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);;
            String sql = "INSERT INTO emergencia (id_emergencia ,nombre_emergencia, descripcion_emergencia, estado_emergencia, id_institucion)" +
            "VALUES (:id, :nombre, :descripcion, :estado, :idInstitucion, ST_GeomFromText(:point, 4326))";
            String point = "POINT("+emergencia.getLongitud_emergencia()+" "+emergencia.getLatitud_emergencia()+")";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())
                .addParameter("estado", 1)
                .addParameter("idInstitucion", emergencia.getId_institucion())
                .addParameter("point", point)
                .executeUpdate();
                emergencia.setId_emergencia(idAnterior + 1);
            int idAnterior2 = conn.createQuery("SELECT COUNT(*) FROM log_emergencia").executeScalar(Integer.class);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String sql2 = "INSERT INTO log_emergencia (id_log_emergencia ,id_emergencia, nombre_coordinador, accion, time_stamp)" +
            "VALUES (:id, :idEmergencia, :coordinador, :accion, :timeStamp)";
            conn.createQuery(sql2, true)
                .addParameter("id",idAnterior2 + 1)
                .addParameter("idEmergencia", idAnterior2 + 1)
                .addParameter("coordinador", "default")
                .addParameter("accion", "CREAR")
                .addParameter("timeStamp",timestamp)
                .executeUpdate();
            return emergencia;
        }

    }


    
    @Override
    public List<Emergencia> getAll(){
        String sql = "select id_emergencia ,nombre_emergencia, descripcion_emergencia, estado_emergencia, id_institucion,"+
        "st_y(st_astext(location)) as latitud_emergencia, st_x(st_astext(location)) as longitud_emergencia from emergencia";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Emergencia> show(int id) {
        String sql = "select id_emergencia ,nombre_emergencia, descripcion_emergencia, estado_emergencia, id_institucion,"+
        "st_y(st_astext(location)) as latitud_emergencia, st_x(st_astext(location)) as longitud_emergencia from emergencia where id_emergencia = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
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
            String updateSql = "update emergencia set estado_emergencia = :id_estado, nombre_emergencia=:nombre, descripcion_emergencia=:descripcion, id_institucion=:id_ins, location=ST_GeomFromText(:point, 4326) where id_emergencia = :id_emergencia";
            String point = "POINT("+emergencia.getLongitud_emergencia()+" "+emergencia.getLatitud_emergencia()+")";
            conn.createQuery(updateSql)
                .addParameter("id_emergencia",id)
                .addParameter("nombre", emergencia.getNombre_emergencia())
                .addParameter("descripcion", emergencia.getDescripcion_emergencia())
                .addParameter("id_estado", emergencia.getEstado_emergencia())
                .addParameter("id_ins", emergencia.getId_institucion())
                .addParameter("point", point)
                .executeUpdate();
            return "Se actualizo la emergencia";
        }
    }

    @Override
    public List<Emergencia> getPorRegion(int numero_region) {
        try(Connection conn = sql2o.open()){ // adaptacion de la sentencia vista en clases.                                                                         Se setea el SRID en 4346 para que ST_WITHIN funcione correctamente.
            String sql="SELECT id_emergencia,nombre_emergencia,descripcion_emergencia FROM emergencia AS e INNER JOIN public.regiones AS r ON ST_WITHIN(e.location, ST_SetSRID(r.geom,4326)) WHERE r.numero_region = :numero;";
            return conn.createQuery(sql)
                    .addParameter("numero",numero_region)
                    .executeAndFetch(Emergencia.class);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
           return null;
        }
    }



}

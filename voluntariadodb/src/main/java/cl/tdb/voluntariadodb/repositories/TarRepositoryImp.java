package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;


@Repository
public class TarRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea crearTarea(Tarea tarea){
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
        }

    }


    @Override
    public String updateTarea(int nuevoNumeroTarea, Tarea tarea){
        try(Connection conn = sql20.open()){
            String updateSql = "update tarea set id_estado = :idEstado where id = :id_tarea";
            con.createQuery(updateSql)
                .addParameter("idEstado", nuevoNumeroTarea)
                .addParameter("id_tarea", tarea.getId_tarea())
                .executeUpdate();
            return "Se actualizo la tarea";
        }
    }


}
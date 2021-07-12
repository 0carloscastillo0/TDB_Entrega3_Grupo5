package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankRepositoryImp implements RankingRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Ranking crear(Ranking ranking){
        try(Connection conn = sql2o.open()){
            int idAnterior = conn.createQuery("SELECT COUNT(*) FROM ranking").executeScalar(Integer.class);;
            String sql = "INSERT INTO ranking (id_ranking ,valoracion_ranking,id_voluntario,id_tarea)" +
            "VALUES (:id, :valoracion, :idVoluntario, :idTarea)";
            conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("valoracion", ranking.getValoracion())
                .addParameter("idVoluntario", ranking.getId_voluntario())
                .addParameter("idTarea", ranking.getId_tarea())
                .executeUpdate();
                ranking.setId_ranking(idAnterior + 1);
                return ranking;
        }

    }


    
    @Override
    public List<Ranking> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Ranking> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking where id_ranking = :id")
                    .addParameter("id",id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from ranking where id_ranking = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


    // update de ranking solo cambia su estado, no sus atributos, para ello se debe eliminar la ranking y crearla de nuevo.
    @Override
    public String update(Ranking ranking, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update ranking set valoracion_ranking = :valoracion, id_voluntario = :idVoluntario, id_tarea = :idTarea where id_ranking = :id";
            conn.createQuery(updateSql)
            .addParameter("id",id)
            .addParameter("valoracion", ranking.getValoracion())
            .addParameter("idVoluntario", ranking.getId_voluntario())
            .addParameter("idTarea", ranking.getId_tarea())
            .executeUpdate();
            return "Se actualizo la ranking";
        }
    }

}

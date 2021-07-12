package cl.tdb.voluntariadodb.repositories;

import cl.tdb.voluntariadodb.models.Ranking;

import java.util.List;

public interface RankingRepository {
    public Ranking crear(Ranking ranking);
    public String update(Ranking ranking, int id);
    public List<Ranking> getAll();
    public List<Ranking> show(int id);
    public void delete(int id);
}
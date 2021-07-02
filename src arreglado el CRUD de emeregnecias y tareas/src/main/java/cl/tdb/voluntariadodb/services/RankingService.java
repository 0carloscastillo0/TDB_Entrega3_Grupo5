package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Ranking;
import cl.tdb.voluntariadodb.repositories.RankingRepository;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
    private final RankingRepository rankingRepository;

    RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    @PostMapping("/ranking")
    @ResponseBody
    public Ranking crear(@RequestBody Ranking ranking){
        Ranking resultado = rankingRepository.crear(ranking);
        return resultado;
    }
    


    // leer R
    @GetMapping("/ranking")
    public List<Ranking> getAllRankings(){
        return rankingRepository.getAll();
    }
    
    @GetMapping("/ranking/{id}")
    public List<Ranking> getRanking(@PathVariable int id){
        return rankingRepository.show(id);
    }


    // actualizar U
    @PutMapping("/ranking/{id}")
    @ResponseBody
    public String updateRanking(@RequestBody Ranking ranking, @PathVariable int id){
        String retorno = rankingRepository.update(ranking,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/ranking/{id}")
    public void borrar(@PathVariable int id){
        rankingRepository.delete(id);
    }
}

package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Eme_Habilidad;
import cl.tdb.voluntariadodb.repositories.EmeHabilidadRepository;


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
public class EmeHabilidadService {
    private final EmeHabilidadRepository eme_habilidadRepository;

    EmeHabilidadService(EmeHabilidadRepository eme_habilidadRepository){
        this.eme_habilidadRepository = eme_habilidadRepository;
    }

    @PostMapping("/emeHabilidad")
    @ResponseBody
    public Eme_Habilidad crear(@RequestBody Eme_Habilidad eme_habilidad){
        Eme_Habilidad resultado = eme_habilidadRepository.crear(eme_habilidad);
        return resultado;
    }
    


    // leer R
    @GetMapping("/emeHabilidad")
    public List<Eme_Habilidad> getAllEme_Habilidads(){
        return eme_habilidadRepository.getAll();
    }
    
    @GetMapping("/emeHabilidad/{id}")
    public List<Eme_Habilidad> getEme_Habilidad(@PathVariable int id){
        return eme_habilidadRepository.show(id);
    }


    // actualizar U
    @PutMapping("/emeHabilidad/{id}")
    @ResponseBody
    public String updateEme_Habilidad(@RequestBody Eme_Habilidad eme_habilidad, @PathVariable int id){
        String retorno = eme_habilidadRepository.update(eme_habilidad,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/emeHabilidad/{id}")
    public void borrar(@PathVariable int id){
        eme_habilidadRepository.delete(id);
    }
}

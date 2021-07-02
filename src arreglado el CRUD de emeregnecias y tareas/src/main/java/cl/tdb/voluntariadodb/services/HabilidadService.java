package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Habilidad;
import cl.tdb.voluntariadodb.repositories.HabilidadRepository;


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
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @PostMapping("/habilidad")
    @ResponseBody
    public Habilidad crear(@RequestBody Habilidad habilidad){
        Habilidad resultado = habilidadRepository.crear(habilidad);
        return resultado;
    }
    


    // leer R
    @GetMapping("/habilidad")
    public List<Habilidad> getAllHabilidads(){
        return habilidadRepository.getAll();
    }
    
    @GetMapping("/habilidad/{id}")
    public List<Habilidad> getHabilidad(@PathVariable int id){
        return habilidadRepository.show(id);
    }


    // actualizar U
    @PutMapping("/habilidad/{id}")
    @ResponseBody
    public String updateHabilidad(@RequestBody Habilidad habilidad, @PathVariable int id){
        String retorno = habilidadRepository.update(habilidad,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/habilidad/{id}")
    public void borrar(@PathVariable int id){
        habilidadRepository.delete(id);
    }
}

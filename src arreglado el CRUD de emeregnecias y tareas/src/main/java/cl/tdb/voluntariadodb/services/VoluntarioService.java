package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Voluntario;
import cl.tdb.voluntariadodb.repositories.VoluntarioRepository;


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
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @PostMapping("/voluntario")
    @ResponseBody
    public Voluntario crear(@RequestBody Voluntario voluntario){
        Voluntario resultado = voluntarioRepository.crear(voluntario);
        return resultado;
    }
    


    // leer R
    @GetMapping("/voluntario")
    public List<Voluntario> getAllVoluntarios(){
        return voluntarioRepository.getAll();
    }
    
    @GetMapping("/voluntario/{id}")
    public List<Voluntario> getVoluntario(@PathVariable int id){
        return voluntarioRepository.show(id);
    }


    // actualizar U
    @PutMapping("/voluntario/{id}")
    @ResponseBody
    public String updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable int id){
        String retorno = voluntarioRepository.update(voluntario,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/voluntario/{id}")
    public void borrar(@PathVariable int id){
        voluntarioRepository.delete(id);
    }
}

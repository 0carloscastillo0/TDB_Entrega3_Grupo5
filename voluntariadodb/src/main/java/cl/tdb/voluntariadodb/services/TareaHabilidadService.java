package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Tarea_Habilidad;
import cl.tdb.voluntariadodb.repositories.TareaHabilidadRepository;


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
public class TareaHabilidadService {
    private final TareaHabilidadRepository tarea_habilidadRepository;

    TareaHabilidadService(TareaHabilidadRepository tarea_habilidadRepository){
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    @PostMapping("/tareaHabilidad")
    @ResponseBody
    public Tarea_Habilidad crear(@RequestBody Tarea_Habilidad tarea_habilidad){
        Tarea_Habilidad resultado = tarea_habilidadRepository.crear(tarea_habilidad);
        return resultado;
    }
    


    // leer R
    @GetMapping("/tareaHabilidad")
    public List<Tarea_Habilidad> getAllTarea_Habilidads(){
        return tarea_habilidadRepository.getAll();
    }
    
    @GetMapping("/tareaHabilidad/{id}")
    public List<Tarea_Habilidad> getTarea_Habilidad(@PathVariable int id){
        return tarea_habilidadRepository.show(id);
    }


    // actualizar U
    @PutMapping("/tareaHabilidad/{id}")
    @ResponseBody
    public String updateTarea_Habilidad(@RequestBody Tarea_Habilidad tarea_habilidad, @PathVariable int id){
        String retorno = tarea_habilidadRepository.update(tarea_habilidad,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/tareaHabilidad/{id}")
    public void borrar(@PathVariable int id){
        tarea_habilidadRepository.delete(id);
    }
}

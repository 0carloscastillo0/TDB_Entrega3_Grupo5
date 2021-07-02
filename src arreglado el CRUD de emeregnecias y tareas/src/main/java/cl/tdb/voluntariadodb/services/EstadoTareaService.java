package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Estado_Tarea;
import cl.tdb.voluntariadodb.repositories.EstadoTareaRepository;


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
public class EstadoTareaService {
    private final EstadoTareaRepository estadoTareaRepository;

    EstadoTareaService(EstadoTareaRepository estadoTareaRepository){
        this.estadoTareaRepository = estadoTareaRepository;
    }

    @PostMapping("/estadoTarea")
    @ResponseBody
    public Estado_Tarea crear(@RequestBody Estado_Tarea estadoTarea){
        Estado_Tarea resultado = estadoTareaRepository.crear(estadoTarea);
        return resultado;
    }
    


    // leer R
    @GetMapping("/estadoTarea")
    public List<Estado_Tarea> getAllEstadoTareas(){
        return estadoTareaRepository.getAll();
    }
    
    @GetMapping("/estadoTarea/{id}")
    public List<Estado_Tarea> getEstadoTarea(@PathVariable int id){
        return estadoTareaRepository.show(id);
    }


    // actualizar U
    @PutMapping("/estadoTarea/{id}")
    @ResponseBody
    public String updateEstadoTarea(@RequestBody Estado_Tarea estadoTarea, @PathVariable int id){
        String retorno = estadoTareaRepository.update(estadoTarea,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/estadoTarea/{id}")
    public void borrar(@PathVariable int id){
        estadoTareaRepository.delete(id);
    }
}

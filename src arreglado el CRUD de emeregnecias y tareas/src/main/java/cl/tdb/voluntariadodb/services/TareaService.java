package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Tarea;
import cl.tdb.voluntariadodb.repositories.TareaRepository;

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
public class TareaService{

    private final TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    // crear C
    @PostMapping("/tarea")
    @ResponseBody
    public Tarea crearTarea(@RequestBody Tarea tarea){
        Tarea resultado = tareaRepository.crear(tarea);
        return resultado;
    }

    // leer R
    @GetMapping("/tarea")
    public List<Tarea> getAllTareas(){
        return tareaRepository.getAll();
    }
    
    @GetMapping("/tarea/{id}")
    public List<Tarea> getTarea(@PathVariable int id){
        return tareaRepository.show(id);
    }


    // actualizar U
    @PutMapping("/tarea/{id}")
    @ResponseBody
    public String updateTarea(@RequestBody Tarea tarea, @PathVariable int id){
        String retorno = tareaRepository.update(tarea,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/tarea/{id}")
    public void borrar(@PathVariable int id){
        tareaRepository.delete(id);
    }
}
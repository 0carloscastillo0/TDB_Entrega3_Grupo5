package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Emergencia;
import cl.tdb.voluntariadodb.repositories.EmergenciaRepository;


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
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;

    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @PostMapping("/emergencia")
    @ResponseBody
    public Emergencia crear(@RequestBody Emergencia emergencia){
        Emergencia resultado = emergenciaRepository.crear(emergencia);
        return resultado;
    }
    


    // leer R
    @GetMapping("/emergencia")
    public List<Emergencia> getAllEmergencias(){
        return emergenciaRepository.getAll();
    }
    
    @GetMapping("/emergencia/{id}")
    public List<Emergencia> getEmergencia(@PathVariable int id){
        return emergenciaRepository.show(id);
    }
    @GetMapping("/emergencia/region/{numero_region}")
    public List<Emergencia> getEmergenciaPorRegion(@PathVariable int numero_region){
        return emergenciaRepository.getPorRegion(numero_region);
    }

    // actualizar U
    @PutMapping("/emergencia/{id}")
    @ResponseBody
    public String updateEmergencia(@RequestBody Emergencia emergencia, @PathVariable int id){
        String retorno = emergenciaRepository.update(emergencia,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/emergencia/{id}")
    public void borrar(@PathVariable int id){
        emergenciaRepository.delete(id);
    }
}

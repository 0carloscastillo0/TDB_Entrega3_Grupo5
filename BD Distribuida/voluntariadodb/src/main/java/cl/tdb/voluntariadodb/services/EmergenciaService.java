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
    

    
  
}

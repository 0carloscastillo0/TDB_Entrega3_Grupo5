package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Emergencia;
import cl.tdb.voluntariadodb.repositories.EmergenciaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    @ResponseBody
    public Emergencia crearEmergencia(@RequestBody Emergencia emergencia){
        Integer resultado = emergenciaRepository.crearEmergencia(emergencia);
        return resultado;
    }

}
package cl.tbd.voluntariadodb.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.voluntariadodb.repositories.HabiRepository;
import cl.tbd.voluntariadodb.models.Habilidad;


@RestController
public class HabilidadService {
    
    private final HabiRepository habiRepository;
    HabilidadService(HabiRepository habiRepository){
        this.habiRepository = habiRepository;
    }

    @PostMapping("/createHabi")
    @ResponseBody
    public String createHabilidad(@RequestBody Habilidad habilidad){
        habiRepository.createHabilidad(habilidad);
        return "Habilidad creada";
    }


}
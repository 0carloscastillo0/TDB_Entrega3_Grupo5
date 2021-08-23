package cl.tbd.voluntariadodb.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cl.tbd.voluntariadodb.models.Voluntario;
import cl.tbd.voluntariadodb.repositories.VolRepository;
import org.bson.Document;

@RestController
public class VoluntarioService {
    
    private final VolRepository volRepository;
    VoluntarioService(VolRepository volRepository){
        this.volRepository = volRepository;
    }
    @GetMapping("/habisVol/{nombre_voluntario}")
    @ResponseBody
    public List<Document> habilidadesVoluntarios(@PathVariable String nombre_voluntario){
        List<Document> resultado = volRepository.habilidadesVoluntarios(nombre_voluntario);
        return resultado;
    }

    @PostMapping("/createVol")
    @ResponseBody
    public String createVoluntario(@RequestBody Voluntario voluntario){
        volRepository.createVoluntario(voluntario);
        return "Voluntario agregado";
    }


}
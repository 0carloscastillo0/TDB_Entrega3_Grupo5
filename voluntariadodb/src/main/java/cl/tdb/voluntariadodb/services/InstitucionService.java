package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Institucion;
import cl.tdb.voluntariadodb.repositories.InstitucionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class InstitucionService {


    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }


    @GetMapping("/instituciones/count")
    public String countInstituciones(){
        int total = institucionRepository.countInstituciones();
        return String.format("Tienes %s instituciones!!", total);
    }

}
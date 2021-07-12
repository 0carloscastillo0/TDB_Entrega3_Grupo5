package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Institucion;
import cl.tdb.voluntariadodb.repositories.InstitucionRepository;

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
;


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

    @PostMapping("/institucion")
    @ResponseBody
    public Institucion crear(@RequestBody Institucion institucion){
        Institucion resultado = institucionRepository.crear(institucion);
        return resultado;
    }
    


    // leer R
    @GetMapping("/institucion")
    public List<Institucion> getAllInstitucions(){
        return institucionRepository.getAll();
    }
    
    @GetMapping("/institucion/{id}")
    public List<Institucion> getInstitucion(@PathVariable int id){
        return institucionRepository.show(id);
    }


    // actualizar U
    @PutMapping("/institucion/{id}")
    @ResponseBody
    public String updateInstitucion(@RequestBody Institucion institucion, @PathVariable int id){
        String retorno = institucionRepository.update(institucion,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/institucion/{id}")
    public void borrar(@PathVariable int id){
        institucionRepository.delete(id);
    }
}
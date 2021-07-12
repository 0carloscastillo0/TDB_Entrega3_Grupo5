package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Vol_Habilidad;
import cl.tdb.voluntariadodb.repositories.VolHabilidadRepository;


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
public class VolHabilidadService {
    private final VolHabilidadRepository vol_habilidadRepository;

    VolHabilidadService(VolHabilidadRepository vol_habilidadRepository){
        this.vol_habilidadRepository = vol_habilidadRepository;
    }

    @PostMapping("/volHabilidad")
    @ResponseBody
    public Vol_Habilidad crear(@RequestBody Vol_Habilidad vol_habilidad){
        Vol_Habilidad resultado = vol_habilidadRepository.crear(vol_habilidad);
        return resultado;
    }
    


    // leer R
    @GetMapping("/volHabilidad")
    public List<Vol_Habilidad> getAllVol_Habilidads(){
        return vol_habilidadRepository.getAll();
    }
    
    @GetMapping("/volHabilidad/{id}")
    public List<Vol_Habilidad> getVol_Habilidad(@PathVariable int id){
        return vol_habilidadRepository.show(id);
    }


    // actualizar U
    @PutMapping("/volHabilidad/{id}")
    @ResponseBody
    public String updateVol_Habilidad(@RequestBody Vol_Habilidad vol_habilidad, @PathVariable int id){
        String retorno = vol_habilidadRepository.update(vol_habilidad,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/volHabilidad/{id}")
    public void borrar(@PathVariable int id){
        vol_habilidadRepository.delete(id);
    }
}

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

    @PostMapping("/emergencia")
    @ResponseBody
    public Emergencia crearEmergencia(@RequestBody Emergencia emergencia){
        Emergencia resultado = emergenciaRepository.crearEmergencia(emergencia);
        return resultado;
    }
    @GetMapping("/emergencia1")
    public List<Emergencia> obtenerEmergencias1(){
        return emergenciaRepository.obtenerEmergencias1();
    }
    @GetMapping("/emergencia2")
    public List<Emergencia> obtenerEmergencias2(){
        return emergenciaRepository.obtenerEmergencias2();
    }
    @GetMapping("/emergencia3")
    public List<Emergencia> obtenerEmergencias3(){
        return emergenciaRepository.obtenerEmergencias3();
    }
    @GetMapping("/emergencia4")
    public List<Emergencia> obtenerEmergencias4(){
        return emergenciaRepository.obtenerEmergencias4();
    }

}

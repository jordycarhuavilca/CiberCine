package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Salas;
import pe.org.group02.ventaboletoscine.repository.SalasRepository;
import pe.org.group02.ventaboletoscine.response.ResponseTemp;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/salas")
public class SalasService {

    @Autowired
    private SalasRepository salasRepository;

    @PostMapping("/add")
    public ResponseTemp addSala(@RequestBody Salas salas){
        if(salas.getIdsala() != null){
            return new ResponseTemp(401, "Id no permitido");
        }
        salasRepository.save(salas);
        return new ResponseTemp(200, null);
    }

    @GetMapping("/find")
    public ResponseConsultas<Salas> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Salas> salas = null;
        if (id > 0) {
            salas = salasRepository.findAllById(List.of(id));
        } else if (id == 0) {
            salas = salasRepository.findAll();
        } else {
            return new ResponseConsultas<Salas>(404, "not found id", null);
        }

        return new ResponseConsultas<Salas>( 200 , null, salas);
    }

    @PatchMapping("/update")
    public ResponseTemp updateSala(@RequestBody Salas salas){
        if(!salasRepository.findById(salas.getIdsala()).isPresent()){
            return new ResponseTemp(404, "Not Found");
        }

        salasRepository.save(salas);
        return new ResponseTemp(200, null);
    }

    @DeleteMapping("/delete")
    public ResponseTemp deleteSalas(@RequestBody Salas salas) {
        if (!salasRepository.findById(salas.getIdsala()).isPresent()) {
            return new ResponseTemp(404, "Not Found");
        }
        salasRepository.delete(salas);
        return new ResponseTemp(200, null);
    }
}

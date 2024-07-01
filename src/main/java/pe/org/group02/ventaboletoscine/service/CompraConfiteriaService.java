package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.CompraConfiteria;
import pe.org.group02.ventaboletoscine.repository.CompraConfiteriaRepository;
import pe.org.group02.ventaboletoscine.response.ResponseTemp;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/confiteria")
public class CompraConfiteriaService {

    @Autowired
    private CompraConfiteriaRepository compraConfiteriaRepository;

    @PostMapping("/add")
    public ResponseTemp addCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria){
        if(compraConfiteria.getIdcompraconfiteria() != null){
            return new ResponseTemp(401, "Id no permitido");
        }
        compraConfiteriaRepository.save(compraConfiteria);
        return new ResponseTemp(200, null);
    }

    @GetMapping("/find")
    public ResponseConsultas<CompraConfiteria> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<CompraConfiteria> compraConfiteria = null;
        if (id > 0) {
            compraConfiteria = compraConfiteriaRepository.findAllById(List.of(id));
        } else if (id == 0) {
            compraConfiteria = compraConfiteriaRepository.findAll();
        } else {
            return new ResponseConsultas<CompraConfiteria>(404, "not found id", null);
        }

        return new ResponseConsultas<CompraConfiteria>( 200 , null, compraConfiteria);
    }

    @PatchMapping("/update")
    public ResponseTemp updateCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria){
        if(!compraConfiteriaRepository.findById(compraConfiteria.getIdcompraconfiteria()).isPresent()){
            return new ResponseTemp(404, "Not Found");
        }

        compraConfiteriaRepository.save(compraConfiteria);
        return new ResponseTemp(200, null);
    }

    @DeleteMapping("/delete")
    public ResponseTemp deleteCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria) {
        if (!compraConfiteriaRepository.findById(compraConfiteria.getIdcompraconfiteria()).isPresent()) {
            return new ResponseTemp(404, "Not Found");
        }
        compraConfiteriaRepository.delete(compraConfiteria);
        return new ResponseTemp(200, null);
    }
}

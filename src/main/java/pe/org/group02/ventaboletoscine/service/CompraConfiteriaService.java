package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.CompraConfiteria;
import pe.org.group02.ventaboletoscine.repository.CompraConfiteriaRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/confiteria")
public class CompraConfiteriaService {

    @Autowired
    private CompraConfiteriaRepository compraConfiteriaRepository;

    @PostMapping("/add")
    public Response addCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria){
        if(compraConfiteria.getIdcompraconfiteria() != null){
            return new Response(401, "Id no permitido");
        }
        compraConfiteriaRepository.save(compraConfiteria);
        return new Response(200, null);
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
    public Response updateCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria){
        if(!compraConfiteriaRepository.findById(compraConfiteria.getIdcompraconfiteria()).isPresent()){
            return new Response(404, "Not Found");
        }

        compraConfiteriaRepository.save(compraConfiteria);
        return new Response(200, null);
    }

    @DeleteMapping("/delete")
    public Response deleteCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria) {
        if (!compraConfiteriaRepository.findById(compraConfiteria.getIdcompraconfiteria()).isPresent()) {
            return new Response(404, "Not Found");
        }
        compraConfiteriaRepository.delete(compraConfiteria);
        return new Response(200, null);
    }
}

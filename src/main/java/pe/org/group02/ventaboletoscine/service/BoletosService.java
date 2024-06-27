//package pe.org.group02.ventaboletoscine.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pe.org.group02.ventaboletoscine.entity.Compra;
//import pe.org.group02.ventaboletoscine.repository.BoletosRepository;
//import pe.org.group02.ventaboletoscine.response.Response;
//import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/ticket")
//public class BoletosService {
//    @Autowired
//    private BoletosRepository boletosRepository;
//
//    @PostMapping("/add")
//    public Response addBoleto(@RequestBody Compra boletos){
//        if(boletos.getIdBoleto() != null){
//            return new Response(401, "Id no permitido");
//        }
//        boletosRepository.save(boletos);
//        return new Response(200, null);
//    }
//
//    @GetMapping("/find")
//    public ResponseConsultas<Compra> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
//        Iterable<Compra> boletos = null;
//        if (id > 0) {
//            boletos = boletosRepository.findAllById(List.of(id));
//        } else if (id == 0) {
//            boletos = boletosRepository.findAll();
//        } else {
//            return new ResponseConsultas<Compra>(404, "not found id", null);
//        }
//
//        return new ResponseConsultas<Compra>( 200 , null, boletos);
//    }
//
//    @PatchMapping("/update")
//    public Response updateBoleto(@RequestBody Compra boletos){
//        if(!boletosRepository.findById(boletos.getIdBoleto()).isPresent()){
//            return new Response(404, "Not Found");
//        }
//
//        boletosRepository.save(boletos);
//        return new Response(200, null);
//    }
//
//    @DeleteMapping("/delete")
//    public Response deleteBoleto(@RequestBody Compra boletos) {
//        if (!boletosRepository.findById(boletos.getIdBoleto()).isPresent()) {
//            return new Response(404, "Not Found");
//        }
//        boletosRepository.delete(boletos);
//        return new Response(200, null);
//    }
//}

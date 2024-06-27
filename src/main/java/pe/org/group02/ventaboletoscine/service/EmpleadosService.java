//package pe.org.group02.ventaboletoscine.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pe.org.group02.ventaboletoscine.entity.Empleados;
//import pe.org.group02.ventaboletoscine.repository.PeliculasRepository;
//import pe.org.group02.ventaboletoscine.response.Response;
//import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/employee")
//public class EmpleadosService {
//
//    @Autowired
//    private PeliculasRepository peliculasRepository;
//
//    @PostMapping("/add")
//    public Response addEmpleados(@RequestBody Empleados empleados) {
//        if (empleados.getIdEmpleado() != null) {
//            return new Response(401, "Anuthorized");
//        }
//
//        peliculasRepository.save(empleados);
//        return new Response(200, null);
//    }
//
//    @GetMapping("/find")
//    public ResponseConsultas<Empleados> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
//        Iterable<Empleados> empleados = null;
//        if (id > 0) {
//            empleados = peliculasRepository.findAllById(List.of(id));
//        } else if (id == 0) {
//            empleados = peliculasRepository.findAll();
//        } else {
//            return new ResponseConsultas<Empleados>(404, "Not Found", null);
//        }
//
//        return new ResponseConsultas<Empleados>(200, null, empleados);
//    }
//
//    @PatchMapping("/update")
//    public Response updateEmpleados(@RequestBody Empleados empleados) {
//        if (!peliculasRepository.findById(empleados.getIdEmpleado()).isPresent()) {
//            return new Response(404, "Not Found");
//        }
//        peliculasRepository.save(empleados);
//        return new Response(200, null);
//    }
//
//    @DeleteMapping("/delete")
//    public Response deleteEmpleados(@RequestBody Empleados empleados) {
//        if (!peliculasRepository.findById(empleados.getIdEmpleado()).isPresent()) {
//            return new Response(404, "Not Found");
//        }
//        peliculasRepository.delete(empleados);
//        return new Response(200, null);
//    }
//}

package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Empleados;
import pe.org.group02.ventaboletoscine.repository.EmpleadosRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosService {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @PostMapping("/add")
    public Response addEmpleados(@RequestBody Empleados empleados){
        if(empleados.getIdEmpleado() != null){
            return new Response(401, "Anuthorized");
        }

        empleadosRepository.save(empleados);
        return new Response(200, null);
    }

    @GetMapping("{id}")
    public ResponseConsultas<Empleados> findById(@RequestParam(value = "id", defaultValue = "0") Integer id){
        Iterable<Empleados> empleados = null;
        if(id > 0){
            empleados = empleadosRepository.findAllById(List.of(id));
        }
        else if (id == 0){
            empleados = empleadosRepository.findAll();
        }
        else {
            return new ResponseConsultas<Empleados>( 404 , "Not Found", null);
        }

        return new ResponseConsultas<Empleados>(200, null, empleados);
    }

    /*@PostMapping("/update")
    public UpdateEmpleadosResponse updateEmpleados(@RequestBody Empleados empleados){
        if(!empleadosRepository.findById(empleados.getIdEmpleado()).isPresent()){
            return new UpdateEmpleadosResponse("99", "Id no encontrado");
        }
        empleadosRepository.save(empleados);
        return new UpdateEmpleadosResponse("01", null);
    }

    @PostMapping("delete")
    public DeleteEmpleadosResponse deleteEmpleados(@RequestBody Empleados empleados){
        if(!empleadosRepository.findById(empleados.getIdEmpleado()).isPresent()){
            return new DeleteEmpleadosResponse("99", "Id no encontrado");
        }
        empleadosRepository.delete(empleados);
        return new DeleteEmpleadosResponse("01", null);
    }*/
}

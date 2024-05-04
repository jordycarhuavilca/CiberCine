package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Empleados;
import pe.org.group02.ventaboletoscine.entity.Usuarios;
import pe.org.group02.ventaboletoscine.repository.UsuariosRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/add")
    public Response addUsuario(@RequestBody Usuarios usuarios) {

        if (usuarios.getIdUsuario() != null) {
            return new Response(401, "Id no permitido");
        }

        usuariosRepository.save(usuarios);
        return new Response(200, null);
    }

    @GetMapping("/find")
    public ResponseConsultas<Usuarios> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Usuarios> usuarios = null;
        if (id > 0) {
            usuarios = usuariosRepository.findAllById(List.of(id));
        } else if (id == 0) {
            usuarios = usuariosRepository.findAll();
        } else {
            return new ResponseConsultas<Usuarios>(404, "not found id", null);
        }

        return new ResponseConsultas<Usuarios>( 200 , null, usuarios);
    }

    @PostMapping("/update")
    public Response updateUsuario(@RequestBody Usuarios usuarios){
        if(!usuariosRepository.findById(usuarios.getIdUsuario()).isPresent()){
            return new Response(404, "Not Found");
        }

        usuariosRepository.save(usuarios);
        return new Response(200, null);
    }

    @PostMapping("/delete")
    public Response deleteUsuario(@RequestBody Usuarios usuarios) {
        if (!usuariosRepository.findById(usuarios.getIdUsuario()).isPresent()) {
            return new Response(404, "Not Found");
        }
        usuariosRepository.delete(usuarios);
        return new Response(200, null);
    }

}

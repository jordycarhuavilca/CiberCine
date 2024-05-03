package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Usuarios;
import pe.org.group02.ventaboletoscine.repository.UsuariosRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/add")
    public Response addUsuarios(@RequestBody Usuarios usuarios) {

       /* if (usuarios.getIdUsuario() != null) {
            return new Response<Usuarios>("99", "Id no permitido");
        }*/

        /*usuariosRepository.save(usuarios);*/
        return new Response(200, null);
    }

    @GetMapping("{id}")
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
    @GetMapping()
    public ResponseConsultas<Usuarios> findAll() {
        Iterable<Usuarios> usuarios = null;
        usuarios = usuariosRepository.findAll();
        return new ResponseConsultas<Usuarios>( 200 , null, usuarios);
    }
}

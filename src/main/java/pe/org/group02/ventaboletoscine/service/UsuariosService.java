package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Usuarios;
import pe.org.group02.ventaboletoscine.repository.UsuariosRepository;
import pe.org.group02.ventaboletoscine.response.usuarios.FindUsuariosResponse;
import pe.org.group02.ventaboletoscine.response.usuarios.addUsuariosResponse;


import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/add")
    public addUsuariosResponse addUsuarios(@RequestBody Usuarios usuarios) {
        if (usuarios.getIdUsuario() != null) {
            return new addUsuariosResponse("99", "Id no permitido");
        }

        usuariosRepository.save(usuarios);
        return new addUsuariosResponse("01", null);
    }

    @GetMapping("find")
    public FindUsuariosResponse findUsuarios(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Usuarios> usuarios = null;
        if (id > 0) {
            usuarios = usuariosRepository.findAllById(List.of(id));
        } else if (id == 0) {
            usuarios = usuariosRepository.findAll();
        } else {
            return new FindUsuariosResponse("99", "Id no existe", null);
        }

        return new FindUsuariosResponse("01", null, usuarios);
    }
}

package pe.org.group02.ventaboletoscine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.entity.Usuarios;
import pe.org.group02.ventaboletoscine.repository.UsuariosRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
import pe.org.group02.ventaboletoscine.response.ResponseLogin;
import pe.org.group02.ventaboletoscine.security.JWTAuthenticationConfig;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private JWTAuthenticationConfig jwtAuthenticationConfig;

    @PostMapping("/login")
    public ResponseLogin loginUsuario(@RequestBody Usuarios usu){
        Usuarios usuResult = usuariosRepository.findByEmail(usu.getEmail());
        if(usuResult == null){
            return new ResponseLogin(404, "user not found", null);
        }
        if(!new BCryptPasswordEncoder().matches(usu.getPassword(), usuResult.getPassword())){
            return new ResponseLogin(99, "wrong password", null);
        }

        String token = jwtAuthenticationConfig.getJWTToken(usu.getEmail());
        return new ResponseLogin(01, null, token);
    }

    @PostMapping("/add")
    public Response addUsuario(@RequestBody Usuarios usu) {

        if (usu.getIdusuario() != null) {
            return new Response(401, "Id no permitido");
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(usu.getPassword());
        usu.setPassword(encodedPassword);
        usuariosRepository.save(usu);
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

    @PatchMapping("/update")
    public Response updateUsuario(@RequestBody Usuarios usu){
        if(!usuariosRepository.findById(usu.getIdusuario()).isPresent()){
            return new Response(404, "Not Found");
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(usu.getPassword());
        usu.setPassword(encodedPassword);
        usuariosRepository.save(usu);
        return new Response(200, null);
    }

    @DeleteMapping("/delete")
    public Response deleteUsuario(@RequestBody Usuarios usu) {
        if (!usuariosRepository.findById(usu.getIdusuario()).isPresent()) {
            return new Response(404, "Not Found");
        }
        usuariosRepository.delete(usu);
        return new Response(200, null);
    }

}

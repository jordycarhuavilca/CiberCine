package pe.org.group02.ventaboletoscine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.group02.ventaboletoscine.DTO.usuario.VerifyRegistrationDto;
import pe.org.group02.ventaboletoscine.entity.Usuarios;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
import pe.org.group02.ventaboletoscine.response.ResponseLogin;
import pe.org.group02.ventaboletoscine.service.UsuariosService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/login")
    public ResponseLogin loginUsuario(@RequestBody Usuarios usu){
       return this.usuariosService.loginUsuario(usu);
    }

    @PostMapping("/registrate")
    public Response registrate(@RequestBody Usuarios usu) {
        return this.usuariosService.registrate(usu);
    }

    @PostMapping("/verifyRegistration")
    public ResponseEntity<String> verifyRegistration(@RequestBody VerifyRegistrationDto verifyRegistrationDto) {
        return this.usuariosService.verifyRegistration(verifyRegistrationDto);
    }

    @GetMapping("/find")
    public ResponseConsultas<Usuarios> findById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        return this.usuariosService.findById(id);
    }

    /*@PatchMapping("/update")
    public Response updateUsuario(@RequestBody Usuarios usu){
        return this.usuariosService.updateUsuario(usu);
    }

    @DeleteMapping("/delete")
    public Response deleteUsuario(@RequestBody Usuarios usu) {
        return this.usuariosService.deleteUsuario(usu);
    }*/

}

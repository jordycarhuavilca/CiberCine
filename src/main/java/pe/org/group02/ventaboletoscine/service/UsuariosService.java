package pe.org.group02.ventaboletoscine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.org.group02.ventaboletoscine.DTO.usuario.UsuarioDto;
import pe.org.group02.ventaboletoscine.DTO.usuario.VerifyRegistrationDto;
import pe.org.group02.ventaboletoscine.entity.Email;
import pe.org.group02.ventaboletoscine.entity.Usuarios;
import pe.org.group02.ventaboletoscine.helper.emailHelper;
import pe.org.group02.ventaboletoscine.repository.UsuariosRepository;
import pe.org.group02.ventaboletoscine.response.Response;
import pe.org.group02.ventaboletoscine.response.ResponseConsultas;
import pe.org.group02.ventaboletoscine.response.ResponseLogin;
import pe.org.group02.ventaboletoscine.security.JWTAuthenticationConfig;
import pe.org.group02.ventaboletoscine.utils.emailConstans;
import pe.org.group02.ventaboletoscine.utils.userUtils;
import java.util.List;

@Service
@Slf4j
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private JWTAuthenticationConfig jwtAuthenticationConfig;

    @Autowired
    private TemporalRegistrationService temporalRegistrationService;

    @Autowired
    private emailHelper emailHelper;

    private void addUser(UsuarioDto user){
        Usuarios usuarios = new Usuarios();
        usuarios.setNombre(user.getNombre());
        usuarios.setApellido(user.getApellido());
        usuarios.setEmail(user.getEmail());
        usuarios.setPassword(user.getPassword());
        usuariosRepository.save(usuarios);
    }

    public ResponseLogin loginUsuario(Usuarios usu){
        Usuarios usuResult = usuariosRepository.findByEmail(usu.getEmail());
        if(usuResult == null){
            return new ResponseLogin(404, "incorrect credentials", null);
        }
        if(!new BCryptPasswordEncoder().matches(usu.getPassword(), usuResult.getPassword())){
            return new ResponseLogin(99, "incorrect credentials", null);
        }

        String token = jwtAuthenticationConfig.getJWTToken(usu.getEmail());
        return new ResponseLogin(01, null, token);
    }

    public ResponseEntity<String> verifyRegistration(VerifyRegistrationDto verifyRegistrationDto){
        log.info("verifyRegistration.init " + verifyRegistrationDto.toString());
        Email temporalRegistration = this.temporalRegistrationService.findById(verifyRegistrationDto.getCode());
        log.info("temporalRegistration.get " + temporalRegistration);


        if(temporalRegistration == null) return new ResponseEntity<String>( "error",
                    HttpStatus.BAD_REQUEST);

        Boolean isRigthUser= temporalRegistration.getUsuario().getEmail().equals(verifyRegistrationDto.getEmail());

        if (!isRigthUser) return new ResponseEntity<String>( "error",
                HttpStatus.BAD_REQUEST);

        this.addUser(temporalRegistration.getUsuario());
        return new ResponseEntity<String>( "Ok",
                HttpStatus.OK);
    }

    public Response registrate(Usuarios usu) {
        log.info("registrate.init " + usu.toString());
        if (usu.getEmail() == null && usu.getPassword() == null){
            return new Response(401, "Email   password are required");
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(usu.getPassword());
        usu.setPassword(encodedPassword);
        UsuarioDto usuario = userUtils.setUpUser(usu);
        Email email = userUtils.setUpEmail(emailConstans.ASUNTO[0],userUtils.generateNumericId(),usuario);
        log.info("registrate.email " + email.toString());
        temporalRegistrationService.save(email);
        emailHelper.sendEmail(email);
        return new Response(200, null);
    }

    public ResponseConsultas<Usuarios> findById(Integer id) {
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

    /*public Response updateUsuario(Usuarios usu){
        if(!usuariosRepository.findById(usu.getIdusuario()).isPresent()){
            return new Response(404, "Not Found");
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(usu.getPassword());
        usu.setPassword(encodedPassword);
        usuariosRepository.save(usu);
        return new Response(200, null);
    }

    public Response deleteUsuario(Usuarios usu) {
        if (!usuariosRepository.findById(usu.getIdusuario()).isPresent()) {
            return new Response(404, "Not Found");
        }
        usuariosRepository.delete(usu);
        return new Response(200, null);
    }*/
}

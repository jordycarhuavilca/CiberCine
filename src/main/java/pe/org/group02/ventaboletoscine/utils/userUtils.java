package pe.org.group02.ventaboletoscine.utils;

import pe.org.group02.ventaboletoscine.DTO.usuario.UsuarioDto;
import pe.org.group02.ventaboletoscine.entity.Email;
import pe.org.group02.ventaboletoscine.entity.Usuarios;

import java.security.SecureRandom;
import java.util.Random;

public class userUtils {
    private static final Random RANDOM = new SecureRandom();
    private static final int ID_LENGTH = 4;

    public static Integer generateNumericId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ID_LENGTH; i++) {
            int digit = RANDOM.nextInt(10);
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }
    public static UsuarioDto setUpUser(Usuarios user){
        UsuarioDto usuario = new UsuarioDto();
        usuario.setEmail(user.getEmail());
        usuario.setPassword(user.getPassword());
        usuario.setNombre(user.getNombre());
        usuario.setApellido(user.getApellido());
        return usuario;
    }
    public static Email setUpEmail(String asunto, Integer verificationCode, UsuarioDto user ) {
        Email email = new Email();
        email.setAsunto(asunto);
        email.setId(verificationCode);
        email.setUsuario(user);
        return email;
    }
}

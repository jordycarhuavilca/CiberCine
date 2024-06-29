package pe.org.group02.ventaboletoscine.DTO.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDto implements Serializable {
    private Integer idusuario;
    private String email;
    private String password;
    private String nombre;
    private String apellido;
}

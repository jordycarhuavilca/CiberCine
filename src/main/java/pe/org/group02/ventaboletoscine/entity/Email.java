package pe.org.group02.ventaboletoscine.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import pe.org.group02.ventaboletoscine.DTO.usuario.UsuarioDto;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RedisHash(value = "email",timeToLive = 60)
public class Email implements Serializable {
        public Integer id;
        private String asunto;
        private UsuarioDto usuario;
}

package pe.org.group02.ventaboletoscine.DTO.usuario;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class VerifyRegistrationDto {
    Integer code;
    String email;
}

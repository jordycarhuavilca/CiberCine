package pe.org.group02.ventaboletoscine.response.usuarios;

import pe.org.group02.ventaboletoscine.entity.Usuarios;

public record FindUsuariosResponse(String code, String error, Iterable<Usuarios> usuarios) {
}

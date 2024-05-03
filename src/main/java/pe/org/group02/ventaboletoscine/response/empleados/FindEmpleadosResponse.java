package pe.org.group02.ventaboletoscine.response.empleados;

import pe.org.group02.ventaboletoscine.entity.Empleados;

public record FindEmpleadosResponse(String code, String error, Iterable<Empleados> empleados) {
}

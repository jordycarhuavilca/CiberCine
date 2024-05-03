INSERT INTO cine (nombre, direccion, ciudad) VALUES ('Cinepolis', 'Av. Insurgentes Sur 123', 'Ciudad de México');
INSERT INTO cine (nombre, direccion, ciudad) VALUES ('Cinemex', 'Paseo de la Reforma 456', 'Ciudad de México');
INSERT INTO cine (nombre, direccion, ciudad) VALUES ('Cine Star', 'Calle Morelos 789', 'Guadalajara');

INSERT INTO salas (numero_sala, disponibilidad_sala, numero_butacas, id_cine) VALUES ('Sala 1', 1, 100, 1);
INSERT INTO salas (numero_sala, disponibilidad_sala, numero_butacas, id_cine) VALUES ('Sala 2', 1, 120, 2);
INSERT INTO salas (numero_sala, disponibilidad_sala, numero_butacas, id_cine) VALUES ('Sala 3', 1, 80, 3);

INSERT INTO roles (nombre_rol) VALUES ('Administrador');
INSERT INTO roles (nombre_rol) VALUES ('Operador');

INSERT INTO empleados (nombre_empleado, correo_empleado, telefono_empleado, id_rol, id_cine) VALUES ('Juan Perez', 'juan@example.com', '555-1234', 1, 1);
INSERT INTO empleados (nombre_empleado, correo_empleado, telefono_empleado, id_rol, id_cine) VALUES ('Maria Gonzalez', 'maria@example.com', '555-5678', 2, 2);
INSERT INTO empleados (nombre_empleado, correo_empleado, telefono_empleado, id_rol, id_cine) VALUES ('Luis Ramirez', 'luis@example.com', '555-9101', 2, 3);

INSERT INTO usuarios (id_empleado, usuario, contrasenia, created_at) VALUES (1, 'usuario1', 'contrasenia1', '2024-05-01');
INSERT INTO usuarios (id_empleado, usuario, contrasenia, created_at) VALUES (2, 'usuario2', 'contrasenia2', '2024-05-02');
INSERT INTO usuarios (id_empleado, usuario, contrasenia, created_at) VALUES (3, 'usuario3', 'contrasenia3', '2024-05-03');

INSERT INTO generos (nombre_genero) VALUES ('Drama');
INSERT INTO generos (nombre_genero) VALUES ('Acción');
INSERT INTO generos (nombre_genero) VALUES ('Comedia');

INSERT INTO peliculas (nombre_pelicula, director_pelicula, duracion_pelicula, idioma_pelicula) VALUES ('Avatar', 'James Cameron', '162 minutos', 'Inglés');
INSERT INTO peliculas (nombre_pelicula, director_pelicula, duracion_pelicula, idioma_pelicula) VALUES ('El Padrino', 'Francis Ford Coppola', '175 minutos', 'Inglés');
INSERT INTO peliculas (nombre_pelicula, director_pelicula, duracion_pelicula, idioma_pelicula) VALUES ('Titanic', 'James Cameron', '195 minutos', 'Inglés');

INSERT INTO peliculas_generos (id_pelicula, id_genero) VALUES (1, 1);
INSERT INTO peliculas_generos (id_pelicula, id_genero) VALUES (1, 2);
INSERT INTO peliculas_generos (id_pelicula, id_genero) VALUES (2, 1);

INSERT INTO funciones (fecha, id_peligen, id_sala) VALUES ('2024-05-01', 1, 1);
INSERT INTO funciones (fecha, id_peligen, id_sala) VALUES ('2024-05-02', 2, 2);
INSERT INTO funciones (fecha, id_peligen, id_sala) VALUES ('2024-05-03', 3, 3);

INSERT INTO boletos (id_funcion, precio, cantidad) VALUES (1, 10.5, 2);
INSERT INTO boletos (id_funcion, precio, cantidad) VALUES (2, 12.0, 3);
INSERT INTO boletos (id_funcion, precio, cantidad) VALUES (3, 9.75, 4);

INSERT INTO comprobante_pago (id_boleto, id_usuario, monto_total, metodo_pago) VALUES (1, 1, 21.0, 'Tarjeta de crédito');
INSERT INTO comprobante_pago (id_boleto, id_usuario, monto_total, metodo_pago) VALUES (2, 2, 36.0, 'Efectivo');
INSERT INTO comprobante_pago (id_boleto, id_usuario, monto_total, metodo_pago) VALUES (3, 3, 39.0, 'Transferencia bancaria');



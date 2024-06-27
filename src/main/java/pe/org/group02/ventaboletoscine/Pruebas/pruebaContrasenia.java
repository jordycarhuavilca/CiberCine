package pe.org.group02.ventaboletoscine.Pruebas;

import pe.org.group02.ventaboletoscine.security.Constants;

public class pruebaContrasenia {
    public static void main(String[] args) {
        String encryptedPassword = Constants.encryptPassword("ivan123");
        System.out.println("contrasenia encriptada : " + encryptedPassword);
    }
}

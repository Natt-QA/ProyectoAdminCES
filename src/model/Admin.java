package model;

public class Admin extends Usuario {

    public Admin(String nombre, String apellido, String email, String pais, String contrasena) {
        super(nombre, apellido, email, pais, contrasena);
    }

    public String getRol() {
        return "ADMIN";
    }
}
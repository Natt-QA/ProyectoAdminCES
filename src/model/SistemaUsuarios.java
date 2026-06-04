package model;

import java.util.ArrayList;

public class SistemaUsuarios {

    private ArrayList<Usuario> usuarios;

    public SistemaUsuarios() {
        usuarios = new ArrayList<>();
        cargarUsuariosPrueba();
    }

    private void cargarUsuariosPrueba() {
        usuarios.add(new Tester("Natalia", "Tester", "tallica.cs@gmail.com", "Uruguay", "12345", "Senior"));
        usuarios.add(new Admin("Natalia", "Larrondo", "larrondo.nat@gmail.com", "Uruguay", "1234"));
    }

    public boolean existeEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public Usuario login(String email, String contrasena) {
        Usuario u = buscarPorEmail(email);
        if (u == null) {
            return null;
        }
        if (u.getContrasena().equals(contrasena)) {
            return u;
        }
        return null;
    }

    public void registrarAdmin(String nombre, String apellido, String email, String pais, String contrasena) {
        usuarios.add(new Admin(nombre, apellido, email, pais, contrasena));
    }

    public void registrarTester(String nombre, String apellido, String email, String pais, String contrasena, String tipoTester) {
        usuarios.add(new Tester(nombre, apellido, email, pais, contrasena, tipoTester));
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u.getRol() + " | " + u.getNombre() + " " + u.getApellido() + " | " + u.getEmail());
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
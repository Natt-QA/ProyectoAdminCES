package model;

import java.util.HashMap;
import java.util.Map;

public class SistemaUsuarios {

    private Map<String, Usuario> usuarios;

    public SistemaUsuarios() {
        usuarios = new HashMap<>();
        cargarUsuariosPrueba();
    }

    private void cargarUsuariosPrueba() {
        Tester t1 = new Tester("Natalia", "Tester", "tallica.cs@gmail.com", "Uruguay", "12345", "Senior");
        usuarios.put(t1.getEmail().toLowerCase(), t1);

        Admin a1 = new Admin("Natalia", "Larrondo", "larrondo.nat@gmail.com", "Uruguay", "1234");
        usuarios.put(a1.getEmail().toLowerCase(), a1);
    }

    public boolean existeEmail(String email) {
        return usuarios.containsKey(email.toLowerCase());
    }

    public Usuario buscarPorEmail(String email) {
        return usuarios.get(email.toLowerCase());
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
        Admin nuevo = new Admin(nombre, apellido, email, pais, contrasena);
        usuarios.put(nuevo.getEmail().toLowerCase(), nuevo);
    }

    public void registrarTester(String nombre, String apellido, String email, String pais, String contrasena, String tipoTester) {
        Tester nuevo = new Tester(nombre, apellido, email, pais, contrasena, tipoTester);
        usuarios.put(nuevo.getEmail().toLowerCase(), nuevo);
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios.values()) {
            System.out.println(u.getRol() + " | " + u.getNombre() + " " + u.getApellido() + " | " + u.getEmail());
        }
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
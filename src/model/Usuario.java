package model;

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private String pais;
    private String contrasena;

    public Usuario(String nombre, String apellido, String email, String pais, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pais = pais;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getPais() { return pais; }
    public String getContrasena() { return contrasena; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setPais(String pais) { this.pais = pais; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public abstract String getRol();
}
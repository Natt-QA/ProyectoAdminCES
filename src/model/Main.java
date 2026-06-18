package model;

import java.util.Scanner;

public class Main {

    static SistemaUsuarios sistema = new SistemaUsuarios();

    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("Elija una opción");
            System.out.println("1- Login");
            System.out.println("2- Registro");
            System.out.println("3- Listar usuarios");
            System.out.println("4- Buscar usuario");
            System.out.println("5- Salir");
            Scanner scan = new Scanner(System.in);
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    login();
                    break;
                case 2:
                    registro();
                    break;
                case 3:
                    sistema.listarUsuarios();
                    break;
                case 4:
                    buscarUsuario();
                    break;
                default:
                    System.out.println("Saliendo...");
                    opcion = 5;
                    break;
            }
        } while (opcion != 5);
    }

    private static void registro() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese nombre:");
        String nombre = scan.nextLine();
        while (nombre == null || nombre.equals("") || nombre.length() <= 5) {
            System.out.println("No supera la cantidad minima de caracteres, ingrese nuevamente el nombre:");
            nombre = scan.nextLine();
        }

        System.out.println("Ingrese apellido:");
        String apellido = scan.nextLine();
        while (apellido == null || apellido.equals("")) {
            System.out.println("No supera la cantidad minima de caracteres, ingrese nuevamente el apellido:");
            apellido = scan.nextLine();
        }

        System.out.println("Ingrese email:");
        String email = scan.nextLine();
        while (email == null || !email.contains("@")) {
            System.out.println("Formato email incorrecto, ingrese nuevamente el email:");
            email = scan.nextLine();
        }

        System.out.println("Ingrese país:");
        String pais = scan.nextLine();
        while (pais == null || pais.equals("")) {
            System.out.println("No supera la cantidad minima de caracteres, ingrese nuevamente el pais:");
            pais = scan.nextLine();
        }

        System.out.println("Ingrese contraseña:");
        String contrasena = scan.nextLine();
        while (contrasena == null || contrasena.equals("") || contrasena.length() < 8) {
            System.out.println("La contraseña debe tener un mínimo de 8 caracteres, ingrese nuevamente la contraseña:");
            contrasena = scan.nextLine();
        }

        System.out.println("Ingrese tipo de usuario:");
        System.out.println("1- Admin");
        System.out.println("2- Tester");
        int tipo = scan.nextInt();

        if (tipo == 1) {
            sistema.registrarAdmin(nombre, apellido, email, pais, contrasena);
            System.out.println("Registro exitoso.");
        } else if (tipo == 2) {
            System.out.println("Ingrese tipo de Tester:");
            System.out.println("1- Junior");
            System.out.println("2- Semi-Senior");
            System.out.println("3- Senior");
            int tipoTesterOpcion = scan.nextInt();
            String tipoTester;
            if (tipoTesterOpcion == 1) {
                tipoTester = "Junior";
            } else if (tipoTesterOpcion == 2) {
                tipoTester = "Semi-Senior";
            } else {
                tipoTester = "Senior";
            }
            sistema.registrarTester(nombre, apellido, email, pais, contrasena, tipoTester);
            System.out.println("Registro exitoso.");
        } else {
            System.out.println("Opción inválida. No se registró ningún usuario.");
        }
    }

    private static void login() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese email: ");
        String emailIngresado = scan.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contrasenaIngresada = scan.nextLine();

        Usuario u = sistema.login(emailIngresado, contrasenaIngresada);
        if (u == null) {
            if (!sistema.existeEmail(emailIngresado)) {
                System.out.println("No existe el usuario en el sistema.");
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Usuario logueado con éxito");
        }
    }

    private static void buscarUsuario() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese email a buscar: ");
        String email = scan.nextLine();

        Usuario u = sistema.buscarPorEmail(email);
        if (u == null) {
            System.out.println("No existe un usuario con ese email.");
        } else {
            System.out.println(u.getRol() + " | " + u.getNombre() + " " + u.getApellido() + " | " + u.getEmail());
        }
    }
}
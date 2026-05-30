# Proyecto Admin CES

Este proyecto corresponde al relevamiento inicial del sistema Admin CES y a la implementación de primeras funcionalidades por consola en Java.

## Funcionalidades detectadas en el sistema

* Inicio de sesión: permite acceder al sistema con un usuario registrado.  
  Datos requeridos: email y contraseña.

* Registro de usuario administrador: permite registrar un nuevo usuario administrador en el sistema.  
  Datos requeridos: nombre, apellido, email, contraseña y país de nacimiento.

* Visualización de usuarios: permite ver el listado de usuarios registrados en el sistema.  
  Datos requeridos: no requiere ingresar datos adicionales.

* Reinicio de contraseña: permite restablecer la contraseña de un usuario.  
  Datos requeridos: email y nueva contraseña.

* Alta de cuenta para tester: permite registrar un usuario tester en el sistema.  
  Datos requeridos: nombre, apellido, email, país, contraseña y tipo de tester.

* Ver perfil de usuario administrador: permite consultar los datos del usuario administrador autenticado.  
  Datos requeridos: usuario autenticado.

* Editar perfil de usuario administrador: permite modificar los datos del usuario administrador autenticado.  
  Datos requeridos: nombre, apellido, email, país y contraseña.

* Eliminar usuario: permite eliminar un usuario tester del sistema.  
  Datos requeridos: usuario a eliminar.

* Cerrar sesión: permite finalizar la sesión del usuario autenticado.  
  Datos requeridos: no requiere ingresar datos adicionales.

## Funcionalidades implementadas por consola

* Menú principal con opciones de Login, Registro y Salir.
* Registro de usuario administrador.
* Validación de datos básicos durante el registro.
* Login con verificación de email y contraseña.
* Mensajes de error cuando el usuario no existe o la contraseña es incorrecta.

## Clase Usuario

Se creó la clase `Usuario` con atributos básicos:

* nombre
* apellido
* email
* país
* contraseña

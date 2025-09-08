Sistema de Gestión de Biblioteca Digital 
Un sistema simple implementado en Java para gestionar libros, usuarios y préstamos en una biblioteca. Este proyecto sirve como un ejemplo práctico del uso de la Programación Orientada a Objetos (POO) y las colecciones de Java.

Objetivo Principal
El objetivo es demostrar la aplicación de conceptos fundamentales de Java para construir un sistema funcional y bien estructurado. Se hace especial énfasis en:

Encapsulamiento: Proteger los datos de las clases.

Inmutabilidad: La clase Libro es inmutable para garantizar la integridad de los datos del catálogo.

Uso de Colecciones:

Map: Para un acceso rápido a libros (por ISBN) y usuarios (por ID).

Set: Para registrar de manera eficiente los libros que están actualmente prestados y evitar duplicados.

List: Para mantener el registro de los libros que cada usuario tiene en su poder.

Estructura del Proyecto
El sistema está compuesto por cuatro clases principales:

Libro.java: Representa un libro con atributos como isbn, titulo, autor y categoria. Es una clase inmutable.

Usuario.java: Representa a un usuario de la biblioteca con un id, nombre y una lista de los ISBN de los libros que tiene prestados.

Biblioteca.java: Es el corazón del sistema. Centraliza toda la lógica de negocio: gestiona el catálogo de libros, el registro de usuarios y las operaciones de prestar y devolver libros.

Main.java: Una clase ejecutable que contiene un flujo de prueba para demostrar las funcionalidades del sistema.

Cómo Empezar
Para compilar y ejecutar este proyecto, necesitas tener un JDK (Java Development Kit) instalado en tu sistema (versión 8 o superior).

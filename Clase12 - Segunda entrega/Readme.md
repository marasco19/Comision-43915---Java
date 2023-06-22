# Facturación ABM

Este es un proyecto llamado Facturación ABM desarrollado para el Curso de Java Comisión 43915. El proyecto utiliza el framework Spring Boot y se centra en la implementación de operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para cuatro entidades: Client, Products, Invoice e InvoiceDetail.

## Clase principal

La clase principal que se encarga de levantar el proyecto es `Clase8ApplicationJpaAbmApplication`. Esta clase contiene el método `main` que inicia la aplicación Spring Boot y configura el contexto de la aplicación.

## Librerías utilizadas

El proyecto hace uso de las siguientes librerías principales:

1. `spring-boot-starter-data-jpa`: Esta librería proporciona la funcionalidad de persistencia de datos mediante el uso de JPA (Java Persistence API). Permite interactuar con la base de datos de forma sencilla y abstrae gran parte de la complejidad asociada con el acceso a datos.

2. `spring-boot-starter-web`: Esta librería facilita el desarrollo de aplicaciones web utilizando Spring MVC. Proporciona todas las dependencias necesarias para crear controladores, manejar solicitudes HTTP y realizar la configuración básica para el desarrollo web.

3. `h2`: H2 es una base de datos relacional en memoria que se utiliza en este proyecto para el almacenamiento de datos. Es una base de datos ligera y fácil de usar, ideal para el desarrollo y pruebas en entornos locales.

4. `spring-boot-starter-test`: Esta librería contiene las dependencias necesarias para escribir pruebas unitarias y de integración en el proyecto. Proporciona herramientas y utilidades para facilitar el testing de las diferentes capas de la aplicación.

5. `spring-boot-maven-plugin`: Este plugin de Maven se utiliza para empaquetar y generar el archivo ejecutable del proyecto. Permite crear un archivo JAR autocontenido que incluye todas las dependencias necesarias para ejecutar la aplicación.


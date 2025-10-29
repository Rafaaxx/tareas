# Gestor de Tareas -  Fundamentos de Spring Boot
Proyecto desarrollado para la materia **Programación III** (UTN - TUP).

Este proyecto fue realizado aplicando los fundamentos de Spring Boot:

-Inyeccion de dependencias.

-Application context.

-Uso de profiles.

-Uso de @Service, @Repository y @Component, definiendo roles.

-Uso de application.properties, con profiles especificos (dev y prod).

-Beans.


## ⚙️ **Tecnologías Utilizadas**

| Tecnología | Descripción |
|------------|-------------|
|  Java 21 | Lenguaje de programación |
|  Spring Boot 3.5.7 | Framework principal |
|  Maven | Gestión de dependencias |
|  Lombok | Reducción de código boilerplate |
|  Spring DevTools | Reinicio automático en desarrollo |
|  JUnit (starter-test) | Pruebas unitarias |

--- 
## Ejecucion del Proyecto
#### 1. Desde IntelliJ IDEA o cualquier IDE:

Abrí la clase TareasApplication.java

-Ejecutá el método main

-Observá la salida en la consola (modo dev o prod, lo cual se puede cambiar en application.properties)
 
#### 2. Desde la terminal (Maven):
mvn spring-boot:run

## Cambio de Profiles

Para cambiar entre entornos, entrá en application.properties y editá esta linea, eligiendo entre estas 2 opciones:

-spring.profiles.active=dev (modo de desarrollo).

-spring.profiles.active=prod (modo de producción).

## Capturas de pantalla
Modo desarrollo:

Imagen 1:
![Captura de pantalla 2025-10-29 125226.png](Capturas%2FCaptura%20de%20pantalla%202025-10-29%20125226.png)
Imagen 2:
![Captura de pantalla 2025-10-29 125237.png](Capturas%2FCaptura%20de%20pantalla%202025-10-29%20125237.png)
Modo produccion:

Imagen 1:
![Captura de pantalla 2025-10-29 125329.png](Capturas%2FCaptura%20de%20pantalla%202025-10-29%20125329.png)
Imagen 2:
![Captura de pantalla 2025-10-29 125334.png](Capturas%2FCaptura%20de%20pantalla%202025-10-29%20125334.png)
## Conclusiones de lo aprendido 
Despues de realizar el trabajo, puedo concluir en que aprendí 
a utilizar Spring Boot, siendo capaz de crear proyectos usando esta
herramienta. He logrado manejar la inyección de dependencias, estereotipos, uso de CommandLineRunner archivos application.properties
y similares, e implementar profiles. Además, usé lombok y streams.
## Nombre y legajo
Rafael Navarro -
52718

Comisión 1
# Prueba Tecnica

Desarrollo de la prueba tecnica para el proceso de selección

## Primero pasos

Este proyecto esta pensado para ser desplegado como un contenedor en un Docker Engine, construyendo primero la imagen
y luego ejecutando docker run, mas abajo explico los pasos necesarios para el despliegue

### Prerequisitos

```
Docker
```

### Instalación

Descargar el proyecto:

```
https://github.com/degogamez/prueba-tecnica/archive/master.zip
```

Descomprimimos e ingresamos al proyecto prueba-tecnica

Construimos la imagen docker

```
docker build -t prueba-tecnica .
```

Ejecutamos el contenedor

```
docker run -p 8080:8080 prueba-tecnica
```

¡Y Listo! Hasta este punto tienes la aplicación andando :D

Para saber como consumir la api, por favor visitar la documentacion de swagger

[Documentación API](http://localhost:8080/swagger-ui.html)

## Construido con

* [Spring Framework]
* [Spring Boot]
* [Gradle]
* [H2 DB]
* [Docker]
* [Swagger]
* [JUnit]
* [Mockito]
* [Tomcat]
* [JAX-RS]
* [JPA]

## Autor

* **Diego Andres Gamez Teran** [degogamez](https://github.com/degogamez)

## Agradecimientos

* Gracias por la oportunidad
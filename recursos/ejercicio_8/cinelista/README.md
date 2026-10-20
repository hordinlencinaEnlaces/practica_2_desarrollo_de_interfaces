# CineLista v0

Práctica 2 de Desarrollo de Interfaces (DAM) - Spring Boot + Thymeleaf + Bootstrap.

## Pantallas

| Pantalla | URL | Qué hace |
|---|---|---|
| Mi lista | `GET /` | Tabla con las películas guardadas y botón de borrar por fila |
| Añadir título | `GET /anadir` | Formulario que guarda la película |

## Endpoints

- `POST /peliculas` guarda la película del formulario y vuelve a Mi lista.
- `POST /peliculas/{id}/eliminar` elimina la película indicada.

## Ejecutar

Requisitos: Java 17+ y Maven.

```bash
mvn spring-boot:run
```

Abrir http://localhost:8080

## Tests

```bash
mvn test
```

Los datos se guardan en memoria (se pierden al reiniciar).

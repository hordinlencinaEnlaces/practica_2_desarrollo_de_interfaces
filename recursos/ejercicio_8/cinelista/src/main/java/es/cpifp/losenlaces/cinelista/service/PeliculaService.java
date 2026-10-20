package es.cpifp.losenlaces.cinelista.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.cpifp.losenlaces.cinelista.model.Pelicula;

/**
 * Almacén en memoria de las películas (v0: sin base de datos).
 */
@Service
public class PeliculaService {

    private final List<Pelicula> peliculas = new CopyOnWriteArrayList<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

    public List<Pelicula> listar() {
        return new ArrayList<>(peliculas);
    }

    public Pelicula guardar(Pelicula pelicula) {
        pelicula.setId(siguienteId.getAndIncrement());
        peliculas.add(pelicula);
        return pelicula;
    }

    public void eliminar(Long id) {
        peliculas.removeIf(p -> p.getId().equals(id));
    }
}

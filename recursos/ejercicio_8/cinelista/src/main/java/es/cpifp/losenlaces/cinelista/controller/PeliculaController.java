package es.cpifp.losenlaces.cinelista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.cpifp.losenlaces.cinelista.model.Pelicula;
import es.cpifp.losenlaces.cinelista.service.PeliculaService;

@Controller
public class PeliculaController {

    private final PeliculaService servicio;

    public PeliculaController(PeliculaService servicio) {
        this.servicio = servicio;
    }

    /** Página de inicio: Mi lista. */
    @GetMapping("/")
    public String miLista(Model model) {
        model.addAttribute("peliculas", servicio.listar());
        return "mi-lista";
    }

    /** Formulario de Añadir título. */
    @GetMapping("/anadir")
    public String formulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "anadir-titulo";
    }

    /** Botón Guardar: recibe los datos del formulario. */
    @PostMapping("/peliculas")
    public String guardar(@ModelAttribute Pelicula pelicula) {
        servicio.guardar(pelicula);
        return "redirect:/";
    }

    /** Botón Borrar: elimina la película correspondiente. */
    @PostMapping("/peliculas/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/";
    }
}

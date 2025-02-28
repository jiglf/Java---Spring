package laguerradelanillo.guerra.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import laguerradelanillo.guerra.modelo.Ejercito;
import laguerradelanillo.guerra.modelo.Personaje;
import laguerradelanillo.guerra.recursos.Raza;
import laguerradelanillo.guerra.recursos.Tipo;
import laguerradelanillo.guerra.servicio.Juego;


@Controller
public class controladorPrincipal {

    static ModelAndView modelAndView = new ModelAndView();

    // guardo las listas en una variable de instancia, en lugar de crearlas en cada petición
    private static Ejercito ejercitoHeroes = Juego.creacionEjercitoHeroes();
    private static Ejercito ejercitoBestias = Juego.creacionEjercitoBestias();

   
    @GetMapping("/")
    public ModelAndView home() {

        modelAndView.addObject("ejercitoHeroes", ejercitoHeroes.getPersonajes());
        modelAndView.addObject("ejercitoBestias", ejercitoBestias.getPersonajes());


        modelAndView.setViewName("principal");

       
    return modelAndView;

       
    }

    @GetMapping("/crear-personaje")
    public ModelAndView mostrarFormularioCreacion() {
       
        modelAndView.setViewName("crear-personaje");

    return modelAndView;
    }

    @PostMapping("/guardar-personaje")
    public String guardarPersonaje(@ModelAttribute Personaje nuevoPersonaje) {

        if (nuevoPersonaje.getRaza() == Raza.ELFO || nuevoPersonaje.getRaza() == Raza.HUMANO ||
        nuevoPersonaje.getRaza() == Raza.HOBBIT || nuevoPersonaje.getRaza() == Raza.MAGO) {
        nuevoPersonaje.setTipo(Tipo.HEROE);   // Asignamos tipo Héroe
        if (!ejercitoHeroes.contienePersonaje(nuevoPersonaje)) {
            ejercitoHeroes.anadirPersonaje(nuevoPersonaje);
        }
        } else {
        nuevoPersonaje.setTipo(Tipo.BESTIA);  // Asignamos tipo Bestia
        if (!ejercitoBestias.contienePersonaje(nuevoPersonaje)) {
            ejercitoBestias.anadirPersonaje(nuevoPersonaje);
        }
    }
 
    // Redirige de vuelta a la página principal
    return "redirect:/";


    }

    @GetMapping("/resultadoLucha")
    public ModelAndView resultadoLucha() {

        modelAndView.addObject("resumenBatalla", Juego.lucha() );

        modelAndView.setViewName("resultadoBatalla");

    return modelAndView;

    }
   
    @GetMapping("/reiniciar-juego")
    public String reiniciarJuego() {

        ejercitoHeroes.vaciarEjercito();
        ejercitoBestias.vaciarEjercito();

        ejercitoHeroes = Juego.creacionEjercitoHeroes();
        ejercitoBestias = Juego.creacionEjercitoBestias();

        Juego.lucha();

    return "redirect:/";
    }



}

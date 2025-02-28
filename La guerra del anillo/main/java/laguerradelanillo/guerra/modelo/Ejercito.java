package laguerradelanillo.guerra.modelo;

import java.util.ArrayList;

public class Ejercito {


    /* clase para definir la estructura y los metodos de cada lista para 
    asi poder operar con los opciones de lista
    la de heroes y la de bestias
    */
    
    ArrayList<Personaje> ejercitoPersonajes = new ArrayList<>();
    
    
    public void anadirPersonaje(Personaje personaje) {
        ejercitoPersonajes.add(personaje);
    }
    
    public boolean borrarPersonaje(Personaje personaje) {
        return ejercitoPersonajes.remove(personaje);
    }
    
    public boolean estaVacio() {
        return ejercitoPersonajes.isEmpty();
    }
    
    public int tamanhoEjercito() {
        return ejercitoPersonajes.size();
    }
    
    public Personaje obtenerPersonaje(int indice) {
        return ejercitoPersonajes.get(indice);
    }
    
    public Personaje borrarPosicion(int indice) {
        return ejercitoPersonajes.remove(indice);
    }
    
    public void cambiarPersonaje(int indice, Personaje personaje) {
        ejercitoPersonajes.set(indice, personaje);
    }

    public void vaciarEjercito() {
        ejercitoPersonajes.clear();
    }

    //para comprobar si ya existe el mismo personaje
    public boolean contienePersonaje(Personaje personaje) {
        return ejercitoPersonajes.contains(personaje);
    }

    public ArrayList<Personaje> getPersonajes() {
        return ejercitoPersonajes;
    }

    



}

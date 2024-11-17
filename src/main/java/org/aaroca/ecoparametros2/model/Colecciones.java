package org.aaroca.ecoparametros2.model;

import java.util.HashMap;

public class Colecciones {

    private static final HashMap<String, String> generos = new HashMap<>();
    private static final HashMap<String, Pais> paises = new HashMap<>();
    private static final HashMap<String, String> musica = new HashMap<>();
    private static final HashMap<String, String> aficiones = new HashMap<>();


    static {

        generos.put("F", "Femenino");
        generos.put("M", "Masculino");
        generos.put("O", "Otros");


        paises.put("es", new Pais("España", "Castellano", "34", true,"espania.jpg"));
        paises.put("fr", new Pais("Francia", "Francés", "33", false,"francia.jpg"));
        paises.put("it", new Pais("Italia", "Italiano", "39", false,"italia.jpg"));
        paises.put("pt", new Pais("Portugal", "Portugués", "351", false,"portugal.jpg"));
        paises.put("en", new Pais("Reino unido", "Inglés", "44", true,"reino_unido.jpg"));


        musica.put("E", "Electrónica");
        musica.put("F", "Funky");
        musica.put("N", "New age");
        musica.put("P", "Pop");
        musica.put("R", "Rock");


        aficiones.put("D","Deporte");
        aficiones.put("L","Lectura");
        aficiones.put("P","Pintura");
        aficiones.put("V","Viajes");
    }


    public static HashMap<String, String> getGeneros() {
        return generos;
    }

    public static HashMap<String, Pais> getPaises() {
        return paises;
    }

    public static HashMap<String, String> getMusicas() {
        return musica;
    }

    public static HashMap<String, String> getAficiones() {
        return aficiones;
    }
}
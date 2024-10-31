package org.aaroca.ecoparametros2.model;

import java.util.HashMap;

public class Colecciones {

    private static final HashMap<String, String> generos = new HashMap<>();
    private static final HashMap<String, String> paises = new HashMap<>();
    private static final HashMap<String, String> musica = new HashMap<>();
    private static final HashMap<String, String> aficiones = new HashMap<>();


    static {

        generos.put("F", "Femenino");
        generos.put("M", "Masculino");
        generos.put("O", "Otros");


        paises.put("E", "España");
        paises.put("F", "Francia");
        paises.put("A", "Andorra");
        paises.put("P", "Portugal");


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

    public static HashMap<String, String> getPaises() {
        return paises;
    }

    public static HashMap<String, String> getMusicas() {
        return musica;
    }

    public static HashMap<String, String> getAficiones() {
        return aficiones;
    }
}
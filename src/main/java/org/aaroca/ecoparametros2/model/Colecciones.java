package org.aaroca.ecoparametros2.model;

import java.util.HashMap;

public class Colecciones {

    private static final HashMap<String, String> generos = new HashMap<>();
    private static final HashMap<String, String> paises = new HashMap<>();
    private static final HashMap<String, String> musica = new HashMap<>();


    static {

        generos.put("F", "Femenino");
        generos.put("M", "Masculino");
        generos.put("O", "Otros");


        paises.put("E", "España");
        paises.put("F", "Francia");
        paises.put("A", "Andorra");
        paises.put("P", "Portugal");


        musica.put("B", "Blues");
        musica.put("R", "Rock");
        musica.put("C", "Musica clasica");
        musica.put("H", "Hardstyle");
    }


    public static HashMap<String, String> getGeneros() {
        return generos;
    }

    public static HashMap<String, String> getPaises() {
        return paises;
    }

    public static HashMap<String, String> getMusica() {
        return musica;
    }
}
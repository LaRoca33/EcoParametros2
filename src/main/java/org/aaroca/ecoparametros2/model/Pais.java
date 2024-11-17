package org.aaroca.ecoparametros2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class Pais {
    private String pais;
    private String idioma;
    private String prefijoTelefonicoPais;
    private Boolean muestraIdioma;
    private String nombreArchivoBandera;
}

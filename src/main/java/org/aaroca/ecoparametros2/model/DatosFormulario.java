package org.aaroca.ecoparametros2.model;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DatosFormulario {
    private String usuario;
    private String clave;
    private String pi;
    private String generoSeleccionado;
    private ArrayList<String> aficionesSeleccionadas;
    private String comentarios;
}

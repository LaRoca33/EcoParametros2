package org.aaroca.ecoparametros2.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DatosFormulario {
    private String usuario;
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    private String paisSeleccionado;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Float peso;
    private String prefijoTelefonico;
    private String telefono;
    private String email;
    private String url;
    private List<String> aficionesSeleccionadas;
    private List<String> musicasSeleccionadas;
    private String comentarios;
    private Boolean licencia;
}

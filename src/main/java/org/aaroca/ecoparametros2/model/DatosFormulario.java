package org.aaroca.ecoparametros2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    @NotNull
    private String usuario;
    @NotBlank
    @NotNull
    private String clave;
    @NotNull
    @NotBlank
    private String confirmarClave;
    @NotNull
    private String generoSeleccionado;
    @NotNull
    @NotBlank
    private String paisSeleccionado;
 //   @NotNull
 //   @NotBlank
    private LocalDate fechaNacimiento;
    @NotNull
    private Integer edad;
    @NotNull
    private Float peso;
    @NotNull
    private String prefijoTelefonico;
    @NotNull
    private String telefono;
    @NotNull
    private String email;
    @NotNull
    private String url;
    @NotNull
    private List<String> aficionesSeleccionadas;
    @NotNull
    private List<String> musicasSeleccionadas;
    @NotNull
    private String comentarios;
    @NotNull
    private Boolean licencia;
}

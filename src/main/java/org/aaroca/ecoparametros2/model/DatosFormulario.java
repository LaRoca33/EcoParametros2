package org.aaroca.ecoparametros2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.aaroca.ecoparametros2.model.Validaciones.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ComprobarClaves
@ComprobarEdadFechaNac
public class DatosFormulario {
    @NotBlank
    @NotNull
    private String usuario;
    @NotBlank
    @NotNull
    @Size(min=6, max=12)
    @Pattern(regexp ="(?=.*[0-9])(?=.*[a-zñ])(?=.*[A-ZÑ])(?=.*[!#$%&]).*")
    private String clave;
    @NotNull
    @NotBlank
    private String confirmarClave;
    @NotNull
    @ComprobarGeneros(message = "{ComprobarGeneros.DatosFormulario.generoSeleccionado}")
    private String generoSeleccionado;
    @NotNull
    @NotBlank
    @ComprobarPais(message = "{ComprobarPais.DatosFormulario.paisSeleccionado}")
    private String paisSeleccionado;
 //   @NotNull
 //   @NotBlank
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    @ComprobarFechaNac(message = "{ComprobarFechaNac.DatosFormulario.fechaNacimiento}")
    private LocalDate fechaNacimiento;
    @NotNull
    private Integer edad;
    @NotNull
    private Float peso;
    @NotNull
    @ComprobarPrefijoTel(message = "{ComprobarPrefijoTel.DatosFormulario.prefijoTelefonico}")
    private String prefijoTelefonico;
    @NotNull
    @Size(min = 9, max = 9)
    private String telefono;
    @NotNull
    @ComprobarEmail(message = "{ComprobarEmail.DatosFormulario.email}")
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
    @ComprobarLicencia(message = "{ComprobarLicencia.DatosFormulario.licencia}")
    private Boolean licencia;
}

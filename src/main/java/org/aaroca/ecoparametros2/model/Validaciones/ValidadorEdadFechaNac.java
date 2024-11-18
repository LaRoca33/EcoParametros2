package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.aaroca.ecoparametros2.model.DatosFormulario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ValidadorEdadFechaNac implements ConstraintValidator<ComprobarEdadFechaNac, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario form, ConstraintValidatorContext context) {
        Integer edad= form.getEdad();
        LocalDate fechaNac= form.getFechaNacimiento();
        Integer periodo;
        if (edad == null){
            return true;
        }
        if (fechaNac == null){
            return true;
        }
        periodo = Math.toIntExact(ChronoUnit.YEARS.between(fechaNac, LocalDate.now()));
        return Objects.equals(edad, periodo);
    }
}

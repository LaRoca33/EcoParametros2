package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class ValidadorFechaNac implements ConstraintValidator<ComprobarFechaNac,LocalDate>{
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        Period periodo= Period.between(value,LocalDate.now());
        return periodo.getYears()>=18;
    }
}

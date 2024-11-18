package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorPeso implements ConstraintValidator<ComprobarPeso, Float> {
    @Override
    public boolean isValid(Float peso, ConstraintValidatorContext context) {
        if (peso == null) {
            return true; // Dejar que otras validaciones manejen los nulos
        }

        return peso.toString().matches("\\d+(\\.\\d+)?");
    }
}

package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorLicencia implements ConstraintValidator<ComprobarLicencia,Boolean> {
    @Override
    public boolean isValid(Boolean licencia, ConstraintValidatorContext context) {
        if(licencia == null) {
            return false;
        }
        return licencia;
    }
}

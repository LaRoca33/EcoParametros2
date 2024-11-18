package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorEmail implements ConstraintValidator<ComprobarEmail,String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null) {
            return true;
        }
        return email.matches("^\\w+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}

package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.aaroca.ecoparametros2.model.Colecciones;

import java.util.Map;

public class ValidadorGeneros implements ConstraintValidator<ComprobarGeneros,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Map<String,String> listaGeneros = Colecciones.getGeneros();
        return listaGeneros.containsKey(value);
    }
}

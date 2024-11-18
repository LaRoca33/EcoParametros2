package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.aaroca.ecoparametros2.model.Colecciones;
import org.aaroca.ecoparametros2.model.Pais;

import java.util.Map;

public class ValidadorPais implements ConstraintValidator<ComprobarPais,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Map<String, Pais> listaPaises= Colecciones.getPaises();
        return listaPaises.containsKey(value);
    }
}

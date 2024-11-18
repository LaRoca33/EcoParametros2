package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.aaroca.ecoparametros2.model.Colecciones;
import org.aaroca.ecoparametros2.model.Pais;

import java.util.Map;

public class ValidadorPrefijoTel implements ConstraintValidator<ComprobarPrefijoTel,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Map<String, Pais> listaPaises = Colecciones.getPaises();
        for (Pais pais : listaPaises.values()){
            if (pais.getPrefijoTelefonicoPais().equals(value)){
                return true;
            }
        }
        return false;
    }
}

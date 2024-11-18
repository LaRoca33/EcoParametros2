package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.aaroca.ecoparametros2.model.DatosFormulario;

public class ValidadorClaves implements ConstraintValidator<ComprobarClaves, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario formulario, ConstraintValidatorContext context) {
        String clave = formulario.getClave();
        String confirmarClave= formulario.getConfirmarClave();
    /*    if(clave==null||confirmarClave==null){
            return true;
        }*/
        return clave.equals(confirmarClave);
    }
}

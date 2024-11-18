package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ValidadorLicencia.class)
@Documented
public @interface ComprobarLicencia {
    String message() default "Valor de licencia no aceptado";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

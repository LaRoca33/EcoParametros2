package org.aaroca.ecoparametros2.model.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = ValidadorEdadFechaNac.class)
@Documented
public @interface ComprobarEdadFechaNac {
    String message() default "{comprobar.edadFechaNac.error}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

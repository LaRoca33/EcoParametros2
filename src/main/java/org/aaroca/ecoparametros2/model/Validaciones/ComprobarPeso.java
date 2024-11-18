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
@Constraint(validatedBy = ValidadorPeso.class)
@Documented
public @interface ComprobarPeso {
    String message() default "El peso tiene que ser decimal";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

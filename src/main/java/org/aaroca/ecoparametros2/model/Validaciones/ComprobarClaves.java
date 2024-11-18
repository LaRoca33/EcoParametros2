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
@Constraint(validatedBy = ValidadorClaves.class)
@Documented
public @interface ComprobarClaves {
    String message() default "{comprobar.claves.error}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

package se.kth.korlinge.currencyconverter.controllers;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validation annotation that checks that the "from" and "to" currency in an exchange request are not the same currency
 */
@Constraint(validatedBy = UniqueToAndFromValidator.class)
@Target( {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueToAndFrom {
   String message() default "You cannot convert between the same currency.";

   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}

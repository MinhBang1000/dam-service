package ctu.cit.se.dam_service.exceptions.customizes.annotations;

import ctu.cit.se.dam_service.exceptions.customizes.imples.DateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {
    String message() default "End date must be after start end";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String beginDateName();
    String endDateName();
}

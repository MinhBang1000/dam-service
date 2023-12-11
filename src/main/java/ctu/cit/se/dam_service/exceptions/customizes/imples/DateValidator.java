package ctu.cit.se.dam_service.exceptions.customizes.imples;

import ctu.cit.se.dam_service.exceptions.customizes.annotations.ValidDateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.Objects;

public class DateValidator implements ConstraintValidator<ValidDateRange, Object> {
    private String beginDateName;
    private String endDateName;

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
        beginDateName = constraintAnnotation.beginDateName();
        endDateName = constraintAnnotation.endDateName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime beginDate = (LocalDateTime) new BeanWrapperImpl(value).getPropertyValue(beginDateName);
        LocalDateTime endDate = (LocalDateTime) new BeanWrapperImpl(value).getPropertyValue(endDateName);
        return Objects.nonNull(beginDate) && Objects.nonNull(endDate) && beginDate.isBefore(endDate);
    }
}

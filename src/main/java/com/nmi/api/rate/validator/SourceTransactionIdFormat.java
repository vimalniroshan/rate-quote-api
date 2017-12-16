package com.nmi.api.rate.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Constraint(validatedBy = SourceTransactionIdFormat.SourceTransactionIdValidator.class)
public @interface SourceTransactionIdFormat {
    String message() default "{com.nmi.api.source.transaction.id.format}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SourceTransactionIdValidator implements ConstraintValidator<SourceTransactionIdFormat, String> {
        @Override
        public void initialize(final SourceTransactionIdFormat constraintAnnotation) {
        }

        @Override
        public boolean isValid(final String value, final ConstraintValidatorContext context) {
            return value == null || value.length() <= 100;
        }
    }
}

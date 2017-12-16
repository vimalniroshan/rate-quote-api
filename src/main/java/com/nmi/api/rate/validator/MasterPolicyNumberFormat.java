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
@Constraint(validatedBy = MasterPolicyNumberFormat.MasterPolicyNumberFormatValidator.class)
public @interface MasterPolicyNumberFormat {
    String message() default "{com.nmi.api.masterpolicy.number.format}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class MasterPolicyNumberFormatValidator implements ConstraintValidator<MasterPolicyNumberFormat, String> {
        @Override
        public void initialize(final MasterPolicyNumberFormat constraintAnnotation) {
        }

        @Override
        public boolean isValid(final String value, final ConstraintValidatorContext context) {
            return value != null && value.matches("[0-9]{5}-[0-9]{4}");
        }
    }
}
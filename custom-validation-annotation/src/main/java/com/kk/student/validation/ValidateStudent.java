package com.kk.student.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StudentValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateStudent {

    String message() default "Invalid User";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

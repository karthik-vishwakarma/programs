package com.kk.student.validation;

import com.kk.student.model.Student;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentValidator implements ConstraintValidator<ValidateStudent, Student> {

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Inside StudentValidator");
        if (ObjectUtils.isEmpty(student)) {
            return false;
        }
        return !ObjectUtils.isEmpty(student.getAge()) && student.getName() != null && student.getRollNumber() != null;
    }
}

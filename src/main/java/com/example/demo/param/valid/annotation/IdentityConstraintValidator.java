package com.example.demo.param.valid.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 16:42
 * @Description: TODO
 */
public class IdentityConstraintValidator implements ConstraintValidator<IdentityNo,String> {
    @Override
    public void initialize(IdentityNo constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.equals("身份证号")){
            return true;
        }
        return false;
    }
}

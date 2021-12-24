package com.example.demo.param.valid.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 16:41
 * @Description: TODO
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityConstraintValidator.class)//用哪个校验器校验
public @interface IdentityNo {

    String message() default "身份证号码不符合规则";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}

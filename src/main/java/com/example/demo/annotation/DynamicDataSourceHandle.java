package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/18 14:22
 * @Description: TODO
 */
@Component
@Aspect
public class DynamicDataSourceHandle {


    @Pointcut("@annotation(DS)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Class<?>[] argTypes = new Class[pjp.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        String methodName = pjp.getSignature().getName();
        try {
            try {
                method = pjp.getTarget().getClass().getDeclaredMethod(methodName, argTypes);
            } catch (Exception e) {
                // 处理泛型及子类传参的情况
                Method[] supperMethods = pjp.getTarget().getClass().getDeclaredMethods();
                for (Method supperMethod : supperMethods) {
                    if (supperMethod.getName().equals(methodName)
                            && supperMethod.getParameterCount() == argTypes.length) {
                        boolean isMatchType = true;
                        for (int i = 0; i < supperMethod.getParameterCount(); i++) {
                            Class<?> paramType = supperMethod.getParameterTypes()[i];
                            Class<?> inParamType = argTypes[i];
                            if (!paramType.isAssignableFrom(inParamType)) {
                                if (paramType.isPrimitive() || inParamType.isPrimitive()) {
                                    // 处理基本类型
                                } else {
                                    isMatchType = false;
                                    break;
                                }
                            }
                        }
                        if (isMatchType) {
                            method = supperMethod;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("DynamicDataSourceSign_aop_method_error", e);
        }
        DS annotation = method.getAnnotation(DS.class);

        DataSourceTypeEnum dataSourceTypeEnum = annotation.value();
        DataSource.getDataSource(dataSourceTypeEnum);
        Object obj = pjp.proceed();
        return obj;
    }

}

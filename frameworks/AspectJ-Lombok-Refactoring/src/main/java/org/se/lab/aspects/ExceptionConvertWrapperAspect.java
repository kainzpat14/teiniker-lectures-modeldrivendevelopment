package org.se.lab.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class ExceptionConvertWrapperAspect {
    @Around("execution(public * org.se.lab.frontend.*Wrapper.*(..)) && !execution(* *.*validateLogin*(..))")
    public Object exceptionWrapper(ProceedingJoinPoint jp) {
        try {
            Object result = jp.proceed(jp.getArgs());
            return result;
        } catch (Throwable t) {

            throw new IllegalArgumentException(t.getMessage());
        }
    }
}

package org.se.lab.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.se.lab.frontend.ISession;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class LoginRequiredAspect {
    @Before("execution(@org.se.lab.aspects.RequiresLogin * *.*(..))")
    public void loginRequiredWrapper(JoinPoint jp) {
        try {
            Field sessionField = jp.getThis().getClass().getDeclaredField("session");
            sessionField.setAccessible(true);
            ISession session = (ISession) sessionField.get(jp.getThis());
            if (session.getUser() == null) {
                throw new IllegalArgumentException("You need to be logged in to perform this operation");
            }
        }
        catch(NoSuchFieldException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}

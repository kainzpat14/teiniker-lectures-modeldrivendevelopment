package org.se.lab.concerns;

import java.util.Arrays;
import java.util.stream.Collectors;


public aspect LoggingAspect {
	pointcut logWrappers() : within(@org.se.lab.concerns.Wrapper *) && execution(* *(..));
	
	Object around(): logWrappers()  {
		String methodName = thisJoinPoint.getSignature().getName();
        Object[] values = thisJoinPoint.getArgs();
        String parameters = Arrays.stream(values).map(Object::toString).collect(Collectors.joining(","));
        try {
	        Object result = proceed();
	        System.out.println("User called method "+methodName+"("+parameters+") which returned "+result);
	        return result;
        } catch(RuntimeException t) {
        	System.out.println("User called method "+methodName+"("+parameters+") which failed with "+t);
        	throw t;
        }
	}
}

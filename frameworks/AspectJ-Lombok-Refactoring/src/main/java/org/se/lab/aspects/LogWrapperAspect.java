package org.se.lab.aspects;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogWrapperAspect {
	@Around("execution(public * org.se.lab.frontend.*Wrapper.*(..))")
	public Object logWrapper(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		Object[] values = jp.getArgs();
		String parameters = Arrays.stream(values).map(Object::toString).collect(Collectors.joining(","));
		String method = methodName + "(" + parameters + ")";
		try {
			System.out.println(method + " started");
			Object result = jp.proceed(jp.getArgs());
			System.out.println(method + " resulted in " + result);
			return result;
		} catch (Throwable t) {
			System.out.println(method + "failed with");
			t.printStackTrace();
			throw t;
		}
	}
}

package org.se.lab.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class MeasurementAspect {
	@Around("execution(public * org.se.lab.business.rules.*Service.*(..))")
	public Object measure(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		long time = System.currentTimeMillis();
		try {
			return jp.proceed(jp.getArgs());
		} finally {
			System.out.println(methodName + "() took " + (System.currentTimeMillis() - time)+"ms");
		}
	}
}

package org.se.lab.concerns;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MeasurementAspect {

	@Around("execution(org.se.lab.application.User org.se.lab.application.MemoryUserApi.createUser(String,String))")
	public Object measureCreateUser(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			return jp.proceed(jp.getArgs());
		} finally {
			reportTime(start);
		}
	}

	private void reportTime(long start) {
		long time = System.currentTimeMillis() - start;
		System.out.println("The call took " + time + "ms");
	}
}

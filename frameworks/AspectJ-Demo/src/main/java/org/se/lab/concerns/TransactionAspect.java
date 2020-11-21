package org.se.lab.concerns;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TransactionAspect {
	@Around("within(@org.se.lab.concerns.API *) && execution(* *(..))")
	public Object decorateAspect(ProceedingJoinPoint jp) throws Throwable {
		startTx();
		try {
			Object result = jp.proceed(jp.getArgs());

			endTx();
			return result;
		} catch (Throwable t) {
			rollbackTx();
			throw t;
		}
	}

	private void rollbackTx() {
		System.out.println("Rolling back transaction");
	}

	private void endTx() {
		System.out.println("Ending transaction");
	}

	private void startTx() {
		System.out.println("Starting transaction");
	}
}

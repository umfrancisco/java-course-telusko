package com.telusko.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	// return type, class-name.method-name(args)
	
	@Before("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodCall(JoinPoint jp) {
		log.info("Method called -> "+jp.getSignature());
	}
	
	@After("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodExecuted(JoinPoint jp) {
		log.info("Method executed -> "+jp.getSignature());
	}
	
	@AfterThrowing("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodCrash(JoinPoint jp) {
		log.info("Method has some issues -> "+jp.getSignature());
	}
	
	@AfterReturning("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
	public void logMethodExecutedSuccess(JoinPoint jp) {
		log.info("Method executed successfully -> "+jp.getSignature());
	}
}

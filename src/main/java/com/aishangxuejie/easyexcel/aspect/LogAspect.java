package com.aishangxuejie.easyexcel.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAspect
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/6
 * @Version V1.0
 **/
@Component
@Aspect
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	/**
	 * execution 执行方法时出发
	 * 类路径
	 * ..*任意类 .*任意方法(..) 使用任意参数
	 * *只能匹配一级路径
	 *..可以匹配多级，可以是包路径，也可以匹配多个参数
	 *
	 */
	@Pointcut("execution(public * com.aishangxuejie.easyexcel.controller..*.*(..))")
	public void Pointcut(){
	}
	@Before("Pointcut()")
	public void beforeMethod(JoinPoint joinPoint){
		log.info("beforeMethod 前置方法切入");
	}
	@After("Pointcut()")
	public void afterMethod(JoinPoint joinPoint){
		log.info("afterMethod 后置方法切入");
	}
	@AfterReturning(value="Pointcut()",returning="result")
	public void afterReturningMethod(JoinPoint joinPoint,Object result){
		log.info("afterReturningMethod 返回结果方法切入");
	}
	@AfterThrowing(value="Pointcut()",throwing="e")
	public void afterReturningMethod(JoinPoint joinPoint, Exception e){
		log.info("afterReturningMethod 返回异常方法切入");
		e.printStackTrace();
	}
	@Around("Pointcut()")
	public Object Around(ProceedingJoinPoint pjp) throws Throwable {
		log.info("Around 执行方法之前");
		Object object = pjp.proceed();
		log.info("Around 执行方法之后--返回值：" +object);
		return object;
	}

}

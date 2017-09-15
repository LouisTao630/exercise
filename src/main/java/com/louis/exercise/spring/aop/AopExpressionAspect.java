package com.louis.exercise.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 展示Pointcut各种expression的各种含义和写法。
 * 
 * <p>
 * execution表达式结构: <code>execution(modifiers-pattern? ret-type-pattern
 * declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)</code>
 * </p>
 * 
 * @author Louis Tao
 *
 */
@Aspect
@Component
public class AopExpressionAspect {

	final static Logger logger = LoggerFactory.getLogger(AopExpressionAspect.class);

	@Pointcut("execution(* *..TestAopExpressionBean.*(..))")
	private void pointAllMethod() {
	}

	@Pointcut("execution(public * *..TestAopExpressionBean.*(..))")
	private void pointcutPublicMethod() {

	}

	@Before("pointAllMethod()")
	public void aspectAllMethods() {
		logger.info("函数拦截，范围：任何函数");
	}

	@Before("pointcutPublicMethod()")
	public void aspectPublicMethods() {
		logger.info("函数拦截，范围：public函数");
	}
}

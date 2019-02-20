package com.zs.pms.log;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志通知 声明式AOP
 * 
 * @author admin
 *
 */
public class LogAdvice2 {
	/**
	 * 记录日志的方法
	 * 
	 * @param method
	 * @return
	 * @throws Throwable
	 */
	public Object log(ProceedingJoinPoint method) throws Throwable {
		// 执行业务方法
		Object o = method.proceed();
		System.out.println("用声明式AOP记录日志：" + method.getSignature().getName());
		return o;
	}

}

package com.zs.pms.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 日志通知
 * 
 * @author admin
 *
 */
public class LogAdvice implements MethodInterceptor {
	/**
	 * 拦截方法后执行
	 */
	public Object invoke(MethodInvocation method) throws Throwable {
		// 执行具体的方法
		Object o = method.proceed();
		// 记录日志
		System.out.println("记录日志：" + method.getMethod().getName());
		return o;
	}

}

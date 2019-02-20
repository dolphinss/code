import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.zs.pms.log.LogAdvice;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService2;
import com.zs.pms.serviceimpl.User2ServiceImpl;

public class TestAOP {
	@Test
	public void testlog() {
		// 创建业务对象
		UserService2 us = new User2ServiceImpl();
		// 创建日志通知--记录日志
		LogAdvice la = new LogAdvice();
		// 创建切点 方法名匹配
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		// 拦截以add开头的方法
		pointcut.addMethodName("add*");
		// 拦截以update开头的方法
		pointcut.addMethodName("update*");
		// 创建日志切面=通知+切点
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, la);
		// 由代理把切面织入组织
		// 代理 工厂
		ProxyFactory factory = new ProxyFactory();
		// 代理有了记录日志的服务 织入
		factory.addAdvisor(advisor);
		// 代理目标是UserService2--- 业务方法
		factory.setTarget(us);
		// 从代理中获得业务对象
		UserService2 us2 = (UserService2) factory.getProxy();
		TUser user = new TUser();
		// 新增
		us2.addUser(user);
		// 修改
		us2.updateUser(user);
	}

}

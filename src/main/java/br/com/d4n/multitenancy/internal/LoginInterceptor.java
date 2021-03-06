package br.com.d4n.multitenancy.internal;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.d4n.multitenancy.DataSourceContextHolder;

@Aspect
public class LoginInterceptor {

	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	private InfraManager infraManager;

	@Pointcut("@target(app.multitenancy.stereotype.LoginController)")
	public void isLoginController() {
	}

	@AfterReturning(value = "isLoginController() && target(controller) && @annotation(annotation)", argNames = "controller,annotation,result", returning = "result")
	public Object onLogin(JoinPoint joinPoint, Object controller, LoginController annotation, Object result) throws Throwable {
		System.out.println("\n\n\nLoginInterceptor.onLogin() is running!");

		// Set Current DataSource
		DataSourceContextHolder.setTargetDataSource(infraManager.determineUserDataSource((String) result));
		return result;
	}
}
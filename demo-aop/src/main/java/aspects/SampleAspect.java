package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {
	
	@Before(value="execution (* service.EmployeeService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("calling before aspect "+joinPoint.getSignature().toString());
	}
	
	@After(value="execution(* service.EmployeeService.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("calling after aspect "+joinPoint.getSignature().toString());
	}

}

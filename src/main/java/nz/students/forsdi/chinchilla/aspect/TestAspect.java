package nz.students.forsdi.chinchilla.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class TestAspect {
    @Before("execution(public * nz.students.forsdi.chinchilla.rest.*.*(..))")
    public void testLogging() {
        System.out.println("===> Executing @Before advice");
    }
}

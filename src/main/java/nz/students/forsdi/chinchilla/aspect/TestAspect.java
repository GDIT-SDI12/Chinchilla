package nz.students.forsdi.chinchilla.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Keep pointcut expressions as specific as possible
 * If it is too uncertain, you are going to see server's html error page
 * instead of your JSON
 */

@Aspect
@Component
public class TestAspect {
    @Before("execution(* nz.students.forsdi.chinchilla.rest.*RestController.*(..))")
    public void testLogging() {
        System.out.println("===> Executing @Before advice");
    }
}

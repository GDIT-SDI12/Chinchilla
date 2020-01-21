package nz.students.forsdi.chinchilla.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public * nz.students.forsdi.chinchilla.rest.*.*(..))")
    private void timeLogger() {
        System.out.println();
    }
}

package nz.students.forsdi.chinchilla.aspect;

import nz.students.forsdi.chinchilla.rest.NotAuthorizedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Keep pointcut expressions as specific as possible
 * If it is too uncertain, you are going to see server's html error page
 * instead of your JSON
 */

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* nz.students.forsdi.chinchilla.rest.*RestController.*(..))")
    private void timeLogger(JoinPoint jp) {
        MethodSignature ms = (MethodSignature) jp.getSignature();
        System.out.println("Method: " + ms);
        int currentTime = (int) (Math.random() * 1000);
        if (currentTime % 2 == 0) {
            throw new NotAuthorizedException("Current time is " + currentTime);
        }
    }
}

package Profile;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("@annotation(Profiler)")
    public void method(){}

    @Around("method()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long s = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.println(System.currentTimeMillis()-s);
    }
}

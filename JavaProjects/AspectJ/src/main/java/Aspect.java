import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;


@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Pointcut("@annotation(Logger)")
    public void method() {}

//    @Before("method()")
//    public void before(){
//        System.out.println("before");
//    }
    @Around("method()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----before------");
        joinPoint.proceed();
        System.out.println("-----after-------");
    }
}

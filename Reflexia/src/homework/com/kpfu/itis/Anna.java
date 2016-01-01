package homework.com.kpfu.itis;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Anna {
    public String name();
    int count() default 0;
    String[] mass() default {"1","2"};
    enum Color{RED,GREEN,BLUE};
    Color[] color() default {};
    String value();
}

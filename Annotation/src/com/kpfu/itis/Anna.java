package com.kpfu.itis;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anna {
    String name();
    String surname();
    int count() default 0;
    String[] mass() default {"1","2","3"};
    Color[] color() default {Color.RED,Color.BLUE};
}

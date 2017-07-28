package com.own.learn.jdk.annotation;

import java.lang.annotation.*;

/**
 * Created by pafer on 17-2-3.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "pafer";

    String version() default "1.0";

    String date();

    String comment();
}

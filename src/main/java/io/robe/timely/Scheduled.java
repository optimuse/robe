package io.robe.timely;

/**
 * Created by sinanselimoglu on 13/02/14.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation class for cron operations operations.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Scheduled {
    enum Manager{
        DB,
        ANNOTATION
    }
    String cron();
    Manager manager() default Manager.ANNOTATION;
}
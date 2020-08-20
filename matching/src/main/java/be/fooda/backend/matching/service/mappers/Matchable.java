package be.fooda.backend.matching.service.mappers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Matchable {
    public String value() default "";
    public double weight() default 1.00;

    public double minScore() default 1.00;
}
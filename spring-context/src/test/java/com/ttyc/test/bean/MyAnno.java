package com.ttyc.test.bean;

import org.springframework.core.testfixture.stereotype.Indexed;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface MyAnno {

	String value() default "defaultName";
}

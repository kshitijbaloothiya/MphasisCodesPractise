package com.mphasis.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ClassPream{
    String author();
    String data();
    String lastModifiedB() default "N/A";
}

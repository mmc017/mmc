package com.example.bootstudy.aop.datasource;

import java.lang.annotation.*;

/**
 * @author Zz
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSourceConstants.testOne;
}

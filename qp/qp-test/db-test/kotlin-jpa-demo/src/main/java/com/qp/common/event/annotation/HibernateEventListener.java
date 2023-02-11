package com.qp.common.event.annotation;

import java.lang.annotation.*;

/**
 * @author 78772
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HibernateEventListener {
}

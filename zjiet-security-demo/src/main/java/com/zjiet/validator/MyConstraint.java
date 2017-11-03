package com.zjiet.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义注解
 * @Target    :指定注解作用在某个位置  1.ElementType.METHOD  2.ElementType.FIELD
 * @Constraint: 指定受哪个类的约束
 * @Retention :表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时，
               所以他们可以用反射的方式读取。
 * @author    : linlc
 * 2017/10/24 16:31
 */

@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = MyConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

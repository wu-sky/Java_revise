package com.anno;



import java.lang.annotation.*;

/**
 * @author：sky-吴 用户注解
 * @create：2020-1-7 创建日期注解
 */

@Inherited //注解标记的可以继承??
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_PARAMETER})
//这个target 可以修饰(方法, 构造器, 参数, 类, 泛型), 就是说放在(方法, 构造器, 参数, 类, 泛型)上面
@Retention(RetentionPolicy.RUNTIME) //Retention 这个注解将被加载到内存中
public @interface MyAnnotation {


	String value() default "啊啦戛亚"; //设置默认属性值之后, 注解不必写属性


}
/*
@Repeatable(????) 可重复注解, 即一类注解可以使用多个
*  如果注解内部没有属性, 则代表它是一个标识, 类似于某些标识接口, 如 Serializable
 */

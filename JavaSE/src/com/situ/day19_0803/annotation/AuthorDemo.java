package com.situ.day19_0803.annotation;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Author("/author")
public class AuthorDemo {

    @Author(name = "张三", age = 23, value = "男")
    //@Author(value = "张三")
    //@Author("张三")
    public void save() {

    }

    @Test
    public void test1() throws NoSuchMethodException {
        Class<AuthorDemo> clazz = AuthorDemo.class;
        Method method = clazz.getMethod("save");
        Author typeAuthor = clazz.getAnnotation(Author.class);
        System.out.println(typeAuthor.value());// /author

        // 1.先获取代表方法的Method类型
        Author methodAuthor = method.getAnnotation(Author.class);
        // 2、获取方法上的注解
        System.out.println(methodAuthor.name());
        System.out.println(methodAuthor.age());
        System.out.println(methodAuthor.value());
    }
}

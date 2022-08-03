package com.situ.day4_0714;

import java.security.AccessControlContext;


// inherit:继承  extends:
public class Student extends Person {

    private String className;
    public Student() {
//        new Person()
//        super()这个不写 默认java会帮你加上
        super();
    }
// Ctrl+Alt+向左箭头
    public Student(int id, String name, int age, String className) {
//        new Person(id, name, age)
//        Call to 'super()' must be first statement in constructor body
//        构造子类对象时候首先构造父类对象
//        super(id, name, age);
        this.className = className;
    }
    public Student(int id, String name, int age) {
        // new Student(int id, String name, int age, String className)
       this(id, name, age,"java220702");
    }

    public void study() {
        className = "java220702";
//        assign:赋值 access：访问
//        id' has private access in 'com.situ.day4_0714.Person'
        id = 1;
        System.out.println("id是"+id+"的"+name+"在"+className+"学习");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
package com.situ.day4_0714;

//Object是所有类的父类  如果不写 会默认写上
public class Person extends Object{
    protected int id;
    protected String name;
    protected int age;

    public Person() {
    }

    public Person(int id, String name, int age) {//当前类
        this.id = id;
        this.name = name;
        this.age = age;
    }

    protected  void show(){
        System.out.println("id是："+id+"，名字是："+name+",年龄：" + age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

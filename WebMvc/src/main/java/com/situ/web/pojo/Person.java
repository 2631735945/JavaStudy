package com.situ.web.pojo;

import java.io.Serializable;
//Javabean
public class Person implements Serializable {
    private String name;
    private  Integer age;
    private  String gender;

    public Person() {
        System.out.println("Person.Person");
    }
static{
        Person person=new Person("23",12,"nan");
    System.out.println(person.getName());

}
    public Person(String name, Integer age, String gender) {
        System.out.println("Person.Person");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

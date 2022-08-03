package com.situ.day18_0802;

import java.io.Serializable;

// JavaBean
// 写到文件、在网络上传输
// java.io.NotSerializableException
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public Student() {

    }

    private Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    // signature  body
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

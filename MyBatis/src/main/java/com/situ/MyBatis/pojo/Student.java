package com.situ.MyBatis.pojo;

import java.util.HashMap;
import java.util.Objects;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer banjiId;
//    从学生角度来说，一个学生对应一个班级
    private Banji banji;



    public Student() {
    }


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getBanjiId() {
        return banjiId;
    }

    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }

    public Banji getBanji() {
        return banji;
    }

    public void setBanji(Banji banji) {
        this.banji = banji;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", banjiId=" + banjiId +
                ", banji=" + banji +
                '}';
    }
}

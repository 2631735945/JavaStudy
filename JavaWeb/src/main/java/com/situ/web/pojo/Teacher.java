package com.situ.web.pojo;

public class Teacher {
    private Integer id;
    private  String name;
    private Integer age;
    private String address;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

//    public static void main(String[] args) {
//        int count=0;
//
//        for(int i=0;i<=100;i++)
//              count=count++;
//        System.out.println(count);
//    }
}

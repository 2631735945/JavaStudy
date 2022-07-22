package com.situ.day5_0715.stati;

public class Student extends Person {

    private static User3 user3 = new User3();
    private  User4 user4 = new User4();

    static {
        System.out.println("Student.static initializer");
    }

    {
        System.out.println("Student.instance initializer");
    }

    public Student() {
        super();
        System.out.println("Student.Student");
    }
}

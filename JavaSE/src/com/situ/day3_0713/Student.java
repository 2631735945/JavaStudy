package com.situ.day3_0713;


//    实体类:和数据库表一一对应
public class Student {
    //属性 field:静态的描述这个事物特征
//    属性一般是私有的 private:访问范围 是 当前类
    private int id;
    private String name;
    private int age;
    private String gender;

//    方法：method
//无参构造

//java默认会提供一个无参构造方法
//    如果你自己实现了任何一个构造方法
//    java就不会再提供这个默认的无参构造方法
    public Student() {
//        System.out.println("Student student1");
    }

//有参构造方法
//    Constructor:构造方法
    public Student(int id, String name, int age, String gender) {
        System.out.println("Student student2");
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(int id, String name, int age) {
        //        Call to 'this()' must be first statement in constructor body
        // new Student(int id, String name, int age, String gender)
        this(id, name, age, "男");
        System.out.println("Student student3");

    }

    //    实例方法，必须先new出一个对象，对象.方法();
    public void setId(int id) {
//        The value id assigned to 'id' is never used
//        Variable 'id' is assigned to itself  变量id 自身给自身赋值
        // 就近原则
//        id = id;
        // this：当前new出来对象
        // student.setId(1) this当成student这个对象
        this.id = id;
    }
    public int getId() {
        return id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getInfo() {
        return "Student[id:" + id + ",name:" + name + ",age:" + age + ",gender:" + gender + "]";
    }
}

package com.situ.day5_0715;

public class Student {
//    属性 field 实例属性:要new对象使用
    public int id;
//    静态属性 ：无需new对象  类名.属性/方法（）
    private static String name;
    private  int age;
    private String gender;
//    方法 method
//    实例方法
    public void show(){
        System.out.println("Student.show");
    }
public static void print(){
    System.out.println("!");

}
    public static void main(String[] args) {
        Student student=new Student();
        student.id=1;
        System.out.println(student.gender);
        student.show();

        Student.print();
//        Static member 'com.situ.day5_0715.Student.print()' accessed via instance reference
//        静态成员'com.situ.day5_0715.Student.print()'通过实例引用访问
        student.print(); //可以调用
    }
}

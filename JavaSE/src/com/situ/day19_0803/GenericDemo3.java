package com.situ.day19_0803;


import com.situ.day18_0802.Student;
import com.situ.day5_0715.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo3<T> {
    // Student Teacher
    public<K> void save(K k) {

    }

    public void update(T t) {

    }

    public void delete(T t) {

    }

    @Test
    public void test1() {
        GenericDemo3<Student> genericDemo1 = new GenericDemo3<>();
        Student student = new Student();
        genericDemo1.update(student);
        genericDemo1.delete(student);

        GenericDemo3<Teacher> genericDemo2 = new GenericDemo3<>();
        Teacher teacher = new Teacher();
        genericDemo2.update(teacher);
        genericDemo2.delete(teacher);

        List<Student> list1 = new ArrayList<>();
        List<Teacher> list2 = new ArrayList<>();
    }

}

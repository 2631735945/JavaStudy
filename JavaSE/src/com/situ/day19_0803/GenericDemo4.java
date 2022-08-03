package com.situ.day19_0803;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {

    public void save1(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
        // list.add("abc");
    }

    // Long Double Integer extends Number
    public void save2(List<? extends Number> list) {

    }

    @Test
    public void test1() {
        List<Double> list1 = new ArrayList<>();
        save2(list1);
        List<Integer> list2 = new ArrayList<>();
        save2(list2);

        List<String> list3 = new ArrayList<>();
        // save2(list3);
    }

    public void save3(List<? super String> list) {

    }

    @Test
    public void test2() {
        List<String> list1 = new ArrayList<>();
        save3(list1);
        List<Object> list2 = new ArrayList<>();
        save3(list2);
        //List<Integer> list3 = new ArrayList<>();
        //save3(list3);


    }
}

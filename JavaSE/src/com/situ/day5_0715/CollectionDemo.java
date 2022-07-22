package com.situ.day5_0715;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionDemo {
    @Test
    public  void test1(){
        int[] array={2,3,4,5};
        int index= Arrays.binarySearch(array,4);
        System.out.println(index);
    }
    @Test
    public  void test2(){
        int[] array={2,3,4,5};
//        Arraylist 底层怎么扩容
//        有序可重复
        List<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(34);
        list.add(45);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        ArrayList<Student> list1=new ArrayList<>();

//        无序不重复
        HashSet<Integer> set=new HashSet<>();
        set.add(12);
        set.add(34);
        set.add(45);
        set.add(45);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}

package com.situ.day21_0808.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionDemo {
    // Iterator: 迭代器

    @Test
    public void test1(){

        Collection<String> collection=new ArrayList<>();;
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        collection.add("张三");
        System.out.println(collection);
        collection.remove("张三");
        System.out.println(collection);
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    @Test
    public void test2(){
        Collection<String> collection = new ArrayList<>();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        collection.add("张三");

        String s="hello ,world\0";
        System.out.println(s);
        for (String str : collection) {
            System.out.println(str);
        }

        System.out.println("*****************");

        Iterator<String>iterator=collection.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        list.add(2, "Java");//List接口定义的方法
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("--------------");
        //由于List集合拥有索引，因此List集合迭代方式除了使用迭代器之外，还可以使用索引进行迭代。
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
        }
        System.out.println("--------------");


//        抛出异常
        //迭代器的并发修改异常 java.util.ConcurrentModificationException
        //就是在遍历的过程中,使用了集合方法修改了集合的长度,不允许的
        //对集合使用迭代器进行获取,获取时候判断集合中是否存在 "abc3"对象
        //如果有,添加一个元素 "ABC3"
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            //对获取出的元素s,进行判断,是不是有"abc3"
            if(s.equals("abc3")){
                list.add("ABC3");
            }
            System.out.println(s);
        }
    }


    //报错
    //        java.util.ConcurrentModificationException
    @Test
    public void test23() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String item : list) {
            if (item.equals("3")) {
                System.out.println(item);
                // 在迭代时，不要使用集合的方法操作元素。
                list.remove(item);
            }
        }
        System.out.println(list.size());
    }

//    实现删除
    @Test
        public void test(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("3")){
                iterator.remove();
                System.out.println(str);
            }

        }
        System.out.println(list.size());
    }

    @Test
    public void test_(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        ListIterator<String> listIterator=list.listIterator();
        while (listIterator.hasNext()){
            String str = listIterator.next();
            if(str.equals("3")){
                listIterator.add("asas");
            }
            System.out.println(str);
        }

        System.out.println(list);

    }


}
//之所以new了新的String，也放不进去，是因为String重写了code和equals，使之不是比较地址，而是比较内容
//再重写code和equals之前  student4和student1仅管他们的内容是一样的，但是因为地址不同，他们的code是不同的，所以student4也可以放进去
//再重写code和equals之后  我们通过比较id和name 内容是否一样的方法，来计算code ，这样student4和student1的code是一样的，然后比较equals，
// 他们的内容还是一样的，所以student4 就放不进去
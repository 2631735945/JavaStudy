package com.situ.day6_0716;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("cn", "中国");
        map.put("us", "美国");
//        Set set=map1.entrySet();
//        Set<Map.Entry> set=map1.entrySet();
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("------------");
        String value = map.get("cn");
        System.out.println(value);
        System.out.println("*************");
        Set<String> keyset = map.keySet();
        for (String key : keyset) {
            System.out.println(key + "  " + map.get(key));
        }
    }


    @Test
    public void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("cn", "中华人民共和国");
        map.put("us", "美利坚合众国");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        // Iterator:迭代器
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {//只判断有没有下一个
            Map.Entry<String, String> entry = iterator.next();// 指向下一个
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }
        System.out.println("-------------");
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        }
    }

}

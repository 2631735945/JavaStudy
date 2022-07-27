package com.situ.web.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.Person;
import org.junit.Test;

import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonDemo {
    @Test
    public void test() throws JsonProcessingException {
        //1.创建Person对象
      Person person=new Person("张三",23,"男");
        //2.创建Jackson的核心对象  ObjectMapper
       ObjectMapper objectMapper=new ObjectMapper();
       String json=objectMapper.writeValueAsString(person);
        // {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);
    }
    @Test
    public void test1() throws JsonProcessingException {
        List<Person> list=new ArrayList<>();
        Person person=new Person("张三",23,"男");
        Person person1=new Person("张三1",21,"男1");
        Person person2=new Person("张三2",22,"男2");
        Person person3=new Person("张三3",23,"男3");
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(list);
        System.out.println(json);
    }
    @Test
    public void test2() throws JsonProcessingException {
        Map<String,Object> map = new HashMap();
        map.put("name","张三");
        map.put("age",13);
        map.put("gender","男");
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(map);
        System.out.println(json);
    }

    //演示 JSON字符串转为Java对象
    @Test
    public  void test4() throws IOException {
        //1.初始化JSON字符串
        // String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //2.创建ObjectMapper对象
            ObjectMapper mapper=new ObjectMapper();
//        3.转换为Java对象 Person对象
        Person person=mapper.readValue(json,Person.class);
        System.out.println(person);
    }
}

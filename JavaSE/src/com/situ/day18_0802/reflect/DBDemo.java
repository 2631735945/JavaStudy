package com.situ.day18_0802.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DBDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //IDB db = new Oracle();
        // db.getConnection();
        // 在代码里面不出现具体的子类代码
        // 反射+配置文件  property  properties
        FileInputStream fileInputStream = new FileInputStream("JavaSE/src/com/situ/day18_0802/reflect/db.properties");
        //读取配置文件
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String className = properties.getProperty("className");
        Class clazz = Class.forName(className);
        // 无参构造方法
        //Constructor constructor = clazz.getConstructor();
        //IDB db = (IDB) constructor.newInstance();

        // 如果调用的是无参构造方法，可以不需要获得Constructor，直接clazz.newInstance();
        IDB db = (IDB)clazz.newInstance();
        db.getConnection();
    }

}

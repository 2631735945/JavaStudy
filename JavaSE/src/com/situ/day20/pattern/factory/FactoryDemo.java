package com.situ.day20.pattern.factory;


import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FactoryDemo {
    @Test
    public void test1() {
        Cal cal = new Add();
        cal.setNumA(3);
        cal.setNumB(5);
        double result1 = cal.getResult();
        System.out.println(result1);

        cal = new Sub();
        double result2 = cal.getResult();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Cal cal = CalFactory.createCal();
        cal.setNumA(3);
        cal.setNumB(5);
        double result = cal.getResult();
        System.out.println(result);
    }

}

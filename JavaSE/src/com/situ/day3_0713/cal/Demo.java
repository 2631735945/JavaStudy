package com.situ.day3_0713.cal;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.function.Supplier;

public class Demo {
    @Test
    public void test() {
        Add add = new Add(3, 5);
        int result = add.getResult();
        System.out.println(result);

        Sub sub = new Sub(4, 1);
        System.out.println(sub.getResult());

//        继承什么就是什么
        Cal cal = new Add(6, 8);
        System.out.println(cal.getResult());
        cal = new Sub(7, 3);
        System.out.println(cal.getResult());
    }

    @Test
    public void test33() {
        Add add = new Add(3, 2);
        // Cal cal = add
        show(add);
        Sub sub = new Sub(3, 2);
        // Cal cal = sub
        show(sub);

//        AbstractShape' is abstract; cannot be instantiated
//        AbstractShape abstractShape=new AbstractShape() ;
    }

    public void show(Cal cal) {
        int result = cal.getResult();
        System.out.println(result);
    }


}


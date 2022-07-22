package com.situ.day4_0714.bird;

import org.junit.jupiter.api.Test;

public class Demo {
    @Test
    public void test1(){
        DaYan daYan=new DaYan();
        daYan.egg();
        daYan.fly();
        daYan.print();
        // bird是站在AbstractBird这个角度去看new出来的大雁，
        // 只能看到下蛋这个功能
        AbstractBird abstractBird=new DaYan();
        abstractBird.egg();
        // abstractBird.fly();
        // abstractBird.print();

        // fly是站在IFly这个角度去看new出来的大雁，
        // 只能看到fly这个功能
        IFly iFly=new DaYan();
        iFly.fly();

    }}

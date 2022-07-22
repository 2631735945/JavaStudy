package com.situ.day4_0714.bird;

public class DaYan extends AbstractBird implements IFly {
    @Override
    public void egg() {
        System.out.println("DaYan.edd");
    }

    @Override
    public void fly() {
        System.out.println("DaYan.fly");
    }
    public void print(){
        System.out.println("DaYan.print");

    }

}



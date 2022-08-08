package com.situ.day20.pattern.factory;

public class Add extends Cal{
    public Add() {
    }

    @Override
    public double getResult() {
        return numA + numB;
    }
}
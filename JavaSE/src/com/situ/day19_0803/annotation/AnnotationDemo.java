package com.situ.day19_0803.annotation;


import org.junit.jupiter.api.Test;

import java.util.List;

public class AnnotationDemo {

    // 抑制编译器警告 List不加泛型会出警告
    @SuppressWarnings(value = {"unused", "rawtypes"})
    private void save() {
        List list = null;
    }

    // 标记方法以及过时
    @Deprecated
    private void save1() {
    }

    @Test
    public void test1() {
        save1();
    }
}

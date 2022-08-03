package com.situ.day19_0803;

import org.junit.jupiter.api.Test;

public class GenericDemo2 {
    // 泛型方法
    public<K,T> K save(K k, T t) {
        return k;
    }

    @Test
    public void test1() {
        // 使用泛型时候，才确定泛型的类型
        Double d = save(1.0, 1);
        String str = save("abc", 1);
    }
}
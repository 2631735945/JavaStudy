package com.situ.day8_0718.excep;

/**
 * 1、所有的异常的都是Throwable的子类
 * 2、如果写一个运行时异常，需要继承RuntimeException
 * 3、如果要写一个编译时异常，继承Exception
 * 未雨绸缪，提前检查
 */
public class MeiQianException extends Exception{
    // 这个message会抛出这个异常时候会打印的信息
    public MeiQianException(String message){
        super(message);
    }
}

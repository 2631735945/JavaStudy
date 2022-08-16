package com.situ.spring.proxy;

public class MiShu implements IQianZi {
    private DongShiZhang dongshizhang;

    public MiShu (DongShiZhang dongshizhang){
        this.dongshizhang=dongshizhang;
    }

    @Override
    public void qianzi() {
//        权限处理
        System.out.println("MiShu.qianzi before 开始事务");
        dongshizhang.qianzi();
        System.out.println("MiShu.qianzi end 结束事务");
    }
}

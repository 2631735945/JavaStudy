package com.situ.day8_0718.excep;

public class AccountManager {
//    余额
    private Double balance;

    public AccountManager(Double balance) {
        this.balance = balance;
    }
//    存钱
    public void deposit(Double money){
        balance+=money;
    }
//    取钱
    public void withdraw(Double money) throws MeiQianException {
        if(balance>=money){
            balance-=money;
        }else {
//            余额不足
            double needMoney=money-balance;
            throw new MeiQianException("余额不足还差：" + needMoney);
        }

    }}

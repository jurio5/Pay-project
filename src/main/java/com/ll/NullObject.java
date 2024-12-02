package com.ll;

public class NullObject implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("존재하지 않는 결제 방식 입니다.");
        return false;
    }
}

package com.ll;

public class TossPay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("선택하신 결제 방식은 토스페이 결제 방식입니다.");
        System.out.println("입력하신 결제 금액 : " + amount + "원");
        return true;
    }
}

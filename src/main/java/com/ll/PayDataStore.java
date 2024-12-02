package com.ll;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PayDataStore {
    private final Scanner scanner;

    public PayDataStore(Scanner scanner) {
        this.scanner = scanner;
    }

    public void pay() {

        printPaymentMethod();
        System.out.print("원하시는 결제 방식을 입력해 주세요 : ");
        String cmd = scanner.nextLine();

        Pay pay = payData(cmd);
        System.out.print("원하시는 결제 금액을 입력해 주세요. : ");
        try {
            int amount = scanner.nextInt();
            scanner.nextLine();
            boolean result = pay.pay(amount);

            System.out.println("입력하신 내용이 맞다면 'Y' 틀리다면 'N'을 입력해 주세요.");
            System.out.print("입력 : ");
            String answer = scanner.nextLine();

            if ("y".equalsIgnoreCase(answer)) {
                System.out.println("결제를 진행합니다.");
            } else {
                System.out.println("결제가 취소되었습니다.");
                return;
            }

            if (result) {
                System.out.println("결제에 성공했습니다.");
            } else {
                System.out.println("결제에 실패했습니다.");
            }

            System.out.println("메인 메뉴로 이동합니다.");

        } catch (InputMismatchException e) {
            System.out.println("결제 금액은 숫자로 입력해 주세요.");
            scanner.nextLine();
        }
    }

    public Pay payData(String cmd) {
        switch (cmd) {
            case "1":
            case "kakaoPay":
                return new KakaoPay();
            case "2":
            case "naverPay":
                return new NaverPay();
            case "3":
            case "tossPay":
                return new TossPay();
            case "4":
            case "giftPay":
                return new GiftPay();

        }
        return new NullObject();
    }

    public static void printPaymentMethod() {
        System.out.print("""
                1. kakaoPay
                2. naverPay
                3. tossPay
                4. giftPay
                """);
    }
}

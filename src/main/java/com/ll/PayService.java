package com.ll;

import java.util.Scanner;

public class PayService {
    private final Scanner scanner;
    private final PayDataStore payDataStore;

    public PayService(Scanner scanner) {
        this.scanner = scanner;
        this.payDataStore = new PayDataStore(scanner);
    }
    void run() {
        while (true) {
            System.out.println("1. 결제 || 2. 종료");
            System.out.print("입력 : ");
            String option = scanner.nextLine();

                switch (option) {
                    case "1":
                    case "결제":
                        payDataStore.pay();
                        break;
                    case "2":
                    case "종료":
                        System.out.print("결제를 종료합니다.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("존재하지 않는 방식 입니다.");
                }
        }
    }
}

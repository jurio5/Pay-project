package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PayService payService = new PayService(scanner);
            payService.run();
        }
    }
}
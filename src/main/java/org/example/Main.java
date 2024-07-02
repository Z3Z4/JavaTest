package org.example;

import java.util.Scanner;

import org.example.FactorialCalculator.FactorialCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для вычисления его факториала: ");
        int number = scanner.nextInt();
        long result = FactorialCalculator.factorial(number);
        System.out.println("Факториал числа " + number + " равен " + result);
    }

}
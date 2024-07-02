package org.example.FactorialCalculator;

public class FactorialCalculator {
    // Метод для вычисления факториала с использованием рекурсии
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
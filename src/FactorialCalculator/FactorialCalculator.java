package FactorialCalculator;

public class FactorialCalculator {
    public static long factorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Число должно быть неотрицательным!");
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

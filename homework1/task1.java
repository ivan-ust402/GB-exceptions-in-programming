package homeworks.homework1;

/**
 * Задача 1
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */

public class task1 {
    public static void main(String[] args) {
        // 1 случай деление на ноль, ArithmeticException
        // System.out.println(divide(10, 0));
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        return a/b;
    }
}

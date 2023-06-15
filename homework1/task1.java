package homeworks.homework1;

import java.util.Objects;

/**
 * Задача 1
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */

public class task1 {
    public static void main(String[] args) {
        // 1 случай деление на ноль, ArithmeticException
        System.out.println(divide(10, 0));

        // 2 случай - обращение к индексу за пределами длины входящего массива
        // ArrayIndexOutOfBoundsException
        int[] array = new int[]{1, 2};
        System.out.println("Value of third element: " + findValueOfThirdElement(array));

        // 3 случай - NullPointerException
        Integer[] array1 = new Integer[]{1, null, 3};
        print(array1);
    }


    // 1 случай
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        return a/b;
    }

    // 2 случай
    public static int findValueOfThirdElement(int[] array){
        if (array.length < 4) {
            throw new ArrayIndexOutOfBoundsException("Размер массива меньше индекса искомого элемента!");
        }
        return array[3];
    }

    // 3 случай
    public static void print(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.isNull(array[i])) {
                throw new NullPointerException("Элемент не может быть null!");
            }
            System.out.println(array[i]);
        }
    }
}

package homeworks.homework1;

import java.util.Arrays;

/**
 * Задача 3
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 * и возвращающий новый массив, каждый элемент которого равен частному элементов 
 * двух входящих массивов в той же ячейке. Если длины массивов не равны, 
 * необходимо как-то оповестить пользователя. Важно: При выполнении метода 
 * единственное исключение, которое пользователь может увидеть - 
 * RuntimeException, т.е. ваше
 */
public class task3 {
    public static void main(String[] args) {
        int[] array1 = new int[]{2, 4, 6, 8};
        int[] array2 = new int[]{1, 2, 3, 3};

        // int[] array3 = new int[]{1, 2, 3, 4, 5};
        // int[] array4 = new int[]{0, 0, 0, 0};

        System.out.println(Arrays.toString(getNewArray(array1, array2)));

    }

    public static int[] getNewArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не совпадают!");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if(arr2[i] == 0) {
            // throw new ArithmeticException("Невозможно создать массив т.к. во втором массиве среди элементов есть ноль! А на ноль делить нельзя");
            throw new RuntimeException("Невозможно создать массив т.к. во втором массиве среди элементов есть ноль! А на ноль делить нельзя");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}

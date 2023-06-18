package homeworks.homework2;

public class task2 {
    // Задание 2
    // Если необходимо, исправьте данный код 
    // (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    // try {
    //     int d = 0;
    //     double catchedRes1 = intArray[8] / d;
    //     System.out.println("catchedRes1 = " + catchedRes1);
    //  } catch (ArithmeticException e) {
    //     System.out.println("Catching exception: " + e);
    //  }
    public static void main(String[] args) {
        // Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, null};
        // int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] intArray = {1, 2, 3, 4, 5};
        double catchedRes1;
        try {
            int d = 0;
            catchedRes1 = intArray[8] / d;  
         } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
         } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс имеет значение за пределами размерности массива");
         } catch (NullPointerException e) {
            System.out.println("В массиве NULL!");
         } 
         catchedRes1 = 0;
         System.out.println("catchedRes1 = " + catchedRes1);
         
    }

}

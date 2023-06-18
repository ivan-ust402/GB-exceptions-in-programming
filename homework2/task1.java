package homeworks.homework2;

import java.util.Scanner;

public class task1 {
    // Задание 1
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа 
    // (типа float), и возвращает введенное значение. Ввод текста вместо числа 
    // не должно приводить к падению приложения, вместо этого, необходимо 
    // повторно запросить у пользователя ввод данных.
    public static void main(String[] args) {
        UIReturnEnteringNumber();
    }

    public static void UIReturnEnteringNumber() {
        Scanner scan = new Scanner(System.in);
        boolean condition = true;
        int counter = 0;
        while (condition) {
            System.out.print("Введите дробное число: ");
            String inputString = scan.next();
            try {
                float floatNumber = Float.parseFloat(inputString);
                System.out.println(returnEnteringNumber(floatNumber));
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число!");
            }
            
            if (counter % 5 == 0 && counter != 0) {
                System.out.println("Для продолжения введите любую букву. Для выхода введите 'q': ");
                String exit = scan.next();
                if (exit.equals("q")) {
                    condition = false;                
                }
            }
            counter++;
        }
        scan.close();
    }

    public static float returnEnteringNumber(float number) {
        return number;
    }
}

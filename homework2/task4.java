package homeworks.homework2;

import java.util.Scanner;

public class task4 {
    // Задание 4
    // Разработайте программу, которая выбросит Exception, когда пользователь 
    // вводит пустую строку. Пользователю должно показаться сообщение, что 
    // пустые строки вводить нельзя.
    public static void main(String[] args) {
        System.out.println(emptyString()); 
    }

    public static String emptyString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваше сообщение: ");
        String inputString = "";
        try {
            inputString = scan.nextLine();  
            if (inputString.isEmpty()){
                inputString = "Вы ничего не написали!";
                throw new IllegalArgumentException("Строка пустая");
            }          
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            scan.close();            
        }
        return "Ваше сообщение: " + inputString;
    }
}

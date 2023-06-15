package homeworks.homework1;

/**
 * Задача 2
 * Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить? 
 * public static int sum2d(String[][] arr){ 
 *  int sum = 0; 
 *  for (int i = 0; i < arr.length; i++) { 
 *      for (int j = 0; j < 5; j++) { 
 *          int val = Integer.parseInt(arr[i][j]); 
 *          sum += val; 
 *      } 
 *  } 
 *  return sum; 
 * }
 */
public class task2 {
    public static void main(String[] args) {
        String[][] array = new String[][]{{"1", "2", "3", "4", "5"},{"4", "5", "6", "7", "7"},{"7", "8", "9", "0", "0"}};
        System.out.println(sum2d(array));
    }

    public static int sum2d(String[][] arr){ 
        int sum = 0; 
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < 5; j++) { 
                int val = Integer.parseInt(arr[i][j]); 
                sum += val; 
            } 
        } 
        return sum; 
    }

    // Ответ:
    // 1. ArrayIndexOfBoundsException
    // 2. NumberFormatException
}

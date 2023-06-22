package homeworks.homework3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class task1 {

    /**
     * Напишите приложение, которое будет запрашивать у пользователя следующие 
     * данные в произвольном порядке, разделенные пробелом:
     * 
     *      Фамилия Имя Отчество датарождения номертелефона пол
     *     
     * Форматы данных:
     *      фамилия, имя, отчество - строки
     *      датарождения - строка формата dd.mm.yyyy
     *      номер телефона - целое беззнаковое число без форматирования
     *      пол - символ латиницей f или m.
     * 
     *      Приложение должно проверить введенные данные по количеству. 
     * Если количество не совпадает с требуемым, вернуть код ошибки, обработать 
     * его и показать пользователю сообщение, что он ввел меньше и больше данных, 
     * чем требуется.
     *      Приложение должно попытаться распарсить полученные значения и 
     * выделить из них требуемые параметры. Если форматы данных не совпадают, 
     * нужно бросить исключение, соответствующее типу проблемы. Можно 
     * использовать встроенные типы java и создать свои. Исключение должно быть 
     * корректно обработано, пользователю выведено сообщение с информацией, 
     * что именно неверно.
     *      Если всё введено и обработано верно, должен создаться файл с названием, 
     * равным фамилии, в него в одну строку должны записаться полученные данные, 
     * вида
     *      <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
     * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
     * Не забудьте закрыть соединение с файлом.
     *      При возникновении проблемы с чтением-записью в файл, исключение должно 
     * быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
     */

    public static void main(String[] args) throws IOException {
        try {
            UIPersonalData();
        } catch (FileSystemException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        public static void UIPersonalData() throws Exception {
        try (Scanner scan = new Scanner(System.in);) {
            System.out.println("Введите ваши данные через пробел в слудующем формате (в произвольной последовательности):");
            System.out.println("Фамилия Имя Отчество Дата_рождения номер_телефона пол:");
            String inputData = scan.nextLine();
            String[] inputDataArray = inputData.split(" ");
            int checkLength = checkLengthInputData(inputDataArray);
            if (checkLength == -1) {
                System.out.println("Похоже, что вы ввели меньше, чем нужно данных о себе");
            } else if (checkLength == -2) {
                System.out.println("Похоже, что вы ввели больше, чем нужно данных о себе");
            } else {
                savePersonalData(inputDataArray);
            }

        } 
        
     }

    public static int checkLengthInputData(String[] array) {
        if (array.length < 6) {
            return -1;
        }
        if (array.length > 6) {
            return -2;
        }
        return array.length;
    }

    public static void savePersonalData(String[] array) throws Exception{
        String name;
        String surname;
        String patronymic;
        Date birthdate;
        Long phone;
        char gender;

        System.out.println(Arrays.toString(array));

        surname = array[0];
        name = array[1];
        patronymic = array[2];

        try {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            birthdate = format.parse(array[3]);
        } catch (ParseException e) {
            throw new ParseException("Неверный формат даты", e.getErrorOffset());
        }

        try {
            char[] numberArray = array[4].toCharArray(); 
            System.out.println(numberArray.length);
            if (numberArray[0] == '+' && numberArray[0] == '-' && numberArray.length > 11) {
                System.out.println("1");
                throw new RuntimeException("Неверный формат номера телефона");
            }
            phone = Long.parseLong(array[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат номера телефона");
        }
            
        char[] arrayOfSymbols = array[5].toCharArray();
        char man = 'm';
        char woman = 'f';
        if (arrayOfSymbols.length == 1 && (arrayOfSymbols[0] == man || arrayOfSymbols[0] == woman)) {
            gender = arrayOfSymbols[0];
        } else {
            throw new RuntimeException("Неверный формат пола");
        }       
        
        String fileName = surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, birthdate, phone, gender));
            System.out.println("successfully");
        } catch (IOException e){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }
    }
     
         
}

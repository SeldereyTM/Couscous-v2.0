package example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  //  Создаем сканер


        //  Пользователь вводит число, которое будет преобразованно в прописное
        System.out.println("Введите положительное число, которое хотите получить прописью: ");
        long num = scan.nextLong();

        if (num == 0){  //  Если чел ввел 0 -> выводит ноль и заканчивает работу программы
            System.out.println("Ноль");
            System.exit(0);
        }

        int counter = 0;  //  Какой-то счетчик

        long[] arrayOfTriads = new long[7];  //  Массив для триад

        while(num != 0){  // Заполнение массива
            arrayOfTriads[counter] = num % 1000;
            num /= 1000;
            counter++;
        }


        String answer = "";  //  Пустое значение для ответа

        //  Заполнение ответа на каждую триаду отдельно
        if (arrayOfTriads[6] != 0){
            answer += numberWriter(arrayOfTriads[6]);
            answer += "Квинтиллион";
            answer = wordCorrector(answer,arrayOfTriads[6]);
        }

        if (arrayOfTriads[5] != 0){
            answer += numberWriter(arrayOfTriads[5]);
            answer += "Квадриллион";
            answer = wordCorrector(answer,arrayOfTriads[5]);
        }

        if (arrayOfTriads[4] != 0){
            answer += numberWriter(arrayOfTriads[4]);
            answer += "Триллион";
            answer = wordCorrector(answer,arrayOfTriads[4]);
        }

        if (arrayOfTriads[3] != 0){
            answer += numberWriter(arrayOfTriads[3]);
            answer += "Миллиард";
            answer = wordCorrector(answer,arrayOfTriads[3]);
        }
        if (arrayOfTriads[2] != 0){
            answer += numberWriter(arrayOfTriads[2]);
            answer += "Миллион";
            answer = wordCorrector(answer,arrayOfTriads[2]);
        }
        //  Триада тысяч работает по другим фунциям
        if (arrayOfTriads[1] != 0) {
            answer += numberWriter(arrayOfTriads[1]);
           answer = thousandWordCorrector(answer,arrayOfTriads[1]);

        }
        if (arrayOfTriads[0] != 0){
            answer += numberWriter(arrayOfTriads[0]);
        }

        System.out.println(answer);  //  Выводим полученный ответ
    }


    //  Функция для редактирования окончания слов в тысячной триаде
    public static String thousandWordCorrector(String answer,long num){
        char[] result = answer.toCharArray();

        if ((num % 10 == 1) && ((num % 100 - num % 10) != 10)) {  //  Редактор окончаний 1
            result[answer.length() - 3] = 'н';
            result[answer.length() - 2] = 'а';
        } else if ((num % 10 == 2) && ((num % 100 - num % 10) != 10)) {  //  Редактор окончаний 2
            result[answer.length() - 2] = 'е';
        }

        answer = String.valueOf(result);  //  Возвращение овета из массива в ответ

        answer += "Тысяч";

          //  Редактирование слова тысяч
        if ((num % 10 == 1) && ((num % 100 - num % 10) != 10)) {
            answer += "а ";
        } else if ((num % 10 == 2) && ((num % 100 - num % 10) != 10)) {
            answer += "и ";
        } else if ((num % 10 == 3) && ((num % 100 - num % 10) != 10)) {
            answer += "и ";
        } else if ((num % 10 == 4) && ((num % 100 - num % 10) != 10)) {
            answer += "и ";
        } else {
            answer += " ";
        }

        return answer;  //  Возвращает отредактированный ответ
    }


    //  Корректор оконачния высших триад
    public static  String wordCorrector (String answer,long num){
        if ((num % 10 == 1) && ((num % 100 - num % 10) != 10)) {
            answer += " ";
        } else if ((num % 10 == 2) && ((num % 100 - num % 10) != 10)) {
            answer += "а ";
        } else if ((num % 10 == 3) && ((num % 100 - num % 10) != 10)) {
            answer += "а ";
        } else if ((num % 10 == 4) && ((num % 100 - num % 10) != 10)) {
            answer += "а ";
        } else {
            answer += "ов ";
        }

        return answer;
    }


     //  Прописывает цифры словами
     public static String numberWriter (long number){
        String miniAnswer = "";  //  Промежуточный ответ

        int firstNumber = (int) number / 100;  //  Берем первую цифру триады

        switch(firstNumber){
            case 1 -> miniAnswer += "Cто ";
            case 2 -> miniAnswer += "Двести ";
            case 3 -> miniAnswer += "Триста ";
            case 4 -> miniAnswer += "Четыреста ";
            case 5 -> miniAnswer += "Пятьсот ";
            case 6 -> miniAnswer += "Шестьсот ";
            case 7 -> miniAnswer += "Семьсот ";
            case 8 -> miniAnswer += "Восемьсот ";
            case 9 -> miniAnswer += "Девятьсот ";
        }

         number %= 100;  //  Избавляемся от старшей цифры триады

        if (number > 0 && number < 20){  //
            switch((int)number){
                case 1 -> miniAnswer += "Один ";
                case 2 -> miniAnswer += "Два ";
                case 3 -> miniAnswer += "Три ";
                case 4 -> miniAnswer += "Четыре ";
                case 5 -> miniAnswer += "Пять ";
                case 6 -> miniAnswer += "Шесть ";
                case 7 -> miniAnswer += "Семь ";
                case 8 -> miniAnswer += "Восемь ";
                case 9 -> miniAnswer += "Девять ";
                case 10 -> miniAnswer += "Десять ";
                case 11 -> miniAnswer += "Одиннадцать ";
                case 12 -> miniAnswer += "Двенадцать ";
                case 13 -> miniAnswer += "Тринадцать ";
                case 14 -> miniAnswer += "Четырнадцать ";
                case 15 -> miniAnswer += "Пятнадцать ";
                case 16 -> miniAnswer += "Шестнадцать ";
                case 17 -> miniAnswer += "Семнадцать ";
                case 18 -> miniAnswer += "Восемнадцать ";
                case 19 -> miniAnswer += "Девятнадцать ";
            }
        } else if (number >= 20){  //  Если не подходит под верхние слова

            int fNumber = (int) number / 10;
            int sNumber = (int) number % 10;

            switch (fNumber){  //  Среднее число триады
                case 2 -> miniAnswer += "Двадцать ";
                case 3 -> miniAnswer += "Тридцать ";
                case 4 -> miniAnswer += "Сорок ";
                case 5 -> miniAnswer += "Пятьдесят ";
                case 6 -> miniAnswer += "Шестьдесят ";
                case 7 -> miniAnswer += "Семьдесят ";
                case 8 -> miniAnswer += "Восемьдесят ";
                case 9 -> miniAnswer += "Девяносто ";
            }

            switch (sNumber){  //  Младшее число триады
                case 1 -> miniAnswer += "Один ";
                case 2 -> miniAnswer += "Два ";
                case 3 -> miniAnswer += "Три ";
                case 4 -> miniAnswer += "Четыре ";
                case 5 -> miniAnswer += "Пять ";
                case 6 -> miniAnswer += "Шесть ";
                case 7 -> miniAnswer += "Семь ";
                case 8 -> miniAnswer += "Восемь ";
                case 9 -> miniAnswer += "Девять ";
            }
        }

        return miniAnswer;  //  Возвращаем добавленный ответ
    }
}

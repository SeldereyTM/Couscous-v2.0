package example;

import java.io.BufferedReader;  // Миллион непонятных импортов
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class pRiKoL {
    public static void main(String[] args) {

        // Пункт 1
        System.out.println("Введите 2 числа");
        int a, b;
        Scanner scan = new Scanner(System.in);

        while (true) {  // Пока не сработает без ошибок
            try {    // try позволяет обойти краш программы через вывод ошибки
                a = scan.nextInt();
                b = scan.nextInt();
                break;
            } catch (Exception e) {
                scan.next();
                System.out.println("Введите корректные данные");  // Ошибка
            }
        }

        try {  // Попытка делить а на б
            int result = a / b;
            System.out.printf("%d / %d = %d", a, b, result);
        } catch (ArithmeticException e) {
            System.out.println(a + " / " + b + " = математика проиграла");  // Ошибка если неделится
        }

        try {  // Попытка делить б на а
            int result = b / a;
            System.out.println();
            System.out.printf("%d / %d = %d", b, a, result);
        } catch (Exception e) {
            System.out.println(b + " / " + a + " = математика проиграла");
        }



        // Пункт 2
        File text = new File("Hedgehog.txt");  // Создание файла

        try {
            PrintWriter writer = new PrintWriter(text);  // Создание редактора

            for (int i = 1; i <= 200; i++) {  // Заполнение файла 200 рандомными индексированными числами
                writer.println("№" + i + ": " + (int) (Math.random() * 99 + 1) + " ");
            }

            writer.close();  // Дестуктор считывателя
        } catch (Exception e) {
            System.out.println("Ты дубина все сломал");
        }

        Scanner scan1 = new Scanner(System.in);
        System.out.println("\n   ---------\nВыберете номер числа, которое надо вывести");  // Выбор индекса числа Числа
        String address = scan1.nextLine();
        address = "№" + address + ": ";  // Подгонка индекса во избежание ошибок

        try{
            FileReader fr = new FileReader(text);  // Создание считывателя всего файла
            BufferedReader reader = new BufferedReader(fr);  // Создание считывателя строки в файле

            String line = reader.readLine();

            while (line != null) { // Пока строка не пустая
                if(line.contains(address)){  // Проверка на наличие индекса в проверяемой строке
                    String[] words = line.split(": ");  // Создание массива содержащего слова разделенные ": "
                    System.out.println("Искомое число в файле Hedgehog: "+words[1]);  // Вывод второго слова (рандомного числа, созданного ранее)

                }
                line = reader.readLine();  // Считывание строки в цикле
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Пункт 3
        File anton = new File("Anton.txt");  // СОздание двух Файлов
        File ganDone = new File("GanDone.txt");

        try {
            Scanner scanA = new Scanner(anton);
            Scanner scanB = new Scanner(ganDone);

            String antonLine = scanA.nextLine();  // Считывание строк в файлах
            String gunDoneLine = scanB.nextLine();

            StringBuffer bufferAnton = new StringBuffer(antonLine);  // Непонятная штука, но она нужна
            StringBuffer bufferGunDone = new StringBuffer(gunDoneLine);

            bufferAnton.reverse();  // Процесс выворачивание строки
            bufferGunDone.reverse();

            PrintWriter writerAnton = new PrintWriter(anton);  // Создание
            PrintWriter writerGanDone = new PrintWriter(ganDone);

            writerAnton.println(bufferGunDone);  // Замена строк местами в файлах
            writerGanDone.println(bufferAnton);

            writerAnton.close();  // Деструктор считывателей
            writerGanDone.close();

            System.out.println("   ---------\nФайлы Anton & GunDone отредактированы");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

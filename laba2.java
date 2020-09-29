package example;

import java.util.Scanner;  //Подключение сканера для считывания информации с клавиатуры в консоль

public class laba2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  //создание сканера

        System.out.print("-------------\nНеинтересный блок программы:\n");  //неинтересный switch
        for (byte i = 0; i < 3; i++) {
            switch (i) {
                case 0 -> {
                    System.out.print("Секция номер: " + (i + 1));
                    break;
                }
                case 1 -> {
                    System.out.print("\nСекция номер: " + (i + 1));
                    break;
                }
                case 2 -> {
                    System.out.print("\nСекция номер: " + (i + 1));
                    break;
                }
            }
        }


        System.out.print("\nНеинтересный блок программы завершен ._.\n-------------\n" +
                "/Последовательность Фибоначи/" +
                "\nВведите целочисленный аргумент длинны последовательности Фибоначи (1<длинна<47): ");
        int febonachi = scan.nextInt();  //Пользователь вводит длинну последовательности Фибоначи
        int[] FibArr = new int[febonachi]; //Объявление массива
        FibArr[0]=1;
        FibArr[1]=1;
        for (int i=2;i<febonachi;i++){  //Заполнение массива числами Фибоначи
            FibArr[i]=FibArr[i-1]+FibArr[i-2];
        }
        System.out.print("Последовательность Фибоначи длинны "+febonachi+": ");
        for (int i=0;i<(febonachi-1);i++){  //Вывод массива последовательности кроме последнего числа
            System.out.print(FibArr[i]+",");
        }
        System.out.print(FibArr[febonachi-1]);  //Вывод последнего числа последовательности


        System.out.print("\n-------------\n/Числа вампиры/\nВсе 4-х значные числа вампиры:\n");
        int[] numV = new int[4];  //Создание массива под цифры числа для будущего перебора
        for(int i =1000;i<10000;i++){
            int subsI=i;

            //Заполнение массива
            numV[0]=subsI/1000;
            subsI=i%1000;

            numV[1]=subsI/100;
            subsI=i%100;

            numV[2]=subsI/10;
            subsI=i%10;

            numV[3]=subsI;


            //Перебор всех возможных комбинаций цифр и вывод подходящих под условие чисел Вампиров
            if((((numV[0]*10) + numV[2]) * ((numV[1]*10) + numV[3]))==i){
                System.out.println(i+" = "+((numV[0]*10) + numV[2])+" * "+((numV[1]*10) + numV[3]));
            }
            else if((((numV[0]*10) + numV[3]) * ((numV[1]*10) + numV[2]))==i){
                System.out.println(i+" = "+((numV[0]*10) + numV[3])+" * "+((numV[1]*10) + numV[2]));
            }


            else if((((numV[0]*10) + numV[1]) * ((numV[2]*10) + numV[3]))==i){
                System.out.println(i+" = "+((numV[0]*10) + numV[1])+" * "+((numV[2]*10) + numV[3]));
            }
            else if((((numV[0]*10) + numV[3]) * ((numV[2]*10) + numV[1]))==i){
                System.out.println(i+" = "+((numV[0]*10) + numV[3])+" * "+((numV[2]*10) + numV[1]));
            }


            else if((((numV[0]*10) + numV[1]) * ((numV[3]*10) + numV[2]))==i){
                System.out.println(i+" = "+((numV[0]*10) + numV[1])+" * "+((numV[3]*10) + numV[2]));
            }
            else if((((numV[0]*10) + numV[2]) * ((numV[3]*10) + numV[1]))==i){
                System.out.println(i+" = "+((numV[0]*10) + numV[2])+" * "+((numV[3]*10) + numV[1]));
            }


            else if((((numV[1]*10) + numV[0]) * ((numV[2]*10) + numV[3]))==i){
                System.out.println(i+" = "+((numV[1]*10) + numV[0])+" * "+((numV[2]*10) + numV[3]));
            }
            else if((((numV[1]*10) + numV[3]) * ((numV[2]*10) + numV[0]))==i){
                System.out.println(i+" = "+((numV[1]*10) + numV[3])+" * "+((numV[2]*10) + numV[0]));
            }


            else if((((numV[1]*10) + numV[0]) * ((numV[3]*10) + numV[2]))==i){
                System.out.println(i+" = "+((numV[1]*10) + numV[0])+" * "+((numV[3]*10) + numV[2]));
            }
            else if((((numV[1]*10) + numV[2]) * ((numV[3]*10) + numV[0]))==i){
                System.out.println(i+" = "+((numV[1]*10) + numV[2])+" * "+((numV[3]*10) + numV[0]));
            }


            else if((((numV[2]*10) + numV[0]) * ((numV[3]*10) + numV[1]))==i){
                System.out.println(i+" = "+((numV[2]*10) + numV[0])+" * "+((numV[3]*10) + numV[1]));
            }
            else if((((numV[2]*10) + numV[1]) * ((numV[3]*10) + numV[0]))==i){
                System.out.println(i+" = "+((numV[2]*10) + numV[1])+" * "+((numV[3]*10) + numV[0]));
            }
        }
        System.out.print("-------------");  //Конец программы
    }
}

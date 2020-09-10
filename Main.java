package example;

import java.util.Scanner;  //Подключение сканера для считывания информации с клавиатуры в консоль


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  //создание сканера1
        System.out.print("Введите количество пользователей: ");
        int count = scan.nextInt();

        Person[] persons = new Person[count];  //объявление массива объектов
        for (int i = 0; i < count; i++) {
            Scanner scan2 = new Scanner(System.in);  //создание еще двух сканеров
            Scanner scan3 = new Scanner(System.in);  //

            persons[i] = new Person();

            System.out.println("Заполните данные для " + (i + 1) + "-го пользователя:");

            System.out.print("Введите имя: ");
            persons[i].name = scan2.nextLine();

            System.out.print("Введите возраст: ");
            persons[i].age = scan2.nextInt();

            System.out.print("Введите модель телефона: ");
            persons[i].model = scan3.nextLine();

            System.out.print("Введите корректный номер телефона: ");
            persons[i].ChangeNum();

            System.out.println(persons[i].name + " добавлен!\n");
        }

        System.out.println("\nВсе добавленные пользователи:");  //вывод всех созданных объектов
        for (int i = 0; i < count; i++){
            System.out.println("-------------");
            persons[i].displayInfo();
        }

        Scanner scan4 = new Scanner(System.in);  //запуск редактора объектов
        System.out.println("-------------\nВы хотите отредактировать какого-нибудь пользователя?\n1-ДА\n2-НЕТ");
        byte answer = scan4.nextByte();
        while (answer!=2){
            System.out.println("Выберите пользователя, которого хотите отредактировать:");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + "-" + persons[i].name);
            }
            int index = scan.nextInt();
            System.out.println("Какой параметр вы хотите изменить у пользователя "+persons[index-1].name+"\n1-Номер телефона\n2-Модель телефона\n3-оба Параметра\n4-Вернуться назад");
            byte answer2 = scan4.nextByte();

            switch (answer2) {
                case 1 -> {
                    System.out.print(persons[index - 1].name + "'s новый номер: ");
                    persons[index - 1].ChangeNum();
                }
                case 2 -> persons[index - 1].ChangeModel();
                case 3 -> {
                    System.out.print(persons[index - 1].name + "'s новый номер: ");
                    persons[index - 1].ChangeNum();
                    persons[index - 1].ChangeModel();
                }
            }

            System.out.println("Вы хотите отредактировать какого-нибудь пользователя?\n1-ДА\n2-НЕТ");
            answer = scan4.nextByte();
        }

        System.out.println("\nВсе добавленные пользователи:");  //вывод всех отредакторованных созданных объектов
        for (int i = 0; i < count; i++){
            System.out.println("-------------");
            persons[i].displayInfo();
        }
    }
}



class Person{  //Создание класса человек

    String name, model, num;
    int age;

    public Person(String name, int age, String model, String num){  //Конструктор объектов
        this.name = name;
        this.age = age;
        this.model = model;
        this.num = num;
    }

    Person(){ //Конструктор дефолтных значений
        this("Anonymous", 0, "model", "NuN");
    }

   void ChangeNum(){  //Изменение номера телефона
        Scanner scan = new Scanner(System.in);

        this.num= scan.nextLine();  //проверка корректности номера телефона
       while(( this.num.length() != 12 ) || (this.num.indexOf("+") != 0)||(this.num.indexOf("7") != 1 )){
           System.out.print("        !!!Error1!!!\nВы ввели НЕКОРРЕКТНЫЙ номер\nПравильная форма: +7-ХХХ-ХХХ-ХХ-ХХ\n[Пример ввода: +78005553535]\nПожалуйста, введите номер телефона повторно: ");
           this.num = scan.nextLine();
       }

        System.out.println();

    }
    void ChangeModel(){  //Изменение Модели телефона
        Scanner scan = new Scanner(System.in);
        System.out.print(this.name+"'s новая модель телефона: ");
        this.model = scan.nextLine();
        System.out.println();
    }

    void displayInfo(){  //Метод вывода информации
        System.out.println("\nИмя: "+this.name+"\nВозраст: "+ this.age+ "\nМодель телефона: "+model+"\nНомер телефона: "+num+"\n");
    }
}


import java.util.Scanner;  // Подключение сканера

public class FirstGame{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  // Создание сканера

        System.out.println("Хотите начать игру?\n1 - Начать\n0 - выйти из игры");  // Главное меню
        int answer = scan.nextInt(); // Сканируем ответ в главном меню
        if(answer == 1){


            System.out.println("Выберите сложность:\n1 - просто\n2 - средне\n3 - сложно\n4 - очень сложно\n5 - Политех");  // Выбор сложности
            int level = scan.nextInt();  // Сканируем сложность
            int numOfEnemy = (int)(Math.random() * (level * 5) + (level * 3));  // Генерация случайного кол-ва врагов в зависимости от сложности
            int statOfEnemy = numOfEnemy;  // Создание доп счетчика прохождения подземелья

            Enemy boss = new Enemy(250 * level, 5 * level, 15 * level, 1000);  // Создание Босса

            Enemy[] enemies = new Enemy[numOfEnemy];  // Создание массива врагов
            for (int i = 0; i < numOfEnemy; i++){  // Создание случайных параметров для врагов
                int dam =(int)(Math.random() * (10 * level) + (5 * level));
                int hea = (int)(Math.random() * (50 * level) + (40 * level));
                int arm = (int)(Math.random() * (2 * level) + level);
                int exp = (dam - 5 ) + (hea - 40) + (arm - 1);
                enemies[i] = new Enemy(hea, arm, dam, exp);  // Заполнение массива врагами
            }

            System.out.println("Введите никнейм:");  // Выбор имени гг
            String nickname = scan.next();  // Сканирование имени
            Hero hero = new Hero(nickname);  // Создание гг

            System.out.println("\nВыберите класс:\n1 - Танк\n2 - Маг\n3 - Целитель\n4 - яростный бомж");  // Выбор класса гг
            int quality = scan.nextInt();
            switch(quality){  // Отображение выбранного класса
                case 1 :
                    hero.setHero(260, 10, 20, 10);
                    System.out.println("\nВаши стартовые показатели:\n--------\nЗдоровье - 260\nБроня - 10\nУрон - 20\nЛечение - 10\n--------");
                    break;
                case 2 :
                    hero.setHero(180, 5, 30, 15);
                    System.out.println("\nВаши стартовые показатели:\n--------\nЗдоровье - 180\nБроня - 5\nУрон - 35\nЛечение - 15\n--------");
                    break;
                case 3 :
                    hero.setHero(150, 7, 15, 20);
                    System.out.println("\nВаши стартовые показатели:\n--------\nЗдоровье - 150\nБроня - 7\nУрон - 15\nЛечение - 20\n--------");
                    break;
                case 4 :
                    hero.setHero(80, 5, 45, 5);
                    System.out.println("\nВаши стартовые показатели:\n--------\nЗдоровье - 80\nБроня - 5\nУрон - 45\nЛечение - 5\n--------");
                    break;
            }

            // Начало игры

            System.out.println("\nГерой " + hero.name + " спускается в темное страшное пугающее подземелье, чтобы найти сокровище золотого питуха ");

            for (int i = 0; i < numOfEnemy; i++){
                if (hero.health > 0){
                    System.out.println("\n" + hero.name + " встречает " + (i + 1) + "-го врага и нападает на него");  // Начало нового боя

                    while ((enemies[i].health > 0) & (hero.health > 0)){
                        hero.statistics(enemies[i]);  // Вывод статы боя
                        System.out.println("Что делать?...\n1 - атаковать\n2 - лечиться\n3 - Посмотреть статистику\n9 - бежать");  // Выбор действия
                        int battleAnswer = scan.nextInt();
                        if (battleAnswer == 3){  // Возможность посмотреть статистику персонажа
                            hero.showStatics();
                            System.out.println("Что делать?...\n1 - атаковать\n2 - лечиться\n9 - бежать");  // Выбор действия после
                            battleAnswer = scan.nextInt();
                        }
                        switch(battleAnswer){
                            case 1 :
                                enemies[i].getDamage(hero);
                                break;
                            case 2 :
                                hero.getHeal();
                                break;
                            case 9 :
                                hero.health = 0;
                                break;
                        }

                        if (enemies[i].health > 0) hero.getDamage(enemies[i]);  // Если враг жив, герой получает по шапке

                    }
                    if ((enemies[i].health <= 0) & (hero.health > 0)){  // Победа над врагом
                        System.out.println(hero.name + " одержал победу над врагом и продолжил свое приключение");
                        hero.checkLevel(enemies[i]);
                        statOfEnemy--;



                    } else if ((hero.health <= 0) & (enemies[i].health > 0)) System.out.println(hero.name + " проиграл в схватке с судьбой\nИгра завершена...");  // Герой умирает -> проигрыш

                }
            }
            if (statOfEnemy == 0){
                System.out.println("\nГерой одержал победу над всеми противниками на своем пути. \nПереступая через полуразложившиеся трупы старых героев, " + hero.name + " вошел в главный зал, где его взгляд поймал на себе Король подзмелья Томми Бейкер.");
                System.out.println("Томии Бейкер пафосно поднялся со своего трона. Колосальная фигура Томми заслонила собою свет факелов. \nЧерез секунду весь зал завибрировал от его рева. Слова \"Omae Wa Mou Shindeiru\", кажется, было слышно во всех уголках подземелья.");
                System.out.println("Буквально через мнгновение " + hero.name + " услышал \"Nani?!\", и началась великая битва!");

                while ((boss.health > 0) & (hero.health > 0)){

                    hero.statistics(boss);  //
                    System.out.println("Что делать?...\n1 - атаковать\n2 - лечиться\n3 - Посмотреть статистику\n9 - бежать");  // Выбор действия

                    int battleAnswer = scan.nextInt();

                    if (battleAnswer == 3){
                        hero.showStatics();
                        System.out.println("Что делать?...\n1 - атаковать\n2 - лечиться\n9 - бежать");
                        battleAnswer = scan.nextInt();
                    }
                    switch(battleAnswer){
                        case 1 :
                            boss.getDamage(hero);
                            break;
                        case 2 :
                            hero.getHeal();
                            break;
                        case 9 :
                            hero.health = 0;
                            break;
                    }

                    if (boss.health > 0) hero.getDamage(boss);
                }
                if (hero.health <= 0) System.out.println(hero.name + " погиб от рук Томми Бейкера. Очередной герой, чьи останки будут гнить перед дверьми тронного зала...\nКонец игры...");
                else if (boss.health <= 0){
                    System.out.println("\n" + hero.name + " яростно нанес завершающий удар Томми Бейкеру. С рук героя лилась кровь врага, перемешенная с его собственной. Отдышавшись, он пошел в сторону трона...");
                    System.out.println(hero.name + " уселся на трон. На его лице появилась дьявольская ухмылка. \nДвери зала медленно закрылись, а новоиспеченный Король подземелья остался в полном одиночестве.");
                    System.out.println("Кажется, наш герой уже никогда не вспомнит о золотом питухе, за которым он прежде так гнался...");
                    System.out.println("Конец игры...");
                }
            }
        } else {
            System.out.println("Игра завершена");  // в случае выхода из игры
        }
    }


    public static class Hero {  // Объявление класса герой
        Scanner scan1 = new Scanner(System.in);
        String name;
        int health, armor, damage, heal, maxHealth, xp, level;

        Hero(String name, int health, int armor, int damage, int heal, int maxHealth, int xp, int level) {  // Объявление греоя
            this.name = name;
            this.health = health;
            this.armor = armor;
            this.damage = damage;
            this.heal = heal;
            this.maxHealth = maxHealth;
            this.xp = xp;
            this.level = level;
        }

        public void setHero(int health, int armor, int damage, int heal) {  // Выбор класса
            this.health = health;
            this.armor = armor;
            this.damage = damage;
            this.heal = heal;
            this.maxHealth = health;
        }

        Hero(String name) {  // Выбор имени
            this.name = name;
        }

        Hero() {  // стандартные значения
            this("NoN", 100, 25, 30, 20, 100, 0, 1);
        }

        void getHeal() {  // Лечение
            if ((this.health + this.heal) >= this.maxHealth){
                this.health = this.maxHealth;
                System.out.println(" -герой " + this.name + " полность восстановил здоровье");
            } else {
                this.health += this.heal;
                System.out.println(" -герой " + this.name + " пополнил здоровье на " + this.heal);
            }
        }

        void getDamage(Enemy e){  // Урон герою
            if (this.armor < e.damage) {
                this.health -= (e.damage - this.armor);
                System.out.println(" -героя " + this.name + " охладили на " + (e.damage - this.armor) + " урона\n\n");
            }
        }

        void checkLevel(Enemy e){
            this.xp += e.xp;
            while(this.xp >= 100){
                this.level++;
                this.xp -= 100;
                System.out.println("\nУ " + this.name + " новый уровень!(Lv" + (this.level - 1) + "->" + (this.level) + ")\nВыберите характеристику для прокачки:\n1 - здоровье (+15)\n2 - броня (+2)\n3 - урон (+8)\n4 - лечение (+5)");
                int answer1 = scan1.nextInt();
                switch(answer1){
                    case 1 :
                        this.maxHealth += 15;
                        System.out.println("Максимальное здоровье увеличено!");
                        break;
                    case 2 :
                        this.armor += 2;
                        System.out.println("Броня улучшена!");
                        break;
                    case 3 :
                        this.damage += 8;
                        System.out.println("Боевые навыки повышены!");
                        break;
                    case 4 :
                        this.heal += 5;
                        System.out.println("Лечение улучшено!");
                        break;
                }
                this.health = this.maxHealth;
                System.out.println("Здоровье восполнено до максимума!");
            }
        }

        public void statistics(Enemy e){  // Вывод статистики боя
            System.out.println("        ---Бой---\nГерой(Lv" + this.level + "):   Противник(Exp" + e.xp + "):\nHP: " + this.health + "        HP: " + e.health + "\nArm: " + this.armor + "         Arm: " + e.armor + "\nDmg: " + this.damage + "        Dmg: " + e.damage + "\n        ---------");
        }

        public void showStatics(){
            System.out.println("   --- Статистика ---\nГерой" + this.name + ":\nLevel: " + this.level + "(" + this.xp + "Exp)\nЗдоровье: " + this.maxHealth + "/" + this.health + "\nБроня: " + this.armor + "\nСила атаки: " + this.damage + "\nЛечение: " + this.heal + "\n   ------------------");
        }

    }






    public static class Enemy{  // Класс врагов

        int health, armor, damage, xp;

        Enemy(int health, int armor, int damage, int xp){  // Создание врага
            this.health = health;
            this.armor = armor;
            this.damage = damage;
            this.xp = xp;
        }

        Enemy(){  // стандартные значения
            this(100, 25, 30, 10);
        }

        void getDamage(Hero h){  // Урон противнику
           if(this.armor < h.damage){
               this.health -= (h.damage - this.armor);
               System.out.println(" -противник отхватил " + (h.damage - this.armor) + " урона по шапке");
           }
        }
    }
}
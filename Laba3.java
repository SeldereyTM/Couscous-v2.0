import java.util.Scanner;
// подключаем сканнер
public class Laba3{
    public static int value = 0, time = 2500, entry;
    // задаем начальные параметры для игрового значения, скорости игры и значения ввода игрока
    public static class Opponent extends Thread {
        // переопределяем функцию run
        @Override
        public void run() {
            while (value < 10 && value >= -10) {
                System.out.println( "Текущее значение -> " + value);
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (value != 10)
                value--;
            }
            if (value <= -10)
                System.out.println( "Прошу извинить, но вы проиграли");
            else if(value == 10)
                System.out.println( "Поздравляю с победой!!!!");
        }
    }
    // основной блок программы
    public static class Main {
        public static void main(String[] args) {
            // создаем экземпляры сканнера и потока
            Scanner scanner = new Scanner(System.in);
            Opponent thread = new Opponent();
            //дополнительная функция для интереса
            System.out.println( "Выберте скорость:\n1 - изи\n2 - нормал\n3 - хард");
            int difficulty = scanner.nextInt();
            switch (difficulty) {
                case 1 -> time += 500;
                case 3 -> time -= 500;
            }
            // запускаем оппонента
            thread.start();
            //даем возможность игроку шагать
            while (value < 10 && value >= -10) {
                entry = scanner.nextInt();
                if (entry == value + 1){
                    value++;
                    System.out.print( "Текущее значение -> " + value);
                }
            }
        }
    }
}

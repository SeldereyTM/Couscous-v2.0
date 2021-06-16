import java.util.ArrayList;

public class Laba2{
    public static void main(String[] args) {
        // создаем и заполняем список
        ArrayList<String> people = new ArrayList<String>();
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        // выводим список на экран
        for(String person : people)
            System.out.println(person);
        // импользуем созданную функ.
        System.out.println("пулим первого");
        polll(people);
        // проверяем
        for(String person : people)
            System.out.println(person);
    }
    public static void polll(ArrayList<String> a) {
        for(int i = 1; i < a.size(); i++ ) {
            a.set(i-1, a.get(i));
        }
        a.remove(a.size()-1);
    }
}

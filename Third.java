import java.util.Scanner;

public class Third
{
	public static void main(String[] args) {
	    Dog dog = new Dog();
	    BarkVariants[] vars = BarkVariants.values();
        for (BarkVariants s : vars) { System.out.println(s); }
        
        Scanner S = new Scanner(System.in);
        System.out.println("\nНапишите номер варианта: ");
        Money[] typeMoney = Money.values();
        for (Money s: typeMoney) {
            System.out.println("\t" + s.ordinal() + " - " + s);
        }
        
        int pos = S.nextInt();
        if (pos >= 0 & pos < 6){
            Money var = Money.values()[pos];
        
            switch(var){
                case DOLLAR:
                    System.out.print("Доллар - хороший выбор");
                    break;
                case RUBLE:
                    System.out.print(" ...");
                    break;
                case EURO:
                    System.out.print("Евро - прекрасный выбор");
                    break;
                case KRONE:
                    System.out.print("pass");
                    break;
                case TENGE:
                    System.out.print("Самый простой путь стать миллионером");
                    break;
                    
                default:
                    System.out.print("Мимо");
                    break;
            }
        } else {
            System.out.println("Не корректно");
        }
        
	}
}

class Dog{
	String name;
	String breed;
	int age;

//	Конструкторы
	Dog(String name, String breed, int age){
		this.name = name;
		this.breed = breed;
		this.age = age;
	}

	Dog(String name, String breed){
		this(name, breed, 0);
	}

	Dog(String name, int age){
		this(name,"NuN", age);
	}

	Dog(int age){
		this("NuN", "NuN", age);
	}
	
	Dog(){
	    this("NuN", "NuN", 0);
	}
	
	
	void bark(){
		System.out.println("Bark");
	}
	
	void bark(String s){
	    System.out.println(s);
	}
	
	void bark(BarkVariants var){
		switch (var){
			case BARK:
			    bark();
				break;
			case HRM:
			    bark("Hhgrmm");
				break;
			case UH:
			    bark("Uhgrr");
			    break;
			case WOW:
			    bark("Wooow");
			    break;
		}
	}
}

enum BarkVariants{
    BARK, HRM, UH, WOW 
}

enum Money{
    DOLLAR, RUBLE, EURO, KRONE, FRANC, TENGE
}

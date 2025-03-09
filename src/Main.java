import Cat.Cat;
import Dog.Dog;
import FoodBowl.FoodBowl;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Петровей");
        Cat cat2 = new Cat("Бакс");
        Dog dog1 = new Dog("Бинго");
        Dog dog2 = new Dog("Рекс");

        cat1.run(180);
        cat2.swim(5);
        dog1.run(470);
        dog2.swim(8);

        FoodBowl bowl = new FoodBowl(20);

        Cat[] cats = {cat1, cat2};

        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }

        bowl.addFood(10);

        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего животных:" +(Cat.getCatCount() + Dog.getDogCount()));

    }

}

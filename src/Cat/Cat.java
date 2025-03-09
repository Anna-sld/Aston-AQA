package Cat;
import Animal.Animal;
import FoodBowl.FoodBowl;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        this.satiety = false;
        catCount++;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(FoodBowl bowl, int foodAmount) {
        if (bowl.getFood() >= foodAmount) {
            bowl.decreaseFood(foodAmount);
            this.satiety = true;
            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println(name + " хотел съесть " + foodAmount + " еды, но в миске недостаточно.");
        }

    }
    public static int getCatCount() {
        return catCount;
    }
}

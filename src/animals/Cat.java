package animals;

public class Cat extends Animal {
    private boolean fullness;
    private static int counterOfCats;
    private static int bowlOfFood;

    public Cat(String name) {
        super(name);
        counterOfCats++;

    }

    public Cat() {
        counterOfCats++;
    }

    @Override
    public void toRun(int distance) {
        if (distance > 200) {
            System.out.println(getName() + " пробежал 200 м");
        } else {
            System.out.println(getName() + " пробежал " + distance + " м");
        }
    }

    @Override
    public void toSwim(int distance) {
        {
            System.out.println(getName() + " не умеет плавать :(");
        }
    }

    public void feedCat(int food) {
        if (food > bowlOfFood) {
            System.out.println("Увы, еда не бесконечная :(");
            this.setFullness(false);
        } else if (food == bowlOfFood) {
            System.out.println("Еда в миске кончилась, но котик наелся");
            bowlOfFood=bowlOfFood-food;
            this.setFullness(true);
        } else if (food < bowlOfFood) {
            bowlOfFood=bowlOfFood-food;
            this.setFullness(true);
        }
    }

    public static void addFoodToBowl(int amount) {
        bowlOfFood = amount;
        System.out.println("В миску для котов насыпали " + amount + " корма");
    }

    public static void showCatCount() {
        if (counterOfCats == 0) {
            System.out.println("Котиков не существует");
        } else if (counterOfCats == 1) {
            System.out.println("Всего существует " + counterOfCats + " котик");
        } else System.out.println("Всего существует " + counterOfCats + " котиков");
    }

    public boolean getFullness() {
        return fullness;
    }

    public void setFullness(boolean food) {
        this.fullness = food;
    }

    public static void getBowlOfFoodInfo() {
        System.out.println("Количество корма в миске для котов " + bowlOfFood);
    }
}

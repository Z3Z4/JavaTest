package animals;

public class Dog extends Animal {
    private boolean fullness;
    private static int counterOfDogs;
    private static int bowlOfFood;

    public Dog(String name) {
        super(name);
        counterOfDogs++;

    }

    public Dog() {
        counterOfDogs++;
    }

    @Override
    public void toRun(int distance) {
        if (distance > 500) {
            System.out.println(getName() + " пробежал 500 м");
        } else {
            System.out.println(getName() + " пробежал " + distance + " м");
        }
    }

    @Override
    public void toSwim(int distance) {
        {
            if (distance > 10) {
                System.out.println(getName() + "проплыл 10 м");
            } else
                System.out.println(getName() + " проплыл " + distance + " м");
        }
    }

    public void feedDog(int food) {
        if (food > bowlOfFood) {
            System.out.println("Увы, еда не бесконечная :(");
            this.setFullness(false);
        } else if (food == bowlOfFood) {
            System.out.println("Еда в миске кончилась, но собакен наелся");
            bowlOfFood = bowlOfFood - food;
            this.setFullness(true);
        } else if (food < bowlOfFood) {
            bowlOfFood = bowlOfFood - food;
            this.setFullness(true);
        }
    }

    public static void addFoodToBowl(int amount) {
        bowlOfFood = amount;
        System.out.println("В миску для собак насыпали " + amount + " корма");
    }

    public static void showDogCount() {
        if (counterOfDogs == 0) {
            System.out.println("Собак не существует");
        } else if (counterOfDogs == 1) {
            System.out.println("Всего существует " + counterOfDogs + " собака");
        } else System.out.println("Всего существует " + counterOfDogs + " собак");
    }

    public boolean getFullness() {
        return fullness;
    }

    public void setFullness(boolean food) {
        this.fullness = food;
    }

    public static void getBowlOfFoodInfo() {
        System.out.println("Количество корма в миске для собак " + bowlOfFood);
    }
}

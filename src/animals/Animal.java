package animals;

public abstract class Animal {
    private String name;
    private String age;
    private static int counter;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public Animal() {
        counter++;
    }

    public void toRun(int distance) {
        System.out.println(name + " пробежал " + distance + " м");
    }

    public void toSwim(int distance) {
        System.out.println(name + " проплыл " + distance + " м");
    }

    public static void showAnimalCount() {
        if (counter == 0) {
            System.out.println("Животных не существует");
        } else if (counter == 1) {
            System.out.println("Всего существует одно животное");
        } else if (counter > 1) {
            System.out.println("Всего существует " + counter + " животных");
        }
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

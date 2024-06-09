import animals.*;
import task2.*;

public class Main {
    public static void main(String[] args) {

        Cat cats[] = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Kotya" + i);
            System.out.println(cats[i].getName() + " Появился на свет");
        }
        Cat.addFoodToBowl(100);
        Cat.getBowlOfFoodInfo();
        for (Cat cat : cats) {
            cat.feedCat(25);
            System.out.println(cat.getName() + " наелся? " + cat.getFullness());
        }

        System.out.println("");

        cats[3].toSwim(5);
        cats[3].toRun(250);

        System.out.println("");

//
//        Dog dogs[] = new Dog[5];
//        for (int i = 0; i < dogs.length; i++) {
//            dogs[i] = new Dog("Bobik" + i);
//            System.out.println(dogs[i].getName() + " Появился на свет");
//        }
//        Dog.addFoodToBowl(100);
//        Dog.getBowlOfFoodInfo();
//        for (int i = 0; i < dogs.length; i++) {
//            dogs[i].feedDog(30);
//            System.out.println(dogs[i].getName()+" наелся? "+dogs[i].getFullness());
//        }
//
//        System.out.println("");

        Animal.showAnimalCount();
        Cat.showCatCount();
        Dog.showDogCount();

        System.out.println("");

        Circle circle = new Circle(7);
        circle.setFillColor("Жёлтый");
        circle.setBorderColor("Черный");

        Rectangle rectangle = new Rectangle(6, 13);
        rectangle.setFillColor("Фиолетовый");
        rectangle.setBorderColor("Красный");

        Triangle triangle = new Triangle(3, 4, 6);
        triangle.setFillColor("Синий");
        triangle.setBorderColor("Белый");

        System.out.println("Круг: Периметр = " + circle.getPerimeter() + ", Площадь = " + circle.getArea() + ", Цвет фона = " + circle.getFillColor() + ", Цвет границы = " + circle.getBorderColor());
        System.out.println("Прямоугольник: Периметр = " + rectangle.getPerimeter() + ", Площадь = " + rectangle.getArea() + ", Цвет фона = " + rectangle.getFillColor() + ", Цвет границы = " + rectangle.getBorderColor());
        System.out.println("Треугольник: Периметр = " + triangle.getPerimeter() + ", Площадь = " + triangle.getArea() + ", Цвет фона = " + triangle.getFillColor() + ", Цвет границы = " + triangle.getBorderColor());
    }
}

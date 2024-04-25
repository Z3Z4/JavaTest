import java.util.Scanner;

public class Meow {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        String x = new Scanner(System.in).nextLine();
        System.out.println("Your Name is "+x);
    }
}
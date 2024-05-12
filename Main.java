import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //First Task
        System.out.println(printThreeWords());
        //Second Task
        System.out.println(checkSumSign());
        //Third Task
        System.out.println(printColor());
        //Fourth Task
        System.out.println(compareNumbers());
        //Fifth Task
        System.out.println(checkRangeOfSum());
        //Sixth Task
        checkIsPositiveNumber(-9);
        //Seventh Task
        System.out.println(checkIsNegativeNumber(34));
        //Eight Task
        printString("Hello :)", 4);
        //Tenth Task
        int year = 2024;
        System.out.println(isLeapYear(year) ? year + " = Високосный год" : year + " = Не високосный год");
        swapNumbersInArray();
        //Eleventh Task
        fillArray();
        //Twelfth Task
        multiplyArray();
        //Thirteenth Task
        squareArray();
        //Fourteenth Task
        measureArray(7, 34);
    }

    static String printThreeWords() {
        return "Orange \n" + "Banana \n" + "Apple ";
    }

    static String checkSumSign() {
        int a = -10;
        int b = 7;
        return 0 <= (a + b) ? "Сумма положительная" : "Сумма отрицательная";
    }

    static String printColor() {
        int value = 101;
        String result = "111";
        if (value <= 0) {
            result = "Красный";
        } else if (value > 0 && value <= 100) {
            result = "Желтый";
        } else if (value > 100) {
            result = "Зеленый";
        }
        return result;
    }

    static String compareNumbers() {
        int a = 17;
        int b = 48;
        return a >= b ? "a >= b" : "a < b";
    }

    static boolean checkRangeOfSum() {
        Scanner scanner = new Scanner(System.in);
        int num1 = 34;
        int num2 = 56;
        // Сканнеры закомментировал чтобы не мешали проверять
        //    int num1 = scanner.nextInt();
        //    int num2 = scanner.nextInt();
        return (num1 + num2) >= 10 && (num1 + num2) <= 20;
    }

    ;

    static void checkIsPositiveNumber(int num) {
        System.out.println(num >= 0 ? "Число " + num + " положительное" : "Число " + num + " Отрицательное");
    }

    static boolean checkIsNegativeNumber(int num) {
        return num < 0;
    }

    static void printString(String string, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println(string);
        }
    }

    static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }

    static void swapNumbersInArray() {
        int numbers[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Исходный массив ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 1;
            } else {
                numbers[i] = 0;
            }
        }
        System.out.print("\nИзмененный массив ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    static void fillArray() {
        int array[] = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;

        }
        System.out.println("\nМассив заполненный значениями от 1 до 100 ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    static void multiplyArray() {
        int numbers[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                numbers[i] *= 2;
            }

        }
        System.out.println("\nМассив после умножения значений меньше 6 ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    static void squareArray() {
        int arraySize = 5;
        int matrix[][] = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            matrix[i][i] = 1;
            matrix[i][arraySize - 1 - i] = 1;
        }
        System.out.println("\n");
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] measureArray(int len, int initialValue) {
        int array[] = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        return array;
    }


}



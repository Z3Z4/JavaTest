import exception.MyArrayDataException;
import exception.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16",}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "meow", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            System.out.println(changeMatrix(validArray));
        } catch (MyArraySizeException ex) {
            ex.printStackTrace();
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
        }


    }


    public static int changeMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        if (matrix.length != 4) {
            throw new MyArraySizeException("Matrix must be 4x4 size only");
        }
        for (int g = 0; g < matrix.length; g++) {
            if (matrix[g].length != 4) {
                throw new MyArraySizeException("Array must be 4x4 in size.");
            }
        }
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data at (" + i + ", " + j + "): " + matrix[i][j]);
                }
            }
        }
        return result;
    }

    public static void showMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}





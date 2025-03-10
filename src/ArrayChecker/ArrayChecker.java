package ArrayChecker;

import MyArraySizeException.MyArraySizeException;

public class ArrayChecker {
    public static void checkArraySize(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4!");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4!");
            }
        }

        System.out.println("Массив имеет корректный размер 4x4.");
    }
}

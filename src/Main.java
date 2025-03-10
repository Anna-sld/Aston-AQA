import ArrayChecker.ArrayChecker;
import MyArraySizeException.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        checkArrayException();
        checkArray();
    }

    public static void checkArrayException() {
        String[][] wrongArray = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
        };

        try {
            ArrayChecker.checkArraySize(wrongArray);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void checkArray() {
        String[][] wrongArray = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"},
        };

        try {
            ArrayChecker.checkArraySize(wrongArray);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}








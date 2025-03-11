import ArrayChecker.ArrayChecker;
import ArraySizeException.ArraySizeException;
import ArrayDataException.ArrayDataException;
import ArrayProcessor.ArrayProcessor;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4,};

        checkArrayException();
        checkArray();
        checkArrayData();
        generateArrayIndexOutOfBoundsException(numbers);
    }

    public static void checkArrayException() {
        String[][] wrongArray = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
        };

        try {
            ArrayChecker.checkArraySize(wrongArray);
        } catch (ArraySizeException e) {
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
        } catch (ArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void checkArrayData () {
        try {
            String[][] wrongArray = {
                    {"1", "1", "1", "1"},
                    {"2", "2", "ошибка", "2"},
                    {"3", "3", "3", "3"},
                    {"4", "4", "4", "4"}
            };
            System.out.println("Сумма элементов: " + ArrayProcessor.sumArray(wrongArray));

        } catch (ArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
    public static void generateArrayIndexOutOfBoundsException(int[] numbers ) {
        try {
            System.out.println("Попытка доступа к n-му элементу успешна: " + numbers[8]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: выход за границы массива! " + e.getMessage());
        }
    }
}









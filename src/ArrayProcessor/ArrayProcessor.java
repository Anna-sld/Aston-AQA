package ArrayProcessor;

import ArrayDataException.ArrayDataException;

public class ArrayProcessor {

    public static int sumArray(String[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }

}

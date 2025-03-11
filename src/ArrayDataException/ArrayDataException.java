package ArrayDataException;

public class ArrayDataException extends RuntimeException {
    public ArrayDataException(int row, int col, String value) {
        super("Ошибка в ячейке [" + row + "][" + col + "]: '" + value + "' не является числом.");
    }
}


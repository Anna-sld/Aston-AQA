package org.example.ArithmeticOperationsTest;

import org.example.ArithmeticOperations.ArithmeticOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {
    @Test
    void testAddition() {
        Assertions.assertEquals(5, ArithmeticOperations.add(2, 3));
        Assertions.assertEquals(-1, ArithmeticOperations.add(-2, 1));
    }

    @Test
    void testSubtraction() {
        Assertions.assertEquals(1, ArithmeticOperations.subtract(3, 2));
        Assertions.assertEquals(-3, ArithmeticOperations.subtract(-2, 1));
    }

    @Test
    void testMultiplication() {
        Assertions.assertEquals(6, ArithmeticOperations.multiply(2, 3));
        Assertions.assertEquals(-2, ArithmeticOperations.multiply(-2, 1));
    } @Test
    void testDivision() {
        Assertions.assertEquals(2.5, ArithmeticOperations.divide(5, 2));
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
}


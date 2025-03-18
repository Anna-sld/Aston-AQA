package org.example.ArithmeticOperationsTest;

import org.example.ArithmeticOperations.ArithmeticOperations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {
    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticOperations.add(3, 2), 5);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(ArithmeticOperations.subtract(10, 4), 6);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(ArithmeticOperations.multiply(6, 5), 30);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(ArithmeticOperations.divide(8, 2), 4.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(5, 0);
    }
}

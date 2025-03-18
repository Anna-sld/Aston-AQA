package org.example.TriangleAreaCalculatorTest;

import org.example.TriangleAreaCalculator.TriangleAreaCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaCalculatorTest {
    @Test
    public void testCalculateArea() {
        Assert.assertEquals(TriangleAreaCalculator.calculateArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeBase() {
        TriangleAreaCalculator.calculateArea(-5, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeHeight() {
        TriangleAreaCalculator.calculateArea(6, -2);
    }
}

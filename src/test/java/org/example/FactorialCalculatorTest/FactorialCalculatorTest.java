package org.example.FactorialCalculatorTest;

import org.example.FactorialCalculator.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.factorial(-3);
    }
}

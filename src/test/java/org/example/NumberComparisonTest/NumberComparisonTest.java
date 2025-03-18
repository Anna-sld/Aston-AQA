package org.example.NumberComparisonTest;

import org.example.NumberComparison.NumberComparison;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparisonTest {
    @Test
    public void testCompareGreater() {
        Assert.assertEquals(NumberComparison.compare(5, 3), "5 больше 3");
    }

    @Test
    public void testCompareLess() {
        Assert.assertEquals(NumberComparison.compare(2, 7), "2 меньше 7");
    }

    @Test
    public void testCompareEqual() {
        Assert.assertEquals(NumberComparison.compare(4, 4), "Числа равны");
    }
}

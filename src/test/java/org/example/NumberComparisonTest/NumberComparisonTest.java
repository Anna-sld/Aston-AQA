package org.example.NumberComparisonTest;

import org.example.NumberComparison.NumberComparison;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NumberComparisonTest {

    @Test
    public void testComparison() {
        assertEquals("5 больше 3", NumberComparison.compare(5, 3));
        assertEquals("3 меньше 5", NumberComparison.compare(3, 5));
        assertEquals("Числа равны", NumberComparison.compare(7, 7));
    }
}




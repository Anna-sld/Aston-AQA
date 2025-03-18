package org.example.TriangleAreaCalculatorTest;

import org.example.TriangleAreaCalculator.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TriangleAreaCalculatorTest {
    @Test
    void testCalculateArea() {
        assertEquals(10.0, TriangleAreaCalculator.calculateArea(5, 4));
        assertEquals(6.0, TriangleAreaCalculator.calculateArea(3, 4));
        assertEquals(0.5, TriangleAreaCalculator.calculateArea(1, 1));
    }

    @Test
    void testCalculateAreaWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(-5, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(5, -4));
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(-5, -4));
    }
}


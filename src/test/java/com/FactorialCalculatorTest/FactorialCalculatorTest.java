package com.FactorialCalculatorTest;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.FactorialCalculator.FactorialCalculator;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test
    public void testFactorialOfTwo() {
        assertEquals(FactorialCalculator.factorial(2), 2);
    }

    @Test
    public void testFactorialOfThree() {
        assertEquals(FactorialCalculator.factorial(3), 6);
    }

    @Test
    public void testFactorialOfFour() {
        assertEquals(FactorialCalculator.factorial(4), 24);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(FactorialCalculator.factorial(10), 3628800);
    }
}
package com.FactorialCalculatorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.FactorialCalculator.FactorialCalculator;
import org.junit.jupiter.api.Test;


public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    public void testFactorialOfTwo() {
        assertEquals(2, FactorialCalculator.factorial(2));
    }

    @Test
    public void testFactorialOfThree() {
        assertEquals(6, FactorialCalculator.factorial(3));
    }

    @Test
    public void testFactorialOfFour() {
        assertEquals(24, FactorialCalculator.factorial(4));
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.factorial(5));
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.factorial(10));
    }

    @Test
    public void testFactorialOfMinusOne() {
        assertEquals(1, FactorialCalculator.factorial(-1));
    }

    @Test
    public void testFactorialOfMinusTwo() {
        assertEquals(1, FactorialCalculator.factorial(-2));
    }

    @Test
    public void testFactorialOfMinusThree() {
        assertEquals(1, FactorialCalculator.factorial(-3));
    }
    @Test
    public void testFactorialOfMinusFour() {
        assertEquals(1, FactorialCalculator.factorial(-4));
    }
    @Test
    public void testFactorialOfMinusFive() {
        assertEquals(1, FactorialCalculator.factorial(-5));
    }
    @Test
    public void testFactorialOfMinusTen() {
        assertEquals(1, FactorialCalculator.factorial(-10));
    }
}
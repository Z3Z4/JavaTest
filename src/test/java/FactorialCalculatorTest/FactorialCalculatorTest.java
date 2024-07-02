package FactorialCalculatorTest;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.example.FactorialCalculator.FactorialCalculator;

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
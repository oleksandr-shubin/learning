package com.shubin.model.computer.program.calculator;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testGetMaxShouldThrowIllegalArgumentExceptionWhenArrayIsEmpty() {
        final int emptySize = 0;
        double[] numbers = new double[emptySize];

        thrown.expect(IllegalArgumentException.class);
        calc.getMax(numbers);
    }

    @Test
    public void testGetMaxShouldReturnTheFirstElementWhenArrayHasOnlyOneElement() {
        double[] numbers = {1};

        assertThat(calc.getMax(numbers), is(numbers[0]));
    }

    @Test
    public void testGetMaxShouldReturnMaxWhenMoreThanTwoElementsPassed() {
        double[] numbers = {1,2,3};
        double max = 3;

        assertThat(calc.getMax(numbers), is(max));
    }


    @Test
    public void testGetFactorialShouldReturnOneWhenParameterIsOne() {
        int number = 1;
        int expectedResult = 1;

        assertThat(calc.getFactorial(number), is(expectedResult));
    }

    @Test
    public void testGetFactorialShouldReturnOneWhenParameterIsZero() {
        int number = 0;
        int expectedResult = 1;

        assertThat(calc.getFactorial(number), is(expectedResult));
    }

    @Test
    public void testGetFactorialShouldReturn120WhenParameterIs5() {
        int number = 5;
        int expectedResult = 5*4*3*2*1;

        assertThat(calc.getFactorial(number), is(expectedResult));
    }


    @Test
    public void testGetFibonacciShouldReturnZeroWhenIndexIsZero() {
        int index = 0;
        int expectedResult = 0;

        assertThat(calc.getFibonacci(index), is(expectedResult));
    }

    @Test
    public void testGetFibonacciShouldReturnOneWhenIndexIsOne() {
        int index = 1;
        int expectedResult = 1;

        assertThat(calc.getFibonacci(index), is(expectedResult));
    }

    @Test
    public void testGetFibonacciShouldReturn8WhenIndexIs6() {
        int index = 6;
        int expectedResult  = 8;

        assertThat(calc.getFibonacci(index), is(expectedResult));
    }


    @Test
    public void testGetFibonacciRowShouldReturnEmptyStringWhenNumberIsZero() {
        int number = 0;

        assertThat(calc.getFibonacciRow(number), isEmptyString());
    }

    @Test
    public void testGetFibonacciRowShouldHaveNumbersEqualToNumberParameter() {
        int numberQuantity = 5;

        String returnedFibonacciRow = calc.getFibonacciRow(numberQuantity);
        String[] fibonacciNumbers = returnedFibonacciRow.split(" ");
        assertThat(fibonacciNumbers.length, is(equalTo(numberQuantity)));
    }
}
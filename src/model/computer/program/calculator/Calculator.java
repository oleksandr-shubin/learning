package model.computer.program.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator{
    public static final char DECIMAL_MARK = '.';

    public Calculator() {}

    public double getSum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double getDifference(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double getQuotient(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    public double getProduct(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double getSqrt(double number) {
        return Math.sqrt(number);
    }

    public double getSin(double angleInDegrees) {
        return Math.sin(Math.toRadians(angleInDegrees));
    }

    public double getMax(double[] numbers) throws IllegalArgumentException {
        switch(numbers.length) {
            case 0:
                throw new IllegalArgumentException("Array is empty");
            case 1:
                return numbers[0];
            default:
                return Arrays.stream(numbers).max().getAsDouble();
        }
    }

    /**
     * tries to find position of decimal mark
     * if number is not floating point returns -1
     *
     * @param number
     * @return
     */
    public double getDecimalMarkPosition(double number) {
        // check whether number is floating point or not
        if (number == Math.round(number)) {
            return -1;
        }
        return String.valueOf(number).indexOf(DECIMAL_MARK);
    }

    public String formatResult(String operation, double result) {
        String[][] output = new String[2][1];
        output[0] = new String[1];
        output[1] = new String[1];

        output[0][0] = operation;
        output[1][0] = Double.toString(result);
        return output[0][0] + " : " + output[1][0];
    }

    public void printResult(String operation, double number) {
        double result = 0;
        switch (operation) {
            case "sin":
                result = getSin(number);
                break;
            case "sqrt":
                result = getSqrt(number);
                break;
            case "dmp":
                result = getDecimalMarkPosition(number);
            default:
                break;
        }
        System.out.println(formatResult(operation, result));
    }

    public void printResult(String operation, double firstNumber, double secondNumber) {
        double result = 0;
        switch (operation) {
            case "+":
                result = getSum(firstNumber, secondNumber);
                break;
            case "-":
                result = getDifference(firstNumber, secondNumber);
                break;
            case "*":
                result = getProduct(firstNumber, secondNumber);
                break;
            case "/":
                result = getQuotient(firstNumber, secondNumber);
                break;
            default:
                break;
        }
        System.out.println(formatResult(operation, result));
    }

    public void printResult(String operation, double[] numbers) {
        double result = 0;
        switch (operation) {
            case "max":
                result = getMax(numbers);
                break;
            default:
                break;
        }
        System.out.println(formatResult(operation, result));
    }
}

package model.computer.program;

import java.util.Arrays;
import java.util.List;

public interface Calculator {

    double getSum(double firstNumber, double secondNumber);

    double getDifference(double firstNumber, double secondNumber);

    double getQuotient(double firstNumber, double secondNumber);

    double getProduct(double firstNumber, double secondNumber);

    double getSqrt(double number);

    double getSin(double angleInDegrees);

    double getMax(double[] numbers) throws IllegalArgumentException;
}


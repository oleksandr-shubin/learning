package model;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class CalculatorImp implements Calculator {
    private double firstNum;
    private double secondNum;

    /**
     * stores result of getSum() method
     */
    private double result;

    public CalculatorImp() {}

    public CalculatorImp(double firstNum, double secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }


    public void getSum() {
        result = firstNum + secondNum;
    }

    @Override
    public void getSqrt(double a) {
        result = Math.sqrt(a);
    }

    @Override
    public void getSin(double a) {
        result = Math.sin(Math.toRadians(a));
    }

    @Override
    public void getMax(int[] arrayOfInts) throws RuntimeException {
        if (arrayOfInts.length == 0) {
            throw new RuntimeException("Empty array");
        }

        result = arrayOfInts[0];

        if (arrayOfInts.length == 1) {
            return;
        }

        for (int i = 1; i < arrayOfInts.length; i++) {
            result = Math.max(result, arrayOfInts[i]);
        }
    }

    @Override
    public void printResult() {
        System.out.println(result);
    }
}

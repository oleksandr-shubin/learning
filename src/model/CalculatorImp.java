package model;

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
    public void printResult() {
        System.out.println(result);
    }
}

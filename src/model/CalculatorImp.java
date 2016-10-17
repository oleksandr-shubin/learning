package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorImp implements Calculator {
    private double firstNum;
    private double secondNum;
    // private double result;

    private double[] arrayOfNums;

    private Map<String, ArrayList<Double>> results;

    {
        results = new HashMap<String, ArrayList<Double>>();
        results.put("+", new ArrayList<Double>());
        results.put("-", new ArrayList<Double>());
        results.put("/", new ArrayList<Double>());
        results.put("*", new ArrayList<Double>());
        results.put("sqrt", new ArrayList<Double>());
        results.put("sin", new ArrayList<Double>());
        results.put("max", new ArrayList<Double>());
        results.put("decimalPointPosition", new ArrayList<Double>());
    }

    public CalculatorImp() {}

    public CalculatorImp(double firstNum, double secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public double getFirstNum() {
        return firstNum;
    }

    @Override
    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    @Override
    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double[] getArrayOfNums() {
        return arrayOfNums;
    }

    @Override
    public void setArrayOfNums(double[] arrayOfNums) {
        this.arrayOfNums = arrayOfNums;
    }


    @Override
    public void getSum() {
        List<Double> sumResults = results.get("+");
        sumResults.add(firstNum + secondNum);
    }

    @Override
    public void getDifference() {
        List<Double> differenceResults = results.get("-");
        differenceResults.add(firstNum - secondNum);
    }

    @Override
    public void getQuotient() {
        List<Double> quotientResults = results.get("/");
        quotientResults.add(firstNum / secondNum);
    }

    @Override
    public void getProduct() {
        List<Double> productResults = results.get("*");
        productResults.add(firstNum * secondNum);
    }

    @Override
    public void getSqrt() {
        List<Double> sqrtResults = results.get("sqrt");
        sqrtResults.add(Math.sqrt(firstNum));
    }

    @Override
    public void getSin() {
        List<Double> sinResults = results.get("sin");
        sinResults.add(Math.sin(Math.toRadians(firstNum)));
    }

    @Override
    public void getMax() {
        List<Double> maxResults = results.get("max");
        double max = arrayOfNums[0];

        if (arrayOfNums.length == 1) {
            maxResults.add(max);
            return;
        }

        for (int i = 1; i < arrayOfNums.length; i++) {
            max = Math.max(max, arrayOfNums[i]);
        }

        maxResults.add(max);
    }

    @Override
    public boolean getDecimalPointPosition() {
        // check if number is floating point or not
        if (firstNum == Math.round(firstNum)) {
            return false;
        }
        List<Double> decimalPointPositionResults = results.get("decimalPointPosition");
        int index = String.valueOf(firstNum).indexOf(DECIMAL_MARK);
        decimalPointPositionResults.add(Double.valueOf(index));
        return true;
    }

    @Override
    public void printResult(String operation) {
        try {
            List<Double> operationResults = results.get(operation);
            Double result = operationResults.get(operationResults.size() - 1);
            System.out.println(result);
        } catch (ArrayIndexOutOfBoundsException e) {

            /* if result list is empty */
            System.out.println("Please make calculations first!");
        }
    }
}

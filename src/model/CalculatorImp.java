package model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorImp implements Calculator {
    private double firstNum;
    private double secondNum;
    // private double result;

    private Map<String, ArrayList<Double>> results;

    {
        results = new HashMap<String, ArrayList<Double>>();
        results.put("sum", new ArrayList<Double>());
        results.put("difference", new ArrayList<Double>());
        results.put("quotient", new ArrayList<Double>());
        results.put("product", new ArrayList<Double>());
        results.put("sqrt", new ArrayList<Double>());
        results.put("sin", new ArrayList<Double>());
        results.put("max", new ArrayList<Double>());
    }

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

    @Override
    public void getSum() {
        List<Double> sumResults = results.get("sum");
        sumResults.add(firstNum + secondNum);
    }

    @Override
    public void getDifference() {
        List<Double> differenceResults = results.get("difference");
        differenceResults.add(firstNum - secondNum);
    }

    @Override
    public void getQuotient() {
        List<Double> quotientResults = results.get("quotient");
        quotientResults.add(firstNum / secondNum);
    }

    @Override
    public void getProduct() {
        List<Double> productResults = results.get("product");
        productResults.add(firstNum * secondNum);
    }

    @Override
    public void getSqrt(double a) {
        List<Double> sqrtResults = results.get("sqrt");
        sqrtResults.add(Math.sqrt(a));
    }

    @Override
    public void getSin(double a) {
        List<Double> sinResults = results.get("sin");
        sinResults.add(Math.sin(Math.toRadians(a)));
    }

    @Override
    public void getMax(int[] arrayOfInts) throws IllegalArgumentException {
        if (arrayOfInts.length == 0) {
            throw new IllegalArgumentException("Empty array provided");
        }

        List<Double> maxResults = results.get("max");
        double max = arrayOfInts[0];

        if (arrayOfInts.length == 1) {
            maxResults.add(max);
            return;
        }

        for (int i = 1; i < arrayOfInts.length; i++) {
            max = Math.max(max, arrayOfInts[i]);
        }

        maxResults.add(max);
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

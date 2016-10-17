package model;

import java.util.Arrays;
import java.util.List;

public interface Calculator {
    String[] SINGLE_NUM_OPERATIONS = {"sin", "sqrt", "decimalPointPosition"};
    String[] TWO_NUM_OPERATIONS = {"*", "/", "+", "-"};
    String[] ARRAY_OPERATIONS = {"max"};
    char DECIMAL_MARK = '.';

    static boolean isSingleNumOperation(String operation) {
        List<String> singleNumOperationsList = Arrays.asList(SINGLE_NUM_OPERATIONS);
        return singleNumOperationsList.contains(operation);
    }

    static boolean isTwoNumOperation(String operation) {
        List<String> twoNumOperationsList = Arrays.asList(TWO_NUM_OPERATIONS);
        return twoNumOperationsList.contains(operation);
    }

    static boolean isArrayOperation(String operation) {
        List<String> arrayOperationsList = Arrays.asList(ARRAY_OPERATIONS);
        return arrayOperationsList.contains(operation);
    }

    static boolean hasOperation(String operation) {
        return (isSingleNumOperation(operation) ||
                isTwoNumOperation(operation) ||
                isArrayOperation(operation)
        );
    }

    void setFirstNum(double firstNum);

    void setSecondNum(double secondNum);

    void setArrayOfNums(double[] arrayOfNums);


    void getSum();

    void getDifference();

    void getQuotient();

    void getProduct();

    void getSqrt();

    void getSin();

    /**
     * finds the max value
     * of array
     */
    void getMax();

    /**
     * tries to find position of decimal mark
     *
     * @return true if decimal mark found, false if not
     */
    boolean getDecimalPointPosition();

    /**
     * prints last result of certain operation
     *
     * @param operation type of operation
     */
    void printResult(String operation);
}


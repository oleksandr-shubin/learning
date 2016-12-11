package com.shubin.model.computer.program.calculator;

import java.util.Arrays;
import java.util.List;

import static com.shubin.model.computer.program.calculator.OperationType.*;

public class Operation {

    public static final String[] SINGLE_NUM_OPERATIONS = {"sin", "sqrt", "dmp"};
    public static final String[] TWO_NUM_OPERATIONS = {"*", "/", "+", "-"};
    public static final String[] ARRAY_OPERATIONS = {"max"};

    public static OperationType getType(String operation) {
        if (isSingleNumOperation(operation)) {
            return SINGLE_NUM;
        } else if (isTwoNumOperation(operation)) {
            return TWO_NUM;
        } else if (isArrayOperation(operation)) {
            return ARRAY;
        } else {
            return UNKNOWN;
        }
    }

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


}

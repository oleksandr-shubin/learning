package model.computer.program.calculator;

import model.computer.component.DoubleValidator;
import model.computer.program.Launchable;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator implements Launchable {
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

    @Override
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter operation (\"+,-,*,/,sin,sqrt,max,dmp for decimalMarkPosition\"): ");
                String operation = scanner.nextLine().trim();

                switch (Operation.getType(operation)) {
                    case SINGLE_NUM:
                        System.out.print("Enter your number: ");
                        String input = scanner.nextLine();
                        if (DoubleValidator.isValidDouble(input)) {
                            double number = Double.valueOf(input);
                            printResult(operation, number);

                        } else {
                            System.out.println("Wrong number");
                        }
                        break;
                    case TWO_NUM:
                        System.out.println("Enter your first number: ");
                        String firstInput = scanner.nextLine();
                        System.out.println("Enter your second number: ");
                        String secondInput = scanner.nextLine();
                        if (DoubleValidator.isValidDouble(firstInput)
                                && DoubleValidator.isValidDouble(secondInput)) {
                            double firstNumber = Double.valueOf(firstInput);
                            double secondNumber = Double.valueOf(secondInput);
                            printResult(operation, firstNumber, secondNumber);
                        } else {
                            System.out.println("Wrong numbers");
                        }
                        break;
                    case ARRAY:
                        System.out.println("Enter your list of subsequent numbers," +
                                " use coma (,) as delimiter");
                        System.out.println("Example: 10, 20.5, 37.8");
                        String inputList = scanner.nextLine();
                        String[] inputArray = inputList.split(",");
                        if (Arrays.stream(inputArray).allMatch(DoubleValidator::isValidDouble)) {
                            double[] numbers = Arrays.stream(inputArray).mapToDouble(Double::valueOf).toArray();
                            printResult(operation, numbers);
                        } else {
                            System.out.println("Wrong list of numbers");
                        }
                        break;
                    default:
                        System.out.println("Wrong operation");
                        break;
                }
                System.out.println("Enter q to quit or any other key to continue");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.out.println("Application is shutting down...");
                    break;
                }
            }
        }
    }
}

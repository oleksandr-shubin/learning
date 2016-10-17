import model.*;
import builder.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ComputerBuilderDirector CompBuildDirector =
        //        new ComputerBuilderDirectorImp(new MyComputerBuilderImp());

        // Computer myComp = CompBuildDirector.construct();

        Calculator myCalc = new CalculatorImp();
        Scanner scanner = new Scanner(System.in);

    console:
        while (true) {

            // getting and processing first number
            System.out.print("Enter first number: ");
            String firstNumInput = scanner.nextLine();
            if (DoubleValidator.isValidDouble(firstNumInput)) {
                myCalc.setFirstNum(Double.valueOf(firstNumInput));
            } else {
                System.out.println("Wrong first number");
                continue;
            }

            // getting and processing operation
            System.out.print("Enter operation (\"+,-,*,/,sin,sqrt,max,decimalPointPosition\"): ");
            String operation = scanner.nextLine().trim();
            if (!Calculator.hasOperation(operation)) {
                System.out.println("Wrong operation");
                continue;
            }

            // choosing second input
            // depending on operation
            if (Calculator.isTwoNumOperation(operation)) {
                System.out.print("Enter second number: ");
                String secondNumInput = scanner.nextLine();
                if (DoubleValidator.isValidDouble(secondNumInput)) {
                    myCalc.setSecondNum(Double.valueOf(secondNumInput));
                } else {
                    System.out.println("Wrong second number");
                    continue;
                }
            } else if (Calculator.isArrayOperation(operation)) {
                System.out.println("Enter your list of subsequent numbers, use coma (,) as delimiter");
                System.out.println("Example: 10, 20.5, 37.8");
                String numbersInput = scanner.nextLine();
                String[] numbersInputArray = numbersInput.split(",");
                if (Arrays.stream(numbersInputArray).allMatch(DoubleValidator::isValidDouble)) {
                    double[] arrayOfNums = Arrays.stream(numbersInputArray).mapToDouble(Double::valueOf).toArray();
                    myCalc.setArrayOfNums(arrayOfNums);
                } else {
                    System.out.println("Some elements of your list are not numbers");
                    continue;
                }
            }

            switch (operation) {
                case "+":
                    myCalc.getSum();
                    break;
                case "-":
                    myCalc.getDifference();
                    break;
                case "/":
                    myCalc.getQuotient();
                    break;
                case "*":
                    myCalc.getProduct();
                    break;
                case "sin":
                    myCalc.getSin();
                    break;
                case "sqrt":
                    myCalc.getSqrt();
                    break;
                case "max":
                    myCalc.getMax();
                    break;
                case "decimalPointPosition":
                   if (!myCalc.getDecimalPointPosition()) {
                       System.out.println("Your number is not a floating point digit");
                       continue console;
                   }
                    break;
                default:
                    continue;
            }

            myCalc.printResult(operation);

            System.out.println("Enter q to quit or any other key to continue");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Application is shutting down...");
                break;
            }
        }
        scanner.close();
    }
}

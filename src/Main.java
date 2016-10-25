import builder.ComputerBuilderDirector;
import builder.ComputerBuilderDirectorImp;
import builder.MyComputerBuilderImp;
import model.computer.Computer;
import model.computer.component.DoubleValidator;
import model.computer.program.CalculatorImp;
import model.computer.program.Operation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputerBuilderDirector CompBuildDirector =
                new ComputerBuilderDirectorImp(new MyComputerBuilderImp());
        Computer myComp = CompBuildDirector.construct();
        CalculatorImp myCalc = new CalculatorImp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter operation (\"+,-,*,/,sin,sqrt,max,dmp for decimalMarkPosition\"): ");
            String operation = scanner.nextLine().trim();

            switch (Operation.getType(operation)) {
                case SINGLE_NUM:
                    System.out.print("Enter your number: ");
                    String input = scanner.nextLine();
                    if (DoubleValidator.isValidDouble(input)) {
                        double number = Double.valueOf(input);
                        myCalc.printResult(operation, number);

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
                        myCalc.printResult(operation, firstNumber, secondNumber);
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
                        myCalc.printResult(operation, numbers);
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
        scanner.close();
    }
}

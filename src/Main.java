import model.computer.program.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("5! = " + calculator.getFactorial(5));
        System.out.println("15 fibonacci numbers : " + calculator.getFibonacciRow(15));
    }
}

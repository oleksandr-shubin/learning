import builder.ComputerBuilderDirector;
import builder.ComputerBuilderDirectorImp;
import builder.MyComputerBuilderImp;
import model.computer.Computer;
import model.computer.component.DoubleValidator;
import model.computer.program.calculator.Calculator;
import model.computer.program.calculator.Operation;
import model.computer.program.filemanager.FileManager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputerBuilderDirector CompBuildDirector =
                new ComputerBuilderDirectorImp(new MyComputerBuilderImp());
        Computer myComp = CompBuildDirector.construct();
        // Calculator myCalc = new Calculator();
        // myCalc.start();
        FileManager fm = new FileManager();
        fm.copy("first.txt", "second.txt");
    }
}

import builder.ComputerBuilderDirector;
import builder.ComputerBuilderDirectorImp;
import builder.MyComputerBuilderImp;
import model.computer.Computer;
import model.computer.program.calculator.Calculator;
import model.computer.program.filemanager.FileManager;
import model.computer.program.os.Linux;

public class Main {
    public static void main(String[] args) {
        ComputerBuilderDirector CompBuildDirector =
                new ComputerBuilderDirectorImp(new MyComputerBuilderImp());
        Computer myComp = CompBuildDirector.construct();
        myComp.installOS("Linux", new Linux());
        myComp.launchOS("Linux");
        myComp.installApplication("Calculator", new Calculator());
        myComp.installApplication("FileManager", new FileManager());

        myComp.launchApplication("Calculator");
        // myComp.launchApplication("FileManager");
    }
}

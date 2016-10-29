import builder.ComputerBuilderDirector;
import builder.ComputerBuilderDirectorImp;
import builder.MyComputerBuilderImp;
import model.computer.Computer;
import model.computer.program.calculator.Calculator;
import model.computer.program.filemanager.FileManager;
import model.computer.program.os.Linux;
import model.store.ComputerStore;

public class Main {
    public static void main(String[] args) {
        ComputerBuilderDirector CompBuildDirector =
                new ComputerBuilderDirectorImp(new MyComputerBuilderImp());
        Computer myComp = CompBuildDirector.construct();
        myComp.powerOn();
        myComp.installOS("Linux", new Linux());
        myComp.launchOS("Linux");
        myComp.installApplication("Calculator", new Calculator());
        myComp.installApplication("FileManager", new FileManager());

        // myComp.launchApplication("Calculator");
        // myComp.launchApplication("FileManager");

        ComputerStore computerStore = new ComputerStore();
        computerStore.printConfigByForEach();
        computerStore.printConfigByIndex();
        computerStore.printConfigByIterator();
    }
}

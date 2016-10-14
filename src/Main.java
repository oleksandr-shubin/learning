import model.*;
import builder.*;

public class Main {

    public static void main(String[] args) {

        /*
         * MyCompBuilderImp uses
         * setters to initialize
         * properties of myComp
         */
        ComputerBuilderDirector CompBuildDirector =
                new ComputerBuilderDirectorImp(new MyComputerBuilderImp());

        Computer myComp = CompBuildDirector.construct();

        System.out.println(myComp.getDiskDrive());
        System.out.println(myComp.getMotherboard());
        System.out.println(myComp.getVideoCard());
        System.out.println(myComp.getRandomAccessMemory());
    }

}

import builder.ComputerBuilder;
import builder.ComputerBuilderDirector;
import builder.ComputerBuilderDirectorImp;
import builder.MyComputerBuilderImp;
import model.Computer;

public class Main {

    public static void main(String[] args) {

        ComputerBuilderDirector computerBuilderDirector = new ComputerBuilderDirectorImp(new MyComputerBuilderImp());
        Computer computer = computerBuilderDirector.construct();

        System.out.println(computer);
    }

}

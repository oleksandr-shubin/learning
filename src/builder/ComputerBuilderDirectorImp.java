package builder;

import model.Computer;

public class ComputerBuilderDirectorImp implements ComputerBuilderDirector {

    private ComputerBuilder computerBuilder;

    public ComputerBuilderDirectorImp(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    @Override
    public Computer construct() {

        computerBuilder.buildDiskDrive();
        computerBuilder.buildMotherBoard();
        computerBuilder.buildRandomAccessMemory();
        computerBuilder.buildVideoCard();

        return computerBuilder.getResult();
    }
}

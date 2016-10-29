package builder;

import model.computer.Desktop;

public interface ComputerBuilder {

    void buildDiskDrive();

    void buildMotherBoard();

    void buildRandomAccessMemory();

    void buildVideoCard();

    Desktop getResult();
}

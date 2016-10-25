package builder;

import model.computer.Computer;

public interface ComputerBuilder {

    void buildDiskDrive();

    void buildMotherBoard();

    void buildRandomAccessMemory();

    void buildVideoCard();

    Computer getResult();
}

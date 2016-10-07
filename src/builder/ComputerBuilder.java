package builder;

import model.*;

public interface ComputerBuilder {

    void buildDiskDrive();

    void buildMotherBoard();

    void buildRandomAccessMemory();

    void buildVideoCard();

    Computer getResult();
}

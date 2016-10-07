package builder;

import model.*;

public class MyComputerBuilderImp implements ComputerBuilder {

    private Computer computer;

    public MyComputerBuilderImp() {
        computer = new Computer();
    }

    @Override
    public void buildDiskDrive() {
        computer.setDiskDrive(new DiskDrive(DiskType.HARD, 512));
    }

    @Override
    public void buildMotherBoard() {
        computer.setMotherboard(new Motherboard("ASUS"));
    }

    @Override
    public void buildRandomAccessMemory() {
        computer.setRandomAccessMemory(new RandomAccessMemory("Kingstone", 4));
    }

    @Override
    public void buildVideoCard() {
        computer.setVideoCard(new VideoCard("NVIDIA", "GeForce", 1));
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

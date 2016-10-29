package builder;

import model.computer.Computer;

public class MyComputerBuilderImp implements ComputerBuilder {

    private Computer computer;

    public MyComputerBuilderImp() {
        computer = new Computer();
    }

    @Override
    public void buildDiskDrive() {
        computer.setDiskDrive("HITACHI 512 GB");
    }

    @Override
    public void buildMotherBoard() {
        computer.setMotherboard("ASUS");
    }

    @Override
    public void buildRandomAccessMemory() {
        computer.setRandomAccessMemory("KINGSTONE");
    }

    @Override
    public void buildVideoCard() {
        computer.setVideoCard("NVIDIA GeForce 620 GT");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

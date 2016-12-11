package com.shubin.builder;

import com.shubin.model.computer.Desktop;

public class MyComputerBuilderImp implements ComputerBuilder {

    private Desktop computer;

    public MyComputerBuilderImp() {
        computer = new Desktop();
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
    public Desktop getResult() {
        return computer;
    }
}

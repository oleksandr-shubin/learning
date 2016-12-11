package com.shubin.builder;

import com.shubin.model.computer.Desktop;

public class ComputerBuilderDirectorImp implements ComputerBuilderDirector {

    private ComputerBuilder computerBuilder;

    public ComputerBuilderDirectorImp(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    @Override
    public Desktop construct() {

        computerBuilder.buildDiskDrive();
        computerBuilder.buildMotherBoard();
        computerBuilder.buildRandomAccessMemory();
        computerBuilder.buildVideoCard();

        return computerBuilder.getResult();
    }
}

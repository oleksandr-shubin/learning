package com.shubin.builder;

import com.shubin.model.computer.Computer;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;

import java.util.Map;

public class ComputerBuilderDirectorImp implements ComputerBuilderDirector {

    private CustomComputerBuilder customComputerBuilder;

    public ComputerBuilderDirectorImp(CustomComputerBuilder customComputerBuilder) {
        this.customComputerBuilder = customComputerBuilder;
    }

    @Override
    public Computer constructComputer(Map<PartType, Part> parts) {
        return customComputerBuilder.constructComputer(parts);
    }
}

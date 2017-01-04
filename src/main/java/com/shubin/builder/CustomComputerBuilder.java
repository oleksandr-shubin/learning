package com.shubin.builder;

import com.shubin.model.computer.Computer;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;

import java.util.Map;

public interface CustomComputerBuilder {
    void buildManufacturer();
    void buildModel();
    void buildPrice(Map<PartType, Part> parts);
    void buildAmount();
    Computer constructComputer(Map<PartType, Part> parts);
}

package com.shubin.builder.laptop;

import com.shubin.builder.CustomComputerBuilder;
import com.shubin.model.computer.LaptopConfiguration;

public interface CustomLaptopBuilder extends CustomComputerBuilder {
    void buildKeyboard(String keyboard);
    void buildTouchpad(String touchpad);
    void buildBattery(String battery);
    void buildVideoCard(String videoCard);
    void buildRandomAccessMemory(String randomAccessMeory);
    void buildLaptopConfiguration(LaptopConfiguration configuration);
}

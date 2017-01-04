package com.shubin.builder.laptop;

import com.shubin.model.computer.Computer;
import com.shubin.model.computer.LaptopConfiguration;
import com.shubin.model.computer.parts.Part;
import com.shubin.model.computer.parts.PartType;

import java.util.Map;

public class CustomLaptopBuilderImp extends AbstractLaptopBuilder
        implements CustomLaptopBuilder {

    @Override
    public void buildManufacturer() {
        laptop.setManufacturer("custom");
    }

    @Override
    public void buildModel() {
        laptop.setModel("custom");
    }

    @Override
    public void buildAmount() {
        laptop.setAmount(1);
    }

    @Override
    public void buildPrice(Map<PartType, Part> parts) {
        int price = 0;
        for (Part part : parts.values()) {
            price += part.getPrice();
        }
        laptop.setPrice(price);
    }

    @Override
    public void buildKeyboard(String keyboard) {
        laptop.setKeyboard(keyboard);
    }

    @Override
    public void buildTouchpad(String touchpad) {
        laptop.setTouchpad(touchpad);
    }

    @Override
    public void buildBattery(String battery) {
        laptop.setBattery(battery);
    }

    @Override
    public void buildVideoCard(String videoCard) {
        laptop.setVideoCard(videoCard);
    }

    @Override
    public void buildRandomAccessMemory(String randomAccessMeory) {
        laptop.setRandomAccessMemory(randomAccessMeory);
    }

    @Override
    public void buildLaptopConfiguration(LaptopConfiguration configuration) {
        laptop.setConfiguration(configuration);
    }

    @Override
    public Computer constructComputer(Map<PartType, Part> parts) {
        buildManufacturer();
        buildModel();
        buildAmount();
        buildPrice(parts);
        buildKeyboard(parts.get(PartType.Keyboard).getInfo());
        buildTouchpad(parts.get(PartType.Touchpad).getInfo());
        buildBattery(parts.get(PartType.Battery).getInfo());
        buildVideoCard(parts.get(PartType.VideoCard).getInfo());
        buildRandomAccessMemory(parts.get(PartType.RandomAccessMemory).getInfo());
        buildLaptopConfiguration(LaptopConfiguration.Custom);
        return laptop;
    }
}

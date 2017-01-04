package com.shubin.model.computer;

import com.shubin.model.computer.power.LidSwitcher;

public class Laptop extends AbstractComputer {
    private String keyboard;
    private String touchpad;
    private String battery;
    private String videoCard;
    private String randomAccessMemory;
    private LaptopConfiguration configuration;

    public Laptop() {
        switcher = new LidSwitcher();
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(String touchpad) {
        this.touchpad = touchpad;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(String randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public LaptopConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(LaptopConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void printType() {
        System.out.println("Type: laptop");
    }

    @Override
    public String toString() {
        return  "Laptop{" +
                super.toString() +
                "keyboard='" + keyboard + '\'' +
                ", touchpad='" + touchpad + '\'' +
                ", battery='" + battery + '\'' +
                ", videoCard='" + videoCard + '\'' +
                ", randomAccessMemory='" + randomAccessMemory + '\'' +
                ", configuration=" + configuration +
                '}';
    }
}

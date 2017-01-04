package com.shubin.model.computer.power;

public class ScreenTapSwitcher implements Powerable {
    @Override
    public void powerOn(Boolean powered) {
        System.out.println("Screen is tapped twice");
        System.out.println("Computer starts...");
        powered = true;
    }

    @Override
    public void powerOff(Boolean powered) {
        System.out.println("Computer shutdowns...");
        powered = false;
    }
}

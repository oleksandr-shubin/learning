package com.shubin.model.computer.power;

public class LidSwitcher implements Powerable {
    @Override
    public void powerOn(Boolean powered) {
        System.out.println("Lid is opened");
        System.out.println("Computer starts...");
        powered = true;
    }

    @Override
    public void powerOff(Boolean powered) {
        System.out.println("Lid is closed");
        System.out.println("Computer shutdowns...");
        powered = false;
    }
}

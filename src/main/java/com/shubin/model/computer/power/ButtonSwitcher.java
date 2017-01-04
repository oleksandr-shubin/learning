package com.shubin.model.computer.power;

public class ButtonSwitcher implements Powerable {
    @Override
    public void powerOn(Boolean powered) {
        System.out.println("Power button pressed to ON");
        System.out.println("Computer starts...");
        powered = true;
    }

    @Override
    public void powerOff(Boolean powered) {
        System.out.println("Power button pressed to OFF");
        System.out.println("Computer shutdowns...");
        powered = false;
    }
}

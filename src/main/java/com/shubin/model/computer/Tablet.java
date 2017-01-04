package com.shubin.model.computer;

import com.shubin.model.computer.power.ScreenTapSwitcher;

public class Tablet extends AbstractComputer {
    private String sensorType;
    private String GSMModule;

    public Tablet() {
        switcher = new ScreenTapSwitcher();
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getGSMModule() {
        return GSMModule;
    }

    public void setGSMModule(String GSMModule) {
        this.GSMModule = GSMModule;
    }

    @Override
    public void printType() {
        System.out.println("Type: tablet");
    }

    @Override
    public String toString() {
        return "Tablet:" + "\n" +
                "\t" + "sensorType=" + sensorType + "\n" +
                "\t" + "GSMModule=" + GSMModule;
    }
}

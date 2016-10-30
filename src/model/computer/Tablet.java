package model.computer;

import model.computer.program.Launchable;
import model.computer.program.os.OperationSystem;

public class Tablet extends AbstractComputer {
    private String sensorType;
    private String GSMModule;

    public Tablet() {
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
    public void installOS(String name, OperationSystem os) {

    }

    @Override
    public void launchOS(String name) {

    }

    @Override
    public void installApplication(String name, Launchable application) {

    }

    @Override
    public void launchApplication(String name) {

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

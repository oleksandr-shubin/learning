package model.computer;

import model.computer.program.Launchable;
import model.computer.program.os.OperationSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractComputer implements Computer, Powerable, Serializable {
    private boolean powered;
    private Map<String, OperationSystem> operationSystems = new HashMap<>();
    private OperationSystem activeSystem;

    @Override
    public void powerOn() {
        powered = true;
        System.out.println("Device is powered on");
    }

    @Override
    public void powerOff() {
        powered = false;
        System.out.println("Device is powered off");
    }

    @Override
    public void installOS(String name, OperationSystem os) {
        if (powered) {
            operationSystems.put(name, os);
        } else {
            throw new ComputerAccessException();
        }
    }

    @Override
    public void launchOS(String name) {
        if (powered) {
            activeSystem = operationSystems.get(name);
        } else {
            throw new ComputerAccessException();
        }
    }

    @Override
    public void installApplication(String name, Launchable application) {
        if (powered) {
            activeSystem.install(name, application);
        } else {
            throw new ComputerAccessException();
        }
    }

    @Override
    public void launchApplication(String name) {
        if (powered) {
            activeSystem.launch(name);
        } else {
            throw new ComputerAccessException();
        }
    }

    @Override
    public abstract void printType();
}

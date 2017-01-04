package com.shubin.model.computer;

import com.shubin.model.computer.power.Powerable;
import com.shubin.model.computer.program.Launchable;
import com.shubin.model.computer.program.os.OperationSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractComputer implements Computer, Serializable {
    protected int computerId;
    protected String manufacturer;
    protected String model;
    protected int price;
    protected int amount;
    private Boolean powered;
    protected Powerable switcher;
    private Map<String, OperationSystem> operationSystems = new HashMap<>();
    private OperationSystem activeSystem;

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void powerOn() {
        switcher.powerOn(powered);
    }

    public void powerOff() {
        switcher.powerOff(powered);
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

    @Override
    public String toString() {
        return  "computerId=" + computerId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", ";
    }
}

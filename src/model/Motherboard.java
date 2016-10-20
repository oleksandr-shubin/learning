package model;

import java.io.Serializable;

public class Motherboard implements Serializable {

    private String manufacturer;

    public Motherboard(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Motherboard:" + "\n" +
                "\t\t" + "manufacturer=" + manufacturer;
    }
}

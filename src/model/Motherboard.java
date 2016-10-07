package model;

public class Motherboard {

    private String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Motherboard(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Motherboard:" + "\n" +
                "\t\t" + "manufacturer=" + manufacturer;
    }
}

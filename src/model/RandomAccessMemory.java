package model;

public class RandomAccessMemory {

    private String manufacturer;

    /**
     * capacity in GB
     */
    private int capacity;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RandomAccessMemory(String manufacturer, int capacity) {
        this.manufacturer = manufacturer;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RandomAccessMemory:" + "\n" +
                "\t\t" + "manufacturer=" + manufacturer + "\n" +
                "\t\t" + "capacity=" + capacity;
    }
}

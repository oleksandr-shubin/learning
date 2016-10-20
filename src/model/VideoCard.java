package model;

import java.io.Serializable;

public class VideoCard implements Serializable {

    private String manufacturer;

    private String serie;

    /**
     * capacity in GB
     */
    private int capacity;

    public VideoCard(String manufacturer, String serie, int capacity) {
        this.manufacturer = manufacturer;
        this.serie = serie;
        this.capacity = capacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "VideoCard:" + "\n" +
                "\t\t" + "manufacturer=" + manufacturer + "\n" +
                "\t\t" + "serie=" + serie + "\n" +
                "\t\t" + "capacity=" + capacity;
    }
}

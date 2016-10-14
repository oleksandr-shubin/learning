package model;

import java.io.Serializable;

public class DiskDrive implements Serializable {
    private DiskType type;

    /**
     *  capacity in GB
     */
    private int capacity;

    public DiskType getType() {
        return type;
    }

    public void setType(DiskType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DiskDrive(DiskType type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "DiskDrive:" + "\n" +
                "\t\t" + "capacity=" + capacity + "\n" +
                "\t\t" + "type=" + type;
    }
}

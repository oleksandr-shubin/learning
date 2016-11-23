package model.enums;

public enum WindRose {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    private final int degrees;

    WindRose(int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getRhumbs() {
        return Double.valueOf(degrees / 11.25).intValue();
    }
}

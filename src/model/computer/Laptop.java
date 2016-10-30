package model.computer;

import model.computer.program.Launchable;
import model.computer.program.os.OperationSystem;

public class Laptop extends AbstractComputer {
    private String keyboard;
    private String touchpad;

    public Laptop() {
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(String touchpad) {
        this.touchpad = touchpad;
    }

    @Override
    public void printType() {
        System.out.println("Type: laptop");
    }

    @Override
    public String toString() {
        return "Laptop:" + "\n" +
                "\t" + "keyboard=" + keyboard + "\n" +
                "\t" + "touchpad=" + touchpad;
    }
}

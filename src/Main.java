import model.computer.Computer;
import model.computer.Desktop;
import model.computer.Laptop;
import model.computer.Tablet;
import model.store.Cart;

public class Main {
    public static void main(String[] args) {

        Desktop desktop = new Desktop();
        desktop.setRandomAccessMemory("Kingston 512 GB");
        desktop.setVideoCard("NVIDIA GeForce 9600 GT");
        desktop.setMotherboard("ASROCK");
        desktop.setDiskDrive("SSD 256 GB");

        Tablet tablet = new Tablet();
        tablet.setGSMModule("ChinaConnection 3G/GSM");
        tablet.setSensorType("Resistive");

        Laptop laptop = new Laptop();
        laptop.setKeyboard("Chicklet with backlight");
        laptop.setTouchpad("ElanTech");

        Cart<Computer> computersCart = new Cart<>();
        computersCart.add(desktop);
        computersCart.add(tablet);
        computersCart.add(laptop);

        computersCart.printConfigs();
    }
}

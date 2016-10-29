package model.computer;

import model.computer.component.DiskDrive;
import model.computer.component.Motherboard;
import model.computer.component.RandomAccessMemory;
import model.computer.component.VideoCard;
import model.computer.program.Launchable;
import model.computer.program.os.OperationSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Computer implements Powerable, Serializable {
    private Motherboard motherboard;
    private RandomAccessMemory randomAccessMemory;
    private VideoCard videoCard;
    private DiskDrive diskDrive;

    private Map<String, OperationSystem> operationSystems = new HashMap<>();
    private OperationSystem activeSystem;
    private boolean powered;

    public Computer() {

    }

    public Computer(Motherboard motherboard, RandomAccessMemory randomAccessMemory,
                    VideoCard videoCard, DiskDrive diskDrive) {
        this.motherboard = motherboard;
        this.randomAccessMemory = randomAccessMemory;
        this.videoCard = videoCard;
        this.diskDrive = diskDrive;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public RandomAccessMemory getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(RandomAccessMemory randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public DiskDrive getDiskDrive() {
        return diskDrive;
    }

    public void setDiskDrive(DiskDrive diskDrive) {
        this.diskDrive = diskDrive;
    }

    @Override
    public void powerOn() {
        powered = true;
        System.out.println("Computer is powered on");
    }

    @Override
    public void powerOff() {
        powered = false;
        System.out.println("Computer is powered off");
    }

    public void installOS(String name, OperationSystem os) {
        if (powered) {
            operationSystems.put(name, os);
        } else {
            throw new ComputerAccessException();
        }
    }

    public void launchOS(String name) {
        if (powered) {
            activeSystem = operationSystems.get(name);
        } else {
            throw new ComputerAccessException();
        }
    }

    public void installApplication(String name, Launchable application) {
        if (powered) {
            activeSystem.install(name, application);
        } else {
            throw new ComputerAccessException();
        }
    }

    public void launchApplication(String name) {
        if (powered) {
            activeSystem.launch(name);
        } else {
            throw new ComputerAccessException();
        }
    }

    @Override
    public String toString() {
        return "Computer:" + "\n" +
                "\t" + "diskDrive=" + diskDrive + "\n" +
                "\t" + "videoCard=" + videoCard + "\n" +
                "\t" + "randomAccessMemory=" + randomAccessMemory + "\n" +
                "\t" + "motherboard=" + motherboard;
    }

}

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
        System.out.println("Computer is powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Computer is powered off");
    }

    @Override
    public String toString() {
        return "Computer:" + "\n" +
                "\t" + "diskDrive=" + diskDrive + "\n" +
                "\t" + "videoCard=" + videoCard + "\n" +
                "\t" + "randomAccessMemory=" + randomAccessMemory + "\n" +
                "\t" + "motherboard=" + motherboard;
    }

    public void installOS(String name, OperationSystem os) {
        this.operationSystems.put(name, os);
    }

    public void launchOS(String name) {
        activeSystem = operationSystems.get(name);
    }

    public void installApplication(String name, Launchable application) {
        activeSystem.install(name, application);
    }

    public void launchApplication(String name) {
        activeSystem.launch(name);
    }

}

package model;

import java.io.Serializable;

public class Computer implements Powerable, Serializable {
    private Motherboard motherboard;
    private RandomAccessMemory randomAccessMemory;
    private VideoCard videoCard;
    private DiskDrive diskDrive;

    private Calculator calc;

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

    public Calculator getCalc() {
        return calc;
    }

    public void setCalc(Calculator calc) {
        this.calc = calc;
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
}

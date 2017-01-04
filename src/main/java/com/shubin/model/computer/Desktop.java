package com.shubin.model.computer;

import com.shubin.model.computer.power.ButtonSwitcher;
import com.shubin.model.computer.power.ScreenTapSwitcher;

import javax.xml.bind.SchemaOutputResolver;
import java.io.Serializable;

public class Desktop extends AbstractComputer implements Serializable {
    private String motherboard;
    private String randomAccessMemory;
    private String videoCard;
    private String diskDrive;

    public Desktop() {
        switcher = new ButtonSwitcher();
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(String randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getDiskDrive() {
        return diskDrive;
    }

    public void setDiskDrive(String diskDrive) {
        this.diskDrive = diskDrive;
    }

    @Override
    public void printType() {
        System.out.println("Type: desktop");
    }

    @Override
    public String toString() {
        return "Desktop:" + "\n" +
                "\t" + "diskDrive=" + diskDrive + "\n" +
                "\t" + "videoCard=" + videoCard + "\n" +
                "\t" + "RandomAccessMemory=" + randomAccessMemory + "\n" +
                "\t" + "motherboard=" + motherboard;
    }

}

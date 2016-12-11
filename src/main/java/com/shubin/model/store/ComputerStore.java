package com.shubin.model.store;

import com.shubin.model.computer.Desktop;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ComputerStore {
    private List<Desktop> catalogComputerList;

    public ComputerStore() {
        Desktop firstComputer = new Desktop();
        firstComputer.setDiskDrive("Transcend 1 TB");
        firstComputer.setMotherboard("ASROCK");
        firstComputer.setRandomAccessMemory("KINGSTON 8 GB");
        firstComputer.setVideoCard("AMD RADEON 9867");

        Desktop secondComputer = new Desktop();
        secondComputer.setDiskDrive("ScanDisk 2 TB");
        secondComputer.setMotherboard("ASUS");
        secondComputer.setRandomAccessMemory("KINGSTON 8 GB");
        secondComputer.setVideoCard("NVIDIA GeForce 960MX");

        Desktop thirdComputer = new Desktop();
        thirdComputer.setDiskDrive("HITACHI 12 GB");
        thirdComputer.setMotherboard("Dell XPS");
        thirdComputer.setRandomAccessMemory("KINGSTON 4 GB");
        thirdComputer.setVideoCard("NVIDIA GeForce 830M");

        catalogComputerList = new ArrayList<Desktop>();
        catalogComputerList.add(firstComputer);
        catalogComputerList.add(secondComputer);
        catalogComputerList.add(thirdComputer);
    }

    public void printConfigByIndex() {
        for (int i = 0; i < catalogComputerList.size(); i++) {
            System.out.println(catalogComputerList.get(i));
        }
    }

    public void printConfigByIterator() {
        ListIterator<Desktop> iterator = catalogComputerList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printConfigByForEach() {
        for (Desktop computer : catalogComputerList) {
            System.out.println(computer);
        }
    }


}


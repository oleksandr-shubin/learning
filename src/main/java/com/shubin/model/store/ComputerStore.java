package com.shubin.model.store;

import com.shubin.model.computer.Laptop;

import java.util.List;
import java.util.ListIterator;

public class ComputerStore {
    private List<Laptop> catalogComputerList;

    public ComputerStore() {

    }

    public void printConfigByIndex() {
        for (int i = 0; i < catalogComputerList.size(); i++) {
            System.out.println(catalogComputerList.get(i));
        }
    }

    public void printConfigByIterator() {
        ListIterator<Laptop> iterator = catalogComputerList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printConfigByForEach() {
        for (Laptop computer : catalogComputerList) {
            System.out.println(computer);
        }
    }
}


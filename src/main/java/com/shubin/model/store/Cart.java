package com.shubin.model.store;

import java.util.ArrayList;
import java.util.List;

public class Cart<Computer> {
    private List<Computer> computers = new ArrayList<>();

    public void add(Computer computer) {
        computers.add(computer);
    }

    public void remove(Computer computer) {
        computers.remove(computer);
    }

    public void remove(int index) {
        computers.remove(index);
    }

    public void printConfigs() {
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }
}

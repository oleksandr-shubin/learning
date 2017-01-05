package com.shubin.model.store;

import com.shubin.model.computer.AbstractComputer;

public class Warranty extends AdditionalServiceDecorator {

    public Warranty(AbstractComputer computer) {
        super(computer);
        System.out.println("Adding additional warranty");
    }

    public int getPrice() {
        return computer.getPrice() + 100;
    }

    @Override
    public String toString() {
        String superString = computer.toString();
        String modifiedString = superString.replaceAll("price=\\d+", "price=" + getPrice());
        return modifiedString + ", additional warranty";
    }
}

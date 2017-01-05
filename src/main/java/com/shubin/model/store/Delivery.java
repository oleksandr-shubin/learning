package com.shubin.model.store;

import com.shubin.model.computer.AbstractComputer;

public class Delivery extends AdditionalServiceDecorator {

    public Delivery(AbstractComputer computer) {
        super(computer);
        System.out.println("Adding delivery");
    }

    public int getPrice() {
        return computer.getPrice() + 150;
    }

    @Override
    public String toString() {
        String superString = computer.toString();
        String modifiedString = superString.replaceAll("price=\\d+", "price=" + getPrice());
        return modifiedString + ", delivery";
    }

}

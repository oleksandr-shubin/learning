package com.shubin.model.store;

import com.shubin.model.computer.AbstractComputer;

public class Service extends AdditionalServiceDecorator {

    public Service(AbstractComputer computer) {
        super(computer);
        System.out.println("Adding additional service");
    }

    public int getPrice() {
        return computer.getPrice() + 200;
    }

    @Override
    public String toString() {
        String superString = computer.toString();
        String modifiedString = superString.replaceAll("price=\\d+", "price=" + getPrice());
        return modifiedString + ", additional service";
    }
}

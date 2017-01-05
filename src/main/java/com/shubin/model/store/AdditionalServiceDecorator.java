package com.shubin.model.store;

import com.shubin.model.computer.AbstractComputer;
import com.shubin.model.computer.Computer;

public abstract class AdditionalServiceDecorator extends AbstractComputer {

    protected AbstractComputer computer;

    public AdditionalServiceDecorator(AbstractComputer computer) {
        this.computer = computer;
    }

    @Override
    public void printType() {
        computer.printType();
    }
}

package com.shubin.builder.laptop;

import com.shubin.model.computer.Laptop;

public abstract class AbstractLaptopBuilder implements CustomLaptopBuilder {
    protected Laptop laptop;

    public AbstractLaptopBuilder() {
        laptop = new Laptop();
    }
}

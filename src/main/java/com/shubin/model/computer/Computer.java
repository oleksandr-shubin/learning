package com.shubin.model.computer;

import com.shubin.model.computer.program.Launchable;
import com.shubin.model.computer.program.os.OperationSystem;

public interface Computer {
    static void printTypes() {
        System.out.println("There are three types of computers:" +
                "laptops, tablets and desktops");
    }

    void printType();

    default void greet() {
        System.out.println("Hello, user!!!");
    }

    void installOS(String name, OperationSystem os );

    void launchOS(String name);

    void installApplication(String name, Launchable application);

    void launchApplication(String name);
}

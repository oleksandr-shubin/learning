package com.shubin.model.computer.program.os;

import com.shubin.model.computer.program.Launchable;

public interface OperationSystem {
    void install(String name, Launchable application);

    void deinstall(String name);

    void launch(String name);
}

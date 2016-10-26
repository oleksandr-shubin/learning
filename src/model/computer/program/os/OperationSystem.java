package model.computer.program.os;

import model.computer.program.Launchable;

public interface OperationSystem {
    void install(String name, Launchable application);

    void deinstall(String name);

    void launch(String name);
}

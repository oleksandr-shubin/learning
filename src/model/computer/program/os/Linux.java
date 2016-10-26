package model.computer.program.os;

import model.computer.program.Launchable;

import java.util.HashMap;
import java.util.Map;

public class Linux implements OperationSystem {
    Map<String, Launchable> applications = new HashMap<>();

    @Override
    public void install(String name, Launchable application) {
        applications.put(name, application);
    }

    @Override
    public void deinstall(String name) {

        applications.remove(name);
    }

    @Override
    public void launch(String name) {
        Launchable application = applications.get(name);
        application.start();
    }
}

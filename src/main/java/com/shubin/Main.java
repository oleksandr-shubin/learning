package com.shubin;

import com.shubin.controller.ComputerStoreController;
import com.shubin.locator.ServiceLocator;
import com.shubin.locator.ServiceLocatorImp;

public class Main {
    public static void main(String[] args) {
        try {
            ServiceLocator service = new ServiceLocatorImp();
            ComputerStoreController controller = (ComputerStoreController) service.getService("ComputerStoreController");
            controller.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}

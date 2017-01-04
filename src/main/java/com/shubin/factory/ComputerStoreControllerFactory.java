package com.shubin.factory;

import com.shubin.View.View;
import com.shubin.builder.ComputerBuilderDirector;
import com.shubin.controller.ComputerStoreController;
import com.shubin.locator.ServiceLocator;
import com.shubin.service.ComputerStoreService;
import com.shubin.service.LaptopService;
import com.shubin.service.PartService;
import com.shubin.validator.PartValidator;
import com.shubin.validator.TransactionValidator;

public class ComputerStoreControllerFactory implements Factory<ComputerStoreController> {

    @Override
    public ComputerStoreController createService(ServiceLocator serviceLocator) throws ReflectiveOperationException {
        return new ComputerStoreController(
                (LaptopService) serviceLocator.getService("LaptopService"),
                (PartService) serviceLocator.getService("PartService"),
                (ComputerStoreService) serviceLocator.getService("ComputerStoreService"),
                new TransactionValidator(),
                new PartValidator(),
                new View(),
                (ComputerBuilderDirector) serviceLocator.getService("ComputerBuilderDirector")
        );
    }
}

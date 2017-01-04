package com.shubin.factory;

import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.ComputerStoreMySQLMapper;
import com.shubin.service.ComputerStoreService;

public class ComputerStoreServiceFactory implements Factory<ComputerStoreService> {
    @Override
    public ComputerStoreService createService(ServiceLocator serviceLocator) throws ReflectiveOperationException {
        return new ComputerStoreService(
                (ComputerStoreMySQLMapper) serviceLocator.getService("ComputerStoreMySQLMapper")
        );
    }
}

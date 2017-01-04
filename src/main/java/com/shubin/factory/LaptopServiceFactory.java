package com.shubin.factory;

import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.LaptopMySQLMapper;
import com.shubin.service.LaptopService;

public class LaptopServiceFactory implements Factory<LaptopService> {
    @Override
    public LaptopService createService(ServiceLocator serviceLocator) throws ReflectiveOperationException {
        return new LaptopService(
                (LaptopMySQLMapper) serviceLocator.getService("LaptopMySQLMapper")
        );
    }
}

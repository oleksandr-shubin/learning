package com.shubin.factory;

import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.PartMySQLMapper;
import com.shubin.service.PartService;

import java.sql.SQLException;

public class PartServiceFactory implements Factory<PartService> {
    @Override
    public PartService createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new PartService(
                (PartMySQLMapper) serviceLocator.getService("PartMySQLMapper")
        );
    }
}

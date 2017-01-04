package com.shubin.factory;

import com.shubin.hydrator.PartHydrator;
import com.shubin.locator.ServiceLocator;

import java.sql.SQLException;

public class PartHydratorFactory implements Factory<PartHydrator> {
    @Override
    public PartHydrator createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new PartHydrator();
    }
}

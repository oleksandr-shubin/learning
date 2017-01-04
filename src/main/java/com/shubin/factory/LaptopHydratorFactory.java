package com.shubin.factory;

import com.shubin.hydrator.LaptopHydrator;
import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.DBConnection;

import java.sql.SQLException;

public class LaptopHydratorFactory implements Factory<LaptopHydrator> {
    @Override
    public LaptopHydrator createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new LaptopHydrator(DBConnection.getConnection());
    }
}

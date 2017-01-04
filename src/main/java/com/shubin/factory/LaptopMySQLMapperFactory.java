package com.shubin.factory;

import com.shubin.hydrator.Hydrator;
import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.DBConnection;
import com.shubin.mapper.LaptopMySQLMapper;
import com.shubin.model.computer.Laptop;

import java.sql.SQLException;

public class LaptopMySQLMapperFactory implements Factory<LaptopMySQLMapper> {
    @Override
    public LaptopMySQLMapper createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new LaptopMySQLMapper(
                DBConnection.getConnection(),
                (Hydrator<Laptop>) serviceLocator.getService("LaptopHydrator")
        );
    }
}

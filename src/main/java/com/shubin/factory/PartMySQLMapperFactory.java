package com.shubin.factory;

import com.shubin.hydrator.Hydrator;
import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.DBConnection;
import com.shubin.mapper.PartMySQLMapper;
import com.shubin.model.computer.parts.Part;

import java.sql.SQLException;

public class PartMySQLMapperFactory implements Factory<PartMySQLMapper> {
    @Override
    public PartMySQLMapper createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new PartMySQLMapper(
                DBConnection.getConnection(),
                (Hydrator<Part>) serviceLocator.getService("PartHydrator")
        );
    }
}

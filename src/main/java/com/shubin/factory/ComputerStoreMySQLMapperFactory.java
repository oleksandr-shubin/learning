package com.shubin.factory;

import com.shubin.hydrator.Hydrator;
import com.shubin.locator.ServiceLocator;
import com.shubin.mapper.ComputerStoreMySQLMapper;
import com.shubin.mapper.DBConnection;
import com.shubin.model.store.Transaction;

import java.sql.SQLException;

public class ComputerStoreMySQLMapperFactory implements Factory<ComputerStoreMySQLMapper> {
    @Override
    public ComputerStoreMySQLMapper createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new ComputerStoreMySQLMapper(
                DBConnection.getConnection(),
                (Hydrator<Transaction>) serviceLocator.getService("TransactionHydrator")
        );
    }
}

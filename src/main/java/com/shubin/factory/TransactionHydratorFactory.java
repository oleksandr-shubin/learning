package com.shubin.factory;

import com.shubin.hydrator.TransactionHydrator;
import com.shubin.locator.ServiceLocator;

import java.sql.SQLException;

public class TransactionHydratorFactory implements Factory<TransactionHydrator> {
    @Override
    public TransactionHydrator createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new TransactionHydrator();
    }
}

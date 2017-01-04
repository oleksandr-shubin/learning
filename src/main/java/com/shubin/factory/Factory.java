package com.shubin.factory;

import com.shubin.locator.ServiceLocator;

import java.sql.SQLException;

public interface Factory<T> {
    T createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException;
}
